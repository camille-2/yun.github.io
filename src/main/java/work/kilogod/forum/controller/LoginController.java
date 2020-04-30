package work.kilogod.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.kilogod.forum.model.MangoUser;
import work.kilogod.forum.model.WXSessionModel;
import work.kilogod.forum.service.MangoUserService;
import work.kilogod.forum.util.common.HttpClientUtil;
import work.kilogod.forum.util.common.JsonUtils;
import work.kilogod.forum.util.login.IsLogin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private MangoUserService mangoUserService;

    /**
     * 登录功能
     *
     * @param code
     * @param mangoUser
     * @return
     */
    @Transactional
    @PostMapping("/Login")
    public IsLogin Login(String code, @RequestBody MangoUser mangoUser) {

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<String, String>();
        param.put("appid", "wx18e6c963c65e7b73");
        param.put("secret", "aee7e6b170cbf75d3b476f67c1ef28de");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        WXSessionModel wxSessionModel = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

        String openid = wxSessionModel.getOpenid();
        mangoUser.setUserOpenid(openid);

        return new IsLogin().isTrue(mangoUser, openid, mangoUserService);
    }

    @PostMapping("/checkAdmin")
    public List<MangoUser> checkAdmin(Integer id) {
        MangoUser mangoUser = new MangoUser();
        mangoUser.setUserId(id);
        return mangoUserService.getUserMessageByOtherMessage(mangoUser);
    }
}
