import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    private int port;
    private CopyOnWriteArrayList<ServerWorker> serverWorkers;
    private ExecutorService threadPool;
    private Socket client;
    private ServerSocket server;


    public Server() {
        this.port = 8090;
        this.serverWorkers = new CopyOnWriteArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(2);


    }

    public void run() {

        try {
            this.server = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " server is online");

        while (true) {

            try {

                this.client = server.accept();

                ServerWorker serverWorker = new ServerWorker(client, this);

                this.serverWorkers.add(serverWorker);
                this.threadPool.submit(serverWorker);


                System.out.println("joined the chat");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void joinMessageAndCommands(){

        for(ServerWorker serverWorker : serverWorkers){

            serverWorker.getPrinter().println("-------------------");
            serverWorker.getPrinter().println("----JOINED CHAT----");
            serverWorker.getPrinter().println("Command list: \n/pm_name -> private message\n/q -> leave chat and disconnect");
            serverWorker.getPrinter().println("-------------------");
        }

    }

    public void chooseName(){

        for(ServerWorker serverWorker : serverWorkers){

            serverWorker.getPrinter().println("Write your name!");

        }

    }

    public void whisper(String message) {
    }

    public void broadcast(String message, Socket socket) {

        for (ServerWorker serverWorker : serverWorkers) {

            try {
                if (serverWorker.inputStream() != socket.getInputStream()) {

                    serverWorker.getPrinter().println(Thread.currentThread().getName() + ": " + message);


                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void disconnect(Socket socket) {

        try {

            for (ServerWorker serverWorker : serverWorkers) {

                serverWorker.getPrinter().println(Thread.currentThread().getName() + ": left the chat");
                serverWorkers.remove(serverWorker);
                System.out.println(serverWorkers.size());

            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
