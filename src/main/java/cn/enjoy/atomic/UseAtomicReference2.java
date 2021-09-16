package cn.enjoy.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class UseAtomicReference2 {

    //    static UserInfo userInfo = new UserInfo("haha", 18);
    static AtomicReference<UserInfo> userRef = new AtomicReference<UserInfo>();

    public static void main(String[] args) throws Exception{
        UserInfo userInfo = new UserInfo("haha", 18);
        userRef.set(userInfo);
//        userInfo.setAge(30);//如果是本身线程修改值，会默认为内存地址不变

//        UserInfo updateUser = new UserInfo("difashi", 28);
////
////        boolean b = userRef.compareAndSet(userInfo, updateUser);
////        System.out.println(b);



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        + "当前变量值：" + userRef.get().toString() + "-" + userRef.compareAndSet(userInfo, new UserInfo("difashi", 28)));
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                userInfo.setName("thread2 修改的");
                System.out.println(Thread.currentThread().getName()
                        + "当前变量值：" + userRef.get().toString() + "-" + userRef.compareAndSet(userInfo, new UserInfo("difashi2", 30)));
            }
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

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
