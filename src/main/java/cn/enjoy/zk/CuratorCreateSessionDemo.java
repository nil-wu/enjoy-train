package cn.enjoy.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorCreateSessionDemo {

    private final static String CONNECTIONSTR = "42.193.168.30:2181";

    public static void main(String[] args) {
        //创建会话的两种方式
        //normal
        CuratorFramework cratorFramework = CuratorFrameworkFactory.newClient(CONNECTIONSTR, 5000, 5000, new ExponentialBackoffRetry(1000, 3));
        cratorFramework.start();//start方法创建连接

        //fluent风格 链式编程
        CuratorFramework cratorFramework1 = CuratorFrameworkFactory.builder().connectString(CONNECTIONSTR).sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000,3)).build();
        cratorFramework1.start();

        System.out.println("success");

    }

}
