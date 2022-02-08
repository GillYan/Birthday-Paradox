import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws Exception {
        // declare variables
        GregorianCalendar cal;
        
        cal = getRandDOB();

        System.out.println(cal.get(GregorianCalendar.YEAR) + "-" + (cal.get(GregorianCalendar.MONTH) + 1) + "-" + cal.get(GregorianCalendar.DAY_OF_MONTH));
    }

    /**
     * Generate and return a random date of birth between 1922 and 2022
     * @return  A GregorianCalendar variable with a randomly generated date
     */
    private static GregorianCalendar getRandDOB() {
        // declare variables
        GregorianCalendar cal;
        int iYear, iDay;

        // initialize variables
        cal = new GregorianCalendar();
        iYear = getRand(1922, 2022);
        cal.set(GregorianCalendar.YEAR, iYear);
        iDay = getRand(1, cal.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        cal.set(GregorianCalendar.DAY_OF_YEAR, iDay);

        return cal;
    }


    /**
     * Returns a randomly generated number between min and max.
     * @param min   The lowest possible number to return
     * @param max   The highest possible number to return.
     * @return      A number between min and max.
     */
    private static int getRand(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
