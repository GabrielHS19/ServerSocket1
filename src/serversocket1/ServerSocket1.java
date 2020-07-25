
package serversocket1;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerSocket1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(5000);           
            System.out.println("Servidor Iniciado....");
        while(true){


            Socket client=server.accept();
            System.out.println("Cliente Aceptado");
            HiloCliente hilo = new HiloCliente(client);
            hilo.start();

        }
        
    }
    
}
