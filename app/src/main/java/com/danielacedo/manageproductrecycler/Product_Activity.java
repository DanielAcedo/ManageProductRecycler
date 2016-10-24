package com.danielacedo.manageproductrecycler;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.danielacedo.manageproductrecycler.adapter.ProductAdapterRecycler;

/**
 * Activity inherating from ListActivity that displays all the products in out Applicationś List
 * @author Daniel Acedo Calderón
 */
public class Product_Activity extends AppCompatActivity {
    public final static int REQUEST_CODE_ADDPRODUCT = 1; //Request code to start an Activity for adding products

    ProductAdapterRecycler adapter;
    private RecyclerView rcv_Product;
    FloatingActionButton fab_AddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_);

        adapter = new ProductAdapterRecycler(this);
        rcv_Product = (RecyclerView)findViewById(R.id.rcv_Product);
        rcv_Product.setLayoutManager(new LinearLayoutManager(this));
        rcv_Product.setAdapter(adapter);

        fab_AddProduct = (FloatingActionButton)findViewById(R.id.fab_AddProduct);
        fab_AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Product_Activity.this, AddProduct_Activity.class);
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
