package c21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ZhaoTao on 2016/8/29.
 */
public class MappedChannelRead {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"))) {
            long fSize = fChan.size();
            MappedByteBuffer mbuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            for (int i = 0; i < fSize; i++) {
                System.out.println((char) mbuf.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
