package biblioteca;

import java.util.Calendar;
//Classe de suporte para calculos usando datas (Calendar)
public class DateManagement {
    //Esse recurso pode ser útil em outro momento
    //Calcular dias entre calendários
    public int daysBetweenDates(Calendar firstDate, Calendar secondDate){

        if (firstDate.get(Calendar.YEAR) == secondDate.get(Calendar.YEAR)) {
            return Math.abs(firstDate.get(Calendar.DAY_OF_YEAR) - secondDate.get(Calendar.DAY_OF_YEAR));
        } else {
            if (secondDate.get(Calendar.YEAR) > firstDate.get(Calendar.YEAR)) {
                Calendar temp = firstDate;
                firstDate = secondDate;
                secondDate = temp;
            }
            int extraDays = 0;
    
            int firstDateDaysOfYear = firstDate.get(Calendar.DAY_OF_YEAR);
    
            while (firstDate.get(Calendar.YEAR) > secondDate.get(Calendar.YEAR)) {
                firstDate.add(Calendar.YEAR, -1);
                extraDays += firstDate.getActualMaximum(Calendar.DAY_OF_YEAR);
            }
    
            return extraDays - secondDate.get(Calendar.DAY_OF_YEAR) + firstDateDaysOfYear ;
        }
    }
}
