package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Thread {
    public UUID id;
    public String conteudo;
    public UUID userId;
    public UUID threadIdPrincipal;
    public List<Thread> respostas = new ArrayList<Thread>();

    public Thread(String conteudo, UUID userId) {
        this.id = UUID.randomUUID();
        this.conteudo = conteudo;
        this.userId = userId;
    }

    public Thread(String conteudo, UUID userId, UUID threadIdPrincipal) {
        this.id = UUID.randomUUID();
        this.conteudo = conteudo;
        this.userId = userId;
        this.threadIdPrincipal = threadIdPrincipal;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<Thread> getRespostas() {
        return respostas;
    }

    public void setRespostas(Thread resposta) {
        this.respostas.add(resposta) ;
    }

    public UUID getThreadIdPrincipal() {
        return threadIdPrincipal;
    }

    public void setThreadIdPrincipal(UUID threadIdPrincipal) {
        this.threadIdPrincipal = threadIdPrincipal;
    }
}
