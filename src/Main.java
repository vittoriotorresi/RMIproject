import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        String address = args[0];
        String servicename=args[1];
        if(args.length!=2){
            System.out.println("Usage: java Main <address> <servicename>");
            exit(-1);
        }
        ServerInterface server= null;
        try {
            server = (ServerInterface) Naming.lookup("rmi://"+address);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Scanner input=new Scanner(System.in);
        System.out.println("Inserisci due numeri: ");


        try {double n1=input.nextDouble();
            double n2=input.nextDouble();
            double sum = server.getSum(n1,n2);
            System.out.println("La somma e' "+sum);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
            }
}
