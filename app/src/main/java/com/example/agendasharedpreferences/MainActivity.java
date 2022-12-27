package com.example.agendasharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre=(EditText)findViewById(R.id.txt_nombre);
        et_datos=(EditText) findViewById(R.id.txt_datos);
    }

    //Metodo para el boton Guardar
    public void Guardar(View view){
        String nombre=et_nombre.getText().toString();
        String datos=et_datos.getText().toString();

        SharedPreferences preferencias=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor=preferencias.edit();
        //Ponemos en el objeto el nombre y los datos que queremos guardar
        obj_editor.putString(nombre,datos);
        obj_editor.commit();

        //Le dice al usuario que ya se guardo
        Toast.makeText(this,"El contacto ha sido guardado",Toast.LENGTH_SHORT).show();
    }

    //Metodo para el boton Buscar
    public void Buscar(View view){
        //Como son variables locales se pueden repetir los nombres
        String nombre=et_nombre.getText().toString();

        SharedPreferences preferencias=getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos=preferencias.getString(nombre,"");

        if(datos.length()==0){
            Toast.makeText(this, "No se encontró ningún registro", Toast.LENGTH_SHORT).show();
        }else{
            et_datos.setText(datos);
        }
    }
}