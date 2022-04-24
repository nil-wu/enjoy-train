package cn.enjoy.thread.performance;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ReduceLock {

    private Map<String, String> matchMap = new HashMap<>();

    public synchronized boolean isMatch(String name, String regexp) {
        String key = "user." + name;
        String job = matchMap.get(key);
        if (job == null) {
            return false;
        } else {
            return Pattern.matches(regexp, job);//正则，很耗费时间的
        }
    }

    public boolean isMatchReduce(String name, String regexp) {
        String key = "user." + name;
        String job;
        synchronized (this) {
            job = matchMap.get(key);
        }

        if (job == null) {
            return false;
        } else {
            return Pattern.matches(regexp, job);
        }
    }

    public static void main(String[] args) {

    }


}