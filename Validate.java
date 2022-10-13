
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);

    /*
        purpose: check whether the user inputted a valid option
        author: vietchhe170297
        date: 11/10/2022
     */
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /*
        purpose: check whether the user inputted a blank string
        author: vietchhe170297
        date: 11/10/2022
     */
    public static String checkBlankString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /*
        purpose: check whether the user inputted a valid string
        author: vietchhe170297
        date: 11/10/2022
     */
    public static String checkValidString(String choice) {
        String option1 = "U", option2 = "D";

        while (true) {
            if (choice.equalsIgnoreCase(option1) || choice.equalsIgnoreCase(option2)) {
                return choice;
            } else {
                System.out.println("You can only enter either U or D");
                System.out.print("Enter again: ");
                choice = in.nextLine().trim();
            }

        }
    }

    /*
        purpose: check whether the user inputted a valid integer
        author: vietchhe170297
        date: 11/10/2022
     */
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a integer");
                System.out.print("Enter again: ");
            }
        }
    }

    /*
        purpose: used for Y/N
        author: vietchhe170297
        date: 27/09/2022
     */
    public static String checkInputYN() {
        while (true) {
            String result = checkBlankString();

            if (result.equalsIgnoreCase("Y")) {
                return result;
            } else if (result.equalsIgnoreCase("N")) {
                return result;
            }

            System.out.println("Please input y/Y or n/N: ");
            System.out.println("Enter again: ");
        }
    }

    /*
        purpose: used for checking course name
        author: vietchhe170297
        date: 27/09/2022
     */
    public static String checkCourseName(String courseName) {
        String course1 = "Java", course2 = ".NET", course3 = "C/C++";
        while (true) {
            if (courseName.equalsIgnoreCase(course1) || courseName.equalsIgnoreCase(course2) || courseName.equalsIgnoreCase(course3)) {
                return courseName;
            } else {
                System.out.println("The inputted course name is not available.");
                System.out.print("Enter again: ");
                courseName = in.nextLine().trim();

            }
        }
    }

    /*
        purpose: used for checking duplicated ID
        author: vietchhe170297
        date: 27/09/2022
     */
    public static String checkDuplicateID(ArrayList<Student> student, String ID) {
        for (Student s : student) {
            while (ID.equalsIgnoreCase(s.getID())) {
                System.out.println("The inputted ID is already exists");
                System.out.print("Enter another ID: ");
                ID = in.nextLine().trim();
            }
        }

        return ID;
    }

    /*
        purpose: check whether an ID is already existed 
        author: vietchhe170297
        date: 11/10/2022
     */
    public static boolean checkExistingID(ArrayList<Student> student, String code) {
        for (Student d : student) {
            if (code.equalsIgnoreCase(d.getID())) {
                return false;
            }
        }

        return true;
    }
}
