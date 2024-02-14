//2024.02.14 mip24
package Sem4;

import java.util.Date;
import java.util.Formatter;

public class Sotrudnik{
    private Integer tabelID;
    private String name;
    private int oldStag;   //Сумарный стаж на прошлых работах, в днях
    private Date ustroenNaEtuRabotu; //Когда был устроен на эту работу
    private String tel;

    public Sotrudnik(String name){
        this.name = name;
    }

    public int getCurrentExperience(){
        return (int) ((new Date().getTime() - ustroenNaEtuRabotu.getTime())/(1000*60*60*24));
    }

    public int getAllExperience(){
        return getCurrentExperience() + oldStag;
    }

    public String getName(){
        return this.name;
    }

    public String getTel(){
        return this.tel;
    }

    public Integer getTabelID(){
        return this.tabelID;
    }

    @Override
    public String toString(){
        StringBuffer result = new StringBuffer();
        result.append(new Formatter().format("Сотрудник [%d]: %s", this.getTabelID(), name));
        result.append(new Formatter().format(", нанят: %d-%d-%d", 
            ustroenNaEtuRabotu.getYear() + 1900,
            ustroenNaEtuRabotu.getMonth() + 1, ustroenNaEtuRabotu.getDate()));
        result.append(", текуий стаж (дней): "+ this.getCurrentExperience());
        result.append(", общий стаж (дней): "+ this.getAllExperience());
        result.append(", телефон: "+ this.getTel());
        return result.toString();
    }

    static class Builder{
        Sotrudnik temp;

        public Builder(String name){
            this.temp = new Sotrudnik(name);
        }

        public Builder(Sotrudnik temp){
            this.temp = temp;
        }

        public Builder setOldExperience(int oldStag){
            temp.oldStag = oldStag;
            return this;
        }

        public Builder setHireDate(Date ustroenNaEtuRabotu){
            temp.ustroenNaEtuRabotu = ustroenNaEtuRabotu;
            return this;
        }
        
        public Builder setHireDateNow(){
            temp.ustroenNaEtuRabotu = new Date();
            return this;
        }

        public Builder setTel(String tel){
            temp.tel = tel;
            return this;
        }        

        public Builder setTabelID(Integer tabelID){
            temp.tabelID = tabelID;
            return this;
        }        

        public Sotrudnik build(){
            return temp;
        }
    }
}