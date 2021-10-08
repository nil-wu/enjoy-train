package cn.enjoy.jvm.builder;

/**
 * 有可能漏了set值
 */
public class FoodJavaBean {

    /*required*/
    private final String foodName;
    private final int reilang;

    /*optional*/
    private  int danbz;//蛋白质
    private  int dianfen;//淀粉
    private  int zf;//脂肪
    private  int tang;//糖分
    private  int wss;//维生素

    public FoodJavaBean(String foodName, int reilang) {
        this.foodName = foodName;
        this.reilang = reilang;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getReilang() {
        return reilang;
    }

    public int getDanbz() {
        return danbz;
    }

    public void setDanbz(int danbz) {
        this.danbz = danbz;
    }

    public int getDianfen() {
        return dianfen;
    }

    public void setDianfen(int dianfen) {
        this.dianfen = dianfen;
    }

    public int getZf() {
        return zf;
    }

    public void setZf(int zf) {
        this.zf = zf;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getWss() {
        return wss;
    }

    public void setWss(int wss) {
        this.wss = wss;
    }
}
