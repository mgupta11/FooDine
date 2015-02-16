package in.incrementalsolutions.foodine;

/**
 * Created by ManishKGupta on 16/02/15.
 */
public class ShoppingCartEntry {

    private product mproduct;
    private int mquantity;

    public ShoppingCartEntry(product product, int quantity) {
        mproduct = product;
        mquantity = quantity;
    }

    public product getproduct() {

        return mproduct;
    }

    public int getquantity() {

        return mquantity;
    }

    public void setquantity(int quantity) {

        mquantity = quantity;
    }

}
