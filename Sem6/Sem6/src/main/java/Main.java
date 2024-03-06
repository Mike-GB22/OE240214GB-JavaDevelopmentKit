import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    private static int maxTry = 1000;
    private static int countOfDoor = 3;
    private static int maxForRandom = 1000;
    private static int winFromFirstTime = 0;
    private static int winFromSecondTime = 0;

    public static void main(String[] args) {
        System.out.println("Hi");


        for(int i = 0; i < maxTry; i++){
            CaseDorrs caseDoors = new CaseDorrs(countOfDoor);
                System.out.println(i + " " + caseDoors);
            int firstSelect = getRandomDoor();
            int doorWithNothing = caseDoors.getDoorWithNothing(firstSelect);
            System.out.println(String.format(
                    "Выбрали дверь: %d, нам открыли пустую дверь %d (за дверью: %s)"
                    , firstSelect, doorWithNothing, caseDoors.getDoorText(doorWithNothing)));

            //Проверяем случай что мы не изменили решение:
            boolean win = caseDoors.getDoor(firstSelect);
            System.out.println("Случай 1. Мы не меняем дверь: " + winOrLost(win));
            if(win) winFromFirstTime++;

            int otherSelect = getRandomDoor(firstSelect, doorWithNothing);
            boolean winOther = caseDoors.getDoor(otherSelect);
            System.out.println("Случай 2. Мы поменяли дверь (теперь "+ otherSelect
                    + "): " + winOrLost(winOther));
            if(winOther) winFromSecondTime++;

            if(firstSelect == otherSelect) System.out.println("-Error: Двери из обоих попыток одинаковые");
            System.out.println("");
        }

        System.out.println("Всего повторений: " + maxTry);
        System.out.println(String.format(
                "Выиграли НЕ меняя дверь: %d, (%d процентов)"
                , winFromFirstTime, (winFromFirstTime*100/maxTry)));
        System.out.println(String.format(
                "Выиграли меняя дверь: %d, (%d процентов)"
                , winFromSecondTime, (winFromSecondTime*100/maxTry)));


    }

    //Возвращаем случайную дверь
    public static int getRandomDoor(){
        Random rnd = new Random();
        return rnd.nextInt(maxForRandom)%countOfDoor;
    }

    //Возвращаем случайную дверь, но за исключением указанных в списке
    public static int getRandomDoor(List<Integer> doors){
        int result = 0;
        for(int i = 0; i < countOfDoor*10; i++){
            result = getRandomDoor();
            if(!doors.contains(result)) return result;
        }
        System.out.println("Невозможно выбрать другую дверь");
        return result;
    }

    //Возвращаем случайную дверь, но за исключением
    public static int getRandomDoor(Integer firstDoor, Integer doorWithNothing){
        List<Integer> list = new ArrayList<>();
        list.add(firstDoor);
        list.add(doorWithNothing);
        return getRandomDoor(list);
    }

    public static String winOrLost(boolean win){
        return win?"Выиграли!":"Проиграли";
    }
}
