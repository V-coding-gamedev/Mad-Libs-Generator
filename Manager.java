
import java.util.*;

public class Manager extends ArrayList<Student> {

    static Scanner sc = new Scanner(System.in);

    /*
        purpose: display the main menu
        author: vietchhe170297
        date: 27/09/2022
     */
    public static int menu() {
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("6. Display all students' info");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 6);

        System.out.println();

        return choice;
    }

    /*
        purpose: used for adding students
        author: vietchhe170297
        date: 27/09/2022
     */
    static void addStudent(ArrayList<Student> student) {

        int count = 1;

        String ID, name, courseName;
        String ans;
        int semester;

        while (true) {
            System.out.println("Student " + count);

            System.out.print("Enter student ID: ");
            ID = Validate.checkBlankString();
            ID = Validate.checkDuplicateID(student, ID);

            System.out.print("Enter name: ");
            name = Validate.checkBlankString();

            System.out.print("Enter semester: ");
            semester = Validate.checkInputInt();

            System.out.print("Enter course name: ");
            courseName = Validate.checkBlankString();
            courseName = Validate.checkCourseName(courseName);

            student.add(new Student(ID, name, semester, courseName));

            System.out.println("Add successfull!");

            System.out.println("");

            count++;

            if (count > 1) {
                System.out.println("Do you want to another student: (Y/N)");
                ans = Validate.checkInputYN();

                if (ans.equalsIgnoreCase("Y")) {
                    System.out.println("");
                    continue;
                } else if (ans.equalsIgnoreCase("N")) {
                    System.out.println("");
                    break;
                }
            }
        }
    }

    /*
        purpose: find and sort by name 
        author: vietchhe170297
        date: 29/09/2022
     */
    public static void findAndSortByName(ArrayList<Student> student) {
        if (student.isEmpty()) {
            System.out.println("The list is currently empty");
            return;
        }

        ArrayList<Student> listStudentFindByName = listStudentFindByName(student);

        if (listStudentFindByName.isEmpty()) {
            System.out.println("The student's name is not exists!\n");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-10s%-15s\n", "Student name", "Semester", "Course name");
            for (Student s : listStudentFindByName) {
                s.print();
            }
            System.out.println();
        }
    }

    /*
        purpose: a sub menu for adding / deleting students
        author: vietchhe170297
        date: 6/10/2022
     */
    public static void updateOrDelete(int size, ArrayList<Student> student) {
        String name, courseName;
        int semester;

        System.out.print("Enter student's ID that needs to update / delete: ");
        String ID = Validate.checkBlankString();

        System.out.println("U. Update");
        System.out.println("D. Delete");
        System.out.print("Enter your choice: ");
        String choice = Validate.checkBlankString();
        choice = Validate.checkValidString(choice);

        /*
            purpose: choose U will let user to update a student's info
            author: vietchhe170297
            date: 6/10/2022
         */
        if (choice.equalsIgnoreCase("U")) {
            if (Validate.checkExistingID(student, ID)) {
                System.out.println("ID not found");
            } else {
                System.out.print("Enter another code: ");
                String idUpdate = Validate.checkBlankString();
                Student s = getStudentByID(student, ID); // hàm này được sử dụng để chỉnh sửa các thông tin của student cần cập nhật 

                System.out.print("Enter another name: ");
                name = Validate.checkBlankString();

                System.out.print("Enter another semester: ");
                semester = Validate.checkInputInt();

                System.out.print("Enter another course name: ");
                courseName = Validate.checkBlankString();
                courseName = Validate.checkCourseName(courseName);

                s.setID(idUpdate);
                s.setName(name);
                s.setSemester(semester);
                s.setCourseName(courseName);

                System.out.println("Update successfully!\n");
            }
        } /*
            purpose: choose D will let user to update a student's info
            author: vietchhe170297
            date: 6/10/2022
         */ else if (choice.equalsIgnoreCase("D")) {
            if (Validate.checkExistingID(student, ID)) {
                System.out.println("ID not found");
            } else {
                Student s = getStudentByID(student, ID);
                student.remove(s);

                System.out.println("Remove successfully");
            }
        }

        System.out.println("");

    }

    /*
        purpose: display student(s) with student's name, course and total of course
        author: vietchhe170297
        date: 06/10/2022
     */
    public static void report(ArrayList<Student> student) {
        ArrayList<String> st_strlist = new ArrayList<>();
        for (Student st : student) {
            st_strlist.add(st.getName() + "|" + st.getCourseName());
        }
        Set<String> st_strset = new HashSet<>(st_strlist);
        ArrayList<String> cour_report = new ArrayList<>();
        Iterator itr = st_strset.iterator();
        while (itr.hasNext()) {
            String row = (String) itr.next();
            cour_report.add(row + "|" + Collections.frequency(st_strlist, row));
        }
        for (String str : cour_report) {
            System.out.println(str);
        }

        System.out.println("");
    }

    /*
        purpose: find student by name  
        author: vietchhe170297
        date: 29/09/2022
     */
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> student) {

        ArrayList<Student> listStudentFindByName = new ArrayList<>();

        System.out.print("Enter student's name to search: ");
        String name = Validate.checkBlankString();

        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).name.contains(name)) {
                listStudentFindByName.add(student.get(i));
            }
        }

        return listStudentFindByName;

    }

    // for debugging (ALSO CAN BE USED FOR FUNCTION 4) 
    public static void displayData(ArrayList<Student> student) {
        for (int i = 0; i < student.size(); i++) {
            System.out.println(student.get(i));
        }

        System.out.println("");
    }

    /*
        purpose: get student's info by ID  
        author: vietchhe170297
        date: 06/10/2022
     */
    public static Student getStudentByID(ArrayList<Student> student, String code) {
        for (Student s : student) {
            if (s.getID().equalsIgnoreCase(code)) {
                return s;
            }
        }
        return null;
    }
}
