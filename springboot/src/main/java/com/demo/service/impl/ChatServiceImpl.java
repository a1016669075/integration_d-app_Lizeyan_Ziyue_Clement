package com.demo.service.impl;
import java.util.List;
import com.demo.dao.ChatDao;
import com.demo.entity.Chat;
import com.demo.common.Assist;
import com.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ChatServiceImpl implements ChatService{
    @Autowired
    private ChatDao chatDao;
    @Override
    public long getChatRowCount(Assist assist){
        return chatDao.getChatRowCount(assist);
    }
    @Override
    public List<Chat> selectChat(Assist assist){
        return chatDao.selectChat(assist);
    }
    @Override
    public Chat selectChatByObj(Chat obj){
        return chatDao.selectChatByObj(obj);
    }
    @Override
    public Chat selectChatById(Integer id){
        return chatDao.selectChatById(id);
    }
    @Override
    public int insertChat(Chat value){
        return chatDao.insertChat(value);
    }
    @Override
    public int insertNonEmptyChat(Chat value){
        return chatDao.insertNonEmptyChat(value);
    }
    @Override
    public int insertChatByBatch(List<Chat> value){
        return chatDao.insertChatByBatch(value);
    }
    @Override
    public int deleteChatById(Integer id){
        return chatDao.deleteChatById(id);
    }
    @Override
    public int deleteChat(Assist assist){
        return chatDao.deleteChat(assist);
    }
    @Override
    public int updateChatById(Chat enti){
        return chatDao.updateChatById(enti);
    }
    @Override
    public int updateChat(Chat value, Assist assist){
        return chatDao.updateChat(value,assist);
    }
    @Override
    public int updateNonEmptyChatById(Chat enti){
        return chatDao.updateNonEmptyChatById(enti);
    }
    @Override
    public int updateNonEmptyChat(Chat value, Assist assist){
        return chatDao.updateNonEmptyChat(value,assist);
    }

    public ChatDao getChatDao() {
        return this.chatDao;
    }

    public void setChatDao(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

}