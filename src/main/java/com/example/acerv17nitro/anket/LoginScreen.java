package com.example.acerv17nitro.anket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class LoginScreen extends MainActivity implements View.OnClickListener {

    EditText etName,etMail,etPass;
    Button bSign;
    String name ="";
    String pass ="";
    Context con = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etMail = findViewById(R.id.etMail);
        etPass = findViewById(R.id.etPass);
        bSign  = findViewById(R.id.bSign);
        bSign.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        name = etName.getText().toString();
        pass = etPass.getText().toString();

        Intent intent = new Intent(con, MainActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("pass",pass);
        startActivity(intent);

        Toast.makeText(con, "Kayıt Başarılı! Lütfen Giriş Yapınız!", Toast.LENGTH_LONG).show();
    }
}
