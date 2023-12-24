package springbootstudent.mysql.demo1.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    
    @Query
    Optional<Student> findStudentByEmail(String email);

    // @Override
    // <S extends Student> S save(S student);

}
