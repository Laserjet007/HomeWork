/**
 *Java 1. HomeWork7
 *
 *@author teacher end Lazarev Alexei
 *@version 26.11.2021
 */
 
class HomeWork7 {
    public static void main(String[] args) {
        Cat[] cats = {
            new Cat("Barsik", 9), new Cat("Murzik", 5), new Cat("Vasily", 3)
        };
        Plate plate = new Plate(50, 30);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.setFullness(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean gotdrunk;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        gotdrunk = false;
    }
    void setFullness(boolean status) {
        gotdrunk = status;
    }

    void eat(Plate plate) {
        if (!gotdrunk) {
            gotdrunk = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return "{name=" + name + ", appetite=" +
        appetite + ", gotdrunk=" + gotdrunk +"}";
    }
}

class Plate {

    private int volume;
    private int food;

    Plate(int volume, int food) {
        this.volume = volume;
        this.food = food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) {
        return false;
        }
        food -= portion;
        return true;
    }

    void add(int food) {
        if (this.food + food <= volume) {
            this.food += food;
        }
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }
}