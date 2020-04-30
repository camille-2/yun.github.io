package work.kilogod.forum.util.isUpdate;

import work.kilogod.forum.model.MangoMessage;
import work.kilogod.forum.model.MangoUser;
import work.kilogod.forum.service.MangoMessageDetailService;
import work.kilogod.forum.service.MangoUserService;

public class IsUpdate {

    private Integer code;

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public IsUpdate isTrue(Integer id, Integer messageId, String message, MangoMessageDetailService mangoMessageDetailService, MangoUserService mangoUserService) {



        IsUpdate isUpdate = new IsUpdate();
        isUpdate.setCode(500);
        MangoUser user = mangoUserService.getById(id);

        if (user == null) {
            isUpdate.setCode(400);
            return isUpdate;
        }
        MangoMessage mangoMessage = new MangoMessage();

        if (user.getUserIsAdmin() == 2) {
            mangoMessage.setMessageId(messageId);
        } else {
            mangoMessage.setMessageId(messageId);
            mangoMessage.setUserId(id);

            Integer count = mangoMessageDetailService.findCount(mangoMessage);

            if (count == 0) {
                isUpdate.setCode(400);
                return isUpdate;
            }
        }
        mangoMessage.setMessageDetail(message);
        mangoMessageDetailService.update(mangoMessage);
        isUpdate.setCode(200);
        return isUpdate;
    }
}
