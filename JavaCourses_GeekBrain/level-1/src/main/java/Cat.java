public class Cat{
    private String name;
    private int appetite;
    private boolean wellFed = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate, String name){
        wellFed = (plate.getFoodQuantity()-appetite)>=0;    //---Кол-во еды в тарелке
        if (wellFed){
            System.out.println(isFoodEnough(plate.getFoodQuantity(), name)+". Он съел " + appetite+" и теперь он "+isFull(wellFed));
            plate.decreaseFood(appetite);
        }else{
            System.out.println(isFoodEnough(plate.getFoodQuantity(), name)+". Кот хотел съесть "+ appetite +", однако в миске только "+plate.getFoodQuantity()+", поэтому он "+isFull(wellFed));
        }
    }

    public String isFull(boolean full){ // Сытость кота
        if(full){
            return "cыт";
        }else{
            return "голоден";
        }
    }

    public String isFoodEnough(int food, String name) { // Прикоснулся ли кот к миске или нет
        if (food>=appetite){
            return "Кот по имени "+name+" прикоснулся к миске";
        }else{
            return "Кот "+name+" не трогал миску";
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isWellFed() {
        return wellFed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setWellFed(boolean wellFed) {
        this.wellFed = wellFed;
    }
}
