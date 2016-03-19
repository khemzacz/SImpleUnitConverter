package Converters;

import android.content.SharedPreferences;

/**
 * Created by Konrad on 3/5/2016.
 */
public class ConverterFactory {
    private int precision;
    private SharedPreferences sp;
    public ConverterFactory(int p, SharedPreferences sp){
        this.sp = sp;
        this.precision=p;
    }

    public AbstractConverter createConverter(String type){
        if (type.equals("Temperature")){
            return new TemperatureConverter(precision);
        }
        else if (type.equals("Length"))
            return new LengthConverter(precision);
        else if (type.equals("Mass"))
            return new MassConverter(precision);
        else if (type.equals("Speed"))
            return new SpeedConverter(precision);
        else if (type.equals("Power"))
            return new PowerConverter(precision);
        else if (type.equals("Currencies"))
            return new CurrencyConverter(precision,sp);
        return null;
    }
}
