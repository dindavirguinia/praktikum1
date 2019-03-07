package com.example.lenovo.praktikum1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create the spinner
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        //Create the array adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        //spesifikasi
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    public void onRadioButtonClicked(View view) {
        //melakukan cek pada radio button
        //button yang dipilih akan menampilkan toast sesuai dengan delivery methodnya
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.sameday_text));
                break;
            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.nextday_text));
                break;
            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pick_up_text));
                break;
             default:
                 //do nothing
                 break;
        }
    }

    public void displayToast(String message){
        //membuat fungsi toast
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    //do nothing
    }

}
