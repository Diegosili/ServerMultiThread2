/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siliprandi.diego
 */
public class ServerThread implements Runnable{

    private  Socket clientSocket;
    
    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        System.out.println("Server partito: "+clientSocket.getInetAddress());
        try {
            
            clientSocket.getInetAddress();
            
            PrintWriter riceve = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader lettore = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String richiesta = "";
            
            while(!richiesta.equals("exit")) {
                richiesta = lettore.readLine();
                System.out.println("stringa dal client: "+richiesta);
                riceve.println("caratteri: "+richiesta.length());
            }
            
            riceve.close();
            clientSocket.close();
            
            System.out.println("chiusura connessione effettuata");
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
