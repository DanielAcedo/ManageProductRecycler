package com.danielacedo.manageproductrecycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.danielacedo.manageproductrecycler.ListProduct_Application;
import com.danielacedo.manageproductrecycler.R;
import com.danielacedo.manageproductrecycler.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daniel on 24/10/16.
 */

public class ProductAdapterRecycler extends RecyclerView.Adapter<ProductAdapterRecycler.ProductViewHolder>{

    private boolean sortedNameAscendant = true;

    private List<Product> products;
    private Context context;

    public ProductAdapterRecycler(Context context){
        this.context = context;
        this.products = new ArrayList<Product>();
        products.addAll(((ListProduct_Application)context.getApplicationContext()).getProducts()); //Create local copy from Application List.

    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.imv_listProduct_Image.setImageResource(products.get(position).getImage());
        holder.txv_listProduct_Name.setText(products.get(position).getName());
        holder.txv_listProduct_Stock.setText(String.valueOf(products.get(position).getStock()));
        holder.txv_listProduct_Price.setText(String.valueOf(products.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imv_listProduct_Image;
        TextView txv_listProduct_Name, txv_listProduct_Price, txv_listProduct_Stock;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imv_listProduct_Image = (ImageView) itemView.findViewById(R.id.imv_listProduct_Image);
            txv_listProduct_Name = (TextView) itemView.findViewById(R.id.txv_listProduct_Name);
            txv_listProduct_Price = (TextView) itemView.findViewById(R.id.txv_listProduct_Price);
            txv_listProduct_Stock = (TextView) itemView.findViewById(R.id.txv_listProduct_Stock);

        }
    }

    public void getAlphabeticallySortedProducts(){

        if(!sortedNameAscendant){ //If sorted alphabetically backwards
            Collections.sort(products, Product.NAME_ASCENDANT_COMPARATOR);
            sortedNameAscendant = true;
        }
        else {
            Collections.sort(products, Product.NAME_DESCENDANT_COMPARATOR);
            sortedNameAscendant = false;
        }

        this.notifyDataSetChanged();
    }


}
