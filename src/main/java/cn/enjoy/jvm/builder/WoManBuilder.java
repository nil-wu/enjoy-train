package cn.enjoy.jvm.builder;

public class WoManBuilder extends PersonBuilder {

    private Person person;

    public WoManBuilder() {
        this.person = new WoMan();
    }

    @Override
    public void buildHead() {
        person.setHead("Pretty Head");
    }

    @Override
    public void buildBody() {
        person.setBody("soft body");
    }

    @Override
    public void buildFoot() {
        person.setFoot("long white foot");
    }

    @Override
    public Person createPerson() {
        return person;
    }
}
