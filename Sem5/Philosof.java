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

    public synchronized void toEat(){
        while(sitzplatz == null) {
            System.out.printf("\n - Гость: %s, не может есть, так как у него нет места за столом", name);
            status = "Стоит";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int timeToEat = rnd.nextInt(1000, 3000);        

        synchronized(rightFork){synchronized(leftFork){
            System.out.printf("\n -- Гость: %s, сидит на месте: %s, ест с помощью вилок: %s и %s", name, sitzplatz.getName(), leftFork, rightFork);        
            status = String.format("Ест вилками: %s %s, на месте %s",  leftFork, rightFork, sitzplatz.getName());
            
            sleepAlitl(timeToEat);
        }}

        System.out.printf("\n --- Гость: %s, закончил есть. Ел %d мс, сидит на месте %s, освободил вилки : %s и %s", name, timeToEat, sitzplatz.getName(), leftFork, rightFork);        
        status = String.format("Закончил есть",  sitzplatz.getName());      
    }

    public void toThink(){
        System.out.printf("\n ---- Гость: %s, думает", name);  
        status = String.format("Думает, на месте %s",  sitzplatz.getName());      
        sleepAlitl(3000);
    }

    public String getName(){
        return name;
    }

    public SitzPlatz getSitzPlatz(){
        return sitzplatz;
    }

    @Override
    public String toString(){
        return String.format("Гость: %s, сидит на месте: %s, доступны вилки: %s и %s. Статус: %s", name, sitzplatzName, leftFork, rightFork, status);
    }
    
    private void sleepAlitl(int timeToSleep){
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
