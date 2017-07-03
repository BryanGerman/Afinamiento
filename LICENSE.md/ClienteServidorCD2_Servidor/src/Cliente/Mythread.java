package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mythread implements Runnable {

    @Override
    public void run() {
        try {
            String hostName = "localhost";
            int portNumber = 5000;
            Socket kkSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            while ((fromServer = in.readLine()) != null) {
                System.out.println(fromServer + "\n");
                //if (fromServer.equals("Bye."))
                //  break;
                //fromUser = "hola";
                fromUser = stdIn.readLine();
                //if (fromUser != null) {
                //System.out.println("Client: " + fromUser);
                out.println(fromUser);
                //}
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Mythread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
