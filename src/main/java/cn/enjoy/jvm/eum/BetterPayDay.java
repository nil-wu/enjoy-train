package cn.enjoy.jvm.eum;

public enum BetterPayDay {
    MONDAY(PayType.WORK),TUESDAY(PayType.WORK),WENDESDAY(PayType.WORK),
    THURSDAY(PayType.WORK),FRIDAY(PayType.WORK),
    SATURDAY(PayType.REST), SUNDAY(PayType.REST),
    WUYI(PayType.REST);//加的话直接在这里加就可以了

    private final PayType payType;//成员变量

    BetterPayDay(PayType payType) {
        this.payType = payType;
    }

    double pay(double hoursOvertime) {
        return payType.pay(hoursOvertime);
    }

    //策略枚举
    private enum PayType{
        WORK {
            double pay(double hoursOvertime) {
                return hoursOvertime*HOURS_WORK;
            }
        },
        REST{
            double pay(double hoursOvertime) {
                return hoursOvertime * HOURS_REST;
            }
        };

        private static final int HOURS_WORK = 2;
        private static final int HOURS_REST = 3;

        abstract double pay(double hoursOvertime);//抽象计算加班费的方法
    }

    public static void main(String[] args) {
        System.out.println(BetterPayDay.MONDAY.pay(7.5));
    }

}
