package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Activity_rectangulo extends Activity_AreayPerimetro {

    EditText txt_rectangulo_base;
    EditText txt_rectangulo_altura;
    CheckBox cbox_area_rectangulo;
    CheckBox cbox_perimetro_rectangulo;
    Button btn_rectangulo_calcular;
    Button btn_rectangulo_limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt_rectangulo_base = findViewById(R.id.txt_rectangulo_base);
        txt_rectangulo_altura=findViewById(R.id.txt_rectangulo_altura);
        cbox_area_rectangulo=findViewById(R.id.cbox_area_rectangulo);
        cbox_perimetro_rectangulo = findViewById(R.id.cbox_perimetro_rectangulo);
        btn_rectangulo_calcular = findViewById(R.id.btn_rectangulo_calcular);
        btn_rectangulo_limpiar = findViewById(R.id.btn_rectangulo_limpiar);
        btn_rectangulo_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_rectangulo.this, result);
            }
        });
    }
    //toolbar
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
        //convertir a cadena objetos capturados
        //string a double- parseo
        Double valor1_double;
        Double valor2_double;
        if(txt_rectangulo_base.getText().toString().isEmpty() || txt_rectangulo_altura.getText().toString().isEmpty()){
            valor1_double=0.0;
            valor2_double=0.0;
        }else {
            valor1_double = Double.parseDouble(txt_rectangulo_base.getText().toString());
            valor2_double = Double.parseDouble(txt_rectangulo_altura.getText().toString());
        }
        //creamos variable resultado a tipo cadena
        String resultado ="";
        //operamos con checkbox
        if(cbox_area_rectangulo.isChecked()==false && cbox_perimetro_rectangulo.isChecked()==false){
            return resultado="Seleccione una opcion";
        }
        if(cbox_area_rectangulo.isChecked()==true){
            resultado = "El área es: "+ CalcularArea(valor1_double,valor2_double);
        }if(cbox_perimetro_rectangulo.isChecked()==true){
            resultado = resultado+"\nEl perímetro es: "+CalcularPerimetro(valor1_double,valor2_double);
        }
        return resultado;
    }

    public String CalcularArea(Double base, Double altura){
        super.CalcularArea();
        Double area = base*altura ;
        return area.toString();
    }
    public String CalcularPerimetro(Double base, Double altura) {
        super.CalcularPerimetro();
        Double perimetro=  2 *(base+altura);
        return  perimetro.toString();
    }
    public void Limpiar(View view){
        txt_rectangulo_base.setText("");
        txt_rectangulo_altura.setText("");
        cbox_area_rectangulo.setChecked(false);
        cbox_perimetro_rectangulo.setChecked(false);
    }
}