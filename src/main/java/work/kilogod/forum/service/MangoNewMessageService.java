package work.kilogod.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.kilogod.forum.mapper.MangoNewMessageMapper;
import work.kilogod.forum.model.MangoNewMessage;
import work.kilogod.forum.util.SameService;

import java.util.List;

@Service
public class MangoNewMessageService extends SameService<MangoNewMessage> {


    @Autowired
    private MangoNewMessageMapper mangoNewMessageMapper;

    public List<MangoNewMessage> getAllNewMessage(Integer userId) {
        return mangoNewMessageMapper.getAllNewMessage(userId);
    }

    public MangoNewMessage getLastNewMessage(Integer id) {
        return mangoNewMessageMapper.getLastNewMessage(id);
    }
}
