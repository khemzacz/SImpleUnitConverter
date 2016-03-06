package com.example.konrad.simpleunitconverter;

import java.math.BigDecimal;

/**
 * Created by Konrad on 3/6/2016.
 */
public class SpeedConverter extends AbstractConverter {
    public SpeedConverter(){

    }

    private double result;
    private double value;
    private String unit;
    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b)){
            if (a.equals("km/h")) {
                unit = "km/h";
            }
            else if (a.equals("mph")){
                unit = "mph";
            }
            else if (a.equals("m/s")){
                unit = "m/s";
            }
            else if (a.equals("knots")){
                unit = "kn";
            }
            result= value;
        }

        else if (a.equals("km/h")){
            result = kilometersPerHour(b);
        }
        else if (a.equals("mph")){
            result = milesPerHour(b);
        }
        else if (a.equals("m/s")){
            result = metersPerSecond(b);
        }
        else if (a.equals("knots")){
            result = knots(b);
        }
        Double td = new BigDecimal(result).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return (td.toString()+"\n"+unit);
    }

    private double kilometersPerHour(String b){
        if (b.equals("mph"))
            return kmhToMph();
        else if (b.equals("m/s"))
            return kmhToMs();
        else if (b.equals("knots"))
            return kmhToKnots();
        else return 0;
    }

    private double kmhToMs() {
        unit = "m/s";
        return ((value*1000)/3600);
    }

    private double kmhToMph() {
        unit = "mph";
        return (value/1.609344);
    }

    private double kmhToKnots() {
        unit = "kn";
        return (value/1.852);
    }

    private double milesPerHour(String b){
        if (b.equals("km/h"))
            return mphToKmh();
        else if (b.equals("m/s"))
            return mphToMs();
        else if (b.equals("knots"))
            return mphToKnots();
        else return 0;
    }

    private double mphToKmh() {
        unit = "km/h";
        return (value*1.609344);
    }

    private double mphToMs() {
        unit = "m/s";
        return (((value*1.609344)*1000)/3600);
    }

    private double mphToKnots() {
        unit = "kn";
        return (value*0.868976242);
    }


    private double metersPerSecond(String b){
        if (b.equals("km/h"))
            return msToKmh();
        else if (b.equals("mph"))
            return msToMph();
        else if (b.equals("knots"))
            return msToKnots();
        else return 0;
    }

    private double msToKmh() {
        unit = "km/h";
        return ((value*3600)/1000);
    }

    private double msToMph() {
        unit = "mph";
        return (((value*3600)/1000)/1.609344);
    }

    private double msToKnots() {
        unit = "kn";
        return (((value*3600)/1000)/1.852);
    }

    private double knots(String b){
        if (b.equals("km/h"))
            return knotsToKmh();
        else if (b.equals("mph"))
            return knotsToMph();
        else if (b.equals("m/s"))
            return knotsToMs();
        else return 0;
    }

    private double knotsToKmh() {
        unit = "km/h";
        return (value*1.852);
    }

    private double knotsToMph() {
        unit = "mph";
        return (value/0.868976242);
    }

    private double knotsToMs() {
        unit = "m/s";
        return (((value*1.852)*1000)/3600);
    }


}
