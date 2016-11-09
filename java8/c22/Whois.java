package c22;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/9/20
 * \* Time: 15:09
 * \* Description:
 * \
 */
public class Whois {


    public static void main(String[] args) throws IOException {
        int c;

        Socket s = new Socket("whois.internic.net", 43);

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        String str = "baidu.com";
        byte buf[] = str.getBytes();

        //send request
        out.write(buf);

        while ((c = in.read()) != -1) {
            System.out.println((char) c);
        }

        s.close();


    }


}
