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

public class Activity_Hexagono extends Activity_AreayPerimetro {

    EditText txt_hexagono_lado;
    CheckBox cbox_area_hexagono;
    CheckBox cbox_perimetro_hexagono;
    Button btn_hexagono_calcular;
    Button btn_hexagono_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexagono);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_hexagono_lado = findViewById(R.id.txt_hexagono_lado);
        cbox_area_hexagono=findViewById(R.id.cbox_area_hexagono);
        cbox_perimetro_hexagono=findViewById(R.id.cbox_perimetro_hexagono);
        btn_hexagono_calcular = findViewById(R.id.btn_hexagono_calcular);
        btn_hexagono_limpiar = findViewById(R.id.btn_hexagono_limpiar);
        btn_hexagono_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(Activity_Hexagono.this, result);
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
        if(txt_hexagono_lado.getText().toString().isEmpty()){
            valor1_double=0.0;
        }else{
            valor1_double=Double.parseDouble(txt_hexagono_lado.getText().toString());
        }


        //creamos variable resultado a tipo cadena
        String resultado ="";
        //operamos con checkbox
        if(cbox_area_hexagono.isChecked()==false && cbox_perimetro_hexagono.isChecked()==true){
            return resultado="Seleccione una opcion";
        }
        if(cbox_area_hexagono.isChecked()==true){
            resultado = "El área es: "+ CalcularArea(valor1_double);
        }if(cbox_perimetro_hexagono.isChecked()==true){
            resultado = resultado+"\nEl perímetro es: "+CalcularPerimetro(valor1_double);
        }
        return resultado;
    }

    public String CalcularArea(Double lado){
        super.CalcularArea();
        Double apotema=  lado/(2*(Math.tan(Math.toRadians(30))));
        Double area = (6*lado*apotema)/2 ;
        return area.toString();
    }
    public String CalcularPerimetro(Double lado) {
        super.CalcularPerimetro();
        Double perimetro=  6*lado;
        return  perimetro.toString();
    }
    public void Limpiar(View view){
        txt_hexagono_lado.setText("");
        cbox_area_hexagono.setChecked(false);
        cbox_perimetro_hexagono.setChecked(false);
    }

}