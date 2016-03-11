package com.example.konrad.simpleunitconverter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import Dialogs.ChooseKeyboardDialog;
import Listeners.MySettingsListListener;

public class SettingsActivity extends ActionBarActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent thisIntent;
    private Bundle thisBundle;

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    private ListView mainListView;
    private ArrayList<String> mainList;
    private ArrayAdapter<String> mainListAdapter;
    private SettingsActivity this1= this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mainListView= (ListView) findViewById(R.id.listView1);

        String [] pom1 = getResources().getStringArray(R.array.settingsList);
        mainList = new ArrayList<String>(Arrays.asList(pom1));
        mainListAdapter = new ArrayAdapter<String> (this1, android.R.layout.simple_selectable_list_item,mainList);
        mainListView.setAdapter(mainListAdapter);
        mainListView.setOnItemClickListener(new MySettingsListListener(this1));
        thisIntent = getIntent();
        thisBundle = new Bundle();
        sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }


    public void showKeyboardDialog(View v){
        ChooseKeyboardDialog d1 = new ChooseKeyboardDialog();
        d1.show(getFragmentManager(),"KeyboardDialog");
    }



    public ListView getMainListView() {
        return mainListView;
    }

    public ArrayList<String> getMainList() {
        return mainList;
    }

    public ArrayAdapter<String> getMainListAdapter() {
        return mainListAdapter;
    }

    public Intent getThisIntent() {
        return thisIntent;
    }

    public Bundle getThisBundle() {
        return thisBundle;
    }
}
