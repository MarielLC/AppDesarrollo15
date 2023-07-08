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

public class Activity_esfera extends AppCompatActivity {

    EditText txt_esfera_radio;
    RadioButton rb_area_esfera;
    RadioButton rb_volumen_esfera;
    Button btn_esfera_calcular;
    Button btn_esfera_limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        //esfera
        txt_esfera_radio = findViewById(R.id.txt_prisma_esfera_radio);
        rb_area_esfera=findViewById(R.id.rdio_area_esfera);
        rb_volumen_esfera=findViewById(R.id.rdio_volumen_esfera);
        btn_esfera_calcular = findViewById(R.id.btn_esfera_calcular);
        btn_esfera_limpiar = findViewById(R.id.btn_esfera_limpiar);

        btn_esfera_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_esfera.this, result);


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
        Double radio_esfera_double;
        if(txt_esfera_radio.getText().toString().isEmpty()){
            radio_esfera_double=0.0;
        }else{
            radio_esfera_double=Double.parseDouble(txt_esfera_radio.getText().toString());
        }

        //creamos variable resultado a tipo cadena
        String resultado ="";
        //operamos con Radiobutton
        if(rb_area_esfera.isChecked()==false && rb_volumen_esfera.isChecked()==false){
            return resultado="Seleccione una opcion";
        }

        if(rb_area_esfera.isChecked()==true){
            resultado = "El área de la superficie es: "+ CalcularArea(radio_esfera_double);
        }if(rb_volumen_esfera.isChecked()==true){
            resultado = resultado+"\nEl volumen es: "+CalcularVolumen(radio_esfera_double);
        }
        return resultado;
    }

    public String CalcularArea(Double radioE){
        return String.valueOf(4*Math.PI*Math.pow(radioE,2));
    }

    public String CalcularVolumen(Double radioE){
        return String.valueOf((4/3)*Math.PI*Math.pow(radioE,3));
    }

    public void Limpiar(View view){
        txt_esfera_radio.setText("");
        rb_volumen_esfera.setChecked(false);
        rb_area_esfera.setChecked(false);
    }



}