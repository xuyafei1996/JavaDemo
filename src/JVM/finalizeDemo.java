package JVM;

public class finalizeDemo {
    public static class myObject{
        //��¼finalizeDemo�������ڻָ��ɴ���
        finalizeDemo fd;
        public myObject(finalizeDemo fd){this.fd = fd;}
        protected void finalize(){
            //�ָ�����������ɴ�
            fd.ref = this;
            System.out.println("finalizeֻ����һ�Ρ���");
        }
    }

    myObject ref;
    public static void main(String[] args) {
        finalizeDemo fd = new finalizeDemo();
        fd.ref = new myObject(fd);
        //��myObject���ɴ�,���е�finalize()��������
        fd.ref = null;
        System.gc();
        if (fd.ref!=null)
            System.out.println("MyObject���󻹻��ţ�");

    }
}