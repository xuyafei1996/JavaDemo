package networkProgramming;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //�������׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ں�
        Socket s = new Socket("192.168.1.66",10000);

        //��ȡ�׽��ֵ��������д����
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,������".getBytes());

        //�ͷ���Դ
        s.close();
    }
}