package cn.enjoy.rmi;

import java.rmi.Naming;

public class Client {

    public static void main(String[] args)throws Exception {
        //通过rmi发现服务，并且转成一个对象
        IOrder iOrder = (IOrder)Naming.lookup("rmi://localhost:6666/order");
        System.out.println(iOrder.pay("168888"));
    }
}
