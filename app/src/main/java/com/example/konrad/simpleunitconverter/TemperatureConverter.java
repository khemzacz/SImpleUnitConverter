package com.example.konrad.simpleunitconverter;

import java.math.BigDecimal;

/**
 * Created by Konrad on 3/5/2016.
 */
public class TemperatureConverter extends AbstractConverter{

    public TemperatureConverter(){

    }

    private double result;
    private double value;
    private String unit;
    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b)){
            if (a.equals("Celsius"))
                unit = " °C";
            else if (a.equals("Fahrenheit"))
                unit = " °F";
            else if (a.equals("Kelwin")){
                unit = " K";
            }
            result=value;
        }
        else if (a.equals("Celsius")){
            result = celsius(b);
        }
        else if(a.equals("Kelwin")){
            result = kelwin(b);
        }
        else if(a.equals("Fahrenheit")){
            result = fahrenheit(b);
        }
/*      else if(a.equals("Celsius")&& b.equals("Fahrenheit")){
            result= CelsiusToFahrenheit(value);
        }
        else if(a.equals("Celsius")&& b.equals("Kelwin")){
            result= CelsiusToKelwin(value);
        }
        else if(a.equals("Fahrenheit")&& b.equals("Celsius")){
            result= FahrenheitToCelsius(value);
        }
        else if(a.equals("Fahrenheit")&& b.equals("Kelwin")){
            result= FahrenheitToKelwin(value);
        }
        else if(a.equals("Kelwin")&& b.equals("Fahrenheit")){
            result= KelwinToFahrenheit(value);
        }
        else if(a.equals("Kelwin")&& b.equals("Celsius")){
            result= KelwinToCelsius(value);
        }*/
        Double td = new BigDecimal(result).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return (td.toString()+ unit);
    }

    private double celsius(String b)
    {
        if (b.equals("Kelwin")){
            return celsiusToKelwin();
        }
        else if (b.equals("Fahrenheit")){
            return celsiusToFahrenheit();
        }
        else return 0;
    }

    private double fahrenheit(String b){
        if (b.equals("Celsius")){
            return fahrenheitToCelsius();
        }
        else if (b.equals("Kelwin")){
            return fahrenheitToKelwin();
        }
        else return 0;
    }

    private double kelwin(String b){
        if (b.equals("Celsius")){
            return kelwinToCelsius();
        }
        else if (b.equals("Fahrenheit")){
            return kelwinToFahrenheit();
        }
        else return 0;
    }

    private double celsiusToFahrenheit(){
        unit = " °F";
        return (value*1.8+32);
    }
    private double celsiusToKelwin() {
        unit = " K";
        return (value+273.15);
    }

    private double fahrenheitToCelsius() {
        unit = " °C";
        return ((value-32)/1.8);
    }
    private double fahrenheitToKelwin(){
        unit = " K";
        return ((value+459.67)/1.8);
    }

    private double kelwinToCelsius(){
        unit = " °C";
        return (value-273.15);
    }
    private double kelwinToFahrenheit(){
        unit = " °F";
        return (value*1.8-459.67);
    }
}
