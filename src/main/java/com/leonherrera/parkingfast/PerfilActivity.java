package com.leonherrera.parkingfast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {
    String User,Password,Email;
    TextView tPUser, tPPassword, tPEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tPUser = (TextView) findViewById(R.id.tPUser);
        tPPassword = (TextView)findViewById(R.id.tPPassword);
        tPEmail = (TextView)findViewById(R.id.tPEmail);
        Bundle data =getIntent().getExtras();
        User = String.valueOf(data.getString("Usuario"));
        Password = String.valueOf(data.getString("Contraseña"));
        Email=String.valueOf(data.getString("Email"));

        tPUser.setText("Usuario: "+User);
        tPUser.setTextSize(30);
        tPEmail.setText("Email: "+Email);
        tPEmail.setTextSize(30);
        tPPassword.setText("Contraseña: "+Password);
        tPPassword.setTextSize(30);
/*
        tPUser.setText("Usuario: " + eRUser.getText().toString());
        tPPassword.setText("Contraseña: " + eRPassword.getText().toString());
        tPEmail.setText("E-mail: " + eREmail.getText().toString());*/
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mInicio){
            Intent i = new Intent(PerfilActivity.this,InformacionActivity.class);
            i.putExtra("Usuario",User);
            i.putExtra("Contraseña",Password);
            i.putExtra("Email",Email);
            startActivity(i);
        }
        if (id == R.id.mClasificacion){
            Intent i = new Intent(PerfilActivity.this,MainActivity.class);
            i.putExtra("Usuario",User);
            i.putExtra("Contraseña",Password);
            i.putExtra("Email",Email);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
