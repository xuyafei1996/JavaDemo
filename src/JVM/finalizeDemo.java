package JVM;

public class finalizeDemo {
    public static class myObject{
        //记录finalizeDemo对象，用于恢复可达性
        finalizeDemo fd;
        public myObject(finalizeDemo fd){this.fd = fd;}
        protected void finalize(){
            //恢复本对象，令其可达
            fd.ref = this;
            System.out.println("finalize只运行一次……");
        }
    }

    myObject ref;
    public static void main(String[] args) {
        finalizeDemo fd = new finalizeDemo();
        fd.ref = new myObject(fd);
        //令myObject不可达,其中的finalize()将被调用
        fd.ref = null;
        System.gc();
        if (fd.ref!=null)
            System.out.println("MyObject对象还活着！");

    }
}
