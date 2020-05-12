import org.apache.axis.client.Service;
import org.apache.axis.client.Call;

import javax.xml.rpc.ServiceException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Tour {
  //создаём вызов веб-службы
    public static void main(String[] args) throws ServiceException, MalformedURLException {
      //Указываем конечную точку веб-службы.
        String endpoint = "http://localhost:8080/axis/Tourfirm.jws";
      //Создаём новый Service
        Service service = new Service();
      //создаём объект типа call
        Call call = (Call)service.createCall();
     //Указываем что объект типа call содержит адрес Web-службы endpoint и название Web-услуги getEcho
        call.setTargetEndpointAddress(new URL(endpoint));
      //Выводим на экран сообщения
        System.out.println("1 - enter the tour name");
        System.out.println("2 - enter the tour price");
        System.out.println("3 - exit");
        try {
          //Передаем поток System.in объекту
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
          //Объявляем переменную и даём ей неизвестное значение
            String line = null;
          //Введённый текст будет значением переменной
            line = in.readLine();
          //Если количество символов меньше 3 запускаем следующие условия
            while(!line.equals("3")) {
          //Если равно 1
                if(line.equals("1")) {
                  //Создаём переменную и обьяект к ней
                    String tour = in.readLine();
                    Object[] param1 = new Object[]{tour};
                  //Принимаем строку в качестве аргумента
                    String response = (String)call.invoke("tour_price", param1);
                  //Выводим на экран сообщение с нужными параметрами
                    System.out.println("Tour: " + tour + "\n" + "Price: " + response);
                }
              //Если равно 2
                if(line.equals("2")) {
                //Создаём переменную и обьяект к ней
                    String price = in.readLine();
                    Object[] param2 = new Object[]{price};
                  //Принимаем строку в качестве аргумента
                    String response = (String)call.invoke("price_tour", param2);
                  //Выводим на экран сообщение с нужными параметрами
                    System.out.println("Tour: " + response + "\n" + "Price: " + price);
                }
                //Выводим на экран сообщения
                System.out.println("1 - enter the tour name");
                System.out.println("2 - enter the tour price");
                System.out.println("3 - exit");
                line = in.readLine();
            }
          //Отслеживание исключений
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
