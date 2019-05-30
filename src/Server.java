import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface{
    public Server() throws RemoteException{}
    @Override
    public double getSum(double a, double b) throws RemoteException {
        return a+b;
    }
    public static void main(String [] args){
        try {
            ServerInterface server=new Server();
            Naming.rebind("calculator", server);
        } catch(MalformedURLException e) {
                   e.printStackTrace();
               } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
