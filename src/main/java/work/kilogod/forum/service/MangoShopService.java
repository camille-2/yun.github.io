package work.kilogod.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.kilogod.forum.mapper.MangoShopMapper;
import work.kilogod.forum.model.MangoShop;
import work.kilogod.forum.util.SameService;

@Service
public class MangoShopService extends SameService<MangoShop> {
    @Autowired
    private MangoShopMapper mangoShopMapper;


}
