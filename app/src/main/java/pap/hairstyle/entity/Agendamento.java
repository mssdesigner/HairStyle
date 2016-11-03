package pap.hairstyle.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vinicius on 30/10/16.
 */

public class Agendamento implements Serializable {
    private Long id;


    private double valorTotal;


    private Date dataHoraIni;

    private Date dataHoraFim;


    private char horaMarcada;


    private Cliente cliente;

    private Funcionario func;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataHoraIni() {
        return dataHoraIni;
    }

    public void setDataHoraIni(Date dataHoraIni) {
        this.dataHoraIni = dataHoraIni;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public char getHoraMarcada() {
        return horaMarcada;
    }

    public void setHoraMarcada(char horaMarcada) {
        this.horaMarcada = horaMarcada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }
}
