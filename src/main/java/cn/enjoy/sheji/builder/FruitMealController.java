package cn.enjoy.sheji.builder;

public class FruitMealController {

    public void construct(){
        Builder builder = new HolidayBuilder();

        builder.buildApple(100);
        builder.buildOrange(80);
        builder.buildBanana(50);

        FruitMeal fruitMeal = builder.getFruitMeal();
        int cost = fruitMeal.cost();
        System.out.println("本套花费： " + cost);

    }

    public static void main(String[] args) {
        new FruitMealController().construct();
    }
}
