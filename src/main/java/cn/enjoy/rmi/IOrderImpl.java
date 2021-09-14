package cn.enjoy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IOrderImpl extends UnicastRemoteObject implements IOrder {

    protected IOrderImpl() throws RemoteException {
        super();
    }

    public String pay(String id) throws RemoteException {

        return "支付成功!商品订单号："+id;
    }
}
