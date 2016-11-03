package pap.hairstyle.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pap.hairstyle.entity.Agendamento;


/**
 * Created by vinicius on 02/11/16.
 */

public class AgendamentoService {
    //private String caminho = "http://mssdesigner.ddns.net:8022/WsStyleHair-1.0-SNAPSHOT/webresources/agendamento/buscardata/";
    private String caminho = "http://mssdesigner.ddns.net:8022/WsStyleHair-1.0-SNAPSHOT/webresources/agendamento";
    //private  String caminho = "http://192.168.0.19:8081/WsStyleHair/webresources/agendamento/buscardata/" ;
    public List<Agendamento> getAgendamentosPorData(String data) {
        List<Agendamento> agend = new ArrayList();

        HttpURLConnection urlConnection = null;


        try {
            URL url = new URL(caminho+"/buscardata/"+data);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.useDelimiter("\\A").next();

            Gson gson = new Gson();
            agend = gson.fromJson(conteudo, new TypeToken<List<Agendamento>>() {
            }.getType());


        }catch (ConnectException ce) {
            System.out.printf("Passou pel cabelereiro connect Expception !!! ");


        }catch (Exception e){
            throw new RuntimeException(e);

        }finally {
            urlConnection.disconnect();
        }

        return agend;
    }

    public Agendamento post(Agendamento agend){


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
            String json = gson.toJson(agend);
            w.write(json);
            w.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.nextLine();


            agend = gson.fromJson(conteudo,Agendamento.class);
            in.close();




        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {

            urlConnection.disconnect();
        }
        return agend;
    }



}
