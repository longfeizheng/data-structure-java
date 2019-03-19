package cn.merryyou.nio;


import cn.merryyou.file.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class NioTest {

    @Test
    public void testRead() throws Exception {
        String str = "hello nio";
        FileOutputStream fos = new FileOutputStream("nio.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        channel.write(buffer);
        fos.close();
    }

    @Test
    public void testWrite1() throws Exception {
        File file = new File("nio.txt");
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        fis.close();
    }

    @Test
    public void testFileRead() throws Exception {
        List<SettlementImportVO> list = new ArrayList<>();
        // RepaymentResult_01_20180627
        FileUtil.readFile("/Users/zhenglongfei/IdeaProjects/data-structure-java/src/main/java/cn/merryyou/nio/RepaymentResult_01_20180627", 2, list, SettlementImportVO.class);
        if (list.isEmpty()) {
            System.out.println("empty");
        } else {
            list.forEach(e -> System.out.println(e));
        }

    }

    @Test
    public void testClass() throws Exception {
        Field[] fields = SettlementImportVO.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
