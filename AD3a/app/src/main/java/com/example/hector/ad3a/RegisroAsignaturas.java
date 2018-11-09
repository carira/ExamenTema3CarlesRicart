package com.example.hector.ad3a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisroAsignaturas extends AppCompatActivity {

    private Button volver;
    private Button registrar;
    private EditText as_nombreAsg;
    private EditText as_numeroasignaturas;
    private MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.asignaturas);
        volver=(Button)findViewById(R.id.a_volver);
        registrar=(Button) findViewById(R.id.a_registrar);
        as_nombreAsg=(EditText) findViewById(R.id.as_nombreAsg);
        as_numeroasignaturas=(EditText) findViewById(R.id.as_numeroasignaturas);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AD3B.class);
                startActivity(i);
            }
        });

        dbAdapter = new MyDBAdapter(getApplicationContext());

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();

                dbAdapter.insertarAsignaturas(as_nombreAsg.getText().toString() ,as_numeroasignaturas.getText().toString());


            }
        });
    }
}
