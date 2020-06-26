/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerSocket1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(5000);           
            System.out.println("Servidor Iniciado....");
        while(true){
    //        try {

            Socket client=server.accept();
            System.out.println("Cliente Aceptado");
            HiloCliente hilo = new HiloCliente(client);
            hilo.start();
//            InputStreamReader isr=new InputStreamReader(client.getInputStream());
//            BufferedReader receptor=new BufferedReader(isr);
//            
//            PrintWriter emisor=new PrintWriter(client.getOutputStream());
//            
//            String msg=receptor.readLine();
//            
//            System.out.println("Msg:" + msg);
//            
//            emisor.println("Quetal ..");
//            emisor.flush();
            //Emisor
            
            //Receptor
           
            
//        } catch (IOException ex) {
//            Logger.getLogger(ServerSocket1.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }
        
    }
    
}
