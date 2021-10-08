package cn.enjoy.jvm.builder;

/**
 * 类说明：导演者
 */
public class NvWa {

    public Person buildPeron(PersonBuilder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.createPerson();
    }

}
