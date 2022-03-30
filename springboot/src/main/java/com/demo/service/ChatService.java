package com.demo.service;
import java.util.List;
import com.demo.entity.Chat;
import com.demo.common.Assist;
public interface ChatService{
	/**
	 * 获得Chat数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getChatRowCount(Assist assist);
	/**
	 * 获得Chat数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Chat> selectChat(Assist assist);
	/**
	 * 获得一个Chat对象,以参数Chat对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Chat selectChatByObj(Chat obj);
	/**
	 * 通过Chat的id获得Chat对象
	 * @param id
	 * @return
	 */
    Chat selectChatById(Integer id);
	/**
	 * 插入Chat到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertChat(Chat value);
	/**
	 * 插入Chat中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyChat(Chat value);
	/**
	 * 批量插入Chat到数据库
	 * @param value
	 * @return
	 */
    int insertChatByBatch(List<Chat> value);
	/**
	 * 通过Chat的id删除Chat
	 * @param id
	 * @return
	 */
    int deleteChatById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Chat
	 * @param assist
	 * @return
	 */
    int deleteChat(Assist assist);
	/**
	 * 通过Chat的id更新Chat中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateChatById(Chat enti);
 	/**
	 * 通过辅助工具Assist的条件更新Chat中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateChat(Chat value,  Assist assist);
	/**
	 * 通过Chat的id更新Chat中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyChatById(Chat enti);
 	/**
	 * 通过辅助工具Assist的条件更新Chat中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyChat(Chat value, Assist assist);
}