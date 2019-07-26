import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread{
    private  RequestHandler requestHandler;
    private  Socket clientSocket;
    public ClientHandler(Socket clientsocket,RequestHandler requestHandler){
        this.clientSocket=clientsocket;
        this.requestHandler=requestHandler;
    }
    @Override
    public void run(){
        try {
            Scanner input=new Scanner(clientSocket.getInputStream());
            while (true){
                String request=input.nextLine();
                String response=requestHandler.handle(request);
                clientSocket.getOutputStream().write(response.getBytes());
            }
        }catch (IOException e){
            throw new  RuntimeException(e);
        }
    }
}
