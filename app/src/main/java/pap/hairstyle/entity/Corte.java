package pap.hairstyle.entity;

import java.io.Serializable;

/**
 * Created by Renan on 30/10/2016.
 */

public class Corte implements Serializable {
    private String preco;
    private String duracao;
    private String cortefoto;


    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String hora) {
        this.duracao = hora;
    }

    public String getCortefoto() {
        return cortefoto;
    }

    public void setCortefoto(String cortefoto) {
        this.cortefoto = cortefoto;
    }

}
