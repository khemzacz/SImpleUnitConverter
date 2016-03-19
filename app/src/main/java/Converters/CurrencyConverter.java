package Converters;

import android.content.SharedPreferences;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Konrad on 19/03/2016.
 */
public class CurrencyConverter extends AbstractConverter {
    private int precision;
    private double result;
    private double value;
    private String unit;
    private SharedPreferences sp;
    private double chf = 0, gbp =0, jpy =0, pln =0, rub =0, usd = 0, cad = 0, aud =0;
    public CurrencyConverter(int p, SharedPreferences sp){
        super();
        this.sp=sp;
        precision=p;
        chf = Double.parseDouble(sp.getString("CHF","1"));
        gbp = Double.parseDouble(sp.getString("GBP","1"));
        jpy = Double.parseDouble(sp.getString("JPY","1"));
        pln = Double.parseDouble(sp.getString("PLN","1"));
        rub = Double.parseDouble(sp.getString("RUB","1"));
        usd = Double.parseDouble(sp.getString("USD","1"));
        cad = Double.parseDouble(sp.getString("CAD","1"));
        aud = Double.parseDouble(sp.getString("AUD","1"));




    }

    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b)){
            if (a.equals("CHF")){ unit = "CHF"; }
            else if (a.equals("GBP")){ unit = "GBP"; }
            else if (a.equals("JPY")){ unit = "JPY"; }
            else if (a.equals("PLN")){ unit = "PLN"; }
            else if (a.equals("RUB")){ unit = "RUB"; }
            else if (a.equals("USD")){ unit = "USD"; }
            else if (a.equals("CAD")){ unit = "CAD"; }
            else if (a.equals("AUD")){ unit = "AUD"; }
            else if (a.equals("EUR")){ unit = "EUR"; }
            result= value;
        }

        else if (a.equals("CHF")){ result = chf(b); }
        else if (a.equals("GBP")){ result = gbp(b); }
        else if (a.equals("JPY")){ result = jpy(b); }
        else if (a.equals("PLN")){ result = pln(b); }
        else if (a.equals("RUB")){ result = rub(b); }
        else if (a.equals("USD")){ result = usd(b); }
        else if (a.equals("CAD")){ result = cad(b); }
        else if (a.equals("AUD")){ result = aud(b); }
        else if (a.equals("EUR")){ result = eur(b); }
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

    private double eur(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(value);}
        else if (b.equals("GBP")){unit = "GBP"; return eurToGbp(value);}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(value);}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(value);}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(value);}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(value);}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(value);}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(value);}

        return 0;
    }

    private double aud(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(audToEur(value));}
        else if (b.equals("GBP")){unit = "GBP"; return eurToGbp(audToEur(value));}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(audToEur(value));}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(audToEur(value));}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(audToEur(value));}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(audToEur(value));}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(audToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(audToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; return audToEur(value);}
        return 0;
    }

    private double cad(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(chfToEur(value));}
        else if (b.equals("GBP")){unit = "GBP"; return eurToGbp(chfToEur(value));}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(chfToEur(value));}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(chfToEur(value));}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(chfToEur(value));}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(chfToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(chfToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; chfToEur(value);}
        return 0;
    }

    private double usd(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(usdToEur(value));}
        else if (b.equals("GBP")){unit = "GBP"; return eurToGbp(usdToEur(value));}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(usdToEur(value));}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(usdToEur(value));}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(usdToEur(value));}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(usdToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(usdToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; return usdToEur(value);}
        return 0;
    }

    private double rub(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(rubToEur(value));}
        else if (b.equals("GBP")){unit = "GBP"; return eurToGbp(rubToEur(value));}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(rubToEur(value));}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(rubToEur(value));}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(rubToEur(value));}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(rubToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(rubToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; return rubToEur(value);}
        return 0;
    }

    private double pln(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(plnToEur(value));}
        else if (b.equals("GBP")){unit = "GBP"; return eurToGbp(plnToEur(value));}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(plnToEur(value));}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(plnToEur(value));}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(plnToEur(value));}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(plnToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(plnToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; return plnToEur(value);}
        return 0;
    }

    private double jpy(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(jpyToEur(value));}
        else if (b.equals("GBP")){unit = "GBP"; return eurToGbp(jpyToEur(value));}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(jpyToEur(value));}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(jpyToEur(value));}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(jpyToEur(value));}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(jpyToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(jpyToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; jpyToEur(value);}
        return 0;
    }

    private double gbp(String b) {
        if (b.equals("CHF")){unit = "CHF"; return eurToChf(gbpToEur(value));}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(gbpToEur(value));}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(gbpToEur(value));}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(gbpToEur(value));}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(gbpToEur(value));}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(gbpToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(gbpToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; return gbpToEur(value);}
        return 0;
    }

    private double chf(String b) {
        if (b.equals("GBP")){unit = "GBP"; return eurToGbp(chfToEur(value));}
        else if (b.equals("JPY")){unit = "JPY"; return eurToJpy(chfToEur(value));}
        else if (b.equals("PLN")){unit = "PLN"; return eurToPln(chfToEur(value));}
        else if (b.equals("RUB")){unit = "RUB"; return eurToRub(chfToEur(value));}
        else if (b.equals("USD")){unit = "USD"; return eurToUsd(chfToEur(value));}
        else if (b.equals("CAD")){unit = "CAD"; return eurToCad(chfToEur(value));}
        else if (b.equals("AUD")){unit = "AUD"; return eurToAud(chfToEur(value));}
        else if (b.equals("EUR")){unit = "EUR"; return chfToEur(value);}
        return 0;
    }
    private double eurToAud(double value) {
        return value*aud;
    }

    private double eurToCad(double value) {
        return value*cad;
    }

    private double eurToUsd(double value) {
        return value*usd;
    }

    private double eurToRub(double value) {
        return value*rub;
    }

    private double eurToPln(double value) {
        return value*pln;
    }

    private double eurToJpy(double value) {
        return value*jpy;
    }

    private double eurToGbp(double value) {
        return value*gbp;
    }

    private double eurToChf(double value) {
        return value*chf;
    }

    private double audToEur(double value){
        return value/aud;
    }

    private double cadToEur(double value){
        return value/cad;
    }

    private double usdToEur(double value){
        return value/usd;
    }

    private double rubToEur(double value){
        return value/rub;
    }

    private double plnToEur(double value){
        return value/pln;
    }

    private double jpyToEur(double value){
        return value/jpy;
    }
    private double gbpToEur(double value){
        return value/gbp;
    }
    private double chfToEur(double value){
        return value/chf;
    }
}
