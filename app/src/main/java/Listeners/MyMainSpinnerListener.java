package Listeners;

import android.view.View;
import android.widget.AdapterView;

import com.example.konrad.simpleunitconverter.MainActivity;

/**
 * Created by Konrad on 3/10/2016.
 */
public class MyMainSpinnerListener implements AdapterView.OnItemSelectedListener {
    public String chosenDimension = new String();
    private MainActivity m;
    public MyMainSpinnerListener(MainActivity m){ this.m = m;}
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        m.getAdapter1().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m.getAdapter2().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m.getAdapter3().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m.getAdapter4().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chosenDimension = m.getSpinner1().getSelectedItem().toString();
        if (chosenDimension.equals("Mass")) {
            m.getSpinner2().setAdapter(m.getAdapter1());
            m.getSpinner3().setAdapter(m.getAdapter1());
        } else if (chosenDimension.equals("Distance")) {
            m.getSpinner2().setAdapter(m.getAdapter2());
            m.getSpinner3().setAdapter(m.getAdapter2());
        } else if (chosenDimension.equals("Temperature")) {
            m.getSpinner2().setAdapter(m.getAdapter3());
            m.getSpinner3().setAdapter(m.getAdapter3());
        } else if (chosenDimension.equals("Speed")) {
            m.getSpinner2().setAdapter(m.getAdapter4());
            m.getSpinner3().setAdapter(m.getAdapter4());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}