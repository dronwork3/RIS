/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subject.ejb;

import java.util.ArrayList;
import java.util.Collections;
import javax.ejb.Stateful;
import java.util.Comparator;
import java.util.List;


@Stateful
public class Subject implements SubjectLocal {

//Сравниваем объекты списка
    ArrayList content;
    public static Comparator<String[]> cmp = new Comparator<String[]>() {
        @Override
        public int compare(String[] s1, String[] s2) {
            return s2[1].compareTo(s1[1]);
        }
    };

//Присваиваем значение новому списку
    public Subject() {
        content = new ArrayList();
    }

//Получаем список
    @Override
    public ArrayList getList() {
        return content;
    }

//Удаляем элемент с указанным индексом
    @Override
    public void remove(int index) {
        content.remove(index);
    }

//Добавляем переменные и значения
    @Override
    public void add(String departure, String arrival, String price, String classe) {
        content.add(new String[]{departure, arrival, price, classe});
    }

    @Override
      //Получаем последний список
    public ArrayList getMostExpensive(int number) {
      //Клонируем его и его значение
        ArrayList clone = (ArrayList )content.clone();
        Collections.sort(clone, cmp);
        if (clone.size() > number){
            clone = new ArrayList(clone.subList(0, number));
        }
        return clone;
    }
}
