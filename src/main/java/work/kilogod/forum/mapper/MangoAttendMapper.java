package work.kilogod.forum.mapper;

import tk.mybatis.mapper.common.Mapper;
import work.kilogod.forum.model.MangoAttend;

import java.util.List;

public interface MangoAttendMapper extends Mapper<MangoAttend> {
    List<MangoAttend> getAllAttendMessageByUserId(Integer id);
}