package elearning.example.ELearning.CourseMaterial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseMaterialNotFoundException extends RuntimeException {
    public CourseMaterialNotFoundException(String message) {
        super(message);
    }
}
