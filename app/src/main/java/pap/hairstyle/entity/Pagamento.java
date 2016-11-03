package pap.hairstyle.entity;

import java.io.Serializable;

/**
 * Created by vinicius on 30/10/16.
 */

public class Pagamento  implements Serializable{

    private Long id;
    private String status;
    private String tipo;


    private Agendamento agendamento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
}
