//20240306 mip24
import java.util.Random;

public class Case {
    private boolean doors[];

    public Case(){
        this(3);
    }

    public Case(int number){
        Random rnd = new Random();
        doors = new boolean[number];
        int gluckDoor = rnd.nextInt(1000)%number;
        doors[gluckDoor] = true;
    }

    @Override
    public String toString() {

        for(int i = 0; i < doors.length; i++){

        }
    }
}
