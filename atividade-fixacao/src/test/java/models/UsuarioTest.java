package models;

import Services.ThreadService;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsuarioTest
{
    protected Usuario admin;
    protected Usuario cliente;

    @BeforeMethod
    public void setUp() {
        System.out.println("setup");
        this.admin = new Admin("AdminTeste", "admin@gmail.com");
        this.cliente = new Cliente("AdminTeste", "admin@gmail.com");
    }

    @Test
    void testAnUserShouldBeCreateThread()
    {
        String conteudo = "Create teste";

        var result = this.admin.CriarThread(conteudo);

        assertNotNull(result);
        assertEquals(conteudo, result.getConteudo());
        assertEquals(this.admin.id, result.getUserId());
    }

    @Test
    void testAnUserShouldBeUpdateThread()
    {
        String conteudo = "Create teste";
        var threadCreated = this.admin.CriarThread(conteudo);

        String otherConteudo = "Edit teste ";
        this.admin.EditarThread(threadCreated.getId(), otherConteudo);

        var threadResult =  ThreadService.getById(threadCreated.getId());

        assertNotEquals(conteudo, threadResult.getConteudo());
    }

    @Test
    void testAnUserShouldBeResponseAThread()
    {
        String conteudo = "Create teste";
        var threadCreated = this.admin.CriarThread(conteudo);

        this.cliente.ResponderThread(threadCreated.getId(), "Resposta Cliente");
        this.cliente.ResponderThread(threadCreated.getId(), "Resposta Cliente");

        var threadResult =  ThreadService.getById(threadCreated.getId());

        assertEquals(2, threadResult.getRespostas().size());
    }

    @Test
    void testAnUserShouldBeDeleteThread()
    {
        String conteudo = "Create teste";
        var thread = this.admin.CriarThread(conteudo);

        this.admin.ExcluirThread(thread.getId());

        var threadResult =  ThreadService.getById(thread.getId());

        assertNull(threadResult);
    }
}

