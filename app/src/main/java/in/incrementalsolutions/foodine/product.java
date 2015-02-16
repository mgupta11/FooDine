package in.incrementalsolutions.foodine;

import android.graphics.drawable.Drawable;

/**
 * Created by ManishKGupta on 15/02/15.
 */
public class product {

    public String title;
    public Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    public product(String title, Drawable productImage, String description,
                   double price) {
        this.title = title;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
    }


}
