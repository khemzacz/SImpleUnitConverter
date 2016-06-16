package StaticUtilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.konrad.simpleunitconverter.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Konrad on 19/03/2016.
 */
public final class CurrencyValueManager {
    private CurrencyValueManager(){};
    private static SharedPreferences.Editor editor;



    public static void setInitialValues(SharedPreferences sp){
        if (sp.contains("Date")){
            return;
        }
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

    public static void updateValuesViaInternet(Activity mac, SharedPreferences sp){
        //Log.v("CurrencyManager", "1st line of update function");
        final Activity mac1 = mac;
        final SharedPreferences sp1 = sp;
        RequestQueue queue = Volley.newRequestQueue(mac);
        String url = sp.getString("URL","http://api.fixer.io/latest");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                editor = sp1.edit();
                //editor.putString("URL", "http://api.fixer.io/latest");
                String date= null,chf = null ,gbp = null ,jpy = null ,pln = null ,rub = null ,usd = null ,cad = null ,aud = null;
                try {
                    date = response.getString("date");
                    chf = response.getJSONObject("rates").getString("CHF");
                    gbp = response.getJSONObject("rates").getString("GBP");
                    jpy = response.getJSONObject("rates").getString("JPY");
                    pln = response.getJSONObject("rates").getString("PLN");
                    rub = response.getJSONObject("rates").getString("RUB");
                    usd = response.getJSONObject("rates").getString("USD");
                    cad = response.getJSONObject("rates").getString("CAD");
                    aud = response.getJSONObject("rates").getString("AUD");
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(mac1,"Error receiving rates from JSON,\n please contact the developer if you can. ",Toast.LENGTH_LONG ).show();
                    return;
                }
                editor.putString("Date", date);
                editor.putString("CHF", chf);
                editor.putString("GBP", gbp);
                editor.putString("JPY", jpy);
                editor.putString("PLN", pln);
                editor.putString("RUB", rub);
                editor.putString("USD", usd);
                editor.putString("CAD", cad);
                editor.putString("AUD", aud);
                editor.commit();
                Toast.makeText(mac1,"Currency rates updated successfully",Toast.LENGTH_LONG ).show();
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mac1,"Error downloading rates,\n please contact the developer if you can. ",Toast.LENGTH_LONG ).show();
            }
        });
        queue.add(postRequest);

    }




}
