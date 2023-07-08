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

public class Activity_trapecio extends Activity_AreayPerimetro {

    EditText txt_trapecio_a;
    EditText txt_trapecio_b;
    EditText txt_trapecio_c;
    EditText txt_trapecio_d;
    CheckBox cbox_area_trapecio;
    CheckBox cbox_perimetro_trapecio;
    Button btn_trapecio_calcular;
    Button btn_trapecio_limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapecio);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_trapecio);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_trapecio_a= (EditText) findViewById(R.id.txt_trapecio_a);
        txt_trapecio_b=(EditText) findViewById(R.id.txt_trapecio_b);
        txt_trapecio_c=(EditText) findViewById(R.id.txt_trapecio_c);
        txt_trapecio_d=(EditText) findViewById(R.id.txt_trapecio_d);
        cbox_area_trapecio=(CheckBox) findViewById(R.id.cbox_area_trapecio);
        cbox_perimetro_trapecio=(CheckBox) findViewById(R.id.cbox_perimetro_trapecio);
        btn_trapecio_calcular=(Button) findViewById(R.id.btn_trapecio_calcular);
        btn_trapecio_limpiar=(Button) findViewById(R.id.btn_trapecio_limpiar);

        btn_trapecio_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_trapecio_a.getText().toString().isEmpty() || txt_trapecio_b.getText().toString().isEmpty() || txt_trapecio_c.getText().toString().isEmpty() || txt_trapecio_d.getText().toString().isEmpty() || (cbox_area_trapecio.isChecked()==false && cbox_perimetro_trapecio.isChecked()==false)){
                    Toast.makeText(Activity_trapecio.this, "No puede estar vacio los lados", Toast.LENGTH_SHORT).show();
                }else{
                    String result= calcular();
                    showResultDialog(Activity_trapecio.this, result);
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

        String lado_a_trapecio_string=txt_trapecio_a.getText().toString();
        String lado_b_trapecio_string=txt_trapecio_b.getText().toString();
        String lado_c_trapecio_string=txt_trapecio_c.getText().toString();
        String lado_d_trapecio_string=txt_trapecio_d.getText().toString();

        double lado_a_double=Double.parseDouble(lado_a_trapecio_string);
        double lado_b_double=Double.parseDouble(lado_b_trapecio_string);
        double lado_c_double=Double.parseDouble(lado_c_trapecio_string);
        double lado_d_double=Double.parseDouble(lado_d_trapecio_string);



        //creamos variable resultado a tipo cadena
        String resultado ="";

        //operamos con checkbox
        if(cbox_area_trapecio.isChecked()==false && cbox_perimetro_trapecio.isChecked()==false){
            return resultado="Seleccione una opcion";
        }

        if(cbox_area_trapecio.isChecked()==true){
            resultado = "El área es: "+ CalcularArea(lado_a_double,lado_b_double, lado_c_double, lado_d_double);
        }if(cbox_perimetro_trapecio.isChecked()==true){
            resultado = resultado+"\nEl perímetro es: "+CalcularPerimetro(lado_a_double,lado_b_double, lado_c_double, lado_d_double);
        }
        return resultado;
    }

    public String CalcularArea(double ladoa, double ladob, double ladoc, double ladod){
        super.CalcularArea();
        Double altura;
        if(ladob !=ladod) {
            altura = Math.sqrt(Math.pow(ladod, 2) - Math.pow(((Math.pow(ladoa - ladoc, 2) + Math.pow(ladod, 2) - Math.pow(ladob, 2)) / (2 * (ladoa - ladoc))), 2));
        }else {
            altura = Math.sqrt(Math.pow(ladod, 2) - Math.pow((ladoa - ladoc) / 2, 2));
        }
        Double area= ((ladoa+ladoc)/2)*altura ;
        return area.toString();
    }
    public String CalcularPerimetro(double ladoa, double ladob, double ladoc, double ladod) {
        super.CalcularPerimetro();
        Double perimetro=ladoa+ladob+ladoc+ladod;
        return  perimetro.toString();
    }

    public void Limpiar(View view){
        txt_trapecio_a.setText("");
        txt_trapecio_b.setText("");
        txt_trapecio_c.setText("");
        txt_trapecio_d.setText("");
        cbox_perimetro_trapecio.setChecked(false);
        cbox_area_trapecio.setChecked(false);
    }

}