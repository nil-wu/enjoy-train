package cn.enjoy.jvm.builder;

import org.omg.CORBA.PUBLIC_MEMBER;

public class FoodBuilder {

    /*required*/
    private final String foodName;
    private final int reilang;

    /*optional*/
    private int danbz;//蛋白质
    private int dianfen;//淀粉
    private int zf;//脂肪
    private int tang;//糖分
    private int wss;//维生素

    public static class Builder{

        /*required*/
        private final String foodName;
        private final int reilang;

        /*optional*/
        private int danbz;//蛋白质
        private int dianfen;//淀粉
        private int zf;//脂肪
        private int tang;//糖分
        private int wss;//维生素

        public Builder(String foodName, int reilang) {
            this.foodName = foodName;
            this.reilang = reilang;
        }

        public Builder danbz(int val) {
            this.danbz = val;
            return this;
        }

        //......

        public FoodBuilder builder(){
            return new FoodBuilder(this);
        }

    }

    private FoodBuilder(Builder builder) {
        foodName = builder.foodName;
        reilang = builder.reilang;
        danbz = builder.danbz;
        //......
    }


    public static void main(String[] args) {
        FoodBuilder foodBuilder = new Builder("food2", 1000).danbz(100).builder();
    }

}
