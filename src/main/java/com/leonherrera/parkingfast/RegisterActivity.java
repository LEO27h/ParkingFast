package com.leonherrera.parkingfast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText eRUser, eRPassword, eRConfirmPassword, eREmail;
    Button bRAccept, bRCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eRUser = (EditText)findViewById(R.id.eRUser);
        eRPassword = (EditText) findViewById(R.id.eRPassword);
        eRConfirmPassword = (EditText)findViewById(R.id.eRPassword);
        eREmail = (EditText) findViewById(R.id.eREmail);
        bRAccept = (Button) findViewById(R.id.bRAccept);
        bRCancel = (Button) findViewById(R.id.bRCancel);

        /*bRAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(eRUser.getText().toString().equals("") || eRPassword.getText().toString().equals("") || eRConfirmPassword.getText().toString().equals("") || eREmail.getText().toString().equals("")) ){
                    if (eRPassword.getText().toString().equals(eRConfirmPassword.getText().toString())) {
                        Intent intent = new Intent();
                        intent.putExtra("Usuario", eRUser.getText().toString());
                        intent.putExtra("Contraseña", eRPassword.getText().toString());
                        intent.putExtra("Email", eREmail.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Las Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Hay campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        bRAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((eRUser.getText().toString().equals("")  || eRPassword.getText().toString().equals("") || eRConfirmPassword.getText().toString().equals("") || eREmail.getText().toString().equals("")))
                    {

                        Toast.makeText(RegisterActivity.this, "Debe llenar todos los items para continuar", Toast.LENGTH_SHORT).show();
                }else {
                    if (((eRPassword.getText().toString()).equals(eRConfirmPassword.getText().toString()))) {
                        Intent intent = new Intent();
                        intent.putExtra("Usuario",eRUser.getText().toString());
                        intent.putExtra("Contraseña",eRPassword.getText().toString());
                        intent.putExtra("Email",eREmail.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                        Toast.makeText(RegisterActivity.this,"Las contraseñas coinciden", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this,"Las contraseñas deben coincidir", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
        bRCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}
