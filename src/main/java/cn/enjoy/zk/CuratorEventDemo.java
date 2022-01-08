package cn.enjoy.zk;

import org.apache.curator.framework.CuratorFramework;

public class CuratorEventDemo {

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorClientUtils.getInstance();

        //节点变化NodeCache
//        new NodeCache(curatorFramework, "/curator", false);


    }

}
