package work.kilogod.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.kilogod.forum.mapper.MangoUserMapper;
import work.kilogod.forum.model.MangoUser;
import work.kilogod.forum.util.SameService;

import java.util.List;

@Service
public class MangoUserService extends SameService<MangoUser> {

    @Autowired
    private MangoUserMapper mangoUserMapper;

    /**
     * 新用户插入
     *
     * @param mangoUser
     * @return
     */
    public Integer insertUserMessage(MangoUser mangoUser) {
        return mangoUserMapper.insertUserMessage(mangoUser);
    }

    /**
     * 得到符合条件的用户数
     *
     * @param mangoUser
     * @return
     */

    public Integer getUserCount(MangoUser mangoUser) {
        return mangoUserMapper.selectCount(mangoUser);
    }

    /**
     * 更新用户信息
     *
     * @param mangoUser
     */
    public void updateUserMessage(MangoUser mangoUser) {
        mangoUserMapper.updateByPrimaryKey(mangoUser);
    }

    /**
     * 返回符合条件的用户信息
     */
    public List<MangoUser> getUserMessageByOtherMessage(MangoUser mangoUser) {
        return mangoUserMapper.select(mangoUser);
    }

}
