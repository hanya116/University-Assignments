import java.io.*;
import java.net.*;

public class ServerCommannds {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6789);
        System.out.println("Server started on port 6789. Waiting for clients...");

        Socket s = ss.accept();
        System.out.println("Client connected: " + s.getInetAddress());

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String command = "";

        while (true) {
            command = dis.readUTF(); // read command from client
            System.out.println("Client: " + command);

            // ----- BYE -----
            if (command.equalsIgnoreCase("BYE")) {
                dos.writeUTF("Goodbye!");
                dos.flush();
                break;
            }

            // ----- DIR -----
            else if (command.equalsIgnoreCase("DIR")) {
                File folder = new File(".");
                File[] files = folder.listFiles();

                for (File file : files) {
                    if (file.isFile()) {
                        dos.writeUTF(file.getName());
                        dos.flush();
                    }
                }
                dos.writeUTF("END"); // end of DIR
                dos.flush();
            }

            // ----- GET <filename> -----
            else if (command.startsWith("GET")) {
                String[] parts = command.split(" ");
                if (parts.length != 2) {
                    dos.writeUTF("ERROR: Usage GET <filename>");
                    dos.writeUTF("END");
                    dos.flush();
                    continue;
                }

                String filename = parts[1];
                File file = new File(filename);

                if (!file.exists()) {
                    dos.writeUTF("ERROR: File not found");
                    dos.writeUTF("END");
                    dos.flush();
                } else {
                    BufferedReader fr = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = fr.readLine()) != null) {
                        dos.writeUTF(line);
                        dos.flush();
                    }
                    fr.close();
                    dos.writeUTF("END"); // end of file
                    dos.flush();
                }
            }

            else {
                dos.writeUTF("Unknown command");
                dos.writeUTF("END");
                dos.flush();
            }
        }

        dis.close();
        dos.close();
        s.close();
        ss.close();
        System.out.println("Server closed.");
    }
}
