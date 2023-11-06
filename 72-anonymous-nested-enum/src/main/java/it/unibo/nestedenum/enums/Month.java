package it.unibo.nestedenum.enums;


public enum Month {
    January(1, "january", 31),
    February(2, "february", 28),
    March(3, "march", 31),
    April(4, "april", 30),
    May(5, "may", 31),
    June(6, "june", 30),
    July(7, "july", 31),
    August(8, "august", 30),
    September(9, "september", 31),
    October(10, "october", 31),
    November(11, "november", 30),
    December(12, "december", 31);

    private final int idM; 
    private final String name;
    private final int numDays;

    public int getNumDays() {
        return numDays;
    }

    public int getIdM() {
        return idM;
    }

    public String getName() {
        return name;
    }

    public static Month fromString(String mese){
        return Month.valueOf(mese);
    }


    private Month(final int id, final String name, int numDays){
        this.idM = id;
        this.name = name;
        this.numDays = numDays;
    }
}


