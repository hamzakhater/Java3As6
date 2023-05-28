package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamza.daqqa.Model.Student;
import com.hamza.daqqa.repositories.StudentRepository;

@RestController
public class MainController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String index() {
        return String.format("%s", "Welcome In Student");
    }

    @RequestMapping("/showAll")
    public String showAll() {
        Student student = new Student();
        student.setId(120204000);
        student.setName("Hamza");
        student.setMajor("English");
        student.setGrade(80);
        studentRepository.save(student);

        List<Student> students = studentRepository.findAll();
        String st = "";
        for (Student s : students)
            st += s + "<br>";
        return String.format("%s", st);
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).get();
        return String.format("%s", student);
    }
}
