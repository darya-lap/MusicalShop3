package JSTL;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    StringBuilder listOfInstruments = new StringBuilder();

    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        return sdf.format(new Date());

    }

    public void addToList(String instrument){
        listOfInstruments.append(instrument);
    }
}

