public class Basket {

    private MarketProduct[] arr;

    public Basket() {
        this.arr = new MarketProduct[0];
    }

    public MarketProduct[] getProducts() {
        MarketProduct[] shallow = new MarketProduct[this.arr.length];
        for (int i = 0; i < this.arr.length; i++)
            shallow[i] = this.arr[i];
        return shallow;
    }

    public void add(MarketProduct prod) {

        MarketProduct[] copy = new MarketProduct[this.arr.length + 1];

        if (this.arr.length == 0) {
            this.arr = new MarketProduct[1];
            this.arr[0] = prod;

        } else {

            for (int i = 0; i < this.arr.length; i++)
                copy[i] = this.arr[i];

            this.arr = copy;
            copy[copy.length - 1] = prod;
        }
    }

    public boolean remove(MarketProduct prod) {

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(prod)) {
                index = i;
                arr[index] = null;


                for (int j = index; j < arr.length - 1; j++)
                    arr[j] = arr[j + 1];

                MarketProduct[] copy = new MarketProduct[arr.length - 1];
                for (int k = 0; k < arr.length - 1; k++)
                    copy[k] = arr[k];

                arr = copy;
            }
        }
        return index != -1;

    }

    public void clear() {
        arr = new MarketProduct[0];
    }

    public int getNumOfProducts() {
        return this.arr.length;
    }

    public int getSubTotal() {
        int subTotal = 0;
        for (int i = 0; i < arr.length; i++)
            subTotal += arr[i].getCost();
        return subTotal;
    }

    public int getTotalTax() {
        int totalTax = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] instanceof Jam))
                totalTax += (int) (0.15 * arr[i].getCost());
        }
        return totalTax;
    }

    public int getTotalCost() {
        return (this.getSubTotal() + this.getTotalTax());
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < arr.length; i++)
            s += arr[i].getName() + " \t" + String.format("%.2f", (arr[i].getCost()) / 100.0) + "\n";

        s += "\nSubtotal \t" + String.format("%.2f", getSubTotal() / 100.0);
        s += "\nTotal Tax \t" + String.format("%.2f", getTotalTax() / 100.0);
        s += "\n\nTotal Cost \t" + String.format("%.2f", getTotalCost() / 100.0);

        return s;
    }
}

