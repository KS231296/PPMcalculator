package com.example.kinu.ppmcalculator;

public class PPM {

    public double hb(String plec, double masa, double wzrost, double wiek) {
        double ppm = 0;
        if (plec.equals("K")) {
            ppm = 655.1 + (9.563 * masa) + (1.85 * wzrost) - (4.676 * wiek);
        }
        if (plec.equals("M")) {
            ppm = 66.5 + (13.75 * masa) + (5.003 * wzrost) - (6.775 * wiek);
        }
        return ppm;
    }

    public double mifflin(String plec, double masa, double wzrost, double wiek) {
        double ppm = 0;
        if (plec.equals("K")) {
            ppm = (10 * masa) + (6.25 * wzrost) - (5 * wiek) - 161;
        }
        if (plec.equals("M")) {
            ppm = (10 * masa) + (6.25 * wzrost) - (5 * wiek) + 5;
        }
        return ppm;
    }
}
