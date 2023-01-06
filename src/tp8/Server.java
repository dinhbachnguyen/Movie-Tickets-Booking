package tp8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        System.out.println("Connection accpeted from" + socket.getInetAddress().getHostAddress());

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
                String line = null;
                bufferedWriter.write(""+ Integer.parseInt(line)*2);
                bufferedWriter.newLine();
                bufferedWriter.flush();

            }
        }
    }
}
