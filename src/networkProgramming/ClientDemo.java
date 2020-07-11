package networkProgramming;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建流套接字并将其连接到指定主机上的指定端口号
        Socket s = new Socket("192.168.1.66",10000);

        //获取套接字的输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());

        //释放资源
        s.close();
    }
}
