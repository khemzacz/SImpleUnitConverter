package com.example.konrad.simpleunitconverter;

/**
 * Created by Konrad on 3/5/2016.
 */
public class ConverterFactory {
    public ConverterFactory(){

    }

    public AbstractConverter createConverter(String type){
        if (type.equals("Temperature")){
            return new TemperatureConverter();
        }
        else if (type.equals("Distance"))
            return new DistanceConverter();
        else if (type.equals("Mass"))
            return new MassConverter();

        return null;
    }
}
