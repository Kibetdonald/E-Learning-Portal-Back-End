package elearning.example.ELearning.DiscussionForum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionForumServices {
    private final DiscussionForumRepository discussionForumRepository;

    @Autowired
    public DiscussionForumServices(DiscussionForumRepository discussionForumRepository) {
        this.discussionForumRepository = discussionForumRepository;
    }

    public DiscussionForumModel createDiscussionForum(DiscussionForumModel discussionForum) {
        return discussionForumRepository.save(discussionForum);
    }

    public DiscussionForumModel getDiscussionForumById(Long id) {
        return discussionForumRepository.findById(id)
                .orElseThrow(() -> new DiscussionForumNotFoundException("Discussion forum not found"));
    }

    public List<DiscussionForumModel> getAllDiscussionForums() {
        return discussionForumRepository.findAll();
    }

    public DiscussionForumModel updateDiscussionForum(Long id, DiscussionForumModel updatedDiscussionForum) {
        DiscussionForumModel discussionForum = getDiscussionForumById(id);
        discussionForum.setTitle(updatedDiscussionForum.getTitle());
        discussionForum.setDescription(updatedDiscussionForum.getDescription());
        discussionForum.setCreatorId(updatedDiscussionForum.getCreatorId());
        discussionForum.setCreationDate(updatedDiscussionForum.getCreationDate());
        return discussionForumRepository.save(discussionForum);
    }
    public void deleteDiscussionForum(Long id) {
        DiscussionForumModel discussionForum = getDiscussionForumById(id);
        discussionForumRepository.delete(discussionForum);
    }
}
