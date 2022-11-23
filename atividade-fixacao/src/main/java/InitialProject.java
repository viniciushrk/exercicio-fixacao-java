import Services.ThreadFakeDb;
import Services.ThreadService;
import models.Admin;
import models.Cliente;
import models.Thread;
import models.Usuario;

public class InitialProject {
    public static void main(String[] args) {
        Usuario usuarioAdmin = new Admin("jorge", "jorgearrombado@gmail.com");
        Usuario usuarioCliente = new Cliente("jorge", "jorgearrombado@gmail.com");

        System.out.println("cliente: " + usuarioCliente.getId());
        System.out.println("admin: " + usuarioAdmin.getId());

        var threadCliente =  usuarioCliente.CriarThread("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a ty");
        var threadAdmin = usuarioAdmin.CriarThread("teste post");

        printThread();

        usuarioCliente.EditarThread(threadCliente.id, "Teste editar");
        usuarioAdmin.EditarThread(threadAdmin.id, "Teste editar admin");

        printThread();

        usuarioAdmin.ResponderThread(threadCliente.id, "falou merda");
        usuarioAdmin.ResponderThread(threadCliente.id, "falou muuuuita  merda");

        printThread();

        var threadWithAnswers = ThreadService.getById(threadCliente.id);

        System.out.println(threadWithAnswers.getRespostas());

    }

    private static void printThread(){
        for (Thread thread: ThreadFakeDb.threadList) {
            System.out.print("item da thread: " + thread.conteudo);
            System.out.println(" criado por: " + thread.userId);
        }
    }
}
