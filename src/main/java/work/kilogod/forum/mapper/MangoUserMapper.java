package work.kilogod.forum.mapper;

import tk.mybatis.mapper.common.Mapper;
import work.kilogod.forum.model.MangoUser;

public interface MangoUserMapper extends Mapper<MangoUser> {

    Integer insertUserMessage(MangoUser mangoUser);

}