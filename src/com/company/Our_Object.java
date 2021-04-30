package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Our_Object  {
    private final String Unit;
    private final double Coefficient;
    private String Convert_to = "";

    public Our_Object(String unit, double coefficient, String convert_to) {
        Unit = unit;
        Coefficient = coefficient;
        Convert_to = convert_to;
    }
    public Our_Object(String unit, double coefficient) {
        Unit = unit;
        Coefficient = coefficient;
    }
    public String getUnit() {
        return Unit;
    }
    public double getCoefficient() {
        return round(Coefficient);
    }
    public String getConvert_to() {
        return Convert_to;
    }
// Ограничивыем вывод двумя цыфрами после запятой
    private static double round(double Coefficient) {
        BigDecimal bd = new BigDecimal(Double.toString(Coefficient));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
