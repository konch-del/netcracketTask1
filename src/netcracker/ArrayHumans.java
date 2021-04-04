package netcracker;

import java.util.ArrayList;
import java.util.Calendar;
/*
    Класс, наследуемый от ArrayList и используемый для обработки массива объектов Human
*/
public class ArrayHumans extends ArrayList {
    //Поиск по имени
    public ArrayHumans searchLastName(String lastName){
        ArrayHumans result = new ArrayHumans();
        for(Object i : this){
            /*
              Не придумал ничего лучше downcating, есть ли другой оптимальный способ решения?
            */
            if(((Human) i).getLastName().equals(lastName)){
                result.add(i);
            }
        }
        return result;
    }
    // Поиск по атрибуту адреса
    public ArrayHumans searchByAddress(String address){
        ArrayHumans result = new ArrayHumans();
        for(Object i : this){
            if(((Human) i).getAddress().getCountry().equals(address)){
                result.add(i);
            }
            else if(((Human) i).getAddress().getCity().equals(address)){
                result.add(i);
                }
                else if(((Human) i).getAddress().getStreet().equals(address)) {
                    result.add(i);
                    }
                    else if(((Human) i).getAddress().getHouseNumber().equals(address)) {
                        result.add(i);
                        }
        }
        return result;
    }
    //Поиск людей, с датой рождения винтервале
    public ArrayHumans searchByBirth(Calendar after, Calendar before){
        ArrayHumans result = new ArrayHumans();
        for(Object i : this) {
            if(((Human) i).getDateOfBirth().after(after) && ((Human) i).getDateOfBirth().before(before)){
                result.add(i);
            }
        }
        return result;
    }
    // Поиск самого молодого человека в массиве
    public Human searchYoung(){
        Human young = (Human) this.get(0);
        Calendar date = young.getDateOfBirth();
        for(Object i : this) {
            if(((Human) i).getDateOfBirth().after(date)){
                young = (Human) i;
                date = ((Human) i).getDateOfBirth();
            }
        }
        return young;
    }
    // Поиск самого старого человека в массиве
    public Human searchOld(){
        Human old = (Human) this.get(0);
        Calendar date = old.getDateOfBirth();
        for(Object i : this) {
            if(((Human) i).getDateOfBirth().before(date)){
                old = (Human) i;
                date = ((Human) i).getDateOfBirth();
            }
        }
        return old;
    }
    //Возвращает массив в string
    public String infoToString(){
        String result = "";
        for(Object i : this) {
            result += ((Human) i).info();
            result += "\n";
        }
        return result;
    }

}
