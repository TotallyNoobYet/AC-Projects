import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        int portNumber = 9000;
        String input = "Hello World";

        byte[] send = new byte[1024];
        byte[] recvBuffer = new byte[1024];

        InetAddress address = InetAddress.getLocalHost();
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket request = new DatagramPacket(send, send.length, address, portNumber);
        request.setData(input.getBytes());
        socket.send(request);

        DatagramPacket response = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(response);

        String received = new String(response.getData(), 0, response.getLength());

        System.out.println(received);

    }
}
