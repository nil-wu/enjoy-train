package cn.enjoy.jvm.builder;

public class FoodNormal {

    /*required*/
    private final String foodName;
    private final int reilang;

    /*optional*/
    private final int danbz;//蛋白质
    private final int dianfen;//淀粉
    private final int zf;//脂肪
    private final int tang;//糖分
    private final int wss;//维生素

    /*全参数*/
    public FoodNormal(String foodName, int reilang, int danbz, int dianfen, int zf, int tang, int wss) {
        this.foodName = foodName;
        this.reilang = reilang;
        this.danbz = danbz;
        this.dianfen = dianfen;
        this.zf = zf;
        this.tang = tang;
        this.wss = wss;
    }

    /*2个参数*/
    public FoodNormal(String foodName, int reilang) {
        this(foodName, reilang, 0, 0, 0, 0, 0);
    }

    //3-6个参数要全部再写一次

    public static void main(String[] args) {
        new FoodNormal("food1", 1200, 200, 0, 0, 300, 100)
    }

}
