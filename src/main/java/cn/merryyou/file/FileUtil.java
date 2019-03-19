package cn.merryyou.file;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;

public class FileUtil {
    private static final Long MAX_BYTES = 358400L;//1024*350=358400L
    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void readFile(String path, Integer lineStart, List list, Class clazz) throws Exception {
        if (lineStart < 1) {
            logger.error("起始行必须大于1");
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        if (randomAccessFile.length() <= 0) {
            return;
        }

        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
        int bytesRead = channel.read(buffer);
        ByteBuffer stringBuffer = ByteBuffer.allocate(20);
        while (bytesRead != -1) {
            int lineNumber = 1;
            logger.info("读取字节数：{}", bytesRead);
            //之前是写buffer，现在要读buffer
            buffer.flip();// 切换模式，写->读
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                if (b == 10 || b == 13) { // 换行或回车
                    if (lineNumber < lineStart) {
                        lineNumber++;
                        stringBuffer.flip();
                        stringBuffer.clear();
                        continue;
                    }
                    stringBuffer.flip();
                    // 这里就是一个行
                    final String line = Charset.forName("utf-8").decode(stringBuffer).toString();

                    System.out.println(line + "----------");// 解码已经读到的一行所对应的字节
                    Object vo = line2VO(line, clazz);
                    if (!Objects.isNull(vo)) {
                        list.add(vo);
                    }
                    stringBuffer.clear();
                } else {
                    if (stringBuffer.hasRemaining())
                        stringBuffer.put(b);
                    else { // 空间不够扩容
                        stringBuffer = reAllocate(stringBuffer);
                        stringBuffer.put(b);
                    }
                }
            }
            buffer.clear();// 清空,position位置为0，limit=capacity
            //  继续往buffer中写
            bytesRead = channel.read(buffer);
        }
        randomAccessFile.close();
    }

    private static Object line2VO(String line, Class clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object o = clazz.newInstance();
        if (StringUtils.isBlank(line)) {
            return null;
        }
        Field[] fields = clazz.getDeclaredFields();
        String[] split = line.split("|");
        for (int i = 0; i < split.length && fields.length > i; i++) {
            BeanUtils.setProperty(o, fields[i].getName(), split[i]);
        }
        return o;
    }

    private static ByteBuffer reAllocate(ByteBuffer stringBuffer) {
        final int capacity = stringBuffer.capacity();
        byte[] newBuffer = new byte[capacity * 2];
        System.arraycopy(stringBuffer.array(), 0, newBuffer, 0, capacity);
        return (ByteBuffer) ByteBuffer.wrap(newBuffer).position(capacity);
    }
}
