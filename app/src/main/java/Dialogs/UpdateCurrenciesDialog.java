package Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.konrad.simpleunitconverter.MainActivity;
import com.example.konrad.simpleunitconverter.R;

import StaticUtilities.CurrencyValueManager;

/**
 * Created by Konrad on 19/03/2016.
 */
public class UpdateCurrenciesDialog extends DialogFragment {
    private MainActivity ac;

    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        ac = (MainActivity)getActivity();

        LayoutInflater lf = ac.getLayoutInflater();
        LinearLayout ll = (LinearLayout) lf.inflate(R.layout.my_update_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(ac);
        builder.setTitle("Current rates: " + ac.getCurrencyPreferences().getString("Date", "error getting rates"));
        builder.setView((View)ll);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CurrencyValueManager.updateValuesViaInternet(ac,ac.getCurrencyPreferences());
                dialog.dismiss();
            }
        });
        return builder.create();

    }

}
