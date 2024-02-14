package Sem4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Spravochnik {
    private String type;
    private boolean flagWithFilter;
    private List<Sotrudnik> list = new ArrayList<>();
    
    public Spravochnik(){
        this(false);
    }

    public Spravochnik(boolean withFilter){
        this(withFilter, "");
    }
    
    public Spravochnik(boolean withFilter, String filterName){
        flagWithFilter = withFilter;
        if(!flagWithFilter)
            type = " полный, без фильтра";        
        else{
            type = " - выборка, с фильтром";
            if(filterName != null && filterName.length() > 1) type += " [по " + filterName + "]";
        } 
    }

    public void add(Sotrudnik employee){
        //Если это выборка из справочника, нам не надо терять ссылку на объект в полном стправочнике, как и не надо менять табельный номер, ложим сотрудника в справочник, как так есть
        if(flagWithFilter){
            list.add(employee);
        } else {
            Integer tabelID = getMaxTableID() + 1;
            Sotrudnik employeeWithTabelID = new Sotrudnik.Builder(employee).setTabelID(tabelID).build();
            list.add(employeeWithTabelID);
        }
    }

    public Integer getMaxTableID(){
        if(list.size() == 0) return 0;
        Integer result = list.get(0).getTabelID();
        for(int i = 1; i < list.size(); i++){
            Integer tmp = list.get(i).getTabelID();
            if (tmp > result) {result = tmp;}
        }
        if(result == null) return 0;
        return result;
    }

    //Все сотрудники с данным Табельным номером
    public Spravochnik getEmployeeByTabelID(Integer tabelID){
        Spravochnik result = new Spravochnik(true, "табельному номеру: " + tabelID);
        for (Sotrudnik employee : list) {
            if(employee.getTabelID().equals(tabelID)) result.add(employee);
        }
        return result;
    }

    //Все сотрудники с данным Телефонным номером
    public Spravochnik getEmployeeByTel(String tel){
        Spravochnik result = new Spravochnik(true, "телефонному номеру: " + tel);
        for (Sotrudnik employee : list) {
            if(employee.getTel().equals(tel)) result.add(employee);
        }
        return result;
    }

    //Все сотрудники с данным именем
    public Spravochnik getEmployeeByName(String name){
        Spravochnik result = new Spravochnik(true, "имени: " + name);
        for (Sotrudnik employee : list) {
            if(employee.getName().equals(name)) result.add(employee);
        }
        return result;
    }

    //Все сотрудники с данным диапазоном волного стажа в днях
    public Spravochnik getEmployeeByTotalExpirience(int begin, int end){
        Spravochnik result = new Spravochnik(true, "ПОЛНОМУ стажу в днях: от " + begin + " до " + end);
        for (Sotrudnik employee : list) {
            int totalExpirience = employee.getAllExperience();
            if(totalExpirience >= begin && totalExpirience <= end) result.add(employee);
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("Справочник работников" + type + ": ");
        if(list.size() == 0) result.append("пуст");
        else {
            for(Sotrudnik employee : list){
                result.append("\n - " + employee);
            }
        }
        result.append("\n = Всего записей: " + list.size());
        return result.toString();
    }

    
    
}
