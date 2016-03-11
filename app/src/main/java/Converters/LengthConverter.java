package Converters;

import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Konrad on 3/5/2016.
 */
public class LengthConverter extends AbstractConverter {

    private int precision;
    private double result;
    private double value;
    private String unit;
    public LengthConverter(int p){
        precision=p;
    }
    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b)){
            if (a.equals("Kilometers")){ unit = "km"; }
            else if (a.equals("Miles")){ unit = "mi"; }
            else if (a.equals("Feet")){ unit = "ft"; }
            else if (a.equals("Inches")){ unit = "\""; }
            else if (a.equals("Yards")){ unit = "yd"; }
            else if (a.equals("Meters")){ unit = "m"; }
            else if (a.equals("Millimeters")){ unit = "mm"; }
            else if (a.equals("Centimeters")){ unit = "cm"; }
            else if (a.equals("Nanometers")){ unit = "nm"; }
            result= value;
        }

        else if (a.equals("Kilometers")){ result = kilometers(b); }
        else if (a.equals("Miles")){ result = miles(b); }
        else if (a.equals("Feet")){ result = feet(b); }
        else if (a.equals("Inches")){ result = inches(b); }
        else if (a.equals("Yards")){ result = yards(b); }
        else if (a.equals("Meters")){ result = meters(b); }
        else if (a.equals("Millimeters")){ result = millimeters(b); }
        else if (a.equals("Centimeters")){ result = centimeters(b); }
        else if (a.equals("Nanometers")){ result = nanometers(b); }
        if (result<1 || result >10000000)
        {
            BigDecimal bd = new BigDecimal(result);
            int scale = precision - bd.precision() +bd.scale();
            Double td = bd.setScale((scale), RoundingMode.HALF_UP).doubleValue();
            return (td.toString()+" "+unit);
        }
        else {
            Double td = new BigDecimal(result).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            return (td.toString()+" "+unit);
        }
    }

    private double kilometers(String b){
        if (b.equals("Miles")){ unit = "mi"; return kilometersToMiles(value); }
        else if (b.equals("Feet")){ unit = "ft"; return kilometersToFeet(value); }
        else if (b.equals("Meters")){  unit = "m"; return (value*mc.thousand);}
        else if (b.equals("Centimeters")){unit = "cm"; return (value*mc.hundredThousand);}
        else if (b.equals("Millimeters")){unit = "mm"; return (value*mc.million);}
        else if (b.equals("Inches")){unit = "\""; return ((value*mc.hundredThousand)/2.54); }
        else if (b.equals("Yards")){unit = "yd"; return ((value*mc.thousand)/0.9144); }
        else if (b.equals("Nanometers")){unit = "nm"; return (value*mc.trillion);}
        else return 0;
    }

    private double miles(String b){
        if (b.equals("Kilometers")){ unit = "km"; return milesToKilometers(value); }
        else if (b.equals("Feet")) { unit = "ft"; return milesToFeet(value); }
        else if (b.equals("Meters")){unit = "m"; return (milesToKilometers(value)*mc.thousand);}
        else if (b.equals("Centimeters")){unit = "cm"; return (milesToKilometers(value)*mc.hundredThousand);}
        else if (b.equals("Millimeters")){unit = "mm"; return (milesToKilometers(value)*mc.million);}
        else if (b.equals("Inches")){ unit = "\""; return ((milesToKilometers(value)*mc.hundredThousand)/2.54);}
        else if (b.equals("Yards")){unit = "yd"; return (milesToKilometers(value)*mc.thousand/0.9144);}
        else if (b.equals("Nanometers")){unit = "nm"; return (milesToKilometers(value)*mc.trillion);}
        else return 0;
    }

    private double feet(String b){
        if (b.equals("Kilometers")){ unit = "km"; return feetToKilometers(value); }
        else if (b.equals("Miles")) { unit = "mi"; return feetToMiles(value);}
        else if (b.equals("Meters")){unit = "m"; return (feetToKilometers(value)*mc.thousand);}
        else if (b.equals("Centimeters")){unit = "cm"; return (feetToKilometers(value)*mc.hundredThousand);}
        else if (b.equals("Millimeters")){unit = "mm"; return (feetToKilometers(value)*mc.million);}
        else if (b.equals("Inches")){unit = "\""; return ((feetToKilometers(value)*mc.hundredThousand)/2.54);}
        else if (b.equals("Yards")){unit = "yd"; return (feetToKilometers(value)*mc.thousand/0.9144);}
        else if (b.equals("Nanometers")){unit = "nm"; return (feetToKilometers(value)*mc.trillion);}
        else return 0;
    }

    private double meters(String b){
        if (b.equals("Kilometers")) { unit = "km"; return (value/mc.thousand);}
        else if (b.equals("Feet")){unit = "ft"; return (kilometersToFeet(value/mc.thousand));}
        else if (b.equals("Miles")){unit = "mi"; return (kilometersToMiles(value/mc.thousand));}
        else if (b.equals("Centimeters")){unit = "cm"; return (value/100.0);}
        else if (b.equals("Millimeters")){unit = "mm"; return (value/mc.thousand);}
        else if (b.equals("Inches")){unit = "\""; return ((value/100.0)/2.54);}
        else if (b.equals("Yards")){unit = "yd"; return (value/0.9144);}
        else if (b.equals("Nanometers")){unit = "nm"; return (value*mc.billion);}
        else return 0;
    }

    private double centimeters(String b){
        if (b.equals("Kilometers")) {unit = "km"; return (value/mc.hundredThousand);}
        else if (b.equals("Feet")){unit = "ft"; return (kilometersToFeet(value/mc.hundredThousand));}
        else if (b.equals("Miles")){unit = "mi"; return (kilometersToMiles(value/mc.hundredThousand));}
        else if (b.equals("Meters")){unit = "m"; return (value/100.0);}
        else if (b.equals("Millimeters")){unit = "mm"; return (value*10.0);}
        else if (b.equals("Inches")){unit = "\""; return (value/2.54);}
        else if (b.equals("Yards")){unit = "yd"; return ((value/100)/0.9144);}
        else if (b.equals("Nanometers")){unit = "nm"; return (value*mc.million*10.0);}
        else return 0;
    }

    private double millimeters(String b){
        if (b.equals("Kilometers")) { unit = "km"; return (value/mc.million);}
        else if (b.equals("Feet")){unit = "ft"; return (kilometersToFeet(value/mc.million));}
        else if (b.equals("Miles")){unit = "mi"; return (kilometersToMiles(value/mc.million));}
        else if (b.equals("Meters")){unit = "m"; return (value/mc.thousand);}
        else if (b.equals("Centimeters")){unit = "cm"; return (value/10.0);}
        else if (b.equals("Inches")){unit = "\""; return ((value/10/2.54));}
        else if (b.equals("Yards")){unit = "yd"; return ((value/mc.thousand)/0.9144);}
        else if (b.equals("Nanometers")){unit = "nm"; return (value*mc.million);}
        else return 0;
    }

    private double inches(String b){
        if (b.equals("Kilometers")) {unit = "km"; return ((value*2.54)/mc.hundredThousand);}
        else if (b.equals("Feet")){unit = "ft"; return (inchesToFeet(value));}
        else if (b.equals("Miles")){unit = "m"; return (metersToMiles(inchesToMeters(value)));}
        else if (b.equals("Meters")){ unit = "m"; return (inchesToMeters(value));}
        else if (b.equals("Centimeters")){unit = "cm"; return (value*2.54);}
        else if (b.equals("Millimeters")){unit = "mm"; return (value*25.4);}
        else if (b.equals("Yards")){unit = "yd"; return (inchesToYards(value));}
        else if (b.equals("Nanometers")){unit = "nm"; return ((inchesToMeters(value))*mc.billion);}
        else return 0;
    }

    private double yards(String b){
        if (b.equals("Kilometers")) {unit = "km"; return (yardsToMeters(value)/mc.thousand);}
        else if (b.equals("Feet")){unit = "ft"; return (yardsToFeet(value));}
        else if (b.equals("Miles")){unit = "mi"; return (metersToMiles(yardsToMeters(value)));}
        else if (b.equals("Meters")){ unit = "m"; return (yardsToMeters(value));}
        else if (b.equals("Centimeters")){unit = "cm"; return (yardsToMeters(value)*100.0);}
        else if (b.equals("Millimeters")){unit = "mm"; return (yardsToMeters(value)*mc.thousand);}
        else if (b.equals("Inches")){unit = "\""; return (yardsToInches(value));}
        else if (b.equals("Nanometers")){unit = "nm"; return (yardsToMeters(value)*mc.billion);}
        else return 0;
    }

    private double nanometers(String b){
        if (b.equals("Kilometers")) {unit = "km"; return (value/mc.trillion);}
        else if (b.equals("Feet")){unit = "ft"; return (metersToFeet(value / mc.billion));}
        else if (b.equals("Miles")){ unit = "mi"; return (metersToMiles(value/mc.billion));}
        else if (b.equals("Meters")){unit = "m"; return (value/mc.billion);}
        else if (b.equals("Centimeters")){unit = "cm"; return (value/mc.million*10.0);}
        else if (b.equals("Millimeters")){unit = "mm"; return (value/mc.million);}
        else if (b.equals("Inches")){unit = "\""; return (centimetersToInches(value / mc.million * 10.0));}
        else if (b.equals("Yards")){unit = "yd"; return (centimetersToYards(value/mc.million*10.0));}
        else return 0;
    }


    private double kilometersToMiles(double value){
        return (value/1.609344);
    }
    private double kilometersToFeet(double value){
        return ((value*1000.0)/0.3048);
    }

    private double milesToKilometers(double value){
        return (value*1.609344);
    }
    private double milesToFeet(double value){
        return (((value*1.609344)*1000.0)/0.3048);
    }

    private double feetToKilometers(double value){
        return ((value*0.3048)/1000.0);
    }
    private double feetToMiles(double value){
        return (((value*0.3048)/1000.0)/1.609344);
    }

    private double inchesToFeet(double value){
        return (value/12.0);
    }

    private double feetToInches(double value){
        return (value*12.0);
    }

    private double inchesToMeters(double value){
        return (value * 0.0254);
    }

    private double metersToMiles(double value){
        return (kilometersToMiles(value/mc.thousand));
    }

    private double inchesToYards(double value){
        return (value/36.0);
    }

    private double yardsToMeters(double value){
        return (value*0.9144);
    }

    private double yardsToFeet(double value){
        return (value*3.0);
    }

    private double yardsToInches(double value){
        return (value*36.0);
    }

    private double metersToFeet(double value){
        return (value * 3.2808);
    }

    private double centimetersToInches(double value){
        return (value/2.54);
    }
    private double centimetersToYards(double value){
        return ((value/100.0)/0.9144);
    }

}