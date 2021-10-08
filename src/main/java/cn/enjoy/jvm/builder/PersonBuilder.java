package cn.enjoy.jvm.builder;

/**
 * 类说明：抽象建造者
 */
public abstract class PersonBuilder {
    //建造部件
    public abstract void buildHead();
    public abstract void buildBody();
    public abstract void buildFoot();

    public abstract Person createPerson();

}
