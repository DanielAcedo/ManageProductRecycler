package com.danielacedo.listproduct;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;

import com.danielacedo.listproduct.adapter.ProductAdapter;
import com.danielacedo.listproduct.adapter.ProductAdapterA;
import com.danielacedo.listproduct.adapter.ProductAdapterB;

/**
 * Activity inherating from ListActivity that displays all the products in out Applicationś List
 * @author Daniel Acedo Calderón
 */
public class ListProduct_Activity extends ListActivity {
    public final static int REQUEST_CODE_ADDPRODUCT = 1; //Request code to start an Activity for adding products

    //ArrayAdapter<Product> adapter;
    ProductAdapter adapter;
    FloatingActionButton fab_AddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_);

        //First case: Non custom Adapter
        /*adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,
                ((ListProduct_Application)getApplication()).getProducts());
        getListView().setAdapter(adapter);*/

        //Second case: Custom adapter
        adapter = new ProductAdapter(this);
        getListView().setAdapter(adapter);


        //FloatingActionButton
        fab_AddProduct = (FloatingActionButton) findViewById(R.id.fab_AddProduct);

        fab_AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListProduct_Activity.this, AddProduct_Activity.class);
                startActivityForResult(intent, REQUEST_CODE_ADDPRODUCT);
            }
        });


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
        if(requestCode == REQUEST_CODE_ADDPRODUCT && resultCode == Activity.RESULT_OK){
            adapter.notifyDataSetChanged();
        }
    }
}
