package cn.enjoy.sheji.builder;

/**
 * 创建一个MealBuilder类，实际的builder类负责创建套餐的Meal对象
 */
public interface Builder {

    void buildApple(int price);
    void buildBanana(int price);
    void buildOrange(int price);

    FruitMeal getFruitMeal();

}
