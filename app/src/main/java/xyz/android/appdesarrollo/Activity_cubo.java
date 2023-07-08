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

public class Activity_cubo extends AppCompatActivity {

    EditText lado_cubo;
    RadioButton rb_area_cubo;
    RadioButton rb_volumen_cubo;
    Button btn_cubo_calcular;
    Button btn_cubo_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        lado_cubo= findViewById(R.id.txt_cubo_lado);
        rb_area_cubo=findViewById(R.id.rdio_area_cubo);
        rb_volumen_cubo=findViewById(R.id.rdio_volumen_cubo);
        btn_cubo_calcular=findViewById(R.id.btn_cubo_calcular);
        btn_cubo_limpiar=findViewById(R.id.btn_cubo_limpiar);

        btn_cubo_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_cubo.this, result);


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
        //covertir a double el valor de lado
        Double ladoCuboDouble;
        if(lado_cubo.getText().toString().isEmpty()){
            ladoCuboDouble=0.0;
        }else{
            ladoCuboDouble=Double.parseDouble(lado_cubo.getText().toString());
        }
        //creamos variable resultado a tipo cadena
        String resultado ="";
        //operamos con checkbox
        if(rb_area_cubo.isChecked()==false && rb_volumen_cubo.isChecked()==false){
            return resultado="Seleccione una opcion";
        }
        if (rb_area_cubo.isChecked()==true) {
            resultado = "El área es: "+ CalcularArea(ladoCuboDouble);
        }
        if(rb_volumen_cubo.isChecked()==true) {
            resultado = resultado + "\nEl Volumen es: " + CalcularVolumen(ladoCuboDouble);
        }
        return resultado;
    }

    public String CalcularArea(Double ladoCuboD){
        return String.valueOf(6*Math.pow(ladoCuboD,2));
    }

    public String CalcularVolumen(Double ladoCuboD){
        return String.valueOf(Math.pow(ladoCuboD,3));
    }
    public void Limpiar(View view){
        lado_cubo.setText("");
        rb_volumen_cubo.setChecked(false);
        rb_area_cubo.setChecked(false);
    }


}