package in.incrementalsolutions.foodine;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

/**
 * Created by ManishKGupta on 16/02/15.
 */
public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<product> catalog;
    private static List<product> cart;

    public static List<product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<product>();
            catalog.add(new product("Dead or Alive", res
                    .getDrawable(R.drawable.ic_launcher),
                    "Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
            catalog.add(new product("Switch", res
                    .getDrawable(R.drawable.ic_launcher),
                    "Switch by Chip Heath and Dan Heath", 24.99));
            catalog.add(new product("Watchmen", res
                    .getDrawable(R.drawable.ic_launcher),
                    "Watchmen by Alan Moore and Dave Gibbons", 14.99));
        }

        return catalog;
    }

    public static List<product> getCart() {
        if(cart == null) {
            cart = new Vector<product>();
        }

        return cart;
    }
}
