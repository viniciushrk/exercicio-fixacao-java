package models;

import Services.ThreadService;
import static org.junit.Assert.*;
import org.testng.annotations.Test;

public class UsuarioTest
{
    @Test
    void testAnUserShouldBeCreateThread()
    {
        String conteudo = "Create teste";
        var user = new Admin("AdminTeste", "admin@gmail.com");
        var result = user.CriarThread(conteudo);

        assertNotNull(result);
        assertEquals(conteudo, result.conteudo);
        assertEquals(user.id, result.userId);
    }

    @Test
    void testAnUserShouldBeUpdateThread()
    {
        String conteudo = "Create teste";
        var user = new Admin("AdminTeste", "admin@gmail.com");
        var threadCreated = user.CriarThread(conteudo);

        String otherConteudo = "Edit teste ";
        user.EditarThread(threadCreated.id, otherConteudo);

        var threadResult =  ThreadService.getById(threadCreated.id);

        assertNotEquals(conteudo, threadResult.conteudo);
    }

    @Test
    void testAnUserShouldBeResponseAThread()
    {
        String conteudo = "Create teste";
        var user = new Admin("AdminTeste", "admin@gmail.com");
        var userClient = new Cliente("Cliente", "Cliente@gmail.com");
        var threadCreated = user.CriarThread(conteudo);

        userClient.ResponderThread(threadCreated.id, "Resposta Cliente");
        userClient.ResponderThread(threadCreated.id, "Resposta Cliente");

        var threadResult =  ThreadService.getById(threadCreated.id);

        assertEquals(2, threadResult.respostas.size());
    }

    @Test
    void testAnUserShouldBeDeleteThread()
    {
        String conteudo = "Create teste";
        var user = new Admin("AdminTeste", "admin@gmail.com");
        var thread = user.CriarThread(conteudo);

        user.ExcluirThread(thread.id);

        var threadResult =  ThreadService.getById(thread.id);

        assertNull(threadResult);
    }

    @Test
    void foo()
    {
        Usuario user = new Admin("AdminTeste", "admin@gmail.com");

        System.out.println(Admin.class.getName());
    }
}