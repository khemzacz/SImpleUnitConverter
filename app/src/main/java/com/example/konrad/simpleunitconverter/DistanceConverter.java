package com.example.konrad.simpleunitconverter;

import java.math.BigDecimal;

/**
 * Created by Konrad on 3/5/2016.
 */
public class DistanceConverter extends AbstractConverter {
    public DistanceConverter(){

    }

    private double result;
    private double value;
    private String unit;
    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b)){
            if (a.equals("Kilometers")) {
                unit = " km";
            }
            else if (a.equals("Miles")){
                unit = " mi";
            }
            else if (a.equals("Feet")){
                unit = " ft";
            }
            result= value;
        }

        else if (a.equals("Kilometers")){
            result = kilometers(b);
        }
        else if (a.equals("Miles")){
            result = miles(b);
        }
        else if (a.equals("Feet")){
            result = feet(b);
        }
/*        else if(a.equals("Kilometers")&& b.equals("Miles")){
            result= kilometersToMiles();
        }
        else if(a.equals("Kilometers")&& b.equals("Feet")){
            result= kilometersToFeet();
        }

        else if(a.equals("Miles")&& b.equals("Kilometers"))
            result = milesToKilometers();
        else if(a.equals("Miles")&& b.equals("Feet"))
            result = milesToFeet();

        else if(a.equals("Feet")&& b.equals("Kilometers"))
            result = feetToKilometers();
        else if(a.equals("Feet")&& b.equals("Miles"))
            result = feetToMiles(); */
        Double td = new BigDecimal(result).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return (td.toString()+unit);
    }

    private double kilometers(String b){
        if (b.equals("Miles"))
            return kilometersToMiles();
        else if (b.equals("Feet"))
            return kilometersToFeet();
        else return 0;
    }

    private double miles(String b){
        if (b.equals("Kilometers"))
            return milesToKilometers();
        else if (b.equals("Feet"))
            return milesToFeet();
        else return 0;
    }

    private double feet(String b){
        if (b.equals("Kilometers"))
            return feetToKilometers();
        else if (b.equals("Miles"))
            return feetToMiles();
        else return 0;
    }

    private double kilometersToMiles(){
        unit = " mi";
        return (value/1.609344);
    }
    private double kilometersToFeet(){
        unit = " ft";
        return ((value*1000)/0.3048);
    }

    private double milesToKilometers(){
        unit = " km";
        return (value*1.609344);
    }
    private double milesToFeet(){
        unit = " ft";
        return (((value*1.609344)*1000)/0.3048);
    }

    private double feetToKilometers(){
        unit = " km";
        return ((value*0.3048)/1000);
    }
    private double feetToMiles(){
        unit = " mi";
        return (((value*0.3048)/1000)/1.609344);
    }
}