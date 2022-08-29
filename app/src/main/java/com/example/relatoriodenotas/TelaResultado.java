package com.example.relatoriodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TelaResultado extends AppCompatActivity {
    private TextView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado);

        lista = findViewById(R.id.lista);

        Intent it = getIntent();
        String alunos = it.getStringExtra("dados");
        lista.setText(alunos);
    }
}