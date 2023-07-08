package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

public class Activity_AreayPerimetro extends Activity_Opciones{
    Button btn_AP_circulo;
    Button btn_AP_cuadrado;
    Button btn_AP_hexagono;
    Button btn_AP_pentagono;
    Button btn_AP_rectangulo;
    Button btn_AP_trapecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areay_perimetro);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Cambio a la clase Activity_circulo
        btn_AP_circulo =findViewById(R.id.btn_AP_circulo);
        btn_AP_circulo.setOnClickListener(view ->{
            CambiarVentana(Activity_circulo.class);
        });
        //Cambio a la clase Activity_cuadrado
        btn_AP_cuadrado =findViewById(R.id.btn_AP_cuadrado);
        btn_AP_cuadrado.setOnClickListener(view ->{
            CambiarVentana(Activity_Cuadrado.class);
        });
        //Cambio a la clase Activity_hexagono
        btn_AP_hexagono =findViewById(R.id.btn_AP_hexagono);
        btn_AP_hexagono.setOnClickListener(view ->{
            CambiarVentana(Activity_Hexagono.class);
        });
        //Cambio a la clase Activity_pentagono
        btn_AP_pentagono =findViewById(R.id.btn_AP_pentagono);
        btn_AP_pentagono.setOnClickListener(view ->{
            CambiarVentana(Activity_pentagono.class);
        });
        //Cambio a la clase Activity_rectangulo
        btn_AP_rectangulo =findViewById(R.id.btn_AP_rectangulo);
        btn_AP_rectangulo.setOnClickListener(view ->{
            CambiarVentana(Activity_rectangulo.class);
        });
        //Cambio a la clase Activity_trapecio
        btn_AP_trapecio =findViewById(R.id.btn_AP_trapecio);
        btn_AP_trapecio.setOnClickListener(view ->{
            CambiarVentana(Activity_trapecio.class);
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

    public void CalcularArea(){}
    public void CalcularPerimetro(){}

}