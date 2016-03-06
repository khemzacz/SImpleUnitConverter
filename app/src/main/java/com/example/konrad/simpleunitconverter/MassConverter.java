package com.example.konrad.simpleunitconverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Konrad on 3/5/2016.
 */
public class MassConverter extends AbstractConverter {
    public MassConverter(){
        precision = 2;
    }

    private int precision;
    private double result;
    private double value;
    private String unit;
    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b)){
            if (a.equals("Kilograms")) {
                unit = "kg";
            }
            else if (a.equals("Pounds")){
                unit = "lb";
            }
            else if (a.equals("Ounces")){
                unit = "oz";
            }
            result= value;
        }
        else if (a.equals("Kilograms")){
            result = kilograms(b);
        }
        else if(a.equals("Pounds")){
            result = pounds(b);
        }
        else if (a.equals("Ounces")){
            result = ounces(b);
        }
        if (result <1)
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

    private double kilograms(String b){
        if (b.equals("Pounds"))
            return kilogramsToPounds();
        else if (b.equals("Ounces"))
            return kilogramsToOunces();
        else return 0;
    }

    private double pounds(String b){
        if (b.equals("Kilograms"))
            return poundsToKilograms();
        else if (b.equals("Ounces"))
            return poundsToOunces();
        else return 0;
    }
    private double ounces(String b){
        if (b.equals("Kilograms"))
            return ouncesToKilograms();
        else if (b.equals("Pounds"))
            return ouncesToPounds();
        else return 0;
    }


    private double kilogramsToPounds(){
        unit = "lb";
        return (value*2.2046);
    }
    private double kilogramsToOunces(){
        unit = "oz";
        return (value/0.02834952);
    }

    private double poundsToKilograms(){
        unit = "kg";
        return (value/2.2046);
    }
    private double poundsToOunces(){
        unit ="oz";
        return (value*16);
    }

    private double ouncesToKilograms(){
        unit = "kg";
        return (value*0.02834952);
    }
    private double ouncesToPounds(){
        unit = "lb";
        return (value/16);
    }
}
