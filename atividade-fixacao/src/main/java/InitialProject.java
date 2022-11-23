import Services.ThreadFakeDb;
import Services.ThreadService;
import models.Admin;
import models.Cliente;
import models.Thread;
import models.Usuario;

public class InitialProject {
    public static void main(String[] args) {
        Usuario usuarioAdmin = new Admin("jorge", "jorge@gmail.com");
        Usuario usuarioCliente = new Cliente("lucas", "lucas@gmail.com");

        System.out.println("cliente: " + usuarioCliente.getId());
        System.out.println("admin: " + usuarioAdmin.getId());

        var threadCliente =  usuarioCliente.CriarThread("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a ty");
        var threadAdmin = usuarioAdmin.CriarThread("teste post");

        printThread();

        usuarioCliente.EditarThread(threadCliente.getId(), "Teste editar");
        usuarioAdmin.EditarThread(threadAdmin.getId(), "Teste editar admin");

        printThread();

        usuarioAdmin.ResponderThread(threadCliente.getId(), "falou merda");
        usuarioAdmin.ResponderThread(threadCliente.getId(), "falou muuuuita  merda");

        printThread();

        var threadWithAnswers = ThreadService.getById(threadCliente.getId());

        System.out.println(threadWithAnswers.getRespostas());

    }

    private static void printThread(){
        for (Thread thread: ThreadFakeDb.threadList) {
            System.out.print("item da thread: " + thread.getConteudo());
            System.out.println(" criado por: " + thread.getUserId());
        }
    }
}
