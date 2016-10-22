package pap.hairstyle.service;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import pap.hairstyle.entity.Cabelereiro;

/**
 * Created by Renan on 22/10/2016.
 */

public class CabelereiroService {

    public Cabelereiro getCabelereiro(){
        Cabelereiro ca = null;

        HttpURLConnection urlConnection = null;

        //String caminho = "http://192.168.0.14:8081/WsStyleHair/webresources/cliente/" + email + "/" + senha;
        String caminho = "http://mssdesigner.ddns.net:8022/WsStyleHair-1.0-SNAPSHOT/webresources/funcionario";
        try{
            URL url = new URL(caminho);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.useDelimiter("\\A").nextLine();

            Gson gson = new Gson();
            ca = gson.fromJson(conteudo,Cabelereiro.class);


        }catch (Exception e){
            throw new RuntimeException(e);

        }finally {
            urlConnection.disconnect();
        }

        return ca;
    }


}
