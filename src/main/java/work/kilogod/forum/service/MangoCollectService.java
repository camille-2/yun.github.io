package work.kilogod.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.kilogod.forum.mapper.MangoCollectMapper;
import work.kilogod.forum.model.MangoCollect;
import work.kilogod.forum.util.SameService;

import java.util.List;

@Service
public class MangoCollectService extends SameService<MangoCollect> {

    @Autowired
    private MangoCollectMapper mangoCollectMapper;

    public List<MangoCollect> getAllCollectionMessageByUserId(Integer userId) {
        return mangoCollectMapper.getAllCollectionMessageByUserId(userId);
    }
}
