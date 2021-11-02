public class Jam extends MarketProduct {
    private int num;
    private int price;

    public Jam(String name, int num, int price) {
        super(name);
        this.num = num;
        this.price = price;
    }

    public int getCost() {
        return num * price;
    }

    public boolean equals(Object obj) {
        return obj instanceof Jam && ((Jam) obj).getName().equals(this.getName()) &&
               ((Jam) obj).num == this.num && ((Jam) obj).price == this.price;
    }
}
