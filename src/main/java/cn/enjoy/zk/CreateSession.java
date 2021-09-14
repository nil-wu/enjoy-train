package cn.enjoy.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreateSession {

    private final static String CONNECTIONSTR = "42.193.168.30:2181";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final ZooKeeper zooKeeper = new ZooKeeper(CONNECTIONSTR, 5000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
                if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    System.out.println("节点发生了变化，路径："+watchedEvent.getPath());
                }
            }
        });

        System.out.println("111:" + zooKeeper.getState());
        countDownLatch.await();
        System.out.println("222:" + zooKeeper.getState());

        //创建节点
//        zooKeeper.create("/enjoy1", "333".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        //获取数据
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData("/enjoy1", true, stat);
        System.out.println(new String(data));
        System.out.println(stat);

        //修改数据
        zooKeeper.setData("/enjoy1", "999".getBytes(), -1);

        zooKeeper.setData("/enjoy1", "111".getBytes(), -1);

        //删除节点
//        zooKeeper.delete("/enjoy1",-1);

    }
}
