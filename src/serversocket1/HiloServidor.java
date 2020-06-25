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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrielhs
 */
public class HiloServidor extends Thread{
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket=null;

    public HiloServidor(Socket s) {
        socket=s;
        
        try {
            fsalida=new PrintWriter(socket.getOutputStream(),true);
            fentrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        
    }
    
    
    public void run (){
        try {
            InputStreamReader isr=new InputStreamReader(socket.getInputStream());
            BufferedReader receptor=new BufferedReader(isr);
            
            PrintWriter emisor=new PrintWriter(socket.getOutputStream());
            
            String msg=receptor.readLine();
            
            System.out.println("Msg:" + msg);
            
            emisor.println("Quetal ..");
            emisor.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fsalida.close();
            fentrada.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
