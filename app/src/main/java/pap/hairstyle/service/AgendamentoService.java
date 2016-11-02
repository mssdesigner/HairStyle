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

import pap.hairstyle.entity.Agendamento;
import pap.hairstyle.entity.Funcionario;

/**
 * Created by vinicius on 02/11/16.
 */

public class AgendamentoService {
    private String caminho = "http://mssdesigner.ddns.net:8022/WsStyleHair-1.0-SNAPSHOT/webresources/agendamento/buscardata/";
    //private  String caminho = "http://192.168.0.19:8081/WsStyleHair/webresources/agendamento/buscardata/" ;
    public List<Agendamento> getAgendamentosPorData(String data) {
        List<Agendamento> agend = new ArrayList();

        HttpURLConnection urlConnection = null;


        try {
            URL url = new URL(caminho+data);
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
}
