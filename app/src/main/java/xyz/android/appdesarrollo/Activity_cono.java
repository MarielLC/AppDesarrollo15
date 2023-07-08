package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Activity_cono extends AppCompatActivity {

    EditText txt_cono_altura,txt_cono_radio;
    RadioButton rb_area_cono;
    RadioButton rb_volumen_cono;
    Button btn_cono_calcular;
    Button btn_cono_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        txt_cono_altura = findViewById(R.id.txt_cono_altura);
        txt_cono_radio = findViewById(R.id.txt_cono_radio);
        rb_area_cono=findViewById(R.id.rdio_area_cono);
        rb_volumen_cono=findViewById(R.id.rdio_volumen_cono);
        btn_cono_calcular = findViewById(R.id.btn_cono_calcular);
        btn_cono_limpiar = findViewById(R.id.btn_cono_limpiar);
        btn_cono_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_cono.this, result);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void showResultDialog(Context context, String result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Resultado");
        builder.setMessage(result);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public String calcular(){

        double altura_cono_double, radio_cono_double;
        if(txt_cono_altura.getText().toString().isEmpty() || txt_cono_radio.getText().toString().isEmpty()){
            altura_cono_double=0.0;
            radio_cono_double=0.0;
        }else{
            altura_cono_double=Double.parseDouble(txt_cono_altura.getText().toString());
            radio_cono_double=Double.parseDouble(txt_cono_radio.getText().toString());
        }

        String resultado ="";
        //operamos con radiobutton
        if(rb_area_cono.isChecked()==false && rb_volumen_cono.isChecked()==false){
            return resultado="Seleccione una opcion";
        }
        if(rb_area_cono.isChecked()==true){
            resultado = "El área de la superficie es: "+ CalcularArea(altura_cono_double,radio_cono_double);
        }if(rb_volumen_cono.isChecked()==true){
            resultado = resultado+"\nEl volumen es: "+CalcularVolumen(altura_cono_double,radio_cono_double);
        }
        return resultado;

    }

    public String CalcularArea(double alturaCn, double radioCn){
        double ladoInclinado=Math.sqrt(Math.pow(alturaCn,2)+Math.pow(radioCn,2));
        return String.valueOf(Math.PI*radioCn*(radioCn+ladoInclinado));
    }

    public String CalcularVolumen(double alturaCn, double radioCn){
        return String.valueOf((Math.PI*alturaCn*Math.pow(radioCn,2))/3);
    }

    public void Limpiar(View view){
        txt_cono_altura.setText("");
        txt_cono_radio.setText("");
        rb_volumen_cono.setChecked(false);
        rb_area_cono.setChecked(false);
    }


}