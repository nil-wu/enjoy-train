package cn.enjoy.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class UseAtomicReference {

    //    static UserInfo userInfo = new UserInfo("haha", 18);
    static AtomicReference<UserInfo> userRef = new AtomicReference<UserInfo>();

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("haha", 18);
        userRef.set(userInfo);

        UserInfo updateUser = new UserInfo("difashi", 28);

        userRef.compareAndSet(userInfo, updateUser);

        System.out.println(userInfo.toString());
        System.out.println(userRef.get().toString());
    }

    static class UserInfo{
        private String name;
        private int age;

        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
