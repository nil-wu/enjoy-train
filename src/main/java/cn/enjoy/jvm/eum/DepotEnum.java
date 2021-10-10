package cn.enjoy.jvm.eum;

/**
 * 绑定的是数据，但是还可以绑定行为
 */
public enum DepotEnum {

    UNPAY(0,"未支付"),PAID(1,"已支付"), TIMOUT(-1, "超时");

    private int status;
    private String desc;

    DepotEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public int calcStatus(int params) {
        return status + params;
    }

    public static void main(String[] args) {
        for (DepotEnum e : DepotEnum.values()) {
            System.out.println(e + ":" + e.calcStatus(14));
        }
        System.out.println(DepotEnum.PAID.calcStatus(15));
    }
}
