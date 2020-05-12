/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subject.ejb;

import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface SubjectLocal {

//Получаем список
    ArrayList getList();

//удаления элемента из указанного индекса
    void remove(int index);

//Добавляем переменные
    void add(String departure, String arrival, String price, String classe);

//В последнем Списке
    ArrayList getMostExpensive(int number);
}
