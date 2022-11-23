package models;

import interfaces.IThreadService;

import java.util.UUID;

public abstract class Usuario implements IThreadService {
    protected UUID id;
    protected String nomeUsr;
    protected String nome;
    protected String email;
    protected boolean isAtivo = true;

    public UUID getId() {
        return id;
    }

    protected void setId(UUID id) {
        this.id = id;
    }

    public String getNomeUsr() {
        return nomeUsr;
    }

    public void setNomeUsr(String nomeUsr) {
        this.nomeUsr = nomeUsr;
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

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }
}
