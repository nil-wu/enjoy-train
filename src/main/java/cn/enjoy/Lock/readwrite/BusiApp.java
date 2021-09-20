package cn.enjoy.Lock.readwrite;

import cn.enjoy.thread.tools.SleepTools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class BusiApp {

    static final int readWriteRatio = 10;//读写线程的比例
    static final int minthreadCount = 3;//最少线程数
//    static CountDownLatch latch = new CountDownLatch(1);

    /**
     * 读线程
     */
    private static class GetThread implements Runnable{
        private GoodsService goodsService;

        public GetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//
//            }
            long start = System.currentTimeMillis();
            Random r = new Random();
            for (int i = 0; i < 100; i++) {//操作100次
                goodsService.getNum();
            }
            System.out.println(Thread.currentThread().getName() + "读商品数据耗时：" + (System.currentTimeMillis() - start) + "ms");
        }
    }

    /**
     * 写线程
     */
    private static class SetThread implements Runnable{
        private GoodsService goodsService;

        public SetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//
//            }
            long start = System.currentTimeMillis();
            Random r = new Random();
            for (int i = 0; i < 10; i++) {//操作10次
                SleepTools.ms(50);
                goodsService.setNum(r.nextInt(10));
            }
            System.out.println(Thread.currentThread().getName() + "写商品数据耗时：" + (System.currentTimeMillis() - start) + "ms-------------------");
        }
    }

    public static void main(String[] args) {
        GoodsInfo goodsInfo = new GoodsInfo("Cup", 100000, 10000);
//        GoodsService goodsService = new UseSyn(goodsInfo);
        GoodsService goodsService = new UseRwLock(goodsInfo);
        for (int i = 0; i < minthreadCount; i++) {
            Thread setT = new Thread(new SetThread(goodsService));
            for (int j = 0; j < readWriteRatio; j++) {
                Thread getT = new Thread(new GetThread(goodsService));
                getT.start();
            }
            SleepTools.ms(100);
            setT.start();
        }
    }

}
