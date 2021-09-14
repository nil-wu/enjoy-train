package cn.enjoy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {
    /*扩展Thread类*/

    /*实现Runnable接口*/
    private static class UseRun implements Runnable{
        @Override
        public void run() {
            System.out.println("I am implements Runnable");
        }
    }

    /*实现Callable接口，允许有返回值*/
    private static class UseCall implements Callable{
        @Override
        public String call() throws Exception {
            System.out.println("I am implements Callable");
            return "CallResult";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseRun useRun = new UseRun();
        UseCall useCall = new UseCall();

        Thread t1 = new Thread(useRun);
        t1.start();
        FutureTask futureTask = new FutureTask<String>(useCall);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }

}
