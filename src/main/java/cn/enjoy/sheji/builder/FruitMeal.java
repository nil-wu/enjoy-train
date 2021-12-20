package cn.enjoy.sheji.builder;

import cn.enjoy.sheji.factory.product.Apple;
import cn.enjoy.sheji.factory.product.Banana;
import cn.enjoy.sheji.factory.product.Orange;

public class FruitMeal {

    private Apple apple;
    private Banana banana;
    private Orange orange;
    private int discount;
    private int totalPrice;

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public void setBanana(Banana banana) {
        this.banana = banana;
    }

    public void setOrange(Orange orange) {
        this.orange = orange;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int cost(){
        return this.totalPrice;
    }

    public void init(){
        if (null != apple) {
            totalPrice +=apple.price;
        }
        if (null != orange) {
            totalPrice += orange.price;
        }
        if (null != banana) {
            totalPrice += banana.price;
        }
        if (totalPrice > 0) {
            totalPrice -= discount;
        }
    }

    public void showItems(){
        System.out.println("totalPrice: " + totalPrice);
    }

}
