package com.example.kinu.ppmcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double ppm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view){
        TextView wynik = (TextView) findViewById(R.id.wynik);
        Spinner spinnerPlec = (Spinner)findViewById(R.id.opcja_plec);
        Spinner spinnerSposob = (Spinner)findViewById(R.id.opcja_sposob);
        String plec = String.valueOf(spinnerPlec.getSelectedItem());
        String sposob = String.valueOf(spinnerSposob.getSelectedItem());

        EditText poleWzrost = (EditText) findViewById(R.id.wzrost);
        EditText poleMasa = (EditText) findViewById(R.id.masa);
        EditText poleWiek = (EditText) findViewById(R.id.wiek);


        try{
            double wzrost = Double.valueOf(poleWzrost.getText().toString());
            double masa = Double.valueOf(poleMasa.getText().toString());
            double wiek = Double.valueOf(poleWiek.getText().toString());


            PPM obliczenia = new PPM();
            switch (sposob) {
                case "Benedicta-Harrisa":
                    ppm = obliczenia.hb(plec, masa, wzrost, wiek);

                    break;
                case "Mifflina":
                    ppm = obliczenia.mifflin(plec, masa, wzrost, wiek);

                    break;
                default:
                    ppm = 0;
                    break;
            }

            DecimalFormat twoDFFormat = new DecimalFormat("#.##");

            wynik.setText("PPM= "+String.valueOf(twoDFFormat.format(ppm)));

        }catch(NumberFormatException e){
            wynik.setText("Co najmniej 1 z pól nie jest liczba");
        }

    }
}
