/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread2;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siliprandi.diego
 */
public class ServerThread2 implements Runnable{

    private  Socket clientSocket;
    
    public ServerThread2(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        System.out.println("Server partito: "+clientSocket.getInetAddress());
        try {
            clientSocket.getInetAddress();
            
            PrintWriter riceve = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader lettore = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Integer richiesta = 0;
            
            richiesta = clientSocket.parselnt(String.valueOf(lettore.read()));
            System.out.println("numero di server richiesti dal client: "+richiesta);
            
            
            riceve.close();
            clientSocket.close();
            
            System.out.println("chiusura connessione effettuata");
        } catch (IOException ex) {
            Logger.getLogger(ServerThread2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
