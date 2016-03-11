package Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.konrad.simpleunitconverter.R;
import com.example.konrad.simpleunitconverter.SettingsActivity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Konrad on 3/10/2016.
 */
public class ChooseKeyboardDialog extends DialogFragment {
    private SettingsActivity st;
    private ChooseKeyboardDialog this1;
    private String kb;
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        this1=this;
        st = (SettingsActivity)getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(st);
        builder.setTitle("Choose Keyboard");
        final String [] pom1= getResources().getStringArray(R.array.keyboards);
        kb = st.getKeyboard();
        //ArrayList<String> aL1 = new ArrayList<String>(Arrays.asList(pom1));
        //ArrayAdapter<String> aA1 = new ArrayAdapter<String> (getActivity(),android.R.layout.select_dialog_singlechoice,aL1);
        int tmp = 0;
        if (st.getKeyboard().equals("text"))
            tmp = 1;
        else if (st.getKeyboard().equals("phone"))
            tmp = 0;
        builder.setSingleChoiceItems(pom1,tmp, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (pom1[which].equals("Text style")){
                    if (st.getKeyboard().equals(kb)){
                        st.setKeyboard("text");
                        st.sendFlagTrue();
                    }
                    this1.dismiss();
                }
                else if (pom1[which].equals("Phone style")){
                    if (st.getKeyboard().equals(kb)){
                        st.setKeyboard("phone");
                        st.sendFlagTrue();
                    }
                    this1.dismiss();
                }

            }});
        return builder.create();
    }

}
