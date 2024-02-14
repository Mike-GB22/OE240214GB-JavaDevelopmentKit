//2024.02.14 mip24
package Sem4;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Sotrudnik.Builder one = new Sotrudnik.Builder("Ivan").setTel("+7777");
        Sotrudnik one = new Sotrudnik.Builder("Ivan").setOldExperience(1000).setHireDateNow().setTel("+7123").build();
        Sotrudnik two = new Sotrudnik.Builder("Petr").setOldExperience(2000).setHireDate(new Date(121, 11, 18)).setTel("+7123123").build();
        Sotrudnik three = new Sotrudnik.Builder("Petr").setOldExperience(1000).setHireDateNow().setTel("+7123").build();
        Sotrudnik four = new Sotrudnik.Builder("Ivan").setOldExperience(2000).setHireDate(new Date(121, 11, 18)).setTel("+7123123").build();

        System.out.println(one);
        System.out.println(two);
        System.out.println("\n------------------");

        Spravochnik spravochnik = new Spravochnik();
        spravochnik.add(one);
        spravochnik.add(two);
        spravochnik.add(three);
        spravochnik.add(four);

        System.out.println(spravochnik);
        
        System.out.println("\n------------------");
        System.out.println(spravochnik.getEmployeeByName("Ivan"));

        System.out.println("\n------------------");
        System.out.println(spravochnik.getEmployeeByTel("+7123"));
        
        System.out.println("\n------------------");
        System.out.println(spravochnik.getEmployeeByTabelID(1));

        System.out.println("\n------------------");
        System.out.println(spravochnik.getEmployeeByTotalExpirience(2000, 3000));


    }
}
