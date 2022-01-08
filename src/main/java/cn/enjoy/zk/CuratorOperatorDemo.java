package cn.enjoy.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import java.nio.charset.StandardCharsets;

public class CuratorOperatorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorClientUtils.getInstance();

        //创建节点
//        String result = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/curator/curator1/curator11", "123".getBytes());
//        System.out.println(result);

        //删除节点
//        curatorFramework.delete().deletingChildrenIfNeeded().forPath("/curator");

        //查询
//        Stat stat = new Stat();
//        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/curator/curator1/curator11");
//        System.out.println(new String(bytes));

        //更新
//        Stat stat1 = curatorFramework.setData().forPath("/curator/curator1/curator11", "234".getBytes());
//        System.out.println(stat1);

        //异步
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        //创建节点成功会在后台起个后台进程叫 Background，Background new了一个类
//        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
//            @Override
//            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
//                System.out.println(Thread.currentThread().getName() + "->resultcode:" + curatorEvent.getResultCode() + "->" + curatorEvent.getType());
//                countDownLatch.countDown();
//            }
//        }).forPath("/enjoy", "deer".getBytes());
//
//        countDownLatch.await();
//        executorService.shutdown();

        //事务操作，curator独有的
        Collection<CuratorTransactionResult> commit = curatorFramework.inTransaction().create().forPath("/enjoyCreate", "111".getBytes()).and().setData().forPath("/enjoyCreate", "222".getBytes()).and().commit();
        for (CuratorTransactionResult s: commit) {
            System.out.println(s.getForPath() + "->" + s.getType());
        }
    }

}
