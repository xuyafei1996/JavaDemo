package SetDemo;

public class Student {
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
    public boolean equals(Object o) {
        //��ַ��ͬ��true
        if (this == o) return true;
        //�β�Ϊ�գ������Ͳ�ͬ��false
        if (o == null || getClass() != o.getClass()) return false;
        //���䲻ͬ��false
        Student student = (Student) o;
        if (age != student.age) return false;
        //�Ƚ�����
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}