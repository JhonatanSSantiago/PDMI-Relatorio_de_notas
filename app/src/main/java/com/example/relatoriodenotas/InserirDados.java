package com.example.relatoriodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class InserirDados extends AppCompatActivity {
    private EditText nome, nota1, nota2;
    private Button adicionar, resultado;
    private ArrayList<Aluno> lista = new ArrayList<Aluno>();
    private Aluno a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        nome = findViewById(R.id.nome);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);

        adicionar = findViewById(R.id.btnAdd);
        resultado = findViewById(R.id.btnResultado);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_nome = nome.getText().toString();
                Double d_nota_1 = Double.parseDouble((nota1.getText().toString()));
                Double d_nota_2 = Double.parseDouble((nota2.getText().toString()));
                a = new Aluno(s_nome, d_nota_1, d_nota_2);
                a.calcularMedia();
                a.setSituacao(a.getMedia());
                lista.add(a);
                Toast.makeText(getApplicationContext(), " " + lista, Toast.LENGTH_SHORT).show();

            }
        });

        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), TelaResultado.class);
                String arrayToString = lista.toString();
                it.putExtra("dados", arrayToString);
                startActivity(it);
            }
        });

    }
}