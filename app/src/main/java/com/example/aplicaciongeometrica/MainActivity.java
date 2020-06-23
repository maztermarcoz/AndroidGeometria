package com.example.aplicaciongeometrica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textv1;
    private TextView textv2;
    private EditText AX;
    private EditText AY;
    private EditText BX;
    private EditText BY;
    private Button btnCheck;

    public void Checar(){
        //Identificacion de componentes
        textv1 = (TextView)findViewById(R.id.lbl1);
        textv2 = (TextView)findViewById(R.id.lbl2);
        AX = (EditText)findViewById(R.id.editAX);
        AY = (EditText)findViewById(R.id.editAY);
        BX = (EditText)findViewById(R.id.editBX);
        BY = (EditText)findViewById(R.id.editBY);
        btnCheck = (Button)findViewById(R.id.btn1);
       /* btnCheck.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calcular();
                    }
                }

                //Instruccion del boton

        );
         */
    }
    public void Calcular(View view) {
        try {


            float ax = Float.parseFloat(AX.getText().toString());
            float ay = Float.parseFloat(AY.getText().toString());
            float bx = Float.parseFloat(BX.getText().toString());
            float by = Float.parseFloat(BY.getText().toString());

            if ((bx == ax) | (by == ay)) {
                Toast.makeText(this, "No existe una pendiente, cambia los valores", Toast.LENGTH_LONG).show();
            } else {

                float R1 = by - ay;
                float R2 = bx - ax;

                double PR = (R1 / R2);
                double DT = (Math.sqrt((Math.pow(R1, 2)) + (Math.pow(R2, 2))));
                textv1.setText(String.valueOf(R1));
                textv2.setText(String.valueOf(R2));


                Toast.makeText(this, "La pendiente es de " + PR, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "La distancia entre los puntos es de " + DT, Toast.LENGTH_LONG).show();
            }

        } catch (Exception e){
            Toast.makeText(this, "Error desconocido, vuelve a intentarlo"  ,Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Checar();
    }
}