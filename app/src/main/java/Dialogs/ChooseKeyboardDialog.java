package Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;

import com.example.konrad.simpleunitconverter.R;

/**
 * Created by Konrad on 3/10/2016.
 */
public class ChooseKeyboardDialog extends DialogFragment {
    public Dialog onCreateDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose keyboard style");
        builder.setItems(R.array.keyboards, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        } );

        Dialog dialog = builder.create();
        return dialog;

    }
}
