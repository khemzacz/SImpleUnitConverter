package com.example.konrad.simpleunitconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import Converters.AbstractConverter;
import Converters.ConverterFactory;
import Listeners.MyMainSpinnerListener;
import Listeners.MyTextWatcher;
import Listeners.MyOnEditorListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ActionBarActivity {
    final private MainActivity this1= this;
    private Spinner spinner1, spinner2, spinner3;
    private EditText e1;
    private TextView r1;
    private String[] pom1, pom2, pom3, pom4;
    private ArrayList<String> l1, l2, l3, l4;
    private ArrayAdapter<String> adapter1, adapter2, adapter3, adapter4;
    private int precision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 =  (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        e1 = (EditText) findViewById(R.id.editText);
        if (e1.getInputType() == InputType.TYPE_CLASS_TEXT){
            e1.addTextChangedListener(new MyTextWatcher(this));
        } else if(e1.getInputType() == InputType.TYPE_CLASS_PHONE) {
            e1.setOnEditorActionListener(new MyOnEditorListener(this));
        }
        precision=2;
        r1 = (TextView) findViewById(R.id.textView2);
        pom1 = getResources().getStringArray(R.array.mass_units); // takes Strings from XML and puts into table
        pom2 = getResources().getStringArray(R.array.distance_units);
        pom3 = getResources().getStringArray(R.array.temperature_units);
        pom4 = getResources().getStringArray(R.array.speed_units);
        l1 = new ArrayList<String>(Arrays.asList(pom1));
        l2 = new ArrayList<String>(Arrays.asList(pom2));
        l3 = new ArrayList<String>(Arrays.asList(pom3));
        l4 = new ArrayList<String>(Arrays.asList(pom4));
        adapter1 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, l1);
        adapter2 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, l2);
        adapter3 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, l3);
        adapter4 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, l4);
        addListenerOnSpinnerDimensionSelection();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addListenerOnSpinnerDimensionSelection() {
        spinner1.setOnItemSelectedListener(new MyMainSpinnerListener(this1));
    }

    public void onButtonClick(View v) {
        calculate();
    }

    public void calculate(){
        //System.gc();
        String txt0=spinner1.getSelectedItem().toString();
        String txt1=spinner2.getSelectedItem().toString();
        String txt2=spinner3.getSelectedItem().toString();
        try {
            String a = this.e1.getText().toString();
            ConverterFactory cf1 = new ConverterFactory(precision);
            AbstractConverter c1 = cf1.createConverter(txt0);
            String nt = c1.convert(a,txt1,txt2);
            r1.setText(nt);

        } catch(Exception io){
            r1.setText("Incorrect input");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent("com.example.konrad.simpleunitconverter.SettingsActivity");
            startActivity(settingsIntent);
            return true;
        }
        if (id == R.id.action_exit) {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    public EditText getE1(){
        return e1;
    }
    public void hideKeyBoard(){

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(e1.getWindowToken(), 0);
    }
    public void setPrecision(int p){
        this1.precision = p;
    }

    public ArrayAdapter<String> getAdapter1(){return adapter1;}

    public ArrayAdapter<String> getAdapter2() {
        return adapter2;
    }

    public ArrayAdapter<String> getAdapter3() {
        return adapter3;
    }

    public ArrayAdapter<String> getAdapter4() {
        return adapter4;
    }

    public Spinner getSpinner1(){return spinner1;}
    public Spinner getSpinner2(){return spinner2;}
    public Spinner getSpinner3(){return spinner3;}
}
