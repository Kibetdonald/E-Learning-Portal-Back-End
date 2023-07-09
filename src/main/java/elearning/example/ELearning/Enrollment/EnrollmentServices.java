package elearning.example.ELearning.Enrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServices {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServices(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public EnrollmentModel createEnrollment(EnrollmentModel enrollmentModel) {
        return enrollmentRepository.save(enrollmentModel);
    }

    public EnrollmentModel getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found"));
    }

    public List<EnrollmentModel> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    public EnrollmentModel updateEnrollment(Long id, EnrollmentModel updateEnrollment) {
        EnrollmentModel enrollmentModel = getEnrollmentById(id);
        enrollmentModel.setId(updateEnrollment.getId());
        enrollmentModel.setCourseId(updateEnrollment.getCourseId());
        enrollmentModel.setStudentId(updateEnrollment.getStudentId());
        enrollmentModel.setEnrollmentDate(updateEnrollment.getEnrollmentDate());
        return enrollmentRepository.save(enrollmentModel);
    }
    public void DeleteEnrollment(Long id) {
        EnrollmentModel enrollmentModel = getEnrollmentById(id);
        enrollmentRepository.delete(enrollmentModel);
    }

}

