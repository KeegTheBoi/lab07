package it.unibo.nestedenum;

import java.util.Comparator;

import it.unibo.nestedenum.enums.Month;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public MonthSorterNested(){
        super();
    }

    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            public int compare(String first, String second) {               
                return Month.valueOf(first).getNumDays() - Month.valueOf(second).getNumDays();
            }
            
        };
    }

    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            public int compare(String first, String second) {  
                Month c = Month.fromString(first);  
                int cs = c.getIdM();           
                return Month.valueOf(first).getIdM() - Month.valueOf(second).getIdM();
            }
            
        };
    }
}
