import java.io.*;
import java.net.Socket;

public class ServerWorker implements Runnable {

    private String name;

    private Socket client;

    private Server server;
    private BufferedReader reader;
    private PrintWriter printer;

    private String message;

    private InputStream inputStream;

    private OutputStream outputStream;


    public ServerWorker(Socket client, Server server) {
        this.client = client;
        this.server = server;

        try {

            this.reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.printer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {

        server.joinMessageAndCommands();
        server.chooseName();
        try {
            this.name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.currentThread().setName(name);

        while (true) {


            try {

                message = reader.readLine();

                if (message.equals("/q")) {

                    server.disconnect(client);
                    break;


                } else if (message.equals("/pm")) {

                    server.whisper(message);


                } else {

                    server.broadcast(message, client);

                }



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public PrintWriter getPrinter() {
        return printer;
    }

    public InputStream inputStream(){
        try {
           inputStream = client.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public OutputStream outputStream(){
        try {
            outputStream = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    public String getName(){
        return name;
    }


}
