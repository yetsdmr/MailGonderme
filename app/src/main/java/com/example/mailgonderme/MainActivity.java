package com.example.mailgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mAdres,mKonu,mIcerik;
    Button btnGonder;
    String icerikText,konuText,mAdresText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        mailUygulamalariniGorVeGonder();
    }

    private void tanimla() {
        mAdres = findViewById(R.id.editTextMailAdres);
        mKonu = findViewById(R.id.editTextMailKonu);
        mIcerik = findViewById(R.id.editTextMailIcerik);
        btnGonder = findViewById(R.id.btnMailGonder);
    }
    private void bilgiAl(){
        icerikText = mIcerik.getText().toString();
        konuText = mKonu.getText().toString();
        mAdresText = mAdres.getText().toString();
    }
    private void mailUygulamalariniGorVeGonder(){
        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgiAl();
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL,mAdresText);
                    intent.putExtra(Intent.EXTRA_SUBJECT,konuText);
                    intent.putExtra(Intent.EXTRA_TEXT,icerikText);
                    startActivity(Intent.createChooser(intent,"mail gönderiniz"));
                }catch (Exception e){
                    System.out.println(""+e);
                }

            }
        });
    }

}