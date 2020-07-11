package networkProgramming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //�������ն˵�Socket����(DatagramSocket)
        DatagramSocket ds = new DatagramSocket(12345);
        while (true) {
            //����һ�����ݰ������ڽ�������
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            //����DatagramSocket����ķ�����������
            ds.receive(dp);
            //�������ݰ������������ڿ���̨��ʾ
            System.out.println("�����ǣ�" + new String(dp.getData(), 0, dp.getLength()));
        }
        //�رս��ն�
//        ds.close();
    }
}