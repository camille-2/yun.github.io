package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.service.MangoMessageDetailService;
import work.kilogod.forum.service.MangoUserService;
import work.kilogod.forum.util.isUpdate.IsUpdate;

@RestController
public class UpdateMessageByUserIdController {

    @Autowired
    private MangoMessageDetailService mangoMessageDetailService;
    @Autowired
    private MangoUserService mangoUserService;
    @Transactional
    @PostMapping("/updateMessageById/{id}/{messageId}")
    public IsUpdate updateMessageById(@PathVariable Integer id,@PathVariable Integer messageId,@RequestBody String message){


        return new IsUpdate().isTrue(id,messageId,message,mangoMessageDetailService,mangoUserService);
    }
}
