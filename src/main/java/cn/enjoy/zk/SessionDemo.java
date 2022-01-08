package cn.enjoy.zk;

import cn.enjoy.thread.tools.SleepTools;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class SessionDemo {

    //如果如果是集群，这里的 CONNECTSTRING 用空格分割
    private final static String CONNECTSTRING = "42.193.168.30:2181";

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(CONNECTSTRING, 4000);
        System.out.println(zkClient+ " -> success");

        //true是级联添加
//        zkClient.createPersistent("/zkclient/zkclient1/zkclient1-1/zkclient1-1-1", true);
//        zkClient.createPersistent("/node1", true);

        //获取路径或者读取值
//        List<String> children = zkClient.getChildren("/zkclient");
//        for (int i = 0; i < children.size(); i++) {
//            System.out.println(children.get(i));
//            Object o = zkClient.readData("/zkclient");
//            System.out.println(o);
//        }

        //deleteRecursive 递归删除，delete 只是简单删除
//        zkClient.deleteRecursive("/zkclient");

        //数据内容变化触发
        zkClient.subscribeDataChanges("/node1", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("节点名称： " + s + "->节点修改后的值" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("节点删除的值： " + s);
            }
        });

        zkClient.writeData("/node1", "node");
//        SleepTools.ms(1000);//这里没延时的话，两个打印出来就是一样的，很奇怪
        zkClient.writeData("/node1", "node2");

        SleepTools.ms(2000);

        //node1 里面节点变化触发
        zkClient.subscribeChildChanges("/node1", new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println("节点名称： " + s + "当前的节点列表：" + list);
            }
        });
    }

}
