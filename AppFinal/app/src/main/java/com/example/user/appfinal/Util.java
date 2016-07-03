package com.example.user.appfinal;

/**
 * Created by USER on 03/07/2016.
 */
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Util {

    //(s4login)
    //public static String codigo_empleado="";
    //public static String nombre_empleado="";


    //public static final String URL_BASE="http://10.1.74.18:8086/ApiServices/service/";
    private Util()
    {
    }
    //url= ConsultarClientes.php?codigo=0001
    //url= ConsultarMovimientos.php?cuenta=00100001
    public static String execJsonGetRequest(String url) throws ClientProtocolException, IOException
    {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://192.168.1.33:8086/ApiProyecto/service/"+url);
        //HttpGet httpGet = new HttpGet(URL_BASE+url);
        //HttpGet httpGet = new HttpGet(TAG_URL+url);
        httpGet.setHeader("content-type","application/json");
        HttpResponse response = httpclient.execute(httpGet);
        String jsonResult = EntityUtils.toString(response.getEntity());
        return jsonResult;
    }
}
