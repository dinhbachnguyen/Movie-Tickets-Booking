package tp8;

import java.io.*;
import java.net.Socket;

public class Client {
    BufferedWriter bufferedWriter = null;
    public Client() throws IOException {
        try(Socket socket = new Socket("127.0.0.1", 1324)){
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter((socket.getOutputStream()))){
                    BufferedWriter bufferedWriter = new BufferedWriter();
                    bufferedWriter.write("hello");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    String response = bufferedReader.readLine();
                    System.out.println(response);

                }
            }
        }
    }
}
