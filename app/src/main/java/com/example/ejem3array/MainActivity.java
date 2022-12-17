package com.example.ejem3array;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private
    EditText Num1, Num2;
    Button boton;
    TextView Res;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = (EditText)findViewById(R.id.Num1);
        Num2 = (EditText)findViewById(R.id.Num2);
        boton = (Button) findViewById(R.id.boton);
        Res = (TextView) findViewById(R.id.Res);
        spinner1 = (Spinner) findViewById(R.id.sele);

        String [] operaciones = {"Sumar","Restar","Multiplicar","Dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, operaciones);
        spinner1.setAdapter(adapter);

    }
      //Metodo del boton
    public void calcular(View view){

        String string_valor1 = Num1.getText().toString();
        String string_valor2 = Num2.getText().toString();

        int int_valor1 = Integer.parseInt(string_valor1);
        int int_valor2 = Integer.parseInt(string_valor2);

        String seleccion = spinner1.getSelectedItem().toString();

        if(seleccion.equals("Sumar")) {
            int suma = int_valor1 + int_valor2;
            String resultado = String.valueOf(suma);
            Res.setText(resultado);
        }else if(seleccion.equals("Restar")){
            int resta = int_valor1 - int_valor2;
            String resultado = String.valueOf(resta);
            Res.setText(resultado);
        }else if(seleccion.equals("Multiplicar")){
            int multi = int_valor1 * int_valor2;
            String resultado = String.valueOf(multi);
            Res.setText(resultado);
        }else if(seleccion.equals("Dividir")){

            if(int_valor2 != 0){
                int dividir = int_valor1 / int_valor2;
                String resultado = String.valueOf(dividir);
                Res.setText(resultado);
            }else{
                Toast.makeText(this,"No se puede dividir entre cero",Toast.LENGTH_SHORT).show();
            }
        }
    }
}