package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.model.MangoNewMessage;
import work.kilogod.forum.model.MangoUser;
import work.kilogod.forum.service.MangoNewMessageService;
import work.kilogod.forum.service.MangoUserService;

@RestController
public class AddAdminReplyController {

    @Autowired
    private MangoUserService mangoUserService;
    @Autowired
    private MangoNewMessageService mangoNewMessageService;

    @Transactional
    @PostMapping("/addNewMessageByAdmin/{adminId}/{messageId}/{messageUserId}")
    public Integer addNewMessageByAdmin(@PathVariable Integer adminId, @PathVariable Integer messageId, @PathVariable Integer messageUserId, @RequestBody String newMessage) {
        MangoUser admin = mangoUserService.getById(adminId);
        if (admin.getUserIsAdmin() != 2) {
            return 400;
        }

        MangoNewMessage mangoNewMessage = new MangoNewMessage();
        mangoNewMessage.setNewMessageDetail(newMessage);
        mangoNewMessage.setMessageId(messageId);
        mangoNewMessage.setUserId(messageUserId);
        mangoNewMessage.setNewMessageType(3);
        mangoNewMessageService.add(mangoNewMessage);

        return 200;
    }


}
