package com.example.konrad.simpleunitconverter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
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
import Dialogs.UpdateCurrenciesDialog;
import Listeners.MyMainSpinnerListener;
import Listeners.MyTextWatcher;
import Listeners.MyOnEditorListener;
import StaticUtilities.CurrencyValueManager;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ActionBarActivity {
    final private MainActivity this1= this;
    private SharedPreferences sharedPreferences;
    private SharedPreferences currencyPreferences;
    private Intent settingsIntent;
    private Spinner spinner1, spinner2, spinner3;
    //private MyTextWatcher watcher1;
    private boolean firstLaunch;
    private MyOnEditorListener oEL;
    private EditText e1;
    private TextView r1;
    private String[] pom1, pom2, pom3, pom4, pom5;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private ArrayAdapter<String> adapter4;



    private ArrayAdapter<String> adapter5;
    private int precision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        e1 = (EditText) findViewById(R.id.editText);
        oEL = new MyOnEditorListener(this);
        loadSettings();
        e1.setOnEditorActionListener(oEL);
        r1 = (TextView) findViewById(R.id.textView2);
        pom1 = getResources().getStringArray(R.array.mass_units); // takes Strings from XML and puts into table
        pom2 = getResources().getStringArray(R.array.length_units);
        pom3 = getResources().getStringArray(R.array.temperature_units);
        pom4 = getResources().getStringArray(R.array.speed_units);
        pom5 = getResources().getStringArray(R.array.power_units);
        adapter1 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, new ArrayList<String>(Arrays.asList(pom1)));
        adapter2 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, new ArrayList<String>(Arrays.asList(pom2)));
        adapter3 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, new ArrayList<String>(Arrays.asList(pom3)));
        adapter4 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, new ArrayList<String>(Arrays.asList(pom4)));
        adapter5 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, new ArrayList<String>(Arrays.asList(pom5)));
        pom1 = null; pom2 = null; pom3=null;pom4=null;pom5=null;
        System.gc();
        addListenerOnSpinnerDimensionSelection();
        if (firstLaunch){
            UpdateCurrenciesDialog dl = new UpdateCurrenciesDialog();
            dl.show(getFragmentManager(),"update dialog");
        }
        sharedPreferences.edit().putBoolean("firstLaunch",false);
        sharedPreferences.edit().commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onResume(){
        super.onResume();
        loadSettings();
    }


    // loads settings from Shared preferences
    private void loadSettings(){
        sharedPreferences=getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String keyboard = sharedPreferences.getString("keyboard","phone");

        if (keyboard.equals("text")){
            e1.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else if (keyboard.equals("phone")){
            e1.setInputType(InputType.TYPE_CLASS_PHONE);
        }

        precision = sharedPreferences.getInt("precision",2);
        firstLaunch = sharedPreferences.getBoolean("firstLaunch", true);


        currencyPreferences = getSharedPreferences("Currencies", Context.MODE_PRIVATE);
        CurrencyValueManager.setInitialValues(currencyPreferences);
    }

    private void addListenerOnSpinnerDimensionSelection() {
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
            settingsIntent = new Intent("com.example.konrad.simpleunitconverter.SettingsActivity");
            startActivity(settingsIntent);
            return true;
        }
        if (id == R.id.action_exit) {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }


    public void getCurrencyJSON(){


    }


    public EditText getE1(){
        return e1;
    }
    public void hideKeyBoard(){

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(e1.getWindowToken(), 0);
    }
    public void setE1InputType(int inputType){
        e1.setInputType(inputType);
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

    public ArrayAdapter<String> getAdapter5() {
        return adapter5;
    }

    public Spinner getSpinner1(){return spinner1;}
    public Spinner getSpinner2(){return spinner2;}
    public Spinner getSpinner3(){return spinner3;}
    public SharedPreferences getCurrencyPreferences() {
        return currencyPreferences;
    }
}
