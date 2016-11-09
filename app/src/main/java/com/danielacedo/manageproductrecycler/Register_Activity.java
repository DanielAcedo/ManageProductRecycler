package com.danielacedo.manageproductrecycler;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Activity used for registering new users
 * @author Daniel Acedo Calderón
 */
public class Register_Activity extends AppCompatActivity {

    private Spinner spProvince;
    private Spinner spCity;
    private Button btn_ConfirmSignup;
    private RadioGroup rg_typeClient;
    private TextView txv_CompanyNameRegister;
    private EditText edt_CompanyNameRegister;

    private AdapterView.OnItemSelectedListener spinnerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        spProvince = (Spinner)findViewById(R.id.spn_ProvinceRegister);
        spCity = (Spinner)findViewById(R.id.spn_CityRegister);

        rg_typeClient = (RadioGroup)findViewById(R.id.rg_CompanyParticular);
        rg_typeClient.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_Company:
                        showCompany(true);
                        break;
                    case R.id.rb_Particular:
                        showCompany(false);
                        break;
                }
            }
        });

        txv_CompanyNameRegister = (TextView)findViewById(R.id.txv_CompanyNameRegister);
        edt_CompanyNameRegister = (EditText)findViewById(R.id.edt_CompanyNameRegister);

        loadSpinnerProvince();
        loadSpinnerCountry();

    }

    public void showCompany(boolean value){
        txv_CompanyNameRegister.setVisibility(value ? View.VISIBLE : View.GONE);
        edt_CompanyNameRegister.setVisibility(value ? View.VISIBLE : View.GONE);
    }

    public void loadSpinnerCountry(){
        spinnerListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<CharSequence> adapter;

                TypedArray resourceProvinces = getResources().obtainTypedArray(R.array.array_provincia_a_localidades);


                Log.d("Register", resourceProvinces.getString(position));

                adapter = ArrayAdapter.createFromResource(Register_Activity.this,
                            getResources().getIdentifier(resourceProvinces.getString(position), "array", "com.danielacedo.manageproductrecycler"),
                            android.R.layout.simple_spinner_dropdown_item
                        );

                spCity.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        spProvince.setOnItemSelectedListener(spinnerListener);
    }

    public void loadSpinnerProvince(){
        //Initialize province Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.provincias, android.R.layout.simple_spinner_item);
        spProvince.setAdapter(adapter);
    }

    public void signUp(View view){

    }
}
