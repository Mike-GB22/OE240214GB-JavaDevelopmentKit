package Sem5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table implements Iterable<SitzPlatz>{
    private List<SitzPlatz> sitzplatzs;
    private List<Philosof> guests;
    private int countSitzPlatz;
    private int countOfGuest;

    public Table(int countSitzPlatz, List<Philosof> guests){
        this.countSitzPlatz = countSitzPlatz;
        this.guests = guests;
        countOfGuest = guests.size();
        makeTable();
    }

    private void makeTable(){
        sitzplatzs = new ArrayList<>();
        //Меньше 2х мест не может быть, так как по условию задачи нужно иметь 2 вилки
        if(countSitzPlatz < 2) return;

        //Садим гостей из списка за стол, если кому то место не хватило, не садим его
        //Создаем сидячие места
        for(int i = 0; i < countSitzPlatz; i++){
            Fork leftFork = null; 
            Fork rightFork = new Fork("Вилка " + i);
            if(i != 0){
                leftFork = sitzplatzs.get(i - 1).getRightFork();
            }
            SitzPlatz newSitzPlatz = new SitzPlatz(("Место " + i).toString()
                                    , leftFork
                                    , rightFork);
            sitzplatzs.add(newSitzPlatz);

            //Садим гостя
            if(i < countOfGuest){
                newSitzPlatz.setzenPhilisof(guests.get(i));
            }
        }

        //Последнюю вилку делаем доступной как левую, для 0го места
        Fork lastFork = sitzplatzs.get(countSitzPlatz - 1).getRightFork();
        sitzplatzs.get(0).setLeftFork(lastFork);
        sitzplatzs.get(0).getPhilosof().updateForksFromSitzPlatz();
        
    }

    @Override
    public String toString(){
        StringBuffer result = new StringBuffer("Стол (количество мест - " + countSitzPlatz + "): ");
        Integer count = 0;
        for(SitzPlatz sitzPlatz: sitzplatzs){
            result.append("\n" + (count++).toString() +". " + sitzPlatz);
        }
        result.append("\n -------");
        return result.toString();
    }

    public int size(){
        return sitzplatzs.size();
    }

    public SitzPlatz get(int i){
        return sitzplatzs.get(i);
    }

    @Override
    public Iterator<SitzPlatz> iterator() {
        return new MyIterator<SitzPlatz>(sitzplatzs);
    }
    
}

class MyIterator<E> implements Iterator<E>{
    List<E> list;
    int curtenIndex = 0;

    public MyIterator(List<E> sitzPlatzs){
        this.list = sitzPlatzs;
    }

    @Override
    public boolean hasNext() {
        return curtenIndex < list.size();
    }

    @Override
    public E next() {
        return list.get(curtenIndex++);
    }

}
