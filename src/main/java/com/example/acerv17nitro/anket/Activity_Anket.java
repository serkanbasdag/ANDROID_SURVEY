package com.example.acerv17nitro.anket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Anket extends MainActivity {
    Button bGonder;
    RadioGroup rbgTakim,rbgCinsiyet;
    TextView tv;
    RadioButton rbErkek,rbKadin,rbFb,rbGs,rbBjk;
    CheckBox cbc,cbjava,cbjavas,cbphy,cbphp;
    String mesaj="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anket);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        rbgCinsiyet = findViewById(R.id.rbgCinsiyet);
        rbgTakim = findViewById(R.id.rbgTakim);
        tv = findViewById(R.id.tv);
        tv.setText("Ankete Hoşgeldiniz: "+name);

        cbc = findViewById(R.id.cbc);
        cbjava = findViewById(R.id.cbjava);
        cbjavas = findViewById(R.id.cbjavas);
        cbphy = findViewById(R.id.cbphy);
        cbphp = findViewById(R.id.cbphp);

        bGonder = findViewById(R.id.bGonder);
        bGonder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int rbcins = rbgCinsiyet.getCheckedRadioButtonId();
        int rbtakim = rbgTakim.getCheckedRadioButtonId();

        switch (rbcins)
        {
            case R.id.rbErkek: {mesaj += "Cinsiyet: Erkek. " ; break;}
            case R.id.rbKadin: {mesaj += "Cinsiyet: Kadın. " ; break;}
        }
        mesaj += "Takım : ";
        switch (rbtakim)
        {
            case R.id.rbFb: {mesaj += " Fenerbahçe. " ; break;}
            case R.id.rbGs: {mesaj += " Galatasaray. " ; break;}
            case R.id.rbBjk:{mesaj += " Beşiktaş. " ; break;}
        }
        mesaj += "Diller : ";
        if (cbc.isChecked()) {
            mesaj += " C++, ";
        }
        if (cbjava.isChecked()) {
            mesaj += " Java, ";
        }
        if (cbjavas.isChecked()) {
            mesaj += " JavaScript, ";
        }
        if (cbphy.isChecked()) {
            mesaj += " Phyton, ";
        }
        if (cbphp.isChecked()) {
            mesaj += " Php, ";
        }
        Toast.makeText(Activity_Anket.this, mesaj, Toast.LENGTH_LONG).show();
        mesaj = "";
    }
}
