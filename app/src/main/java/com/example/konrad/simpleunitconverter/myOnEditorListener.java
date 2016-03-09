package com.example.konrad.simpleunitconverter;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

/**
 * Created by Konrad on 3/9/2016.
 */
public class myOnEditorListener implements TextView.OnEditorActionListener{
    private MainActivity m;
    public myOnEditorListener(MainActivity m){
        super();
        this.m=m;
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        int result = actionId & EditorInfo.IME_MASK_ACTION;
        switch(result){
            case EditorInfo.IME_ACTION_DONE:
                m.calculate();
                m.hideKeyBoard();
                return true;
            default:
                break;
        }


        return false;
    }
}
