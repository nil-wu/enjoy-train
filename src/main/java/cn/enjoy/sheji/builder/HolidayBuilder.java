package cn.enjoy.sheji.builder;

import cn.enjoy.sheji.factory.product.Apple;
import cn.enjoy.sheji.factory.product.Banana;
import cn.enjoy.sheji.factory.product.Orange;

public class HolidayBuilder implements Builder{
    private FruitMeal fruitMeal = new FruitMeal();

    @Override
    public void buildApple(int price) {
        Apple apple = new Apple();
        apple.setPrice(price);
        fruitMeal.setApple(apple);
    }

    @Override
    public void buildBanana(int price) {
        Banana banana = new Banana();
        banana.setPrice(price);
        fruitMeal.setBanana(banana);
    }

    @Override
    public void buildOrange(int price) {
        Orange orange = new Orange();
        orange.setPrice(price);
        fruitMeal.setOrange(orange);
    }

    @Override
    public FruitMeal getFruitMeal() {
        fruitMeal.setDiscount(15);
        fruitMeal.init();
        return fruitMeal;
    }
}