package pap.hairstyle.entity;

import java.io.Serializable;

/**
 * Created by Renan on 25/10/2016.
 */

public class Funcionario implements Serializable
{

    private Long id;
    private String imagem;
    private String nome;
    private String email;
    private String senha;
    private String camFoto;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getCamFoto() {
        return camFoto;
    }

    public void setCamFoto(String camFoto) {
        this.camFoto = camFoto;
    }
}
