package elearning.example.ELearning.Courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesInterface extends JpaRepository<CourseModel, Long> {

}
