package in.incrementalsolutions.foodine;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by ManishKGupta on 16/02/15.
 */
public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<product> catalog;
    public static Map<product,ShoppingCartEntry> cartMap = new HashMap<product,ShoppingCartEntry>();
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

    public static void setQuantity(product product, int quantity){

        //Get the current cart entry

        ShoppingCartEntry curEntry = cartMap.get(product);

        //Remove the products if quantity is zero or less

        if (quantity <= 0) {

            if (curEntry!=null)
            removeproduct(product);
            return;

        }

        //If current cart entry does not exist, create one

        if(curEntry == null){

            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product,curEntry);
            return;
        }

        //update the quantity
        curEntry.setquantity(quantity);

    }

    public static int getProductQuantity(product product) {

      //get current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);
        if(curEntry!=null)
            return curEntry.getquantity();
        return 0;
    }

    public static void removeproduct(product product) {

        cartMap.remove(product);
    }

    public static List<product> getCartList() {

        List<product> cartList = new Vector<product>(cartMap.keySet().size());
        for (product p : cartMap.keySet()){

            cartList.add(p);
        }
        return cartList;
    }
}
