package cn.enjoy.safeclass;

/**
 * 类说明：不可变的类
 */
public class ImmutableFinalRef {

    private final int a;
    private final int b;
    private final User user;

    public ImmutableFinalRef(int a, int b) {
        this.a = a;
        this.b = b;
        this.user = new User();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public User getUser() {
        return user;
    }

    public static class User{

        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        ImmutableFinalRef ref = new ImmutableFinalRef(12, 23);
        User u = ref.getUser();
        
    }

}
