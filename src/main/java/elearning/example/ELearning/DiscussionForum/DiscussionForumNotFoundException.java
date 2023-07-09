package elearning.example.ELearning.DiscussionForum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiscussionForumNotFoundException extends RuntimeException {
    public DiscussionForumNotFoundException(String message) {
        super(message);
    }
}