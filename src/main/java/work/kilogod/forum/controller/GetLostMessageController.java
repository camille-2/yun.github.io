package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.model.MangoMessage;
import work.kilogod.forum.service.MangoMessageDetailService;

@RestController
public class GetLostMessageController {
    @Autowired
    private MangoMessageDetailService mangoMessageDetailService;

    @PostMapping("/getMessage/getLostMessage")
    public MangoMessage getLostMessage(){

        return mangoMessageDetailService.getLostMessage();
    }
}
