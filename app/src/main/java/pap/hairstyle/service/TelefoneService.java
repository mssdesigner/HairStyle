package pap.hairstyle.service;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import pap.hairstyle.entity.Telefone;

/**
 * Created by Renan on 18/10/2016.
 */

public class TelefoneService {

    public Telefone post(Telefone telefone){
        String caminho = "http://192.168.0.14:8081/WsStyleHair/webresources/telefone";
        //String caminho = "http://mssdesigner.ddns.net:8022/WsStyleHair-1.0-SNAPSHOT/webresources/telefone";

        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(caminho);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setRequestProperty("Accept","application/json");

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            Writer w = new BufferedWriter(new OutputStreamWriter(out));

            Gson gson = new Gson();
            String json = gson.toJson(telefone);
            w.write(json);
            w.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.nextLine();

            telefone = gson.fromJson(conteudo,Telefone.class);
            in.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {

            urlConnection.disconnect();
        }
        return telefone;
    }

}
