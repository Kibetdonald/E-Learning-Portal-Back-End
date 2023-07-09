package elearning.example.ELearning.Enrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final EnrollmentServices enrollmentServices;

    @Autowired
    public EnrollmentController(EnrollmentServices enrollmentServices) {
        this.enrollmentServices = enrollmentServices;
    }
    @PostMapping
    public ResponseEntity<EnrollmentModel> createEnrollment(@RequestBody EnrollmentModel enrollmentModel) {
        EnrollmentModel createEnrollment = enrollmentServices.createEnrollment(enrollmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentModel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentModel> getEnrollmentForumById(@PathVariable Long id) {
        EnrollmentModel enrollmentModel = enrollmentServices.getEnrollmentById(id);
        return ResponseEntity.ok(enrollmentModel);
    }
    @GetMapping
    public ResponseEntity<List<EnrollmentModel>> getAllEnrollment() {
        List<EnrollmentModel> enrollmentModel = enrollmentServices.getAllEnrollment();
        return ResponseEntity.ok(enrollmentModel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentModel> updateEnrollment(@PathVariable Long id, @RequestBody EnrollmentModel updateEnrollment) {
        EnrollmentModel enrollmentModel = enrollmentServices.updateEnrollment(id, updateEnrollment);
        return ResponseEntity.ok(enrollmentModel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentServices.DeleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}

