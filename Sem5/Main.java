//mip24 2024/03/01
//1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//2. Вилки лежат на столе между каждой парой ближайших философов.
//3. Каждый философ может либо есть, либо размышлять.
//4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
package Sem5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static List<Philosof> guests;

    public static void main(String[] args) {
        int countSitzPlatz = 2;
        int countOfGuest = 2;
        CountDownLatch cdl = new CountDownLatch(countSitzPlatz);

        
        guests = new ArrayList<>();
        for(int i = 0; i < countOfGuest; i++){
            Philosof newPhilosof = new Philosof("Филосов " + i, cdl);
            guests.add(newPhilosof);
        }
        System.out.println("Сгенерировали философов:");
        System.out.println(guestToString());

        Table table = new Table(countSitzPlatz, guests);
        System.out.println();
        System.out.println("Сгенерировали стол и усадили гостей:");
        System.out.println(table);

        System.out.println();
        System.out.println("Проверяем усадку философов:");
        System.out.println(guestToString());

        for(SitzPlatz sitzPlatz: table){
            Philosof curentPhilosof = sitzPlatz.getPhilosof();
            if(curentPhilosof != null){
                new Thread(curentPhilosof).start();
            }
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Все УСАЖЕННЫЕ гости сообщили что они поели");
        System.out.println("Проверяем накормленность философов:");
        System.out.println(guestToString());







    }

    public static String guestToString(){
        StringBuffer result = new StringBuffer("Гости (количество - " + guests.size() + "): ");
        Integer count = 0;
        for(Philosof philosof: guests){
            result.append("\n" + (count++).toString() + ". " + philosof);
        }
        result.append("\n -------");
        return result.toString();
    }

    
}
