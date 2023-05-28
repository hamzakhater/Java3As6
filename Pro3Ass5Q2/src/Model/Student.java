import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Student {

    @Id
    private Integer id;
    private String name;
    private String major;
    private double grade;
    @JoinTable(
            name = "Registration",
            joinColumns = @JoinColumn(name = "studentID"),
            inverseJoinColumns = @JoinColumn(name = "courseID"))
    @OneToMany
    List<Course> courses;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", major=" + major + ", grade=" + grade + '}';
    }
}
