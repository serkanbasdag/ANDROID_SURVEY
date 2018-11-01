package com.example.acerv17nitro.anket;

        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etK,etP;
    Button bG,bKayit;
    String k = "serkan";
    String p = "123";
    Context con = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pass = intent.getStringExtra("pass");
        k = name;
        p = pass;

            etK = findViewById(R.id.etK);
            etP = findViewById(R.id.etP);
            bG = findViewById(R.id.bG);
            bKayit = findViewById(R.id.bKayit);
            bKayit.setOnClickListener(this);
            bG.setOnClickListener(this);
        }

        @Override
    public void onClick(View v)
        {
            String k1 = etK.getText().toString();
            String p1 = etP.getText().toString();
         if(v.getId() == bG.getId()) {
             if (k1.equals(k) && p1.equals(p)) {
                 Toast.makeText(con, "Giriş Başarılı!", Toast.LENGTH_LONG).show();
                 Intent intent = new Intent(MainActivity.this, Activity_Anket.class);
                 intent.putExtra("name", k1);
                 startActivity(intent);
             } else {
                 AlertDialog.Builder uyari = new AlertDialog.Builder(con);
                 uyari.setTitle("Giriş Yapılamadı");
                 uyari.setMessage("Kullanıcı Bulunamadı. Kayıt Olmak İstiyor Musunuz?");
                 uyari.setCancelable(false);
                 uyari.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Intent intent = new Intent(MainActivity.this, LoginScreen.class);
                         startActivity(intent);
                     }
                 });
                 uyari.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 });
                 AlertDialog alertDialog = uyari.create();
                 alertDialog.show();
             }
         }
         else if(v.getId() == bKayit.getId())
         {
             Intent intent = new Intent(MainActivity.this, LoginScreen.class);
             startActivity(intent);
         }
        }
}
