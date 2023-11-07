package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        JANUARY(31),
        FEBRUARY( 28),
        MARCH( 31),
        APRIL( 30),
        MAY( 31),
        JUNE( 30),
        JULY( 31),
        AUGUST( 31),
        SEPTEMBER( 30),
        OCTOBER( 31),
        NOVEMBER( 30),
        DECEMBER( 31);
    
        private final int numDays;
    
        private int getNumDays() {
            return numDays;
        }
    
        public static Month fromString(String prefixMonth){
            Month matchedMonth = null;
            int counter = 0;
            for (Month month : Month.values()) {
                if(month.name().startsWith(prefixMonth.toUpperCase())){
                    matchedMonth = month;
                    counter++;
                }
                if(counter > 1){
                    throw new IllegalArgumentException("Ambiguos month prefix");
                }
            }
            if(counter == 0){
                throw new IllegalArgumentException("matched not found");
            }
            return matchedMonth;
        }
    
    
        private Month(int numDays){
            this.numDays = numDays;
        }
    }
    

    public MonthSorterNested(){
        super();
    }

    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            public int compare(String first, String second) {               
                return Month.fromString(first).getNumDays() - Month.fromString(second).getNumDays();
            }
            
        };
    }

    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            public int compare(String first, String second) {                            
                return Month.fromString(first).ordinal() - Month.fromString(second).ordinal();
            }
            
        };
    }
}
