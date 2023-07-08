package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Activity_circulo extends Activity_AreayPerimetro{

    EditText txt_circulo_radio;
    CheckBox cbox_area_circulo;
    CheckBox cbox_perimetro_circulo;
    Button btn_circulo_calcular;
    Button btn_circulo_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_circulo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //circulo
        txt_circulo_radio = findViewById(R.id.txt_circulo_radio);
        cbox_area_circulo=findViewById(R.id.cbox_area_circulo);
        cbox_perimetro_circulo=findViewById(R.id.cbox_perimetro_circulo);
        btn_circulo_calcular = findViewById(R.id.btn_circulo_calcular);
        btn_circulo_limpiar = findViewById(R.id.btn_circulo_limpiar);
        btn_circulo_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String result= calcular();
               showResultDialog(Activity_circulo.this, result);

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
        Double valor1_double;
        if(txt_circulo_radio.getText().toString().isEmpty()){
            valor1_double=0.0;
        }else{
            valor1_double=Double.parseDouble(txt_circulo_radio.getText().toString());
        }

        //creamos variable resultado a tipo cadena
        String resultado ="";
        //operamos con checkbox

        if(cbox_area_circulo.isChecked()==false && cbox_perimetro_circulo.isChecked()==false){
            return resultado="Seleccione una opcion";
        }
        if(cbox_area_circulo.isChecked()==true){
            resultado = "El área es: "+ CalcularArea(valor1_double);
        }
        if(cbox_perimetro_circulo.isChecked()==true){
            resultado = resultado+"\nEl perímetro es: "+CalcularPerimetro(valor1_double);
        }
        return resultado;
    }
    //herencia de métodos de la clase padre Activity_AreayPerimetros
    public String CalcularArea(Double radio){
        super.CalcularArea();
        Double area=  Math.PI * Math.pow(radio,2) ;
        return area.toString();
    }

    public String CalcularPerimetro(Double radio) {
        super.CalcularPerimetro();
        Double perimetro=  2*Math.PI* radio;
        return  perimetro.toString();

    }
    public void Limpiar(View view){

        txt_circulo_radio.setText("");
        cbox_area_circulo.setChecked(false);
        cbox_perimetro_circulo.setChecked(false);
    }

}