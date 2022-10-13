
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> student = new ArrayList<>();

        int size = student.size();

        /*
            purpose: loop until the user want to exit
            author: vietchhe170297
            date: 27/09/2022
         */
        while (true) {
            int choice = Manager.menu();

            if (choice == 5) {
                break;
            }

            switch (choice) {
                case 1:
                    Manager.addStudent(student);
                    break;
                case 2:
                    Manager.findAndSortByName(student);
                    break;
                case 3:
                    Manager.updateOrDelete(size, student);
                    break;
                case 4:
                    Manager.report(student);
                    break;
                case 6:
                    Manager.displayData(student);
                    break;
            }
        }
    }
}
