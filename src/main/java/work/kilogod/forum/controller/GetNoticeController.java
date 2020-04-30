package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.model.MangoNotice;
import work.kilogod.forum.service.MangoNoticeService;

import java.util.List;

@RestController
public class GetNoticeController {


    @Autowired
    private MangoNoticeService mangoNoticeService;

    @PostMapping("/getMessage/getAllNoticeMessage")

    public List<MangoNotice> getAllNoticeMessage() {
        return mangoNoticeService.findAll();
    }

}
