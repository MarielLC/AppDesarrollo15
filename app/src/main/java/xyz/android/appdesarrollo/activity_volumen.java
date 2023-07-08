package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

public class activity_volumen extends Activity_Opciones {

    Button btn_Vol_cubo;
    Button btn_Vol_cilindro;
    Button btn_Vol_rectangular;
    Button btn_Vol_esfera;
    Button btn_Vol_piramide;
    Button btn_Vol_cono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);
        //toolbar retroceder
        Toolbar toolbar = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Cambio a la clase Activity_cubo
        btn_Vol_cubo =findViewById(R.id.btn_Vol_cubo);
        btn_Vol_cubo.setOnClickListener(view ->{
            CambiarVentana(Activity_cubo.class);
        });
        //Cambio a la clase Activity_cilindro
        btn_Vol_cilindro =findViewById(R.id.btn_Vol_cilindro);
        btn_Vol_cilindro.setOnClickListener(view ->{
            CambiarVentana(Activity_cilindro.class);
        });
        //Cambio a la clase Activity_rectangular
        btn_Vol_rectangular =findViewById(R.id.btn_Vol_rectangular);
        btn_Vol_rectangular.setOnClickListener(view ->{
            CambiarVentana(Activity_triangular.class);
        });
        //Cambio a la clase Activity_esfera
        btn_Vol_esfera =findViewById(R.id.btn_Vol_esfera);
        btn_Vol_esfera.setOnClickListener(view ->{
            CambiarVentana(Activity_esfera.class);
        });
        //Cambio a la clase Activity_cubo
        btn_Vol_piramide =findViewById(R.id.btn_Vol_piramide);
        btn_Vol_piramide.setOnClickListener(view ->{
            CambiarVentana(Activity_piramide.class);
        });
        //Cambio a la clase Activity_cubo
        btn_Vol_cono =findViewById(R.id.btn_Vol_cono);
        btn_Vol_cono.setOnClickListener(view ->{
            CambiarVentana(Activity_cono.class);
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
}