package Services;

import models.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ThreadService {

    public static Thread create(UUID userId, String conteudo)
    {
        var novaThread = new Thread(conteudo, userId);
        ThreadFakeDb.threadList.add(novaThread);
        System.out.println("Thread criada.");
        return novaThread;
    }

    public static Thread responseThread(UUID threadId, UUID userId, String conteudo)
    {
        var getThread = ThreadService.getById(threadId);

        if(getThread == null) {
            System.out.println("Thread not found");
            return null;
        }
        var respostaThread = new Thread(conteudo, userId, threadId);
        ThreadFakeDb.threadList.add(respostaThread);

        getThread.setRespostas(respostaThread);
        updateObj(getThread);

        System.out.println("Thread respondida.");
        return respostaThread;
    }

    public static void updateObj(Thread thread)
    {
        ThreadFakeDb.threadList.remove(thread);
        ThreadFakeDb.threadList.add(thread);
        System.out.println("Objeto atualizado.");
    }

    public static void update(UUID threadId, UUID userId ,  String conteudo)
    {
        var getThread = ThreadService.getById(threadId);
        ThreadFakeDb.threadList.remove(getThread);

        if(getThread.userId != userId) {
            System.out.println("Thread not update, because user does not is responsibility.");
            return;
        }

        getThread.setConteudo(conteudo);
        ThreadFakeDb.threadList.add(getThread);

        System.out.println("Thread update.");
    }

    public static void delete(UUID threadId,  UUID userId) {
        var getThread = getById(threadId);

        if (getThread.userId != userId) {
            System.out.println("Thread not delete, because user does not is responsibility.");
            return;
        }

        ThreadFakeDb.threadList.remove(getThread);
        System.out.println("Thread deletada.");
    }

    public static Thread getById(UUID threadId)
    {
        Thread threadSeach = null; 

        int index = 0;
        for (Thread thread: ThreadFakeDb.threadList) {
            if (threadId == thread.id) {
                threadSeach = ThreadFakeDb.threadList.get(index);
            }
            index++;
        }
        
        return threadSeach;
    }

    public static List<Thread> getByUserId(UUID userId) {
        List<Thread> threadsByUser = new ArrayList<Thread>();
        for (Thread thread: ThreadFakeDb.threadList) {
            if (userId == thread.userId) {
                threadsByUser.add(thread);
            }
        }
        return threadsByUser;
    }

    public static List<Thread> getAnswers(UUID threadId) {
        List<Thread> threadsAnswers = new ArrayList<Thread>();
        for (Thread thread: ThreadFakeDb.threadList) {
            if (threadId == thread.threadIdPrincipal) {
                threadsAnswers.add(thread);
            }
        }
        return threadsAnswers;
    }
}
