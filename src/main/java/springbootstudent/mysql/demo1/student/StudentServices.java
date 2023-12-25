package springbootstudent.mysql.demo1.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    
    public void addNewStudent(Student student) throws Exception {
        Optional<Student> studentOptional = 
            studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
            throw new IllegalStateException("=============================================================email taken=======================================================");
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id))
            throw new IllegalStateException("student with id="+id +"doesn't exist");
        else 
            studentRepository.deleteById(id);
    }
}
