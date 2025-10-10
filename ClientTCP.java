import java.io.*;
import java.net.*;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 6789);  
        System.out.println("Connected to server at " + s.getInetAddress());

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stream = "";
        String input = "";

        while (!stream.equalsIgnoreCase("stop")) {
            System.out.print("Client: ");
            input = br.readLine();
            dos.writeUTF(input);
            dos.flush();

            if (input.equalsIgnoreCase("stop")) {
                stream = dis.readUTF();          
                System.out.println("Server: " + stream);
                break;
            }

            stream = dis.readUTF();           
            System.out.println("Server: " + stream);
        }

        dis.close();
        dos.close();
        s.close();
    }
}