package work.kilogod.forum.util.Upload;

import work.kilogod.forum.model.MangoMessage;
import work.kilogod.forum.model.MangoMessageImages;
import work.kilogod.forum.model.MangoUser;
import work.kilogod.forum.service.MangoMessageDetailService;
import work.kilogod.forum.service.MangoMessageImagesService;
import work.kilogod.forum.service.MangoUserService;

import java.util.List;

public class IsUpload {

    /**
     * 500 服务器错误
     * 200 上传成功
     * 403 不允许发布,拉黑
     * 400 数据出现问题
     * 401  未登录
     * 1000 非法入侵
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public IsUpload isTrue(MangoMessage mangoMessage, MangoMessageDetailService mangoMessageDetailService, MangoMessageImagesService mangoMessageImagesService, MangoUserService mangoUserService) {
        IsUpload isUpload = new IsUpload();

        MangoUser user = mangoUserService.getById(mangoMessage.getUserId());

        if (user == null) {
            isUpload.setCode(1000);
            return isUpload;
        }

        if(user.getUserAllow()!=1){
            isUpload.setCode(301);
            return isUpload;
        }

        List<String> resultImage = mangoMessage.getResultImage();

        mangoMessageDetailService.insertMessageDetail(mangoMessage);

        for (int i = 0; i < resultImage.size(); i++) {
            MangoMessageImages mangoMessageImages = new MangoMessageImages();
            mangoMessageImages.setImageUrl(resultImage.get(i));
            mangoMessageImages.setMessageId(mangoMessage.getMessageId());
            mangoMessageImagesService.add(mangoMessageImages);
        }

        isUpload.setCode(200);

        return isUpload;


    }

}
