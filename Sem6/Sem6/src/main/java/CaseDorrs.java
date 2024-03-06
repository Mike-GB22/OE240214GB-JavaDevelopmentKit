//20240306 mip24
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaseDorrs {
    private boolean doors[];

    public CaseDorrs(){
        this(3);
    }

    public CaseDorrs(int number){
        Random rnd = new Random();
        doors = new boolean[number];
        int gluckDoor = rnd.nextInt(1000)%number;
        doors[gluckDoor] = true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Case: ");
        for(int i = 0; i < doors.length; i++){
            result.append(String.format("door %d: %s, ", i, (doors[i]?"CAR":" - ")));
        }
        return result.substring(0,result.length()-2).toString();
    }

    public int getDoorWithNothing(int currentDoor){
        //������ ��� ������ ������, �� ����������� ���������
        List<Integer> doorsWithNothing = new ArrayList<>();
        for(int i = 0; i < doors.length; i++){
            if(doors[i] == false && i != currentDoor){
                doorsWithNothing.add(i);
            }
        }
        //�������� ������ ���� �� ������.
        Random rnd = new Random();
        int door = doorsWithNothing.get(rnd.nextInt(1000)%doorsWithNothing.size());
        return door;
    }

}
