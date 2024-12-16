package com.makotto.calculaFrete.formatter;

import java.text.DecimalFormat;

public class CurrencyFormatter {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static String format(double value) {
        return df.format(value).replace('.', ',');
    }
}
