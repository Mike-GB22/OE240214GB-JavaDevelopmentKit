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
                    "������� �����: %d, ��� ������� ������ ����� %d (�� ������: %s)"
                    , firstSelect, doorWithNothing, caseDoors.getDoorText(doorWithNothing)));

            //��������� ������ ��� �� �� �������� �������:
            boolean win = caseDoors.getDoor(firstSelect);
            System.out.println("������ 1. �� �� ������ �����: " + winOrLost(win));
            if(win) winFromFirstTime++;

            int otherSelect = getRandomDoor(firstSelect, doorWithNothing);
            boolean winOther = caseDoors.getDoor(otherSelect);
            System.out.println("������ 2. �� �������� ����� (������ "+ otherSelect
                    + "): " + winOrLost(winOther));
            if(winOther) winFromSecondTime++;

            if(firstSelect == otherSelect) System.out.println("-Error: ����� �� ����� ������� ����������");
            System.out.println("");
        }

        System.out.println("����� ����������: " + maxTry);
        System.out.println(String.format(
                "�������� �� ����� �����: %d, (%d ���������)"
                , winFromFirstTime, (winFromFirstTime*100/maxTry)));
        System.out.println(String.format(
                "�������� ����� �����: %d, (%d ���������)"
                , winFromSecondTime, (winFromSecondTime*100/maxTry)));


    }

    //���������� ��������� �����
    public static int getRandomDoor(){
        Random rnd = new Random();
        return rnd.nextInt(maxForRandom)%countOfDoor;
    }

    //���������� ��������� �����, �� �� ����������� ��������� � ������
    public static int getRandomDoor(List<Integer> doors){
        int result = 0;
        for(int i = 0; i < countOfDoor*10; i++){
            result = getRandomDoor();
            if(!doors.contains(result)) return result;
        }
        System.out.println("���������� ������� ������ �����");
        return result;
    }

    //���������� ��������� �����, �� �� �����������
    public static int getRandomDoor(Integer firstDoor, Integer doorWithNothing){
        List<Integer> list = new ArrayList<>();
        list.add(firstDoor);
        list.add(doorWithNothing);
        return getRandomDoor(list);
    }

    public static String winOrLost(boolean win){
        return win?"��������!":"���������";
    }
}
