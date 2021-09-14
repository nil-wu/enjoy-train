package cn.enjoy.thread.forkjoin;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 遍历指定目录（含子目录）找寻指定类型文件
 * fork-join的异步操作
 */
public class FindDirsFiles extends RecursiveAction {

    private File path;//当前任务需要搜寻的目录

    public FindDirsFiles(File path) {
        this.path = path;
    }

    @Override
    protected void compute() {
        List
    }

    public static void main(String[] args) {
        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            FindDirsFiles task = new FindDirsFiles(new File("F:/"));
            System.out.println("Task is Running......");
            Thread.sleep(1);
            int otherWork = 0;
            for (int i = 0; i < 100; i++) {
                otherWork = otherWork + 1;
            }
            System.out.println("Main Thread done sth......,otherWork=" + otherWork);
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
