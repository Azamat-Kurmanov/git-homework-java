public class Plate {
    private int foodQuantity;

    public Plate(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public void info(){
        System.out.printf("Текущее количество еды %d \n", foodQuantity);
    }

    public void decreaseFood(int foodQuantity) {
        this.foodQuantity -= foodQuantity;
    }

    public void increaseFoodQuantity(int foodQuantity) {    // Добавление еды в миску
        this.foodQuantity += foodQuantity;
        System.out.printf("В миску было добавлено %d.  \n",foodQuantity);
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
