package cn.merryyou.file;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.URLEncoder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public class BaiDuPan {

    public static String urlPath = "https://pan.baidu.com/api/list?order=name&desc=0&showempty=0&web=1&page=1&num=100&dir=%s";
    public static String reNameUri = "https://pan.baidu.com/api/filemanager?opera=rename&async=2&onnest=fail&channel=chunlei&web=1&app_id=250528&bdstoken=458998c601e686f12d088ecd07559939&logid=MTU3NjAzMjA3MzU0NTAuNjUyMjE3NjYxNTczNTM=&clienttype=0";
    public static String cookie = "BIDUPSID=7C583791F66ACEC39183227BB0292632; PSTM=1527510529; pan_login_way=1; PANWEB=1; BAIDUID=C7A81CD0A752D89E4E5BEB55B0BFABB1:FG=1; H_WISE_SIDS=137151_126008_114552_136293_136748_136626_134982_128149_136667_136436_120157_136769_136659_137217_133995_136365_132909_136456_135846_131247_132378_131517_118880_118873_118850_118819_118786_136687_107313_132785_136800_136431_136094_133351_137221_136862_136815_137014_129654_136195_131861_133847_132552_131423_137212_136165_137465_110085_127969_137550_131951_135623_136614_135416_135457_127417_136635_134351_136322_137618_136988; MCITY=-%3A; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; __51cke__=; H_PS_PSSID=1437_21088_30211_26350_28703; delPer=0; PSINO=1; Hm_lvt_7a3960b6f067eb0085b7f96ff5e660b0=1575856412,1575871788,1575871956,1575959745; BDCLND=SzZ4N%2BtTcEz76fIh3KtejpZb737SLyO829SHVSF%2FYxA%3D; cflag=13%3A3; BDUSS=WtQTlFtU1dSbTc1eXM2R3JQMVhteHU3SjZ-dXZqflNtdlU4WkVIQld2dnZ5UlplRVFBQUFBJCQAAAAAAAAAAAEAAACaf3QJta21rbXEycvE4wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAO88713vPO9dd; SCRC=9d810de0f449c7e06d4ee58389a03e08; STOKEN=9e932437a48027011ca29b3c2ac25756218961739dd66ea6a1f51e856de37d4a; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; ZD_ENTRY=baidu; PANPSC=14760223248170439320%3ACU2JWesajwC9ONyObelPA%2Bs60cmUHWkVFLcAN6qJlVIf0xBVoozfxK91AzBnk5Pr23ZF3n1fcbcr2wqYbSNJzPBl8XefSTKbJOYngdmtlVzubt%2F3lrH1l9thklJhx6JJDxtrzXlRkL5hBaVJALTttis1en6NUQxC4c2uV2AHt3x2TQaGfItAk1vKX4DMNpv6HhgzMjI7O4rZ81l%2BOzvAFtgwtOetg71W0UtUBh8GXDh9bfFV5UX2VQ%3D%3D; __tins__19988117=%7B%22sid%22%3A%201576030019713%2C%20%22vd%22%3A%205%2C%20%22expires%22%3A%201576033565597%7D; __51laig__=29; Hm_lpvt_7a3960b6f067eb0085b7f96ff5e660b0=1576031830; BIDUPSID=7C583791F66ACEC39183227BB0292632; PSTM=1527510529; pan_login_way=1; PANWEB=1; BAIDUID=C7A81CD0A752D89E4E5BEB55B0BFABB1:FG=1; H_WISE_SIDS=137151_126008_114552_136293_136748_136626_134982_128149_136667_136436_120157_136769_136659_137217_133995_136365_132909_136456_135846_131247_132378_131517_118880_118873_118850_118819_118786_136687_107313_132785_136800_136431_136094_133351_137221_136862_136815_137014_129654_136195_131861_133847_132552_131423_137212_136165_137465_110085_127969_137550_131951_135623_136614_135416_135457_127417_136635_134351_136322_137618_136988; MCITY=-%3A; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; __51cke__=; H_PS_PSSID=1437_21088_30211_26350_28703; Hm_lvt_7a3960b6f067eb0085b7f96ff5e660b0=1575856412,1575871788,1575871956,1575959745; BDCLND=SzZ4N%2BtTcEz76fIh3KtejpZb737SLyO829SHVSF%2FYxA%3D; BDUSS=WtQTlFtU1dSbTc1eXM2R3JQMVhteHU3SjZ-dXZqflNtdlU4WkVIQld2dnZ5UlplRVFBQUFBJCQAAAAAAAAAAAEAAACaf3QJta21rbXEycvE4wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAO88713vPO9dd; SCRC=9d810de0f449c7e06d4ee58389a03e08; STOKEN=9e932437a48027011ca29b3c2ac25756218961739dd66ea6a1f51e856de37d4a; delPer=0; PSINO=1; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; cflag=13%3A3; Hm_lpvt_7a3960b6f067eb0085b7f96ff5e660b0=1576031830; __tins__19988117=%7B%22sid%22%3A%201576031831350%2C%20%22vd%22%3A%201%2C%20%22expires%22%3A%201576033631350%7D; __51laig__=30";
    public static String str2 = "├──";
    public static String str1 = "|   ";

    public static void main(String[] args) throws Exception {
//        printDir();
//        renameFile();
        onlineRename();
    }

    public static void onlineRename() throws Exception {
        replaceNameForDir("/2017年山本教育《 素云恋爱》课程", "VIP", "");
    }

    public static void renameFile() throws Exception {
        String param = getParam("/2017年山本教育《 素云恋爱》VIP课程", "2017年山本教育《 素云恋爱》课程");
        if (!onLineReName(reNameUri, param)) {
            System.out.println("重命名失败！");
        }
    }

    private static String getParam(String path, String newName) {
        List<RenameBO> reNames = new ArrayList();
        RenameBO renameBO = new RenameBO();
        renameBO.setPath(path);
        renameBO.setNewname(newName);
        reNames.add(renameBO);
        return JSON.toJSONString(reNames);
    }


    public static void printDir() throws Exception {
        String name = "/微信小程序云开发-从0打造云音乐全栈小程序";
        System.out.println("微信小程序云开发-从0打造云音乐全栈小程序");

        print(name, 1);
    }

    /**
     * 打印目录
     *
     * @param name
     * @param level
     * @throws Exception
     */
    public static void print(String name, int level) throws Exception {
        String url = String.format(urlPath, URLEncoder.encode(name, "UTF-8"));
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
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Cookie", cookie);
        conn.setDoInput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        conn.disconnect();
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


    /**
     * 重命名
     *
     * @param reNameUri
     * @param param
     * @return
     * @throws IOException
     */
    public static boolean onLineReName(String reNameUri, String param) throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(reNameUri);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setRequestProperty("Cookie", cookie);
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        //设置本次连接是否自动重定向
        connection.setInstanceFollowRedirects(true);
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection
                .getOutputStream());
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        String content = "filelist=" + URLEncoder.encode(param, "UTF-8");
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes(content);
        //流用完记得关
        out.flush();
        out.close();
        //获取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        //该干的都干完了,记得把连接断了
        connection.disconnect();
        Response baseResponse = JSON.parseObject(sb.toString(), Response.class);
        return baseResponse.getErrno() == 0;
    }


    /**
     * 在线替换一些字符串/递归替换
     *
     * @param name
     * @param oldStr
     * @param newStr
     */
    public static void replaceNameForDir(String name, String oldStr, String newStr) throws Exception {
        String url = String.format(urlPath, URLEncoder.encode(name, "UTF-8"));
        List<BaseResponse.ListBean> listBeans = getResponse(url);
        if (listBeans.isEmpty()) {
            return;
        }
        for (int i = 0; i < listBeans.size(); i++) {
            if (listBeans.get(i).getIsdir() != 1) {
                // 判断是不是需要修改
                reName(oldStr, newStr, listBeans, i);
            } else {
                replaceNameForDir(listBeans.get(i).getPath(), oldStr, newStr);
                reName(oldStr, newStr, listBeans, i);
            }
        }
    }

    private static void reName(String oldStr, String newStr, List<BaseResponse.ListBean> listBeans, int i) throws IOException {
        if (listBeans.get(i).getServer_filename().contains(oldStr)) {
            String param = getParam(listBeans.get(i).getPath(), listBeans.get(i).getServer_filename().replace(oldStr, newStr));
            if (onLineReName(reNameUri, param)) {
                System.out.println(listBeans.get(i).getPath() + "    修改成功  " + System.currentTimeMillis());
            } else {
                System.out.println(listBeans.get(i).getPath() + "    修改失败  " + System.currentTimeMillis());

            }
            try {
                // 休眠下，否则修改不成功
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
