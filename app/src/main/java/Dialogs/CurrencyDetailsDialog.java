package Dialogs;

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

import com.example.konrad.simpleunitconverter.MainActivity;
import com.example.konrad.simpleunitconverter.R;
import com.example.konrad.simpleunitconverter.SettingsActivity;

import StaticUtilities.CurrencyValueManager;

/**
 * Created by Konrad on 19/03/2016.
 */
public class CurrencyDetailsDialog extends DialogFragment {
    private SettingsActivity sa;

    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        sa = (SettingsActivity)getActivity();

        LayoutInflater lf = sa.getLayoutInflater();
        LinearLayout ll = (LinearLayout) lf.inflate(R.layout.my_update_layout, null);
        TextView txv = (TextView) ll.findViewById(R.id.currencyTextView);
        txv.setGravity(Gravity.CENTER);
        txv.setText("Do You want to update?\n Server has new data every day arround 3 PM CET");
        AlertDialog.Builder builder = new AlertDialog.Builder(sa);
        builder.setTitle("Current rates: " + sa.getCurrencyPreferences().getString("Date", "error getting rates"));
        builder.setView((View) ll);
        builder.setPositiveButton("UpdateNow", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CurrencyValueManager.updateValuesViaInternet(sa, sa.getCurrencyPreferences());
                dialog.dismiss();
            }
        });
        return builder.create();

    }



}
