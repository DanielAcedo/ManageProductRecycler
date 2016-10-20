package com.danielacedo.listproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProduct_Activity extends AppCompatActivity implements IAddProductMvp.View{

    IAddProductMvp.Presenter presenter;
    EditText edt_Name, edt_Description, edt_Price, edt_Brand, edt_Dosage, edt_Stock, edt_Image;
    Button btn_AddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_);

        presenter = new AddProductPresenter(this);

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
                        Double.parseDouble(edt_Price.getText().toString()), Integer.parseInt(edt_Stock.getText().toString()),
                        Integer.parseInt(edt_Image.getText().toString()));
            }
        });
    }

    @Override
    public void setMessageError(String messageError, int view) {

        switch (view){
            case R.id.edt_Name:
                edt_Image.setError(messageError);
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
                edt_Description.setError(messageError);
                break;
            default:
                break;
        }
    }
}
