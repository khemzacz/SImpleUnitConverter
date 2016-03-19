package StaticUtilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.konrad.simpleunitconverter.MainActivity;

import org.json.JSONObject;

/**
 * Created by Konrad on 19/03/2016.
 */
public final class CurrencyValueManager {
    private CurrencyValueManager(){};
    private static SharedPreferences.Editor editor;



    public static void setInitialValues(SharedPreferences sp){
        editor = sp.edit();
        editor.putString("URL", "http://api.fixer.io/latest");
        editor.putString("Date","2016-03-18");
        editor.putString("CHF", "1.0919");
        editor.putString("GBP", "0.77855");
        editor.putString("JPY", "125.79");
        editor.putString("PLN", "4.2625");
        editor.putString("RUB", "76.0498");
        editor.putString("USD", "1.1279");
        editor.putString("CAD", "1.4627");
        editor.putString("AUD", "1.4804");
        editor.commit();

    }

    public static void updateValuesViaInternet(MainActivity mac, SharedPreferences sp){
        RequestQueue queue = Volley.newRequestQueue(mac);
        String url = sp.getString("URL","http://api.fixer.io/latest");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }




}
