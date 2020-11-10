package com.laurien.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private SeekBar     seekBarPorcentagem;
    private EditText    textValor;
    private TextView    textPorcentagem;
    private TextView    textGorjeta;
    private TextView    textTotal;
    private double      porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarPorcentagem  = findViewById(R.id.seekBarPorcentagem);
        textValor           = findViewById(R.id.textValor);
        textGorjeta         = findViewById(R.id.textGorjeta);
        textPorcentagem     = findViewById(R.id.textPorcentagem);
        textTotal           = findViewById(R.id.textTotal);


        //listener seekbar

        seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){

        String valorInserido = textValor.getText().toString();


        if(valorInserido == null || valorInserido.equals("")){
            Toast.makeText(getApplicationContext(), "Insira um valor", Toast.LENGTH_LONG).show();
        }else{
            DecimalFormat f = new DecimalFormat("#.##");
            double valor = Double.parseDouble(valorInserido);

            double gorjeta = valor * (porcentagem/100);
            textGorjeta.setText("R$" + f.format(gorjeta));

            textTotal.setText("R$" + f.format(valor + gorjeta));
        }

    }
}