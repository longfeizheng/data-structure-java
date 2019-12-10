package cn.merryyou.file;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.URLEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public class BaiDuPan {

    public static String urlPath = "https://pan.baidu.com/api/list?order=name&desc=0&showempty=0&web=1&page=1&num=100&dir=%s&t=0.9616726984324069&channel=chunlei&web=1&app_id=250528&bdstoken=458998c601e686f12d088ecd07559939&logid=MTU3NTk2MzE1MTQxMDAuOTY3MTkyMTUzMTA4MjYwMw==&clienttype=0&startLogTime=1575963151410";
    public static String cookie = "";
    public static String str2 = "├──";
    public static String str1 = "|   ";

    public static void main(String[] args) throws Exception {
        String name = "/Java在职加薪课";
        System.out.println("Java在职加薪课");
        print(name, 1);
    }

    public static void print(String pathName, int level) throws Exception {
        String url = String.format(urlPath, URLEncoder.encode(pathName, "UTF-8"));
        List<BaseResponse.ListBean> listBeans = getResponse(url);
        if (listBeans.isEmpty()) {
            return;
        }
        for (int i = 0; i < listBeans.size(); i++) {
            StringBuffer tempStr = new StringBuffer("");
            // 规则输出
            for (int j = 0; j < level; j++) {
                tempStr.append(str1);
            }
            tempStr.append(str2);
            System.out.println(tempStr + listBeans.get(i).getServer_filename() + "     " + (listBeans.get(i).getSize() == 0 ? "" : getPrintSize(listBeans.get(i).getSize())));
            if (listBeans.get(i).getIsdir() == 1) {
                print(listBeans.get(i).getPath(), level + 1);
            }
        }
    }

    public static List<BaseResponse.ListBean> getResponse(String uri) throws Exception {
        URL url = new URL(uri);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Cookie", cookie);
        conn.setDoInput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        BaseResponse baseResponse = JSON.parseObject(sb.toString(), BaseResponse.class);
        return baseResponse.getErrno() == 0 ? baseResponse.getList() : null;
    }

    public static String getPrintSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }
}
