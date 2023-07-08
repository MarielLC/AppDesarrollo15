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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity_triangular extends AppCompatActivity {

    EditText txt_altura_triangular, txt_ladoa_triangular, txt_ladob_triangular;
    RadioButton rb_area_triangular;
    RadioButton rb_volumen_triangular;
    Button btn_triangular_calcular;
    Button btn_triangular_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangular);

        txt_altura_triangular=findViewById(R.id.txt_prisma_rectangular_altura);
        txt_ladoa_triangular=findViewById(R.id.txt_prisma_rectangular_lado_a);
        txt_ladob_triangular=findViewById(R.id.txt_prisma_rectangular_lado_b);
        rb_area_triangular=findViewById(R.id.rdio_area_prisma_rectangular);
        rb_volumen_triangular=findViewById(R.id.rdio_volumen_prisma_rectangular);
        btn_triangular_calcular=findViewById(R.id.btn_prisma_rectangular_calcular);
        btn_triangular_limpiar=findViewById(R.id.btn_prisma_rectangular_limpiar);

        btn_triangular_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_triangular.this, result);

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
        Double altura_triangular_double, ladoa_triangular_double, ladob_triangular_double;
        //creamos variable resultado a tipo cadena
        String resultado ="";
        if(txt_altura_triangular.getText().toString().isEmpty() && txt_ladoa_triangular.getText().toString().isEmpty() && txt_ladob_triangular.getText().toString().isEmpty()){
            Toast.makeText(this, "No puede estar vacio los valores", Toast.LENGTH_SHORT).show();
            altura_triangular_double=0.0;
            ladoa_triangular_double=0.0;
            ladob_triangular_double=0.0;

        }else{
            altura_triangular_double=Double.parseDouble(txt_altura_triangular.getText().toString());
            ladoa_triangular_double=Double.parseDouble(txt_ladoa_triangular.getText().toString());
            ladob_triangular_double=Double.parseDouble(txt_ladob_triangular.getText().toString());
        }

        if(rb_area_triangular.isChecked()==false && rb_volumen_triangular.isChecked()==false){
            return resultado="Seleccione una opcion";
        }

        //operamos con radioButton
        if(rb_area_triangular.isChecked()==true){
            resultado = "El área de la superficie es: "+ CalcularArea(altura_triangular_double,ladoa_triangular_double,ladob_triangular_double);
        }
        if(rb_volumen_triangular.isChecked()==true){
            resultado = resultado+"\nEl Volumen es: "+CalcularVolumen(altura_triangular_double,ladoa_triangular_double,ladob_triangular_double);
        }
        return resultado;
    }

    public String CalcularArea(Double alturaTg, Double ladoaTg,Double ladobTg){
        Double ladocTg=Math.sqrt(Math.pow(ladoaTg,2)+Math.pow(ladobTg,2));
        return String.valueOf((ladoaTg+ladobTg+ladocTg)*alturaTg+2*((ladoaTg*ladobTg)/2));
    }

    public String CalcularVolumen(Double alturaTg, Double ladoaTg,Double ladobTg){
        return String.valueOf(((ladoaTg*ladobTg)/2)*alturaTg);
    }

    public void Limpiar(View view){
        txt_ladob_triangular.setText("");
        txt_ladoa_triangular.setText("");
        txt_altura_triangular.setText("");
        rb_volumen_triangular.setChecked(false);
        rb_area_triangular.setChecked(false);
    }


}