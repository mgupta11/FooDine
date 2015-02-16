package in.incrementalsolutions.foodine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;



public class ShoppingCartActivity extends Activity {

    private List<product> mCartList;
    private ProductAdapter mProductAdapter;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);

        mCartList = ShoppingCartHelper.getCartList();

        // Make sure to clear the selections
        for (int i = 0; i < mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }

        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent productionDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                productionDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productionDetailsIntent);

            }
        });



           /* Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);

            removeButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Loop through and remove all the products that are selected
                    // Loop backwards so that the remove works correctly
                    for(int i=mCartList.size()-1; i>=0; i--) {

                        if(mCartList.get(i).selected) {
                            mCartList.remove(i);
                        }
                    }
                    mProductAdapter.notifyDataSetChanged();
                }
            });

            */

    }


    @Override
    protected void onResume() {
        super.onResume();

            //Refresh the data

            if(mProductAdapter!=null)
            {

                mProductAdapter.notifyDataSetChanged();

            }
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
