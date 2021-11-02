public class Customer {

    private String name;
    private int balance;
    private Basket basket;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.basket = new Basket();
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public Basket getBasket() {
        return this.basket;
    }

    public int addFunds(int funds) {

        if (funds < 0) {
            throw new IllegalArgumentException("Cannot add negative funds!");
        }

        this.balance += funds;
        return this.balance;

    }

    public void addToBasket(MarketProduct prod) {
        this.basket.add(prod);
    }

    public boolean removeFromBasket(MarketProduct prod) {
        return this.basket.remove(prod);
    }

    public String checkOut() {

        if (this.balance < this.basket.getTotalCost())
            throw new IllegalStateException("You can't afford this");
        else {
            this.balance -= this.basket.getTotalCost();
            String s = this.basket.toString();
            this.basket.clear();
            return s;
        }
    }

}
