package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;
import android.widget.Toast;

public class operaciones_matrices extends AppCompatActivity {

    Spinner spinnerM;
    Button guardarM, calcularM, guardarTamaño;
    EditText tamañoN_matrizA, tamañoM_matrizA, tamañoN_matrizB, tamañoM_matrizB, datoM;
    TextView matrizAcompleta, matrizBcompleta, matrizResultado, matriz_informacion;
    TextView txt_texto_matrizA, txt_texto_matrizB,textView28;

    Double matrizA[][], matrizB [][];
    int numeroFilasA,numeroColumnasA,numeroFilasB,numeroColumnasB, i=0, j=0, k=0, l=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones_matrices);

        spinnerM=findViewById(R.id.spinner_matriz);
        guardarM=findViewById(R.id.btn_guardar_datoM);
        calcularM=findViewById(R.id.btn_calcular_matriz);
        guardarTamaño=findViewById(R.id.btn_guardar_tamaño_matriz);
        tamañoN_matrizA=findViewById(R.id.matrizA_tamañoN);
        tamañoM_matrizA=findViewById(R.id.matrizA_tamañoM);
        tamañoN_matrizB=findViewById(R.id.matrizB_tamañoN);
        tamañoM_matrizB=findViewById(R.id.matrizB_tamañoM);
        datoM=findViewById(R.id.txt_datoM);
        matriz_informacion=findViewById(R.id.txt_informacionMatriz);
        matrizAcompleta=findViewById(R.id.txt_matrizA_completo);
        matrizBcompleta=findViewById(R.id.txt_matrizB_completo);
        matrizResultado=findViewById(R.id.txt_matriz_resultado);
        txt_texto_matrizA=findViewById(R.id.txt_texto_matrizA);
        txt_texto_matrizB=findViewById(R.id.txt_texto_matrizB);
        textView28=findViewById(R.id.textView28);

        String [] opciones = {"suma", "resta", "multiplicacion", "division"};

        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinnerM.setAdapter(adaptor);

        //escuchar el evento spinner
        spinnerM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el elemento seleccionado del spinner
                String opcionSelecionada = spinnerM.getSelectedItem().toString();
                //llamamos al metodo para ocultar elemtos y modificar valores
                ocultarElementos(opcionSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se seleccionó ningún elemento en el spinner
            }
        });


        guardarTamaño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matrizA_tamañoN_string=tamañoN_matrizA.getText().toString();
                String matrizA_tamañoM_string=tamañoM_matrizA.getText().toString();
                String matrizB_tamañoN_string=tamañoN_matrizB.getText().toString();
                String matrizB_tamañoM_string=tamañoM_matrizB.getText().toString();

                if(matrizA_tamañoN_string.isEmpty() || matrizA_tamañoM_string.isEmpty() || (matrizA_tamañoN_string.isEmpty() && matrizA_tamañoM_string.isEmpty()) || (matrizA_tamañoN_string.isEmpty() && matrizA_tamañoM_string.isEmpty() && matrizB_tamañoN_string.isEmpty() && matrizB_tamañoM_string.isEmpty() )){
                    Toast.makeText(operaciones_matrices.this, "Ingrese el tamaño de la matriz", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(matrizB_tamañoM_string.isEmpty() && matrizB_tamañoN_string.isEmpty() && !matrizA_tamañoN_string.isEmpty() && !matrizA_tamañoM_string.isEmpty() ){
                    guardarTamañoMatriz(Integer.parseInt(matrizA_tamañoN_string),Integer.parseInt(matrizA_tamañoM_string), Integer.parseInt(matrizA_tamañoN_string),Integer.parseInt(matrizA_tamañoM_string));
                    Toast.makeText(operaciones_matrices.this, "Matrices creados", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!matrizA_tamañoN_string.isEmpty() && !matrizA_tamañoM_string.isEmpty() && !matrizB_tamañoN_string.isEmpty() && !matrizB_tamañoM_string.isEmpty()){
                    guardarTamañoMatriz(Integer.parseInt(matrizA_tamañoN_string),Integer.parseInt(matrizA_tamañoM_string), Integer.parseInt(matrizB_tamañoN_string),Integer.parseInt(matrizB_tamañoM_string));
                    Toast.makeText(operaciones_matrices.this, "Matrices creados", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        guardarM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //llenamos nuestras matrices con los datos

                if(i>numeroColumnasA && j>numeroFilasA && k>numeroColumnasB && l>numeroFilasB){
                    guardarM.setVisibility(View.INVISIBLE);
                    String prueba="";
                    for (int m = 0; m < matrizA[0].length; m++) {
                        for (int n = 0; n <matrizA.length ; n++) {
                            prueba+=" "+matrizA[m][n].toString();
                        }
                        prueba="\n"+prueba;
                    }
                    matrizAcompleta.setText(prueba);
                    return;
                }

                if(i<=numeroFilasA || j<=numeroColumnasA && (k==0 && l==0) ){
                    if(j<=numeroColumnasA){
                        matrizA[i][j]=Double.parseDouble(datoM.getText().toString());
                        Toast.makeText(operaciones_matrices.this, "ingresado"+i+" "+j, Toast.LENGTH_SHORT).show();
                        datoM.setText("");
                        j++;
                    }else{
                        i++;
                        j=0;
                    }
                }
                if(k<=numeroFilasB && l<=numeroColumnasB && i==numeroFilasA && j==numeroColumnasA){

                    if(l<=numeroColumnasB){
                        matrizB[k][l]=Double.parseDouble(datoM.getText().toString());
                        j++;
                    }else{
                        k++;
                        j=0;
                    }
                }

            }
        });

        calcularM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result= calcular();
                //showResultDialog(operaciones_matrices.this, result);
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

    //metodo de ocultar opciones
    public void ocultarElementos(String opcion){
        switch (opcion){
            case "suma":
            case "resta":
                txt_texto_matrizA.setText("Matriz");
                txt_texto_matrizB.setVisibility(View.INVISIBLE);
                tamañoM_matrizB.setVisibility(View.INVISIBLE);
                tamañoN_matrizB.setVisibility(View.INVISIBLE);
                break;
            case "multiplicacion":
                txt_texto_matrizA.setText("Matriz A");
                txt_texto_matrizB.setText("Matriz B");
                txt_texto_matrizB.setVisibility(View.VISIBLE);
                tamañoM_matrizB.setVisibility(View.VISIBLE);
                tamañoN_matrizB.setVisibility(View.VISIBLE);
                break;
            case "division":
                txt_texto_matrizA.setText("Matriz A");
                txt_texto_matrizB.setText("Matriz B");
                txt_texto_matrizB.setVisibility(View.VISIBLE);
                tamañoM_matrizB.setVisibility(View.VISIBLE);
                tamañoN_matrizB.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    //metodo para guardar el tamaño de matriz o matrices;
    public void guardarTamañoMatriz(int tamañoNA, int tamañoMA, int tamañoNB, int tamañoMB){
        matrizA=new Double[tamañoNA][tamañoMA];
        matrizB=new Double[tamañoNB][tamañoMB];
        matriz_informacion.setVisibility(View.VISIBLE);
        datoM.setVisibility(View.VISIBLE);
        guardarM.setVisibility(View.VISIBLE);
        numeroFilasA =tamañoNA-1;
        numeroColumnasA=tamañoMA-1;
        numeroFilasB =tamañoNB-1;
        numeroColumnasB=tamañoMB-1;
    }

    public String calcular(){
        String resultadoM="";
        String seleccion= spinnerM.getSelectedItem().toString();

        switch (seleccion){
            case "suma":

                break;
            case "resta":

                break;
            case "multiplicacion":

                break;
            case "division":

                break;
            default:
                break;

        }




        return resultadoM;
    }


}