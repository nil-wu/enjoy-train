package cn.enjoy.jvm.builder;

public class ManBuilder extends PersonBuilder {

    private Person person;

    public ManBuilder() {
        this.person = new Man();
    }

    @Override
    public void buildHead() {
        person.setHead("Brave Head");
    }

    @Override
    public void buildBody() {
        person.setBody("Strong body");
    }

    @Override
    public void buildFoot() {
        person.setFoot("powerful foot");
    }

    @Override
    public Person createPerson() {
        return person;
    }
}
