package com.example.user.appfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class RegistrarActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
    }

    public void onClickRegistrar(View view)
    {
        //Controles
        EditText etPaterno = (EditText) findViewById(R.id.etPaterno);
        EditText etMaterno = (EditText) findViewById(R.id.etMaterno);
        EditText etNombres = (EditText) findViewById(R.id.etNombres);
        EditText etDNI = (EditText) findViewById(R.id.etDNI);
        EditText etDireccion = (EditText) findViewById(R.id.etDireccion);
        EditText etTelefono = (EditText) findViewById(R.id.etTelefono);

        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        //Dato
        String paterno = etPaterno.getText().toString();
        String materno = etMaterno.getText().toString();
        String nombres = etNombres.getText().toString();
        String dni = etDNI.getText().toString();
        String direccion = etDireccion.getText().toString();
        String telefono = etTelefono.getText().toString();
        String ciudad = "trujillo";
        String email = ".com";

        try
        {
            //Lanzar consulta
            //Util.URL_APP +
            String url =  "RegistrarCliente.php?paterno=" + paterno +"&materno="+materno+"&nombres="+nombres+"&dni="+dni+"&ciudad="+ciudad+"&direccion="+direccion+"&telefono="+telefono+"&email="+email;
            String jsonResult = Util.execJsonGetRequest(url);

            //Procesar el resultado
            JSONObject object = new JSONObject(jsonResult);
            String estado = object.getString("estado");
            String msje = object.getString("message");
            if(estado.equals("0"))
            {
                throw new Exception(msje);
            }
            else
            {
                etPaterno.setText("");
                etMaterno.setText("");
                etNombres.setText("");
                etDNI.setText("");
                etDireccion.setText("");
                etTelefono.setText("");
                tvResultado.setText(msje);
            }
        }
        catch(Exception e)
        {
            tvResultado.setText("AQUI EL ERROR "+e.getMessage());
            //tvResultado.setText("AQUI"+cuenta+monto+usuario+clave);
        }
    }
    public void onCLickRetornar(View view)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
