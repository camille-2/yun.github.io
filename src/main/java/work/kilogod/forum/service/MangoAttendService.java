package work.kilogod.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.kilogod.forum.mapper.MangoAttendMapper;
import work.kilogod.forum.model.MangoAttend;
import work.kilogod.forum.util.SameService;

import java.util.List;

@Service
public class MangoAttendService extends SameService<MangoAttend> {

    @Autowired
    private MangoAttendMapper mangoAttendMapper;

    public List<MangoAttend> getAllAttendMessageByUserId(Integer id) {
        return mangoAttendMapper.getAllAttendMessageByUserId(id);
    }
}
