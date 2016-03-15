package Converters;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Konrad on 15/03/2016.
 */
public class PowerConverter extends AbstractConverter{
    private int precision;
    private double result;
    private double value;
    private String unit;
    public PowerConverter(int p){
        this.precision = p;
    }

    public String convert(String val,String a, String b) {
        value = Double.parseDouble(val);
        if(a.equals(b)){
            if (a.equals("Watts")) {
                unit = "W";
            }
            else if (a.equals("Horsepower")){
                unit = "hp";
            }
            else if (a.equals("Kilowatts")){
                unit = "kW";
            }
            else if (a.equals("Megawatts")){
                unit = "MW";
            }
            else if (a.equals("Gigawatts")){
                unit = "GW";
            }
            result= value;
        }

        else if (a.equals("Watts")){
            result = watts(b);
        }
        else if (a.equals("Horsepower")){
            result = horsepower(b);
        }
        else if (a.equals("Kilowatts")){
            result = kilowatts(b);
        }
        else if (a.equals("Megawatts")){
            result = megawatts(b);
        }
        else if (a.equals("Gigawatts")){
            result = gigawatts(b);
        }
        if (result <1 || result >10000000)
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

    private double gigawatts(String b) {
        if (b.equals("Horsepower")){
            unit = "hp";
            return wattsToHorsePower(gigawatstsToWatts(value));
        }
        else if(b.equals("Watts")){
            unit = "W";
            return gigawatstsToWatts(value);
        }
        else if (b.equals("Megawatts")){
            unit = "MW";
            return wattsToMegawatts(gigawatstsToWatts(value));
        }
        else if (b.equals("Kilowatts")){
            unit = "kW";
            return wattsToKilowatts(gigawatstsToWatts(value));
        }
        else return 0;

    }

    private double gigawatstsToWatts(double value) {
        return value*mc.billion;
    }

    private double megawatts(String b) {
        if (b.equals("Horsepower")){
            unit = "hp";
            return wattsToHorsePower(megawattsToWatts(value));
        }
        else if(b.equals("Watts")){
            unit = "W";
            return megawattsToWatts(value);
        }
        else if (b.equals("Gigawatts")){
            unit = "GW";
            return wattsToMegawatts(megawattsToWatts(value));
        }
        else if (b.equals("Kilowatts")){
            unit = "kW";
            return wattsToKilowatts(megawattsToWatts(value));
        }
        else return 0;
    }

    private double megawattsToWatts(double value) {
        return value*mc.million;
    }

    private double kilowatts(String b) {
        if (b.equals("Horsepower")){
            unit = "hp";
            return wattsToHorsePower(kilowattsToWatts(value));
        }
        else if(b.equals("Watts")){
            unit = "W";
            return kilowattsToWatts(value);
        }
        else if (b.equals("Megawatts")){
            unit = "MW";
            return wattsToMegawatts(kilowattsToWatts(value));
        }
        else if (b.equals("Gigawatts")){
            unit = "GW";
            return wattsToGigawatts(kilowattsToWatts(value));
        }
        else return 0;

    }

    private double kilowattsToWatts(double value) {
        return value*mc.thousand;
    }

    private double horsepower(String b) {

        if (b.equals("Watts")){
            unit = "W";
            return horsepowerToWatts(value);
        }
        else if(b.equals("Kilowatts")){
            unit = "kW";
            return wattsToKilowatts(horsepowerToWatts(value));
        }
        else if (b.equals("Megawatts")){
            unit = "MW";
            return wattsToMegawatts(horsepowerToWatts(value));
        }
        else if (b.equals("Gigawatts")){
            unit = "GW";
            return wattsToGigawatts(horsepowerToWatts(value));
        }
        else return 0;
    }

    private double horsepowerToWatts(double value) {
        return value*745.699872;
    }

    private double watts(String b){
        if (b.equals("Horsepower")){
            unit = "hp";
            return wattsToHorsePower(value);
        }
        else if(b.equals("Kilowatts")){
            unit = "kW";
            return wattsToKilowatts(value);
        }
        else if (b.equals("Megawatts")){
            unit = "MW";
            return wattsToMegawatts(value);
        }
        else if (b.equals("Gigawatts")){
            unit = "GW";
            return wattsToGigawatts(value);
        }
        else return 0;
    }






    private double wattsToGigawatts(double value) {
        return value/mc.billion;
    }

    private double wattsToMegawatts(double value) {
        return value/mc.million;
    }

    private double wattsToKilowatts(double value) {
        return value/mc.thousand;
    }

    private double wattsToHorsePower(double value) {
        return value/745.699872;
    }




}
