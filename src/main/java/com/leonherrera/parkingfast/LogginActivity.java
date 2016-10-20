package com.leonherrera.parkingfast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LogginActivity extends AppCompatActivity {
    private String User, Password, Email;
    EditText eLUser, eLPassword;
    TextView tLRegister;
    Button bLEnter;

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

/*
        prefs = getPreferences(MODE_PRIVATE);

        prefs.getInt("Loggeo",-1);

        int dato = prefs.getInt("Loggeo",-1);
        Log.d("Loggeo",String.valueOf(dato));

        if (dato==1){
            Intent intent = new Intent(this, InformacionActivity.class);
            startActivity(intent);
            finish();
        }
        */

        eLUser = (EditText)findViewById(R.id.eLUser);
        eLPassword = (EditText)findViewById(R.id.eLPassword);
        tLRegister = (TextView)findViewById(R.id.tLRegister);
        bLEnter = (Button)findViewById(R.id.bLEnter);

        tLRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,1234);
            }
        });
        bLEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!((eLUser.getText().toString().equals(""))|| (eLPassword.getText().toString().equals("")))){
                    if(eLPassword.getText().toString().equals(Password) && eLUser.getText().toString().equals(User)){
                        Intent intent =new Intent(LogginActivity.this,InformacionActivity.class);
                        intent.putExtra("Usuario",User);
                        intent.putExtra("Contraseña",Password);
                        intent.putExtra("Email",Email);
                        /*SharedPreferences.Editor editor;
                        editor = prefs.edit();
                        editor.putInt("Loggeo", 1);
                        editor.commit();*/
                        startActivity(intent);
                    }else{
                        Toast.makeText(LogginActivity.this,"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LogginActivity.this,"Debe ingresar su Usuario y Contraseña",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    protected void onActivityResult (int requestcode, int resultCode, Intent data){
        if(requestcode==1234 && resultCode == RESULT_OK){
            User = data.getExtras().getString("Usuario");
            Password = data.getExtras().getString("Contraseña");
            Email = data.getExtras().getString("Email");
            Toast.makeText(LogginActivity.this,"Usuario: "+User+ ", Contrasena: "+Password+ ", Email: "+Email,Toast.LENGTH_SHORT).show();

        }
        if(requestcode==1234 && resultCode == RESULT_CANCELED){
            Toast.makeText(LogginActivity.this,"El registro fue cancelado",Toast.LENGTH_SHORT).show();
        }

    }
}
