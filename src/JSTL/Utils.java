package JSTL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public static void StringtoArrayListInteger(String str, ArrayList<Integer> arr){
        int i = 0;
        while (str.charAt(i) != ']'){
            i++;
            StringBuilder temp = new StringBuilder("");
            while ((str.charAt(i) != ',') && (str.charAt(i) != ']')){
                temp.append(str.charAt(i));
                i++;
            }
            arr.add(Integer.parseInt(temp.toString()));
            if (str.charAt(i) != ']') i++;
        }
    }

    public static void StringtoArrayListString(String str, ArrayList<String> arr){
        int i = 0;
        while (str.charAt(i) != ']'){
            i++;
            StringBuilder temp = new StringBuilder("");
            while ((str.charAt(i) != ',') && (str.charAt(i) != ']')){
                temp.append(str.charAt(i));
                i++;
            }
            arr.add(temp.toString());
            if (str.charAt(i) != ']') i++;
        }
    }
}

