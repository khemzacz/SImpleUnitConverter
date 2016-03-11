package Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.konrad.simpleunitconverter.R;
import com.example.konrad.simpleunitconverter.SettingsActivity;

import org.w3c.dom.Text;

/**
 * Created by Konrad on 3/10/2016.
 */
public class PrecisionDialog extends DialogFragment {
    private SettingsActivity st;
    private PrecisionDialog this1;
    private int precision;
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        this1=this;
        st = (SettingsActivity)getActivity();

        precision =st.getPrecision();

        LayoutInflater inflater = st.getLayoutInflater();
        LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.my_precision_selection, null);
        final SeekBar sk = (SeekBar) ll.findViewById(R.id.precisionSeekBar);
        final TextView tx = (TextView) ll.findViewById(R.id.precisionTextView);
        Log.v("PrecisionDialog", "ok so far");
        tx.setText(Integer.toString(precision));
        sk.setProgress(precision);
        sk.setMax(13);
        AlertDialog.Builder builder = new AlertDialog.Builder(st);
        builder.setTitle("Precision for |n| > 10^8");
        builder.setView((View)ll);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tx.setText(Integer.toString(sk.getProgress()+2));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (precision != (sk.getProgress()+2)) {
                            st.setPrecision(sk.getProgress()+2);
                            st.sendFlagTrue();
                        }
                        dialog.dismiss();
                    }
                });

   /*     builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });*/
        return builder.create();
    }


}
