package com.demo.user;

import com.alibaba.fastjson.JSON;
import com.demo.BaseController;
import com.demo.common.Assist;
import com.demo.entity.Chat;
import com.demo.entity.Userinfo;
import com.demo.service.ChatService;
import com.demo.service.UserinfoService;
import com.demo.utils.AppReponseJsonUtils;
import com.demo.utils.BMPLoader;
import com.demo.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主要用于处理用户信心
 */
@RestController
@RequestMapping("/")
public class UserContoller extends BaseController {
     @Autowired
    private UserinfoService userService;
    @Autowired
     private ChatService chatService;




    /**
     * @return
     */
    @PostMapping(value = "register")
    public Map regest(@RequestBody Userinfo userinfo) {

//

        Map map=new HashMap();
        Userinfo user=new Userinfo();
        user.setUsername(userinfo.getUsername());
        if (userService.selectUserinfoByObj(user)!=null){
            return AppReponseJsonUtils.setFail(map,"该用户名已存在");
        }else{
            userService.insertUserinfo(userinfo);
        }
        return AppReponseJsonUtils.setData(map);
    }


    /**
     * @return
     */
    @PostMapping(value = "update")
    public Map update(@RequestBody Userinfo userinfo) {

//

        Map map=new HashMap();
//        Userinfo user=new Userinfo();
        userService.updateUserinfoById(userinfo);
        return AppReponseJsonUtils.setData(map);
    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping(value= "login")
    public Map logint(@RequestBody Userinfo userinfo, HttpServletResponse response) {
        Map map=new HashMap();

        Userinfo user=new Userinfo();
        user.setUsername(userinfo.getUsername());
        user.setPassword(userinfo.getPassword());
        Userinfo newUser=userService.selectUserinfoByObj(user);
        newUser.set_id(newUser.getId()+"");
        if (newUser!=null){
            Cookie cookie=new Cookie("user_id",newUser.getId()+"");
            response.addCookie(cookie);

            map.put("data",newUser);
            return AppReponseJsonUtils.setData(map);
        }else{
            return AppReponseJsonUtils.setFail(map,"The user name and password are incorrect");

        }
    }
    /**
     * 用户登录
     * @return
     */
    @GetMapping(value= "user")
    public Map getAll(@RequestParam String type) {
        Map map=new HashMap();

        Assist assist=new Assist();
        assist.setRequires(Assist.andEq("type",type));
        map.put("data",userService.selectUserinfo(assist));
        return AppReponseJsonUtils.setData(map);
    }

    /**
     * 获取创建聊天记录
     * @return
     */
    @PostMapping(value= "read")
    public Map read(@RequestParam String chat_id) {
        Map map=new HashMap();

        Assist assist=new Assist();
        assist.setRequires(Assist.andEq("chat_id",chat_id));
        Chat chat=new Chat();
        chat.setChatId(chat_id);
        if (chatService.selectChatByObj(chat)==null){
            chatService.insertChat(chat);
            Chat chat12=  chatService.selectChatByObj(chat);
            map.put("data",chat12);
        }else {
            map.put("data",chatService.selectChatByObj(chat));
        }



        return AppReponseJsonUtils.setData(map);
    }
    /**
     * 获取创建聊天记录
     * @return
     */
    @PostMapping(value= "msglist")
    public Map msglist() {
        Map map=new HashMap();

        Assist assist=new Assist();
        map.put("data",chatService.selectChat(assist));



        return AppReponseJsonUtils.setData(map);
    }
}
