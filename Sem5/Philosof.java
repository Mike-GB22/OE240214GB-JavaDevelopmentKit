package Sem5;

import java.util.Random;

public class Philosof implements Runnable{
    private String name;
    private SitzPlatz sitzplatz;
    private Fork leftFork;
    private Fork rightFork;
    private Random rnd = new Random();

    public Philosof(String name, SitzPlatz sitzplatz){
        this.name = name;
        this.sitzplatz = sitzplatz;
     }

    @Override
    public void run() {
        toEat();
        toThink();
    }

    public void toEat(){
        leftFork = sitzplatz.getLeftFork();
        rightFork = sitzplatz.getRightFork();
        System.out.printf("Филосов: %s, ест с помощью вилок: %s и %s", name, leftFork, rightFork);        
        
        int timeToEat = rnd.nextInt(100, 3000);
        Thread.sleep(timeToEat);

        System.out.printf("Филосов: %s, закончил есть. Ел %d, освободил вилки : %s и %s", name, timeToEat, leftFork, rightFork);        

    }

    public void toThink(){

    }


    


}
