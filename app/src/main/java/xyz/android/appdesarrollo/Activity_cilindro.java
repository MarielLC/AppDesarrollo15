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
import android.widget.Toast;

public class Activity_cilindro extends AppCompatActivity {

    EditText txt_radio_cilindro, txt_altura_cilindro;
    RadioButton rb_area_cilindro;
    RadioButton rb_volumen_cilindro;
    Button btn_cilindro_calcular;
    Button btn_cilindro_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        txt_radio_cilindro=findViewById(R.id.txt_cilindro_radio);
        txt_altura_cilindro=findViewById(R.id.txt_cilindro_altura);
        rb_area_cilindro=findViewById(R.id.rdio_area_cilindro);
        rb_volumen_cilindro=findViewById(R.id.rdio_volumen_cilindro);
        btn_cilindro_calcular=findViewById(R.id.btn_cilindro_calcular);
        btn_cilindro_limpiar=findViewById(R.id.btn_cilindro_limpiar);

        btn_cilindro_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_cilindro.this, result);

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
        //covertimos los valores a Double
        Double radio_cilindro_double, altura_cilindro_double;
        //creamos variable resultado a tipo cadena
        String resultado ="";
        if(txt_radio_cilindro.getText().toString().isEmpty() || txt_altura_cilindro.getText().toString().isEmpty()){
            Toast.makeText(this, "No puede estar vacio los valores", Toast.LENGTH_SHORT).show();
            radio_cilindro_double=0.0;
            altura_cilindro_double=0.0;
        }else{
            radio_cilindro_double=Double.parseDouble(txt_radio_cilindro.getText().toString());
            altura_cilindro_double=Double.parseDouble(txt_altura_cilindro.getText().toString());
        }

        if(rb_volumen_cilindro.isChecked()==false && rb_area_cilindro.isChecked()==false){
            return resultado="Seleccione una opcion";
        }

        //operamos con radioButton
        if(rb_area_cilindro.isChecked()==true){
            resultado = "El área de la superficie es: "+ CalcularArea(radio_cilindro_double,altura_cilindro_double);
        }if(rb_volumen_cilindro.isChecked()==true){
            resultado = resultado+"\nEl Volumen es: "+CalcularVolumen(radio_cilindro_double,altura_cilindro_double);
        }
        return resultado;
    }

    public String CalcularArea(Double radioC, Double alturaC){
        return String.valueOf(2*Math.PI*radioC*(radioC+alturaC));
    }

    public String CalcularVolumen(Double radioC, Double alturaC){
        return String.valueOf(Math.PI*Math.pow(radioC,2)*alturaC);
    }

    public void Limpiar(View view){
        txt_radio_cilindro.setText("");
        txt_altura_cilindro.setText("");
        rb_area_cilindro.setChecked(false);
        rb_volumen_cilindro.setChecked(false);
    }

}