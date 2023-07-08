package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_registrarse extends AppCompatActivity {
    TextView txt_nombre_reg, txt_correo_reg, txt_contraseña_reg;
    Button btn_registrarse;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView irALogin;

    //verificar si el usuario ya accedio
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent  i=new Intent(getApplicationContext(), Activity_Opciones.class);
            startActivity(i);
            finish();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        mAuth=FirebaseAuth.getInstance();
        txt_nombre_reg =findViewById(R.id.txt_nombres);
        txt_correo_reg=findViewById(R.id.txt_correo_registrarse);
        txt_contraseña_reg=findViewById(R.id.txt_contrasena_registrarse);
        btn_registrarse=findViewById(R.id.btn_registrarse);
        progressBar=findViewById(R.id.progressBar);
        irALogin=findViewById(R.id.txt_reg_logearse);

        irALogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irLogear();
            }
        });

        btn_registrarse.setOnClickListener(view ->{
            //irLogear();
            progressBar.setVisibility(View.VISIBLE);
            String nombre, email, contraseña;
            nombre=txt_nombre_reg.getText().toString();
            email=txt_correo_reg.getText().toString();
            contraseña=txt_contraseña_reg.getText().toString();

            if(TextUtils.isEmpty(nombre)){
                Toast.makeText(this, "Ingrese un nombre", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this, "Ingrese un email", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(contraseña)) {
                Toast.makeText(this, "Ingrese un contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, contraseña)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();

                                Toast.makeText(Activity_registrarse.this, "Cuenta creada", Toast.LENGTH_SHORT).show();
                                Intent  i=new Intent(getApplicationContext(), Activity_Opciones.class);
                                startActivity(i);
                                finish();

                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(Activity_registrarse.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        });
    }

    public void irLogear(){
        Intent i = new Intent(this, Activity_login.class);
        startActivity(i);
        finish();
    }
}