package com.majemase.mochila;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    CheckBox chkGorras, chkBanadores, chkCamisetas, chkZapatos, chkPantalones, chkLibros;
    TextView lblSol;
    Double peso = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblSol = findViewById(R.id.lblSol);

        CompoundButton.OnCheckedChangeListener reventos = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton btnView, boolean isChecked) {
                if(isChecked){
                    switch (btnView.getText().toString()){
                        case "Gorras":
                            peso += 0.5;
                            break;
                        case "Bañadores":
                            peso += 1;
                            break;
                        case "Camisetas":
                            peso += 1.25;
                            break;
                        case "Zapatos":
                            peso += 0.59;
                            break;
                        case "Pantalones":
                            peso += 0.75;
                            break;
                        case "Libros":
                            peso += 5;
                            break;
                    }
                    lblSol.setText("Peso " + peso + " Kg");
                }else{
                    switch (btnView.getText().toString()){
                        case "Gorras":
                            peso -= 0.5;
                            break;
                        case "Bañadores":
                            peso -= 1;
                            break;
                        case "Camisetas":
                            peso -= 1.25;
                            break;
                        case "Zapatos":
                            peso -= 0.59;
                            break;
                        case "Pantalones":
                            peso -= 0.75;
                            break;
                        case "Libros":
                            peso -= 5;
                            break;
                    }
                    lblSol.setText("Peso " + peso + " Kg");
                }
            }
        };

        chkGorras = findViewById(R.id.chkGorras);
        chkBanadores = findViewById(R.id.chkBañadores);
        chkCamisetas = findViewById(R.id.chkCamisetas);
        chkZapatos = findViewById(R.id.chkZapatos);
        chkPantalones = findViewById(R.id.chkPantalones);
        chkLibros = findViewById(R.id.chkLibros);

        chkGorras.setOnCheckedChangeListener(reventos);
        chkBanadores.setOnCheckedChangeListener(reventos);
        chkCamisetas.setOnCheckedChangeListener(reventos);
        chkZapatos.setOnCheckedChangeListener(reventos);
        chkPantalones.setOnCheckedChangeListener(reventos);
        chkLibros.setOnCheckedChangeListener(reventos);

        findViewById(R.id.btnVaciar).setOnClickListener(v -> {
            lblSol.setText("Peso 0 Kg");
        });
    }
}