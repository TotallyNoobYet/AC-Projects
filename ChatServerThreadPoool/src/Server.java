import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {


    private int portNumber = 8002;
    private ExecutorService threadPool;
    private CopyOnWriteArrayList<ServerWorker> clientArray;
    private ServerSocket server;
    private Socket client;


    public Server() {
        this.threadPool = Executors.newFixedThreadPool(2);
        this.clientArray = new CopyOnWriteArrayList<>();
    }


    public void ServerListen() {

        try {
            server = new ServerSocket(portNumber);
            while (true) {
                client = server.accept();
                ServerWorker serverWorker = new ServerWorker(client);
                threadPool.submit(serverWorker);
                clientArray.add(serverWorker);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public class ServerWorker implements Runnable {

        private Socket socket;

        public PrintWriter output;

        public BufferedReader input;

        public ServerWorker(Socket socket) {
            this.socket = socket;
            try {
                this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Connection established");
                System.out.println("###Chat initialized###");


                try {

                    String message = input.readLine();


                    for (ServerWorker socket : clientArray) {

                        socket.output.println(message);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}





