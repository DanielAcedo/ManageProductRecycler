package com.danielacedo.manageproductrecycler;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.danielacedo.manageproductrecycler.adapter.ProductAdapterRecycler;

/**
 * Activity inherating from ListActivity that displays all the products in out Applicationś List
 * @author Daniel Acedo Calderón
 */
public class Product_Activity extends AppCompatActivity {
    public final static int REQUEST_CODE_ADD_PRODUCT = 1; //Request code to start an Activity for adding products
    public final static int REQUEST_CODE_EDIT_PRODUCT = 2;


    private ProductAdapterRecycler adapter;
    private RecyclerView rcv_Product;
    private FloatingActionButton fab_AddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_);

        //Adapter
        adapter = new ProductAdapterRecycler(this);
        rcv_Product = (RecyclerView)findViewById(R.id.rcv_Product);
        rcv_Product.setLayoutManager(new LinearLayoutManager(this));
        rcv_Product.setAdapter(adapter);

        //FloatingActionButton
        fab_AddProduct = (FloatingActionButton)findViewById(R.id.fab_AddProduct);
        fab_AddProduct.setOnClickListener( (v) -> {    //Lambda expression for onclick
            Intent intent = new Intent(Product_Activity.this, ManageProduct_Activity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_PRODUCT);
        });

    }

    /*
        Inflates menu in the activity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product, menu); //Inflates the menu resource in the menu object
        return super.onCreateOptionsMenu(menu);
    }

    /*
        Code to be executed for every menuitem
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_add_product:
                Intent intent = new Intent(Product_Activity.this, ManageProduct_Activity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD_PRODUCT);
                break;
            case R.id.action_sort_alphabetically:
                adapter.getAlphabeticallySortedProducts();
                break;
            case R.id.action_settings_general:
                break;
            case R.id.action_settings_account:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles callbacks for activities called with startActivityForResult
     * @param requestCode Request code used for starting the activity
     * @param resultCode Code sent from the started activity
     * @param data Data sent from the started activity
     * @author Daniel Acedo Calderón
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_ADD_PRODUCT && resultCode == Activity.RESULT_OK){ // For adding products
            adapter.notifyDataSetChanged();
        }
    }
}
