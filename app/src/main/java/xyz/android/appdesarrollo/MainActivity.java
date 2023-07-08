package xyz.android.appdesarrollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_m;
    Button btn_ir_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_m =findViewById(R.id.btn_main);
        btn_ir_registrar =findViewById(R.id.btn_ir_registrar);



        btn_m.setOnClickListener(view ->{
            irOpciones();
        });
        btn_ir_registrar.setOnClickListener(view ->{
            irRegistrar();
        });

    }
    public void irOpciones(){
        Intent i = new Intent(this, Activity_Opciones.class);
        startActivity(i);
    }
    public void irRegistrar(){
        Intent i = new Intent(this, Activity_registrarse.class);
        startActivity(i);
    }



}