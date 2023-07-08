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

public class Activity_piramide extends AppCompatActivity {

    EditText txt_piramide_altura, txt_piramide_lado;
    RadioButton rb_area_piramide;
    RadioButton rb_volumen_piramide;
    Button btn_piramide_calcular;
    Button btn_piramide_limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piramide);

        txt_piramide_altura=findViewById(R.id.txt_piramide_altura);
        txt_piramide_lado=findViewById(R.id.txt_piramide_lado);
        rb_area_piramide=findViewById(R.id.rdio_area_piramide);
        rb_volumen_piramide=findViewById(R.id.rdio_volumen_piramide);
        btn_piramide_calcular=findViewById(R.id.btn_piramide_calcular);
        btn_piramide_limpiar=findViewById(R.id.btn_piramide_limpiar);

        btn_piramide_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_piramide.this, result);
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
        Double lado_piramide_double, altura_piramide_double;

        if(txt_piramide_lado.getText().toString().isEmpty() || txt_piramide_altura.getText().toString().isEmpty()){
            lado_piramide_double=0.0;
            altura_piramide_double=0.0;
        }else{
            lado_piramide_double=Double.parseDouble(txt_piramide_lado.getText().toString());
            altura_piramide_double=Double.parseDouble(txt_piramide_altura.getText().toString());
        }

        //creamos variable resultado a tipo cadena
        String resultado ="";
        //operamos con radioButton
        if(rb_area_piramide.isChecked()==false && rb_volumen_piramide.isChecked()==false){
            return resultado="Seleccione una opcion";
        }
        if(rb_area_piramide.isChecked()==true){
            resultado = "El área de la superficie es: "+ CalcularArea(lado_piramide_double, altura_piramide_double);
        }if(rb_volumen_piramide.isChecked()==true){
            resultado = resultado+"\nEl volumen es: "+CalcularVolumen(lado_piramide_double,altura_piramide_double);
        }
        return resultado;

    }

    public String CalcularArea(Double ladoPm, Double alturaPm){
        //calculamos la altura x
        double altura = (ladoPm * Math.sqrt(3)) / 2;

        return String.valueOf(Math.pow(ladoPm,2)+2*ladoPm*altura);
    }
    public String CalcularVolumen(Double ladoPm, Double alturaPm){
        return String.valueOf((1/3)*Math.pow(ladoPm,2)*alturaPm);
    }

    public void Limpiar(View view){
        txt_piramide_altura.setText("");
        txt_piramide_lado.setText("");
        rb_volumen_piramide.setChecked(false);
        rb_area_piramide.setChecked(false);
    }




}