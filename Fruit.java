public class Fruit extends MarketProduct {
    private double weight;
    private int price;

    public Fruit(String name, double weight, int price) {
        super(name);
        this.weight = weight;
        this.price = price;
    }

    public int getCost() {
        return (int) (price * weight);
    }

    public boolean equals(Object obj) {
        return obj instanceof Fruit && ((Fruit) obj).getName().equals(this.getName()) &&
               ((Fruit) obj).weight == this.weight && ((Fruit) obj).price == this.price;
    }
}
