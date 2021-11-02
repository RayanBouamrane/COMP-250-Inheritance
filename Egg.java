public class Egg extends MarketProduct {
    private int num;
    private int price;

    public Egg(String name, int num, int price) {
        super(name);
        this.num = num;
        this.price = price;
    }

    public int getCost() {
        return price * num / 12;
    }

    public boolean equals(Object obj) {
        return obj instanceof Egg && ((Egg) obj).getName().equals(this.getName()) &&
               ((Egg) obj).getCost() == this.getCost() && ((Egg) obj).num == this.num;
    }
}
