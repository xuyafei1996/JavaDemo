package API;

public class ObjectAPI {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("¡÷«‡œº");
        s.setAge(30);
        System.out.println(s);
        System.out.println(s.toString());
    }

    public static class Student extends Object{
        private String name;
        private int age;
        public Student() {
        }
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
