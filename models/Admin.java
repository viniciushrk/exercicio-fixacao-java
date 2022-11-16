package models;

public class Admin extends Usuario
{
    @Override
    public void CriarThread() {
        System.out.println("Criando Thread");
    }

    @Override
    public void EditarThread() {
        System.out.println("Editando Thread");
    }

    @Override
    public void ResponderThread() {
        System.out.println("Respondido Thread");
    }

    @Override
    public void ExcluirThread() {
        System.out.println("Excluido Thread");
    }

    public void FornecerAcesso() {
        System.out.println("Acesso fornecido Thread");
    }

}
