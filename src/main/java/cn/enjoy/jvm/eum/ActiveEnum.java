package cn.enjoy.jvm.eum;

/**
 * 枚举绑定行为
 */
public class ActiveEnum {

    /**
     * 此方法如果添加枚举值，switch值漏了加，会到运行期才抛出异常
     */
    public enum NormalActive{
        PLUS,MINUS,MULTI,DIVIDS;

        double oper(double x, double y) {
            switch (this){
                case PLUS:return x+y;
                case MINUS:return x-y;
                case MULTI:return x*y;
                case DIVIDS:return x/y;
            }
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 用此方法改进
     */
    public enum BetterActive{
        PLUS{
            @Override
            double oper(double x, double y) {
                return x+y;
            }
        },MINUS{
            @Override
            double oper(double x, double y) {
                return x-y;
            }
        };

        abstract double oper(double x, double y);

    }

    public static void main(String[] args) {
        System.out.println(NormalActive.PLUS.oper(0.1, 0.2));
    }

}
