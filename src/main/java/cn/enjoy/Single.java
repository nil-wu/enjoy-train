package cn.enjoy;

public class Single {



    private static Single single;

    public static Single getSingle(){
        if (single == null) {
            single = new Single();
        }
        return single;
    }

    private Single() {

    }
}
