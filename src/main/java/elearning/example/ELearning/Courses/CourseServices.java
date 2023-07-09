package elearning.example.ELearning.Courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseModel getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));
    }

    public CourseModel createCourse(CourseModel course) {
        return courseRepository.save(course);
    }

    public CourseModel updateCourse(Long id, CourseModel updatedCourse) {
        CourseModel course = getCourseById(id);
        course.setTitle(updatedCourse.getTitle());
        course.setDescription(updatedCourse.getDescription());
        course.setImage(updatedCourse.getImage());
        course.setCategory(updatedCourse.getCategory());
        course.setTags(updatedCourse.getTags());
        course.setLanguage(updatedCourse.getLanguage());
        course.setInstructorId(updatedCourse.getInstructorId());
        course.setStartDate(updatedCourse.getStartDate());
        course.setEndDate(updatedCourse.getEndDate());
        course.setDuration(updatedCourse.getDuration());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        CourseModel course = getCourseById(id);
        courseRepository.delete(course);
    }
}
