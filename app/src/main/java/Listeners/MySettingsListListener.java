package Listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.konrad.simpleunitconverter.SettingsActivity;

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
        selectedItem=st.getMainListAdapter().getItem(position);
        Toast.makeText(st,selectedItem,Toast.LENGTH_LONG).show();
        if (selectedItem.equals("Result precision")){

        }
        else if (selectedItem.equals("Keyboard")){

            st.showKeyboardDialog(st.getMainListView());
        }
    }
}
