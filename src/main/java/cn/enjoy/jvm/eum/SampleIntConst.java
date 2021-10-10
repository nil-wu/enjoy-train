package cn.enjoy.jvm.eum;

/**
 *
 */
public class SampleIntConst {

    //延时订单状态
    public static final int ORDER_DEPOT_UNPAY = 0;
    public static final int ORDER_DEPOT_PAID = 1;
    public static final int ORDER_DEPOT_TIMOUT = 2;

    //物流订单状态
    public static final int ORDER_LOGISTICS_READY = 0;
    public static final int ORDER_LOGISTICS_TRANSPORT = 1;
    public static final int IRDER_LOGISTICS_ARRIVED = 2;

    public enum Depot{UNPAY,PAID,TIMOUT}
    public enum Logistics{READY,TRANSPORT,ARRIVED}

    public static void main(String[] args) {
        System.out.println(ORDER_DEPOT_PAID);
        System.out.println(Depot.UNPAY);
        System.out.println(Depot.PAID.ordinal());
    }



}
