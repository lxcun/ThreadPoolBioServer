import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerThreadPool {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        RequestHandler requestHandler=new RequestHandler();
        try{
            ServerSocket serverSocket=new ServerSocket(8088);
            System.out.println("BIOServer has started,linstening on port:"+serverSocket.getLocalSocketAddress());
            while (true){
                Socket socket=serverSocket.accept();
                executorService.submit(new ClientHandler(socket,requestHandler));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
