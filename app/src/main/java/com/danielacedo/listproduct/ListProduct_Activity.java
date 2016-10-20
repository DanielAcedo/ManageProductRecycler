package com.danielacedo.listproduct;

import android.app.ListActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.danielacedo.listproduct.model.Product;

public class ListProduct_Activity extends ListActivity {

    ArrayAdapter<Product> adapter;
    FloatingActionButton fab_AddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_);

        //First case: Non custom Adapter
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,
                ((Login_Application)getApplication()).getProducts());
        getListView().setAdapter(adapter);

        fab_AddProduct = (FloatingActionButton) findViewById(R.id.fab_AddProduct);

        fab_AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
