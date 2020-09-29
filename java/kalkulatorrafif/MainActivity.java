package com.example.kalkulatorrafif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView hasil;
    EditText angka_pertama,angka_kedua,operasi_bil;
    Button button;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka_pertama = findViewById(R.id.etAngka1);
        angka_kedua   = findViewById(R.id.etAngka2);
        operasi_bil   = findViewById(R.id.etOperasi);
        hasil         = findViewById(R.id.tvHasil);
        button        = findViewById(R.id.btnHasil);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String bil    = operasi_bil.getText().toString();
                    double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                    double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                        if (bil.equalsIgnoreCase("-")){
                            total = angka1 - angka2;
                            hasil.setText("Hasil operasi adalah: " + Double.toString(total));
                        }else if(bil.equalsIgnoreCase("+")){
                            total = angka1 + angka2;
                            hasil.setText("Hasil operasi adalah: " + Double.toString(total));
                        }else if(bil.equalsIgnoreCase("/")){
                            total = angka1 / angka2;
                            hasil.setText("Hasil operasi adalah: " + Double.toString(total));
                        }else if(bil.equalsIgnoreCase("*")){
                            total = angka1 * angka2;
                            hasil.setText("Hasil operasi adalah: " + Double.toString(total));
                        }else{
                            hasil.setText("Field Operasi harus diisi dengan\n + - * /");
                            Toast.makeText(getApplicationContext(), "OPERASI ARITMATIK TIDAK SESUAI !",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Log.e("Error", String.valueOf(e));
                        hasil.setText("");
                        Toast.makeText(getApplicationContext(), "INPUTKAN ANGKA TERLEBIH DAHULU !",Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}