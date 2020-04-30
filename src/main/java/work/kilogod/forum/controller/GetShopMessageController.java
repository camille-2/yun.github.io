package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.model.MangoShop;
import work.kilogod.forum.model.MangoShopBusiness;
import work.kilogod.forum.model.MangoShopImages;
import work.kilogod.forum.service.MangoShopBusinessService;
import work.kilogod.forum.service.MangoShopImagesService;
import work.kilogod.forum.service.MangoShopService;

import java.util.List;

@RestController
public class GetShopMessageController {
    @Autowired
    private MangoShopService mangoShopService;

    @Autowired
    private MangoShopImagesService mangoShopImagesService;
    @Autowired
    private MangoShopBusinessService mangoShopBusinessService;

    @PostMapping("/getMessage/getAllShop")
    public List<MangoShop> getAllShopMessage() {
        return mangoShopService.findAll();
    }

    @PostMapping("/getMessage/getShopMessage/{id}")
    public MangoShop getShopMessageById(@PathVariable Integer id) {
        MangoShop mangoShop = mangoShopService.getById(id);
        MangoShopImages mangoShopImages = new MangoShopImages();
        mangoShopImages.setShopId(id);
        mangoShop.setShopImages(mangoShopImagesService.findList(mangoShopImages));
        MangoShopBusiness mangoShopBusiness = new MangoShopBusiness();
        mangoShopBusiness.setShopId(id);
        mangoShop.setShopBusinesses(mangoShopBusinessService.findList(mangoShopBusiness));
        return mangoShop;
    }

}
