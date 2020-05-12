    package RMIClient;

    import java.net.MalformedURLException;
    import java.rmi.Naming;
    import java.rmi.NotBoundException;
    import java.rmi.RemoteException;

    import javax.swing.JOptionPane;

    import RMIInterface.RMIInterface;

    public class Client {
        private static RMIInterface look_up;

        public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
           // проверяет реестр RMI, работающий на локальном хосте, на наличие привязки
            look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
            //создаёт диалоговое окно
            String txt = JOptionPane.showInputDialog("Please, input the word");
            //присваивание и вывод в диалоговое окно полученной строки
            String response = look_up.helloTo(txt);
            JOptionPane.showMessageDialog(null, response);
        }
    }