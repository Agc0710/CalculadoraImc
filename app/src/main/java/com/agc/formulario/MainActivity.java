package com.agc.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDone;
    private EditText TxtName;
    private EditText TxtSurname;
    private EditText TxtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDone = findViewById(R.id.btnDone);
        TxtName = findViewById(R.id.TxtName);
        TxtSurname = findViewById(R.id.TxtSurname);
        TxtEmail = findViewById(R.id.TxtEmail);
        btnDone.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnDone){
            String name = TxtName.getText().toString();
            String surname= TxtSurname.getText().toString();
            String email = TxtEmail.getText().toString();
            if(name.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar el nombre",R.layout.custom_toast).show();
            }
            if(surname.isEmpty()){
                CustomToastView.makeInfoToast(this,"Error al validar el Apellido",R.layout.custom_toast).show();
            }
            if(!isValidEmail(email)){
                CustomToastView.makeWarningToast(this,"Error al validar el Apellido",R.layout.custom_toast).show();
                return;
            }
            Intent myIntent = new Intent(this, Calculadoraimc.class);
            myIntent.putExtra("name", name);
            myIntent.putExtra("surname", surname);
            myIntent.putExtra("email", email);

            startActivity(myIntent);


        }
    }
 //validar caracteres del email con el Pattern que viene por defecto en android
    private Boolean isValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return  pattern.matcher(email).matches();


    }
}