import java.io.*;
import java.net.*;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6789); 
        System.out.println("Server started on port 6789. Waiting for clients...");
        Socket s = ss.accept();
        System.out.println("Client connected: " + s.getInetAddress());

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stream = "";
        String input = "";

        while (!stream.equalsIgnoreCase("stop")) {
            stream = dis.readUTF();            
            System.out.println("Client: " + stream);

            if (stream.equalsIgnoreCase("stop")) {
                dos.writeUTF("stop");         
                dos.flush();
                break;
            }

            System.out.print("Server: ");
            input = br.readLine();              
            dos.writeUTF(input);
            dos.flush();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }
        }

        dis.close();
        dos.close();
        s.close();
        ss.close();
    }
}

