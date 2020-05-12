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
    // реализация интерфейса
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        // создаем и экспортируем удаленный объект
        StringBuilder modifiedString = new StringBuilder();
        //цикл удаления букв
        for (int i = 0; i < name.length(); i++) {
            if (isVowel(name.charAt(i))) {
                modifiedString.append(' ');
            }
            modifiedString.append(name.charAt(i));
        }
        // возвращает изменённую строку
        return "Modified word: " + modifiedString;
    }
  //метод поиска
    public static boolean isVowel(char checkString) {
        char[] vowels  = {'A', 'a'};
        // цикл по поиску А и а
        for (int i = 0; i < vowels.length; i++) {
            if (checkString == vowels[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            // создаем и экспортируем удаленный объект
            Naming.rebind("//localhost/MyServer", new Server());
            System.err.println("Server ready");
//обработчик ошибок
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}