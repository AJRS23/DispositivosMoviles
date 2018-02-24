package com.tec.alvaroramirez.convertidortec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final double cambioColones = 569.43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClickAccept(View view){

        String resultado= "";
        double valor = 0;
        EditText editTextCantidad = findViewById(R.id.editText_monto);
        String cantidad = editTextCantidad.getText().toString();

        RadioButton rbtnCol = findViewById(R.id.rbtn_colones);
        RadioButton rbtnDol = findViewById(R.id.rbtn_dolares);


        if (rbtnCol.isChecked()){
            resultado = cantidad + " CRC = ";
            valor = (double)Math.round(convertirColones(cantidad) * 100000d) / 100000d;
            resultado += String.valueOf(valor) + " USD";
        }
        else if (rbtnDol.isChecked()){
            resultado = cantidad + " USD = ";
            valor = (double)Math.round(convertirDolares(cantidad) * 100000d) / 100000d;
            resultado += String.valueOf(valor) + " CRC";
        }

        TextView txtRes = findViewById(R.id.txt_resultado);
        txtRes.setText(resultado);

        editTextCantidad.setText("");



        /*Log.d("Info",String.format("%s",resultado));

        Toast toast1 = Toast.makeText(getApplicationContext(),String.format("%s",resultado), Toast.LENGTH_LONG);
        toast1.setGravity(Gravity.CENTER, 0,0 );

        toast1.show();*/

    }


    protected double convertirColones(String monto){
        double resultado = Double.parseDouble(monto) / cambioColones;

        return (resultado);
    }
    protected double convertirDolares(String monto){
        double resultado = Double.parseDouble(monto) * cambioColones;

        return (resultado);
    }
}
