package cn.enjoy.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class UseAtomicReference {

    //    static UserInfo userInfo = new UserInfo("haha", 18);
    static AtomicReference<UserInfo> userRef = new AtomicReference<UserInfo>();

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("haha", 18);
        userRef.set(userInfo);
//        userInfo.setAge(30);//如果是本身线程修改值，会默认为内存地址不变

        UserInfo updateUser = new UserInfo("difashi", 28);
        UserInfo updateUser2 = new UserInfo("difashi2", 28);

        //userInfo一直没变，但是 userRef.get() 变了，所以 updateUser2 失败了
        System.out.println(userRef.compareAndSet(userInfo, updateUser));
        System.out.println(userRef.compareAndSet(userInfo, updateUser2));

        System.out.println(userInfo.toString());
        System.out.println(userRef.get().toString());
    }

    static class UserInfo{
        private String name;
        private int age;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

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
