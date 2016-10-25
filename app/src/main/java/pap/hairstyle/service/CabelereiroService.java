package pap.hairstyle.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pap.hairstyle.entity.Cabeleireiro;
import pap.hairstyle.entity.Funcionario;

/**
 * Created by Renan on 22/10/2016.
 */

public class CabelereiroService {

    public List<Funcionario> getCabelereiro(){
        List<Funcionario> cabs = new ArrayList();

        HttpURLConnection urlConnection = null;

        //String caminho = "http://192.168.0.14:8081/WsStyleHair/webresources/cliente/" + email + "/" + senha;
        String caminho = "http://mssdesigner.ddns.net:8022/WsStyleHair-1.0-SNAPSHOT/webresources/funcionario";
        try{
            URL url = new URL(caminho);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.useDelimiter("\\A").next();

            Gson gson = new Gson();
            cabs = gson.fromJson(conteudo,new TypeToken<List<Funcionario>>(){}.getType());


        }catch (Exception e){
            throw new RuntimeException(e);

        }finally {
            urlConnection.disconnect();
        }

        return cabs;
    }


}
