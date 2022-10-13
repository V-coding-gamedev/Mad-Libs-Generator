
public class Student implements Comparable<Student> {

    String ID, name, courseName;
    int semester;

    public Student() {
    }

    public Student(String ID, String name, int semester, String courseName) {
        this.ID = ID;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "ID=" + ID + ", name=" + name + ", semester=" + semester + ", courseName=" + courseName;
    }

    public void print() {
        System.out.printf("%-15s%-10s%-15s\n", name, semester, courseName);
    }

    @Override
    public int compareTo(Student t) {
        return t.name.compareTo(this.name);
    }
}
