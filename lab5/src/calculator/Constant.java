package calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Constant extends Node {
    double value;

    Constant(double value){
        this.sign = value<0 ? -1 : 1;
        this.value = value<0 ? -value : value;
    }


    @Override
    double evaluate() {
        return sign*value;
    }

    @Override
    public String toString() {
        String sgn = sign<0 ? "-" : "";
        // return sgn+Double.toString(value);
        // stosując DecimalFormat pozbędziemy się niepotrzebnych zer na końcu wartości double
        DecimalFormat format = new DecimalFormat("0.#####",new DecimalFormatSymbols(Locale.US));
        return sgn+format.format(value);
    }
}
