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
import android.widget.Toast;

public class Activity_pentagono extends Activity_AreayPerimetro {

    EditText ladoPentagono;
    Button btn_pentagono_calcular;
    Button btn_pentagono_limpiar;
    CheckBox cbox_area_pentagono;
    CheckBox cbox_perimetro_pentagono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pentagono);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_pentagono);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ladoPentagono= (EditText) findViewById(R.id.txt_pentagono_lado);
        btn_pentagono_calcular = (Button) findViewById(R.id.btn_pentagono_calcular);
        btn_pentagono_limpiar = (Button) findViewById(R.id.btn_pentagono_limpiar);
        cbox_area_pentagono= (CheckBox) findViewById(R.id.cbox_area_pentagono) ;
        cbox_perimetro_pentagono= (CheckBox) findViewById(R.id.cbox_perimetro_pentagono);

        btn_pentagono_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //control de errores cuando esta vacio, da mensaje de error
                if(ladoPentagono.getText().toString().isEmpty() || (cbox_area_pentagono.isChecked()==false && cbox_perimetro_pentagono.isChecked()==false )){
                    Toast.makeText(Activity_pentagono.this, "El valor del lado esta vacio", Toast.LENGTH_SHORT).show();
                } else if(Double.parseDouble(ladoPentagono.getText().toString())<0){
                    Toast.makeText(Activity_pentagono.this, "El valor del lado no puede ser negativo", Toast.LENGTH_SHORT).show();
                }else{
                    String result= calcular();
                    showResultDialog(Activity_pentagono.this, result);
                }
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

        Double lado_pentagono_double;
        if(ladoPentagono.getText().toString().isEmpty()){
            lado_pentagono_double=0.0;
        }else{
            lado_pentagono_double=Double.parseDouble(ladoPentagono.getText().toString());
        }


        //creamos variable resultado a tipo cadena
        String resultado ="";
        if(cbox_area_pentagono.isChecked()==false && cbox_perimetro_pentagono.isChecked()==false){
            return resultado="Seleccione una opcion";
        }

        if(cbox_area_pentagono.isChecked()==true){
            resultado = "El área es: "+ CalcularArea(lado_pentagono_double);
        }if(cbox_perimetro_pentagono.isChecked()==true){
            resultado = resultado+"\nEl perímetro es: "+CalcularPerimetro(lado_pentagono_double);
        }
        return resultado;

    }

    public String CalcularArea(Double lado){
        super.CalcularArea();
        Double apotema=  lado/(2*(Math.tan(Math.toRadians(36))));
        Double area = (5*lado*apotema)/2 ;
        return area.toString();
    }

    public String CalcularPerimetro(Double lado) {
        super.CalcularPerimetro();
        Double perimetro=  5*lado;
        return  perimetro.toString();
    }

    public void Limpiar(View view){
        ladoPentagono.setText("");
        cbox_area_pentagono.setChecked(false);
        cbox_perimetro_pentagono.setChecked(false);
    }

}