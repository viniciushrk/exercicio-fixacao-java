package interfaces;

import models.Thread;

import java.util.UUID;

public interface IThreadService {
    Thread CriarThread(String conteudo);
    void EditarThread(UUID threadId, String conteudo);
    Thread ResponderThread(UUID threadId, String conteudo) ;
    void ExcluirThread(UUID threadId);
}
