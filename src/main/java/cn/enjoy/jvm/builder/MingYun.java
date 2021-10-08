package cn.enjoy.jvm.builder;


/**
 * 类说明：客户端
 */
public class MingYun {

    public static void main(String[] args) {
        System.out.println("create NvWa");
        NvWa nvWa = new NvWa();
        nvWa.buildPeron(new ManBuilder());
        nvWa.buildPeron(new WoManBuilder());
    }

}
