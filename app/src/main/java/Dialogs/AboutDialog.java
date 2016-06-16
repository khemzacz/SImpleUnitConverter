package Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.konrad.simpleunitconverter.R;
import com.example.konrad.simpleunitconverter.SettingsActivity;

import StaticUtilities.CurrencyValueManager;

/**
 * Created by Konrad on 16/06/2016.
 */
public class AboutDialog extends DialogFragment {
    private Activity ac;
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        ac = getActivity();
        LayoutInflater lf = ac.getLayoutInflater();
        LinearLayout ll = (LinearLayout) lf.inflate(R.layout.my_update_layout, null);
        TextView txv = (TextView) ll.findViewById(R.id.currencyTextView);
        txv.setGravity(Gravity.CENTER);
        txv.setText("\n Konrad Hemzaczek, WIMiIP\n");
        AlertDialog.Builder builder = new AlertDialog.Builder(ac);
        builder.setTitle("App author: ");
        builder.setView((View) ll);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.create();

    }

}
