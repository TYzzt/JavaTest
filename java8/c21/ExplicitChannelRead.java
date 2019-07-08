package c21;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ZhaoTao on 2016/8/29.
 */
public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filepath = null;


        //创建Path
        try {
            filepath = Paths.get("test.txt");
        } catch (InvalidPathException e) {
            e.printStackTrace();
            return;
        }

        //生成通道
        try (SeekableByteChannel fChan = Files.newByteChannel(filepath)) {
            ByteBuffer mBuf = ByteBuffer.allocate(128); //通过封装已经存在的数组或通过动态分配缓冲区来获取缓冲区
            do {
                count = fChan.read(mBuf);
                //调用read之后，当前位置位于缓冲区的末尾
                if (count != -1) {
                    //rewind the buffer so that it can be read 倒回
                    mBuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
