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
public class ServerMultiThread2 {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5500);
            System.out.println("Server è attivo e in ascolto");
            
            while(true) {
                Socket client = server.accept();
                System.out.println("connessione ricevuta");
                Thread Serverino = new Thread(new ServerThread2(client));
                Serverino.start();
                
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerMultiThread2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
