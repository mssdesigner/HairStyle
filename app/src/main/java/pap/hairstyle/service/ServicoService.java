package pap.hairstyle.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pap.hairstyle.entity.Servico;

/**
 * Created by Renan on 01/11/2016.
 */

public class ServicoService {

    private String caminho = "http://mssdesigner.ddns.net:8022/WsStyleHair-1.0-SNAPSHOT/webresources/servico";


    public List<Servico> getServicos() {
        List<Servico> serv = new ArrayList();

        HttpURLConnection urlConnection = null;


        try {
            URL url = new URL(caminho);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.useDelimiter("\\A").next();

            Gson gson = new Gson();
            serv = gson.fromJson(conteudo, new TypeToken<List<Servico>>() {
            }.getType());


        }catch (ConnectException ce) {
            System.out.printf("Passou pel cabelereiro connect Expception !!! ");


        }catch (Exception e){
            throw new RuntimeException(e);

        }finally {
            urlConnection.disconnect();
        }

        return serv;
    }


}