package elearning.example.ELearning.CourseMaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialService {
    private final CourseMaterialRepository courseMaterialRepository;

    @Autowired
    public CourseMaterialService(CourseMaterialRepository courseMaterialRepository) {
        this.courseMaterialRepository = courseMaterialRepository;
    }

    public CourseMaterialModel createCourseMaterial(CourseMaterialModel courseMaterial) {
        return courseMaterialRepository.save(courseMaterial);
    }

    public CourseMaterialModel getCourseMaterialById(Long id) {
        return courseMaterialRepository.findById(id)
                .orElseThrow(() -> new CourseMaterialNotFoundException("Course material not found"));
    }

    public List<CourseMaterialModel> getAllCourseMaterials() {
        return courseMaterialRepository.findAll();
    }

    public CourseMaterialModel updateCourseMaterial(Long id, CourseMaterialModel updatedCourseMaterial) {
        CourseMaterialModel existingCourseMaterial = getCourseMaterialById(id);
        existingCourseMaterial.setType(updatedCourseMaterial.getType());
        existingCourseMaterial.setTitle(updatedCourseMaterial.getTitle());
        existingCourseMaterial.setContent(updatedCourseMaterial.getContent());
        return courseMaterialRepository.save(existingCourseMaterial);
    }

    public void deleteCourseMaterial(Long id) {
        CourseMaterialModel courseMaterial = getCourseMaterialById(id);
        courseMaterialRepository.delete(courseMaterial);
    }
}
