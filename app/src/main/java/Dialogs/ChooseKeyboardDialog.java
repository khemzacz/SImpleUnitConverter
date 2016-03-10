package Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
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
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        st = (SettingsActivity)getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(st);
        builder.setTitle("Choose Keyboard");
        String [] pom1= getResources().getStringArray(R.array.keyboards);
        //ArrayList<String> aL1 = new ArrayList<String>(Arrays.asList(pom1));
        //ArrayAdapter<String> aA1 = new ArrayAdapter<String> (getActivity(),android.R.layout.select_dialog_singlechoice,aL1);
        builder.setSingleChoiceItems(pom1,-1, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //st.

            }});
        return builder.create();
    }

}
