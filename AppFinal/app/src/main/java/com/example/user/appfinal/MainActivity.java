package com.example.user.appfinal;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Si se trata de Android Version 3 o superior
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            System.out.println("*** My thread is now configured to allow connection");
        }
    }

    public void onClickRegistrar(View view)
    {
        //Intent intent = new Intent(getApplicationContext(),RegistrarActivity.class);
        //startActivity(intent);
        this.finish();
    }

    public void onClickConsultar(View view)
    {
        //Intent intent = new Intent(getApplicationContext(),ConsultarActivity.class);
        //startActivity(intent);
        this.finish();
    }

    public void onClickSalir(View view)
    {
        //Util.nombre_empleado="";
        //Util.codigo_empleado="";
        this.finish();
    }
}