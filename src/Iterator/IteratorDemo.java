package Iterator;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<User> collection = new ArrayList<>();
//        Collection<User> collection = new LinkedList<>();
//        Collection<User> collection = new HashSet<>();
//        List<User> collection = new ArrayList<>();
        collection.add(new User("Harry",24));
        collection.add(new User("Sharry",25));
        collection.add(new User("Mike",24));
        Iterator<User> iterator = collection.iterator();
        System.out.println("【迭代器遍历】");
        while (iterator.hasNext()){
            User user = iterator.next();
            System.out.println("Name:"+user.name+";age"+user.age);
        }
        System.out.println("【增强for循环】");
        for (User user:collection){
            System.out.println("Name:"+user.name+";age"+user.age);
        }
    }

    public static class User{
        public String name;
        private int age;
        public User(String name,int age){
            this.name=name;
            this.age=age;
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
    }
}
