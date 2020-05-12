/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.naming.*;
import javax.jms.*;

public class MySender {
    public static void main(String[] args) {
        try {
          //Создаём сесию отправителя
            InitialContext ctx=new InitialContext();
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");
            QueueConnection con=f.createQueueConnection();
            con.start();
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue t=(Queue)ctx.lookup("myQueue");
            QueueSender sender=ses.createSender(t);
            TextMessage msg=ses.createTextMessage();
            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
          //После создания сообщаем что отправитель может печатать сообщение
                System.out.println("Enter message or enter 'end' to terminate: ");
                String s=b.readLine();
                if (s.equals("end"))
                    break;
                msg.setText(s);
                sender.send(msg);
            //Сообщаем что сообщаение успешно отправлено
                System.out.println("Message successfully sent.");
            }   
            con.close();
      //Обработка исключений
        }catch(Exception e){System.out.println(e);}
    }
}
