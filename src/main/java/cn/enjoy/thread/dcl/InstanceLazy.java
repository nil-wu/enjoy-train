package cn.enjoy.thread.dcl;

public class InstanceLazy {

    private Integer value;
    private Integer val; // 可能很大，如巨型数组 10万

    public InstanceLazy(Integer value) {
        super();
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private static class ValHolder{
        public static Integer vHolder = new Integer(100000);
    }

    public Integer getVal() {
        return ValHolder.vHolder;
    }

}
