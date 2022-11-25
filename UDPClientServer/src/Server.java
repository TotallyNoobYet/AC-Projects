import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Server {
    public static void main(String[] args) throws IOException {

        int portNumber = 9000;

        byte[] recvBuffer = new byte[1024];

        DatagramSocket socket = new DatagramSocket(portNumber);
        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket);

        String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
        String receivedToUpper = received.toUpperCase();

        DatagramPacket sendPacket = new DatagramPacket(receivedToUpper.getBytes(), receivedToUpper.length(), InetAddress.getLocalHost(), receivePacket.getPort());
        socket.send(sendPacket);
        socket.close();
    }



}
