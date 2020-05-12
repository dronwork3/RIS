package RMIInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
//RMi интерфейс
public interface RMIInterface extends Remote {
    public String helloTo(String name) throws RemoteException;
}