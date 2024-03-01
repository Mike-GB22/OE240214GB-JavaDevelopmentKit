package Sem5;

public class SitzPlatz {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private Philosof philosof;

    public SitzPlatz(String name, Fork leftFork, Fork rightFork){
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    //Садим за стол гостя...
    public void setzenPhilisof(Philosof philosof){
        this.philosof = philosof;
            SitzPlatz oldSitzPlatz = philosof.getSitzPlatz();
                if(oldSitzPlatz != null) oldSitzPlatz.setzenNone();
            philosof.setSitzplatz(this);
    }
    
    //Освобождаем место за столом...
    public void setzenNone(){
        philosof.setSitzplatz(null);
        this.philosof = null;
    }

    public Fork getLeftFork(){
        return leftFork;
    }

    public void setLeftFork(Fork fork){
        leftFork = fork;
    }

    public Fork getRightFork(){
        return rightFork;
    }

    public String getName(){
        return name;
    }

    public Philosof getPhilosof(){
        return philosof;
    }

    @Override
    public String toString(){
        return String.format("Место: %s, занято человеком: %s, доступны вилки: %s, %s", name, philosof.getName(), leftFork, rightFork);
    }
}
