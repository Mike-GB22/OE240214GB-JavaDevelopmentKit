//2024.02.15 mip24
package Sem3;

import java.util.Arrays;

public class CompareArrays {

    public static <T1, T2> boolean compareArrays(T1[] a1, T2[] a2){
        if(a1.length != a2.length) return false;
        for(int i = 0; i < a1.length; i++){
            String classNameArray1 = a1[i].getClass().getName();
            String classNameArray2 = a2[i].getClass().getName();
            if(!classNameArray1.equals(classNameArray2)) return false;
        }
        return true;
    }

    public static <T1, T2> String getTextOfCompareArrays(T1[] a1, T2[] a2){
        StringBuilder rersult = new StringBuilder("\n-----------------------");
        rersult.append("\nArray 1: " + Arrays.toString(a1));
        rersult.append("\nArray 2: " + Arrays.toString(a2));
        rersult.append("\ncompareArrays(): " + compareArrays(a1, a2));
        rersult.append("\n");

        return rersult.toString();
    }

    public static void main(String[] args) {
        Number[] array1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] array2 = {1, 2, 3, 4, 5, 6, 7};
        Double[] array3 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};

        System.out.println(getTextOfCompareArrays(array1, array2));
        System.out.println(getTextOfCompareArrays(array1, array3));

        Number[] array4 = {1, 2.0, 3, 4, 5, 6, 7.0};
        Number[] array5 = {1, 2.0, 3, 4, 5, 6, 7.0};

        System.out.println(getTextOfCompareArrays(array4, array5));


    }
}
