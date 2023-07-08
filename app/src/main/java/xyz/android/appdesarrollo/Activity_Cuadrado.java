package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Activity_Cuadrado extends Activity_AreayPerimetro {

    EditText txt_cuadrado_lado;
    CheckBox cbox_area_cuadrado;
    CheckBox cbox_perimetro_cuadrado;
    Button btn_cuadrado_calcular;
    Button btn_cuadrado_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //cuadrado
        txt_cuadrado_lado = findViewById(R.id.txt_cuadrado_lado);
        cbox_area_cuadrado=findViewById(R.id.cbox_area_cuadrado);
        cbox_perimetro_cuadrado=findViewById(R.id.cbox_perimetro_cuadrado);
        btn_cuadrado_calcular = findViewById(R.id.btn_cuadrado_calcular);
        btn_cuadrado_limpiar = findViewById(R.id.btn_cuadrado_limpiar);
        btn_cuadrado_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_Cuadrado.this, result);

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

    public String calcular(){
        //convertir a cadena objetos capturados
        //string a double- parseo
        Double valor1_double;
        if(txt_cuadrado_lado.getText().toString().isEmpty()){
            valor1_double=0.0;
        }else{
            valor1_double=Double.parseDouble(txt_cuadrado_lado.getText().toString());
        }


        //creamos variable resultado a tipo cadena
        String resultado ="";
        //operamos con checkbox
        if(cbox_area_cuadrado.isChecked()==false && cbox_perimetro_cuadrado.isChecked()==false){
            return resultado="Seleccione una opcion";
        }
        if(cbox_area_cuadrado.isChecked()==true){
            resultado = "El área es: "+ CalcularArea(valor1_double);
        }if(cbox_perimetro_cuadrado.isChecked()==true){
            resultado = resultado+"\nEl perímetro es: "+CalcularPerimetro(valor1_double);
        }
        return resultado;
    }
    //herencia de métodos de la clase padre Activity_AreayPerimetros
    public String CalcularArea(Double lado){
        super.CalcularArea();
        Double area= Math.pow(lado,2) ;
        return area.toString();
    }

    public String CalcularPerimetro(Double lado) {
        super.CalcularPerimetro();
        Double perimetro=  4*lado;
        return  perimetro.toString();

    }
    public void Limpiar(View view){
        txt_cuadrado_lado.setText("");
        cbox_area_cuadrado.setChecked(false);
        cbox_perimetro_cuadrado.setChecked(false);
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

}