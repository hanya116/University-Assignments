import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientCommand{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 6789);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (DIR, GET <file>, BYE): ");
            String cmd = sc.nextLine();
            dos.writeUTF(cmd);
            dos.flush();

            if (cmd.equalsIgnoreCase("BYE")) {
                System.out.println(dis.readUTF());
                break;
            }

            String response;
            while (!(response = dis.readUTF()).equals("END")) {
                System.out.println(response);
            }
        }

        dis.close();
        dos.close();
        s.close();
        System.out.println("Disconnected.");
    }
}
