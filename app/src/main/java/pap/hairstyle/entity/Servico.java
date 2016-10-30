package pap.hairstyle.entity;

import java.util.Date;

/**
 * Created by vinicius on 30/10/16.
 */

public class Servico {

    private Long id;
    private String descricao;
    private double valor;



    private int tempoDuracao;

    private String camFoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(int tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public String getCamFoto() {
        return camFoto;
    }

    public void setCamFoto(String camFoto) {
        this.camFoto = camFoto;
    }
}
