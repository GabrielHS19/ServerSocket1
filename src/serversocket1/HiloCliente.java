
package serversocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 *
 * @author gabrielhs
 */
public class HiloCliente extends Thread{
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket=null;

    public HiloCliente(Socket socket) {
        this.socket=socket;
        
        try {
            fsalida=new PrintWriter(socket.getOutputStream(),true);
            fentrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        
    }
    
    
    public void run (){
        try {
            
            String msg=fentrada.readLine();
            
            System.out.println("Msg:" + msg);
            
            fsalida.println("Quetal ..");
            fsalida.flush();
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
