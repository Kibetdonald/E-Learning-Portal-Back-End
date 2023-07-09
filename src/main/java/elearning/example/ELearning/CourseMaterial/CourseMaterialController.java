package elearning.example.ELearning.CourseMaterial;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-materials")
public class CourseMaterialController {

    private final CourseMaterialService courseMaterialService;

    @Autowired
    public CourseMaterialController(CourseMaterialService courseMaterialService) {
        this.courseMaterialService = courseMaterialService;
    }

    @GetMapping
    public List<CourseMaterialModel> getAllCourseMaterials() {
        return courseMaterialService.getAllCourseMaterials();
    }

    @GetMapping("/{id}")
    public CourseMaterialModel getCourseMaterialById(@PathVariable Long id) {
        return courseMaterialService.getCourseMaterialById(id);
    }

    @PostMapping
    public CourseMaterialModel createCourseMaterial(@RequestBody CourseMaterialModel courseMaterial) {
        return courseMaterialService.createCourseMaterial(courseMaterial);
    }

    @PutMapping("/{id}")
    public CourseMaterialModel updateCourseMaterial(@PathVariable Long id, @RequestBody CourseMaterialModel courseMaterial) {
        return courseMaterialService.updateCourseMaterial(id, courseMaterial);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseMaterial(@PathVariable Long id) {
        courseMaterialService.deleteCourseMaterial(id);
    }
}
