import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NodeJsEcho { 
// socket object
private static Socket socket = null; 
public static void main(String[] args) throws UnknownHostException,    
IOException, ClassNotFoundException { 
    // class instance 
    NodeJsEcho client = new NodeJsEcho(); 
    // socket tcp connection 
//    String ip = "zuul-server-23011990.appspot.com"; 
//    int port = 443; 
    String ip = "127.0.0.1";
	int port = 1337;
    client.socketConnect(ip, port); 
    // writes and receives the message

    String message = "message123"; 
    System.out.println("Sending: " + message); 
    String returnStr = client.echo(message); 
    System.out.println("Receiving: " + returnStr); 
    getSocket().close();
    } 

// make the connection with the socket 
private void socketConnect(String ip, int port) throws UnknownHostException,    
 IOException{
    System.out.println("[Connecting to socket...]"); 
    this.socket = new Socket(ip, port); 
    }
// writes and receives the full message int the socket (String) 
public String echo(String message) 
{
    try {
        // out & in 
        PrintWriter out = new PrintWriter(getSocket().getOutputStream(),    
        true); 
        BufferedReader in = new BufferedReader(new   
        InputStreamReader(getSocket().getInputStream()));
        // writes str in the socket and read 
        out.println(message); 
        String returnStr = in .readLine();
        in.close();
        out.close();
        return returnStr; 
        } catch (IOException e) 
    {
            e.printStackTrace();
            }
    return null; 
    } // get the socket instance 
private static Socket getSocket() 
{
    return socket; 
    }

}
