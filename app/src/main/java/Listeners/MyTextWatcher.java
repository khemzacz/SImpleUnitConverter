package Listeners;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;

import com.example.konrad.simpleunitconverter.MainActivity;

/**
 * Created by Konrad on 3/6/2016.
 */
public class MyTextWatcher implements TextWatcher {
    private MainActivity m;
    public MyTextWatcher(MainActivity m){
        super();
        this.m=m;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        for(int i = s.length(); i > 0; i--){ // need to get rid of nasty new lines
            if(s.subSequence(i-1, i).toString().equals("\n")) {
                s.replace(i - 1, i, "");
                m.calculate();
                m.hideKeyBoard();
            }
        }
        //String myTextString = s.toString();
    }
}
