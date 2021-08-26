package com.example.examen_e1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText jeN1;
    private TextView jtResultado, jtTitulo;
    private Button jbAceptar, jbLimpiar, jbSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Caja de texto
        jeN1 = findViewById(R.id.eN1);

        //Resultados
        jtResultado = findViewById(R.id.tResultado);
        jtTitulo = findViewById(R.id.tTitulo);

        //Botones
        jbAceptar = findViewById(R.id.bAceptar);
        jbLimpiar = findViewById(R.id.bLimpiar);
        jbSalir = findViewById(R.id.bSalir);
    }//Fin onCreate

    public void Aceptar(View control){
        if (jeN1.length()==0) {
            Toast.makeText(this, "Tienes que ingresar un numero", Toast.LENGTH_SHORT).show();
            jtResultado.setVisibility(View.INVISIBLE);
            return;
        }

        final int numero = Integer.parseInt(jeN1.getText().toString());

        if (numero<=10) {
            Toast.makeText(this, "Tiene que ingresar numeros mayores que 10", Toast.LENGTH_SHORT).show();
            jtResultado.setVisibility(View.INVISIBLE);
            return;
        }

        int contadorPrimos = 4; //Contar los numeros primos
        int contadorDivisores = 0; //Contador para saber el numero de divisores que tiene el numero
        int numerosHastaNumero, verificarPrimo; //Contadores
        String cadenaNumerosPrimos = "2, 3, 5, 7"; //Cadena para mostrar resultado

        for (numerosHastaNumero=11; numerosHastaNumero<=numero; numerosHastaNumero++) {
             for (verificarPrimo=1; verificarPrimo<=numerosHastaNumero; verificarPrimo++) {
                 if (numerosHastaNumero%verificarPrimo == 0) contadorDivisores++;
             }
            if (contadorDivisores == 2) {
                contadorPrimos++;
                cadenaNumerosPrimos += ", " + numerosHastaNumero;
            }
            contadorDivisores = 0;
        }

        jtResultado.setText("Entre el 1 y el " + numero + " hay " + contadorPrimos + " numeros primos: " + cadenaNumerosPrimos + ".");
        jtResultado.setVisibility(View.VISIBLE);
        jbAceptar.setVisibility(View.INVISIBLE);
        jbSalir.setVisibility(View.INVISIBLE);
        jbLimpiar.setVisibility(View.VISIBLE);
        jeN1.setVisibility(View.INVISIBLE);
        jtTitulo.setVisibility(View.INVISIBLE);

        return;

    }//Fin Aceptar

    public void Limpiar(View control){
        jeN1.setText("");
        jtResultado.setVisibility(View.INVISIBLE);
        jbAceptar.setVisibility(View.VISIBLE);
        jbSalir.setVisibility(View.VISIBLE);
        jeN1.setVisibility(View.VISIBLE);
        jtTitulo.setVisibility(View.VISIBLE);

        return;
    }//Fin Limpiar

    public void Salir(View control){
        finish();
    }//Fin Salir

}//Fin MainActivity