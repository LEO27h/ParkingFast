package com.leonherrera.parkingfast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class InformacionActivity extends AppCompatActivity {
    String User, Password,Email;

    TextView tPPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Bundle data =getIntent().getExtras();
        User = String.valueOf(data.getString("Usuario"));
        Password = String.valueOf(data.getString("Contraseña"));
        Email=String.valueOf(data.getString("Email"));
        tPPerfil = (TextView) findViewById(R.id.tPPerfil);
        tPPerfil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformacionActivity.this, PerfilActivity.class);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mPerfil){
            Intent i = new Intent(InformacionActivity.this,PerfilActivity.class);
            i.putExtra("Usuario",User);
            i.putExtra("Contraseña",Password);
            i.putExtra("Email",Email);
            startActivity(i);
        }
        if (id == R.id.mClasificacion){
            Intent i = new Intent(InformacionActivity.this,MainActivity.class);
            i.putExtra("Usuario",User);
            i.putExtra("Contraseña",Password);
            i.putExtra("Email",Email);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}
