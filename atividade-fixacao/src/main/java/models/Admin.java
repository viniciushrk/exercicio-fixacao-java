package models;

import Services.ThreadService;

import java.util.UUID;

public class Admin extends Usuario
{
    public Admin(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
    }

    @Override
    public Thread CriarThread(String conteudo) {
        return ThreadService.create(this.id, conteudo);
    }

    @Override
    public void EditarThread(UUID threadId, String conteudo) {
        ThreadService.update(threadId, this.id, conteudo);
    }

    @Override
    public Thread ResponderThread(UUID threadId, String conteudo) {
        return ThreadService.responseThread(threadId, this.id, conteudo);
    }

    @Override
    public void ExcluirThread(UUID threadId) {
        ThreadService.delete(threadId, this.id);
    }

    public void FornecerAcesso() {
        System.out.println("Acesso fornecido Thread");
    }

}
