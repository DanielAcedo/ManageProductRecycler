package com.danielacedo.manageproductrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.danielacedo.manageproductrecycler.interfaces.IAddProductMvp;
import com.danielacedo.manageproductrecycler.presenter.ManageProductPresenter;

/**
 * Activity used for adding new products to the application. After creating one successfully it calls back ListProductActivity
 * @author Daniel Acedo Calderón
 */
public class ManageProduct_Activity extends AppCompatActivity implements IAddProductMvp.View{

    IAddProductMvp.Presenter presenter;
    EditText edt_Name, edt_Description, edt_Price, edt_Brand, edt_Dosage, edt_Stock, edt_Image;
    Button btn_AddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product_);

        presenter = new ManageProductPresenter(this);

        edt_Name = (EditText) findViewById(R.id.edt_Name);
        edt_Description = (EditText) findViewById(R.id.edt_Description);
        edt_Price = (EditText) findViewById(R.id.edt_Price);
        edt_Brand = (EditText) findViewById(R.id.edt_Brand);
        edt_Dosage = (EditText) findViewById(R.id.edt_Dosage);
        edt_Stock = (EditText) findViewById(R.id.edt_Stock);
        edt_Image = (EditText) findViewById(R.id.edt_Image);

        btn_AddProduct = (Button)findViewById(R.id.btn_AddProduct);
        btn_AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateProductFields(edt_Name.getText().toString(), edt_Description.getText().toString(),
                            edt_Brand.getText().toString(), edt_Dosage.getText().toString(),
                            edt_Price.getText().toString(), edt_Stock.getText().toString(),
                            edt_Image.getText().toString());


            }
        });
    }

    /**
     * Displays error messages from the presenter in the corresponding views
     * @param messageError The message to be displayed
     * @param view The id of the view to be displayed
     * @author Daniel Acedo Calderón
     */
    @Override
    public void setMessageError(String messageError, int view) {

        switch (view){
            case R.id.edt_Name:
                edt_Name.setError(messageError);
                break;
            case R.id.edt_Description:
                edt_Description.setError(messageError);
                break;
            case R.id.edt_Price:
                edt_Price.setError(messageError);
                break;
            case R.id.edt_Brand:
                edt_Brand.setError(messageError);
                break;
            case R.id.edt_Dosage:
                edt_Dosage.setError(messageError);
                break;
            case R.id.edt_Stock:
                edt_Stock.setError(messageError);
                break;
            case R.id.edt_Image:
                edt_Image.setError(messageError);
                break;
            default:
                break;
        }
    }
}
