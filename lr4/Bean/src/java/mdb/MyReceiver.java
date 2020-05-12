/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import javax.jms.*;
import javax.naming.InitialContext;

import javax.jms.*;
import javax.naming.InitialContext;

public class MyReceiver {
  //Создаём сесию получателя
    public static void main(String[] args) {
        try{
            InitialContext ctx=new InitialContext();
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");
            QueueConnection con=f.createQueueConnection();
            con.start();
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue t=(Queue)ctx.lookup("myQueue");
            QueueReceiver receiver=ses.createReceiver(t);
            MyListener listener=new MyListener();

 // Бесконечный цикл
            receiver.setMessageListener(listener);
        //Сообщаем что пользователь ждёт сообщение
            System.out.println("Receiver1 is ready, waiting for messages...");
        //Сообщаем комбинацию клавиш для выхода
            System.out.println("press Ctrl+c to shutdown...");
            while(true){
        //Приостанавливаем текущий поток на заданное время.
                Thread.sleep(1000);
            }
       //Обработка исключений
        } catch(Exception e){System.out.println(e);}
    }
}
