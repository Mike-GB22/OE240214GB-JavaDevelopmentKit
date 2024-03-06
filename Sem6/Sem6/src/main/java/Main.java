public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        int maxTry = 1000;
        int countOfDoor = 3;

        for(int i = 0; i < maxTry; i++){
            CaseDorrs caseDoors = new CaseDorrs(countOfDoor);
                System.out.println(i + " " + caseDoors);
        }
    }
}
