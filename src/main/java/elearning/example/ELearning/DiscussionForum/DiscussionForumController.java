package elearning.example.ELearning.DiscussionForum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/discussion")
public class DiscussionForumController {
    private final DiscussionForumServices discussionForumService;

    @Autowired
    public DiscussionForumController(DiscussionForumServices discussionForumService) {
        this.discussionForumService = discussionForumService;
    }
    @PostMapping
    public ResponseEntity<DiscussionForumModel> createDiscussionForum(@RequestBody DiscussionForumModel discussionForum) {
        DiscussionForumModel createdDiscussionForum = discussionForumService.createDiscussionForum(discussionForum);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscussionForum);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DiscussionForumModel> getDiscussionForumById(@PathVariable Long id) {
        DiscussionForumModel discussionForum = discussionForumService.getDiscussionForumById(id);
        return ResponseEntity.ok(discussionForum);
    }
    @GetMapping
    public ResponseEntity<List<DiscussionForumModel>> getAllDiscussionForums() {
        List<DiscussionForumModel> discussionForums = discussionForumService.getAllDiscussionForums();
        return ResponseEntity.ok(discussionForums);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DiscussionForumModel> updateDiscussionForum(@PathVariable Long id, @RequestBody DiscussionForumModel updatedDiscussionForum) {
        DiscussionForumModel discussionForum = discussionForumService.updateDiscussionForum(id, updatedDiscussionForum);
        return ResponseEntity.ok(discussionForum);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscussionForum(@PathVariable Long id) {
        discussionForumService.deleteDiscussionForum(id);
        return ResponseEntity.noContent().build();
    }
}
