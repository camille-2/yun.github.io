package work.kilogod.forum.mapper;

import tk.mybatis.mapper.common.Mapper;
import work.kilogod.forum.model.MangoCollect;

import java.util.List;

public interface MangoCollectMapper extends Mapper<MangoCollect> {
    List<MangoCollect>  getAllCollectionMessageByUserId(Integer id);

}