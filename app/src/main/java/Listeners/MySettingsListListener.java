package Listeners;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.konrad.simpleunitconverter.SettingsActivity;

import java.io.Console;

/**
 * Created by Konrad on 3/10/2016.
 */
public class MySettingsListListener implements AdapterView.OnItemClickListener {
    private SettingsActivity st;
    private String selectedItem;
    public MySettingsListListener(SettingsActivity st){
        super();
        this.st=st;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectedItem=st.getMainListAdapter().getItem(position).toString();
        if (selectedItem.equals("Result precision")){
            st.showPrecisionDialog(st.getMainListView());
        }
        else if (selectedItem.equals("Keyboard")){
            st.showKeyboardDialog(st.getMainListView());
        }
        else if (selectedItem.equals("Currency details")){
            st.showCurrencyDetailsDialog(st.getMainListView());
        }
    }
}
