package Converters;

/**
 * Created by Konrad on 3/5/2016.
 */
public class ConverterFactory {
    private int precision;
    public ConverterFactory(int p){
        this.precision=p;
    }

    public AbstractConverter createConverter(String type){
        if (type.equals("Temperature")){
            return new TemperatureConverter(precision);
        }
        else if (type.equals("Distance"))
            return new DistanceConverter(precision);
        else if (type.equals("Mass"))
            return new MassConverter(precision);
        else if (type.equals("Speed"))
            return new SpeedConverter(precision);

        return null;
    }
}
