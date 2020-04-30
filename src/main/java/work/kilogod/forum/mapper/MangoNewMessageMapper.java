package work.kilogod.forum.mapper;

import tk.mybatis.mapper.common.Mapper;
import work.kilogod.forum.model.MangoNewMessage;

import java.util.List;

public interface MangoNewMessageMapper extends Mapper<MangoNewMessage> {

    List<MangoNewMessage> getAllNewMessage(Integer id);


    MangoNewMessage getLastNewMessage(Integer id);
}