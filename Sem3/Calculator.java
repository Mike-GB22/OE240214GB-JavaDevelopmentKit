//2024.02.15 mip24
package Sem3;

public class Calculator {
    public static <T1 extends Number, T2 extends Number> Number sum(T1 num1, T2 num2){
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T1 extends Number, T2 extends Number> Number subtract(T1 num1, T2 num2){
        return num1.doubleValue() - num2.doubleValue();
    }
    
    public static <T1 extends Number, T2 extends Number> Number multiply(T1 num1, T2 num2){
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T1 extends Number, T2 extends Number> Number divide(T1 num1, T2 num2){
        if(num2.doubleValue() == 0) throw new RuntimeException("Divide on 0");
        return num1.doubleValue() / num2.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(sum(1,1f));
        System.out.println(sum(1,1.000003));

        System.out.println(subtract(1,1f));
        System.out.println(subtract(1,1.000003));

        System.out.println(multiply(2,1f));
        System.out.println(multiply(2,1.000003));

        System.out.println(divide(2,1f));
        System.out.println(divide(2,1.000003));
        System.out.println(divide(2,0));
    }

}
