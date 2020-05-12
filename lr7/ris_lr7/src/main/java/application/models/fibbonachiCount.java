package application.models;

import java.util.ArrayList;

public class fibbonachiCount {
    private Integer startDigit;


    public fibbonachiCount() {
    }
  //Объявляем переменную
    public fibbonachiCount(Integer startDigit) {
        this.startDigit = startDigit;
    }
  //Объявляем переменную
    public Integer getStartDigit() {
        return startDigit;
    }
//Объявляем переменную
    public void setStartDigit(Integer startDigit) {
        this.startDigit = startDigit;
    }
//Создаём список
    public ArrayList count(Integer startDigit)
    {
    //Добавляем значения списка и их параметры
        ArrayList arrayList = new ArrayList();
        int n0 = startDigit;
        int n1 = startDigit;
        int n2;

        arrayList.add(n1);

        for(int i = 3; i <= 11; i++){
            n2=n0+n1;
            n0=n1;
            n1=n2;
            arrayList.add(n2);
        }

//Выводим данные списка
        System.out.println(arrayList);
        return arrayList;
    }
}
