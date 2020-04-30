package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.model.MangoCommentReply;
import work.kilogod.forum.service.MangoAttendService;
import work.kilogod.forum.service.MangoCommentReplayService;
import work.kilogod.forum.service.MangoNewMessageService;
import work.kilogod.forum.service.MangoUserService;
import work.kilogod.forum.util.isCommentReply.IsCommentReply;

@RestController
public class AddCommentReplyController {

    @Autowired
    private MangoUserService mangoUserService;
    @Autowired
    private MangoCommentReplayService mangoCommentReplayService;
    @Autowired
    private MangoNewMessageService mangoNewMessageService;
    @Autowired
    private MangoAttendService mangoAttendService;

    @Transactional
    @PostMapping("/addCommentReply/{messageId}")
    public IsCommentReply addCommentReply(@PathVariable Integer messageId, @RequestBody MangoCommentReply mangoCommentReply) {

        return new IsCommentReply().isTrue(messageId, mangoCommentReply, mangoUserService, mangoCommentReplayService, mangoNewMessageService,mangoAttendService);

    }


}
