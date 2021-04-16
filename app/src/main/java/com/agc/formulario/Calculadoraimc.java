package com.agc.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

public class Calculadoraimc extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInformation;
    private TextView tvResult;
    private EditText txtHeight;
    private EditText txtWeight;
    private Button btnCalculator;
    private ImageView ImgState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_caulculadoraimc);
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");
        String email = intent.getStringExtra("email");
        String message = "Hola " + name + " " + surname + " es un gusto tenerte acá tu correo para el informe es: " + email;
        tvInformation = findViewById(R.id.tvtInformation);
        tvResult = findViewById(R.id.tvResult);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        btnCalculator = findViewById(R.id.btnCalculator);
        ImgState = findViewById(R.id.ImgState);
        tvInformation.setText(message);
        btnCalculator.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnCalculator){
            float IMC;
            float PesoKg =Float.parseFloat(txtWeight.getText().toString());
            float altura=Float.parseFloat(txtHeight.getText().toString());

            if(altura == 0 || altura<0){
                CustomToastView.makeInfoToast(this,"Error al validar la ALTURA",R.layout.custom_toast).show();
            }
            if(PesoKg == 0 || altura<0){
                CustomToastView.makeErrorToast(this,"Error al validar el PESO",R.layout.custom_toast).show();
                return;
            }
            IMC= PesoKg/(altura*altura);
            tvResult.setText("Su IMC es: "+ redondeo(IMC));

            if(IMC<18.5){
                tvResult.setText(" Usted se encuentra BAJO DE PESO, su IMC es: "+ IMC);
                ImgState.setImageResource(R.drawable.bajo_peso);
            }
            if(IMC>=18.5 && IMC <=24.9){
                tvResult.setText(" Usted se encuentra en el PESO IDEAL, su IMC es: "+ IMC);
                ImgState.setImageResource(R.drawable.peso_ideal);
            }
            if(IMC>=25 && IMC <=29.9){
                tvResult.setText(" Usted se encuentra con SOBREPESO su IMC es: "+ IMC);
                ImgState.setImageResource(R.drawable.sobre_peso);
            }
            if(IMC>=30 && IMC <=34.9){
                tvResult.setText(" Usted se encuentra con OBESIDAD  su IMC es: "+ IMC);
                ImgState.setImageResource(R.drawable.obesidad);
            }
            if(IMC>=35 && IMC <=39.9){
                tvResult.setText(" Usted se encuentra con OBESIDAD SEVERA su IMC es: "+ IMC);
                ImgState.setImageResource(R.drawable.obesidad_severa);
            }
            if(IMC>=40 ){
                tvResult.setText(" Usted se encuentra con OBESIDAD MORBIDA su IMC es: "+ IMC);
                ImgState.setImageResource(R.drawable.obesidad_morbida);
            }

        }
    }
    public float redondeo(float n){
        float resultado;
        int valor=0;
        valor=(int)(n*100);
        resultado=(float)valor/100;
        return n;
    }

}