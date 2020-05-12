package RMIServer;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import RMIInterface.RMIInterface;

public class Server extends UnicastRemoteObject implements RMIInterface {
    private static final long serialVersionUID = 1L;

    protected Server() throws RemoteException {
        super();
    }

    @Override
    // ���������� ����������
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        // ������� � ������������ ��������� ������
        StringBuilder modifiedString = new StringBuilder();
        //���� �������� ����
        for (int i = 0; i < name.length(); i++) {
            if (isVowel(name.charAt(i))) {
                modifiedString.append(' ');
            }
            modifiedString.append(name.charAt(i));
        }
        // ���������� ��������� ������
        return "Modified word: " + modifiedString;
    }
  //����� ������
    public static boolean isVowel(char checkString) {
        char[] vowels  = {'A', 'a'};
        // ���� �� ������ � � �
        for (int i = 0; i < vowels.length; i++) {
            if (checkString == vowels[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            // ������� � ������������ ��������� ������
            Naming.rebind("//localhost/MyServer", new Server());
            System.err.println("Server ready");
//���������� ������
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}