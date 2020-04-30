package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.service.MangoAttendService;
import work.kilogod.forum.service.MangoCommentService;
import work.kilogod.forum.service.MangoNewMessageService;
import work.kilogod.forum.service.MangoUserService;
import work.kilogod.forum.util.isComment.IsComment;

@RestController
public class AddCommentController {

    @Autowired
    private MangoUserService mangoUserService;
    @Autowired
    private MangoCommentService mangoCommentService;
    @Autowired
    private MangoNewMessageService mangoNewMessageService;
    @Autowired
    private MangoAttendService mangoAttendService;

    @Transactional
    @PostMapping("/addComment/{userId}/{messageId}/{messageUserId}")
    public IsComment addComment(@PathVariable Integer userId, @RequestBody String userComment, @PathVariable Integer messageId, @PathVariable Integer messageUserId) {
        return new IsComment().isTrue(userId, messageId, userComment, messageUserId, mangoUserService, mangoCommentService, mangoNewMessageService, mangoAttendService);
    }

}
