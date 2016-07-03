package com.example.user.appfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class ConsultarActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
    }

    public void onClickConsultar(View view)
    {
        // Controles
        EditText etdni = (EditText) findViewById(R.id.et_dni);
        TextView tvResultado = (TextView) findViewById(R.id.tv_resultado);
        try {
            // Dato
            String dni = etdni.getText().toString();
            // Lanzar consulta
            String url = "ConsultarCliente.php?dni=" + dni;
            String jsonResult = Util.execJsonGetRequest(url);
            // Procesar el resultado
            JSONObject object = new JSONObject(jsonResult);
            String estado = object.getString("estado");
            if (estado.equals("0"))
            {
                throw new Exception("Dato incorrecto.");
            }
            String resultado = "Código: " + object.getString("chr_cliecodigo")
                    + "\nPaterno: " + object.getString("vch_cliepaterno")
                    + "\nMaterno: " + object.getString("vch_cliematerno")
                    + "\nNombres: " + object.getString("vch_clienombre")
                    + "\nDNI: " + object.getString("chr_cliedni")
                    + "\nCiudad: " + object.getString("vch_clieciudad")
                    + "\nDirección: " + object.getString("vch_cliedireccion")
                    + "\nTeléfono: " + object.getString("vch_clietelefono")
                    + "\nEMail: " + object.getString("vch_clieemail");
            tvResultado.setText(resultado);
        } catch (Exception e)
        {
            tvResultado.setText(e.getMessage());
        }
    }

    public void onClickRetornar(View view)
    {
        // TODO
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}