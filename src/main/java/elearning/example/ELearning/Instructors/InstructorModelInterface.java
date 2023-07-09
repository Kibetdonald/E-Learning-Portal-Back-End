package elearning.example.ELearning.Instructors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorModelInterface extends JpaRepository<InstructorModel, Long> {
}
