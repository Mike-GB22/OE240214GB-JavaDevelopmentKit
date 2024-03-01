package Sem5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosof implements Runnable{
    CountDownLatch cdl;
    private String name;
    private SitzPlatz sitzplatz;
    private Random rnd = new Random();
    private String status;

    Fork leftFork;
    Fork rightFork;
    String sitzplatzName;;

    public Philosof(String name, CountDownLatch cdl){
        this.cdl = cdl;
        this.name = name;
        updateForksFromSitzPlatz();
    }

    public void setSitzplatz(SitzPlatz sitzplatz){
        this.sitzplatz = sitzplatz;
        updateForksFromSitzPlatz();
    }

    public void updateForksFromSitzPlatz(){
        if(sitzplatz != null){
            leftFork = sitzplatz.getLeftFork();
            rightFork = sitzplatz.getRightFork();
            sitzplatzName = sitzplatz.getName();
            status = "Сидит на месте: " + sitzplatzName ;
        } else {
            sitzplatzName = "без места";
            status = "Стоит";
        }
    }


    @Override
    public void run() {
        toEat();
        toThink();

        toEat();
        toThink();
        
        toEat();
        toThink();

        cdl.countDown();
        status = "Наелся";
    }

    public void toEat(){
        while(sitzplatz == null) {
            System.out.printf("Гость: %s, не может есть, так как у него нет места за столом", name);
            status = "Стоит";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Гость: %s, сидит на месте: %s, ест с помощью вилок: %s и %s", name, sitzplatz.getName(), leftFork, rightFork);        
        status = String.format("Ест вилками: %s %s, на месте %s",  leftFork, rightFork, sitzplatz.getName());
        
        int timeToEat = rnd.nextInt(100, 3000);
        try {
            Thread.sleep(timeToEat);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.printf("Гость: %s, закончил есть. Ел %d мс, сидит на месте %s, освободил вилки : %s и %s", name, timeToEat, sitzplatz.getName(), leftFork, rightFork);        
        status = String.format("Закончил есть",  sitzplatz.getName());      
    }

    public void toThink(){
        System.out.printf("Гость: %s, думает", name);  
        status = String.format("Думает, на месте %s",  sitzplatz.getName());      
    }

    public String getName(){
        return name;
    }

    public SitzPlatz getSitzPlatz(){
        return sitzplatz;
    }

    @Override
    public String toString(){
        return String.format("Гость: %s, сидит на месте: %s, доступны вилки: %s, %s. Статус: %s", name, sitzplatzName, leftFork, rightFork, status);
    }
    


}
