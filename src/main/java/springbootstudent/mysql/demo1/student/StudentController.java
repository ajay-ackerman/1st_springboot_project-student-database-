package springbootstudent.mysql.demo1.student;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("api/v1/std")
public class StudentController {
    public final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices){
        this.studentServices = studentServices;
    }

    @GetMapping
    public java.util.List<Student> getStudent() {
        return studentServices.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) throws Exception {
        //TODO: process POST request
        studentServices.addNewStudent(student);
    }

    @DeleteMapping("{studentId}")
    public  void  deleteStudent(@PathVariable("studentId") Long id ){
        studentServices.deleteStudent(id);

    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestBody Student student) {
        studentServices.updateStudent(id,student);
    }
    
        
}
