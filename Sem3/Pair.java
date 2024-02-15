//2024.02.15 mip24
package Sem3;

public class Pair <T1, T2>{
    private T1 value1;
    private T2 value2;

    public Pair(T1 t1, T2 t2){
        value1 = t1;
        value2 = t2;
    }

    public T1 getFirst(){
        return value1;
    }
    
    public T2 getSecond(){
        return value2;
    }

    @Override
    public String toString(){
        return String.format("Pair[first element = %s, second element = %s]", value1, value2);
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String,Integer>("Text", 10000);
        System.out.println(pair);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());        

        PairRecord<String, Integer> pairRecord = new PairRecord<String,Integer>("Text", 10000);
        System.out.println(pairRecord);
        System.out.println(pairRecord.value1()); 
        System.out.println(pairRecord.value2()); 
    }
}
