import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int result = 0, runs = 0;
        double avg = 0.0;
        String showDates = null;
        Scanner scan = new Scanner(System.in);

        // ask number of simulations
        do {
            System.out.print("How many times do you want to simulate the problem?\t");
            if (scan.hasNextInt()){
                runs = scan.nextInt();
            }
            
            if (runs <= 0) {
                System.out.println("Please enter a whole number greater than 0\n");
                scan.nextLine();
            }
        } while (runs <= 0);

        // ask whether to show text
        do {
            System.out.print("Do you want to view the generated dates?\t\t");
            showDates = scan.next().toLowerCase();
            
            if (showDates.equals("yes") || showDates.equals("no")) {
                break;
            }
            
            System.out.println("Please either yes or no.\n");
            scan.nextLine();
        } while (showDates != "yes" || showDates != "no");

        // simulate runs number of times
        for (int i = 0; i < runs; i++) {
            result += simulateProblem(showDates);
        }

        // calculate the average times a duplicate birthday was found
        avg = (double)result / runs * 100;

        // output the results
        System.out.println("\n--------------------------------\n");
        System.out.println("Duplicate birthdays were found in " + result + "/" + runs + " simulations");
        System.out.println("This averages out to " + avg + "%");
        scan.close();
    }

    private static int simulateProblem(String showDates) {
        // declare variables
        GregorianCalendar cal;
        Map<DateKey, String> map = new HashMap<>();

        // print divider
        if (showDates.equals("yes")) {
            System.out.println("\n-----------New-----------");
        }

        // generate 23 birthdays and add them to the map
        for (int i = 0; i < 23; i++) {
            String check = null;
            cal = getRandDOB();
            check = map.put(new DateKey(cal.get(GregorianCalendar.MONTH), cal.get(GregorianCalendar.DAY_OF_MONTH)), "Exist");

            // print the date
            if (showDates.equals("yes")) {
                printDOB(cal);
            }

            // duplicate birthday found
            if (check != null) {
                if (showDates.equals("yes")) {
                    System.out.println("Found matching birthday");
                }
                return 1;
            }
        }

        return 0;
    }

    /**
     * Print the info of a Gregorian Calendar variable in format YYYY-MM-DD
     * @param cal   A valid gregorian calendar variable
     */
    private static void printDOB(GregorianCalendar cal) {
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