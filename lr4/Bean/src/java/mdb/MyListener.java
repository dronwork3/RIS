/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.util.Arrays;
import java.io.*;

//обозначения класса как компонента, управляемого сообщениями
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MyListener implements MessageListener {

    public MyListener() {
    }
  //Управление сообщениями
    @Override
    public void onMessage(Message m) {
        try{
        TextMessage msg=(TextMessage)m;
        System.out.println("Following message is received: "+ msg.getText());
        }catch(JMSException e){System.out.println(e);}
    }

}
