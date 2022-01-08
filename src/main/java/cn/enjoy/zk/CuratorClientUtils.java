package cn.enjoy.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorClientUtils {

    private static CuratorFramework curatorFramework;
    private final static String CONNECTSTRING = "42.193.168.30:2181";

    public static CuratorFramework getInstance(){
        curatorFramework = CuratorFrameworkFactory.newClient(CONNECTSTRING, 5000, 5000, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        System.out.println("连接成功2");
        return curatorFramework;
    }

}
