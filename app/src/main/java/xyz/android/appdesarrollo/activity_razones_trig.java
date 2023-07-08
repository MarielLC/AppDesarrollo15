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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class activity_razones_trig extends AppCompatActivity {

    EditText ladoa, ladob, ladoc, anguloTriangulo;
    Spinner spinner1;
    Button btn_calcular_razonesTrigonometricas, btn_limpiar_razonesTrigonometricas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razones_trig);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ladoa= (EditText) findViewById(R.id.valorLadoA);
        ladob= (EditText) findViewById(R.id.valorLadoB);
        ladoc=(EditText) findViewById(R.id.valorLadoC);
        anguloTriangulo=(EditText) findViewById(R.id.txt_tringulorectangulo);
        btn_calcular_razonesTrigonometricas=(Button) findViewById(R.id.btn_trinagulo_rectangulo_calcular) ;
        btn_limpiar_razonesTrigonometricas=(Button) findViewById(R.id.btn_triangulo_rectangulo_limpiar);
        spinner1= (Spinner) findViewById(R.id.spinner);

        String [] opciones = {"Seno", "Coseno", "Tangente", "Cotangente", "Secante", "Cosecante","Pitagoras"};

        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinner1.setAdapter(adaptor);


        btn_calcular_razonesTrigonometricas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                showResultDialog(activity_razones_trig.this, result);
            }
        });

        //escuchar el evento spinner
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el elemento seleccionado del spinner
                String selectedOption = spinner1.getSelectedItem().toString();

                // Llamar a la función OcultarOpciones con el elemento seleccionado
                OcultarOpciones(selectedOption);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se seleccionó ningún elemento en el spinner
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

    public void OcultarOpciones(String opcion){
        switch (opcion){
            case "Seno":
                 ladoa.setVisibility(View.VISIBLE);
                 ladob.setVisibility(View.INVISIBLE);
                 ladoc.setVisibility(View.VISIBLE);
                 anguloTriangulo.setVisibility(View.VISIBLE);
                break;
            case "Coseno":
                ladoa.setVisibility(View.INVISIBLE);
                ladob.setVisibility(View.VISIBLE);
                ladoc.setVisibility(View.VISIBLE);
                anguloTriangulo.setVisibility(View.VISIBLE);

                break;
            case "Tangente":
                ladoa.setVisibility(View.VISIBLE);
                ladob.setVisibility(View.VISIBLE);
                ladoc.setVisibility(View.INVISIBLE);
                anguloTriangulo.setVisibility(View.VISIBLE);

                break;
            case "Cotangente":
                ladoa.setVisibility(View.VISIBLE);
                ladob.setVisibility(View.VISIBLE);
                ladoc.setVisibility(View.INVISIBLE);
                anguloTriangulo.setVisibility(View.VISIBLE);

                break;
            case "Secante":
                ladoa.setVisibility(View.INVISIBLE);
                ladob.setVisibility(View.VISIBLE);
                ladoc.setVisibility(View.VISIBLE);
                anguloTriangulo.setVisibility(View.VISIBLE);

                break;
            case "Cosecante":
                ladoa.setVisibility(View.VISIBLE);
                ladob.setVisibility(View.INVISIBLE);
                ladoc.setVisibility(View.VISIBLE);
                anguloTriangulo.setVisibility(View.VISIBLE);

                break;
            case "Pitagoras":
                ladoa.setVisibility(View.VISIBLE);
                ladob.setVisibility(View.VISIBLE);
                ladoc.setVisibility(View.VISIBLE);
                anguloTriangulo.setVisibility(View.INVISIBLE);

                break;
            default:
                break;

        }
    }

    public String calcular(){
        //obtenemos el valor de la seleccion del spinner
        String seleccion = spinner1.getSelectedItem().toString();
        String resultado="";

        Double ladoa_double,ladob_double,ladoc_double,anguloTriangulo_double;
        //convertir valores a double y control de errores cuando sea vacio
        if(ladoa.getText().toString().isEmpty()){
            ladoa_double=0.0;
        }else{
            ladoa_double=Double.parseDouble(ladoa.getText().toString());
        }

        if(ladob.getText().toString().isEmpty()){
            ladob_double=0.0;
        }else{
            ladob_double=Double.parseDouble(ladob.getText().toString());
        }

        if(ladoc.getText().toString().isEmpty()){
            ladoc_double=0.0;
        }else{
            ladoc_double= Double.parseDouble(ladoc.getText().toString());
        }

        if(anguloTriangulo.getText().toString().isEmpty()){
            anguloTriangulo_double=0.0;
        }else{
            anguloTriangulo_double= Double.parseDouble(anguloTriangulo.getText().toString());
        }

        //controol de error cuando los lados y angulos esten vacios
        if(ladoa_double==0.0 && ladob_double==0.0 && ladoc_double==0.0 && anguloTriangulo_double==0.0){
            return resultado="Los lados y el angulo estan vacios";
        }else {
            switch (seleccion) {
                case "Seno":
                    resultado = calcularSeno(ladoa_double, ladoc_double, anguloTriangulo_double);

                    break;
                case "Coseno":
                    resultado = calcularCoseno(ladob_double, ladoc_double, anguloTriangulo_double);

                    break;
                case "Tangente":
                    resultado = calcularTangente(ladoa_double, ladob_double, anguloTriangulo_double);
                    break;

                case "Cotangente":
                    resultado=calcularCotangente(ladoa_double, ladob_double, anguloTriangulo_double);
                    break;
                case "Secante":
                    resultado=calcularSecante(ladob_double, ladoc_double,anguloTriangulo_double);
                    break;
                case "Cosecante":
                    resultado=calcularCosecante(ladoa_double, ladoc_double, anguloTriangulo_double);
                    break;
                default:
                    Toast.makeText(this, "Opcion es incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
        return resultado;
    }

    public void Limpiar(View view){
        ladoa.setText("");
        ladob.setText("");
        ladoc.setText("");
        anguloTriangulo.setText("");
    }

    public String calcularSeno(Double ladoaSn, Double ladocSn, Double anguloTrianguloSn){
        if(ladoaSn==0.0 && ladocSn==0.0 && anguloTrianguloSn==0.0){
            return "Error casillas vacias";
        }

        if(ladoaSn==0.0 && ladocSn==0.0){
            return String.valueOf(Math.sin(Math.toRadians(anguloTrianguloSn)));
        }else if (ladoaSn!=0.0 && ladocSn!=0.0 && anguloTrianguloSn==0.0) {
            return String.valueOf(Math.toDegrees(Math.asin(Math.toRadians(ladoaSn / ladocSn))));
        }else if (ladoaSn==0.0) {
            return String.valueOf(Math.sin(Math.toRadians(anguloTrianguloSn))*ladocSn);
        } else if (ladocSn==0.0) {
            return String.valueOf(ladoaSn/(Math.toRadians(Math.toRadians(anguloTrianguloSn))));
        }else{
            return "Error";
        }
    }

    public String calcularCoseno(Double ladobCs, Double ladocCs, Double anguloTrianguloCs){
        if(ladobCs==null && ladocCs==null && anguloTrianguloCs==0.0){
            return "Error casillas vacias";
        }

        if(ladobCs==null && ladocCs==null){
            return String.valueOf(Math.cos(Math.toRadians(anguloTrianguloCs)));
        }else if (ladobCs!=0.0 && ladocCs!=0.0 && anguloTrianguloCs==0.0) {
            return String.valueOf(90-Math.toDegrees(Math.acos(Math.toRadians(ladobCs / ladocCs))));
        }else if (ladobCs==null) {
            return String.valueOf(Math.cos(Math.toRadians(anguloTrianguloCs))*ladocCs);
        } else if (ladocCs==null) {
            return String.valueOf(ladobCs/(Math.cos(Math.toRadians(anguloTrianguloCs))));
        }else{
            return "Error";
        }
    }

    public String calcularTangente(Double ladoaTg, Double ladobTg, Double anguloTrianguloTg) {

        if (ladoaTg == 0.0 && ladobTg == 0.0 && anguloTrianguloTg == 0.0) {
            return "error casillas vacias";
        }
        if (ladoaTg == 0.0 && ladobTg == 0.0) {
            return String.valueOf(Math.tan(Math.toRadians(anguloTrianguloTg)));
        } else if (ladoaTg != 0.0 && ladobTg != 0.0 && anguloTrianguloTg == 0.0) {
            return String.valueOf(Math.toDegrees(Math.atan(Math.toRadians(ladoaTg / ladobTg))));
        } else if (ladoaTg == 0.0) {
            return String.valueOf(ladobTg * Math.tan(Math.toRadians(anguloTrianguloTg)));
        } else if (ladobTg == 0.0) {
            return String.valueOf(ladoaTg / (Math.tan(Math.toRadians(anguloTrianguloTg))));
        } else {
            return "Error";
        }
    }
    public String calcularCotangente(Double ladoaCtg, Double ladobCtg, Double anguloTrianguloCtg){
        if(ladoaCtg==0.0 && ladobCtg==0.0 && anguloTrianguloCtg==0.0){
            return "Error casillas vacias";
        }
        if(ladoaCtg==0.0 && ladobCtg==0.0){
            return String.valueOf(1/Math.tan(Math.toRadians(anguloTrianguloCtg)));
        } else if (ladoaCtg!=0.0 && ladobCtg!=0.0 && anguloTrianguloCtg==0.0) {
            return String.valueOf(90-Math.toDegrees(Math.atan(Math.toRadians(ladoaCtg / ladobCtg))));
        } else if (ladoaCtg==0.0) {
            return String.valueOf(ladobCtg * Math.tan(Math.toRadians(anguloTrianguloCtg)));
        } else if (ladobCtg==0.0) {
            return String.valueOf(ladoaCtg / (Math.tan(Math.toRadians(anguloTrianguloCtg))));
        }else{
            return"Error";
        }
    }

    public String calcularSecante(Double ladobSec, Double ladocSec, Double anguloTrianguloSec){
        if(ladobSec==0.0 && ladocSec==0.0 && anguloTrianguloSec==0.0){
            return "Error casillas vacias";
        }
        if(ladobSec==0.0 && ladocSec==0.0){
            return String.valueOf(1/Math.cos(Math.toRadians(anguloTrianguloSec)));
        }else if (ladobSec!=0.0 && ladocSec!=0.0 && anguloTrianguloSec==0.0) {
            return String.valueOf(90-Math.toDegrees(Math.acos(Math.toRadians(ladobSec / ladocSec))));
        }else if (ladobSec==0.0) {
            return String.valueOf(Math.cos(Math.toRadians(anguloTrianguloSec))*ladocSec);
        } else if (ladocSec==0.0) {
            return String.valueOf(ladobSec/(Math.cos(Math.toRadians(anguloTrianguloSec))));
        }else{
            return "Error";
        }
    }

    public String calcularCosecante(Double ladoaCsc, Double ladocCsc, Double anguloTrianguloCsc){
        if(ladoaCsc==0.0 && ladocCsc==0.0 && anguloTrianguloCsc==0.0){
            return "Error casillas vacias";
        }

        if(ladoaCsc==0.0 && ladocCsc==0.0){
            return String.valueOf(1/Math.sin(Math.toRadians(anguloTrianguloCsc)));
        }else if (ladoaCsc!=0.0 && ladocCsc!=0.0 && anguloTrianguloCsc==0.0) {
            return String.valueOf(90-Math.toDegrees(Math.asin(Math.toRadians(ladoaCsc / ladocCsc))));
        }else if (ladoaCsc==0.0) {
            return String.valueOf(Math.sin(Math.toRadians(anguloTrianguloCsc))*ladocCsc);
        } else if (ladocCsc==0.0) {
            return String.valueOf(ladoaCsc/(Math.toRadians(Math.toRadians(anguloTrianguloCsc))));
        }else{
            return "Error";
        }

    }

}