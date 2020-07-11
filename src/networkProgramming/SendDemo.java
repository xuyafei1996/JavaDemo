package networkProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.stream.Stream;

public class SendDemo {
        public static void main(String[] args) throws IOException {
            //�������Ͷ˵�Socket����(DatagramSocket)
            DatagramSocket ds = new DatagramSocket();
            //�Լ���װ����¼������
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = br.readLine()) != null) {
                //�����������886���������ݽ���
                if ("886".equals(line)) {
                    break;
                }
                //�������ݣ��������ݴ��
                byte[] bys = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.1.66"), 12345);

                //����DatagramSocket����ķ�����������
                ds.send(dp);
            }
            //�رշ��Ͷ�
            ds.close();
        }
}