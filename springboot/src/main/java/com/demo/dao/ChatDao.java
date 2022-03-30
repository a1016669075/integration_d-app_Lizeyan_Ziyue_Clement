package com.demo.dao;
import com.demo.entity.Chat;
import java.util.List;
import com.demo.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface ChatDao{
	/**
* Obtenez le nombre total de lignes de données de chat, vous pouvez utiliser l'outil auxiliaire Assist pour effectuer une requête conditionnelle, s'il n'y a pas de condition, passez en null	 * @param assist
	 * @return
	 */
    long getChatRowCount(Assist assist);
	/**
* Pour obtenir l'ensemble de données de chat, vous pouvez interroger la condition via l'outil auxiliaire Assist, s'il n'y a pas de condition, passez null	 * @param assist
	 * @return
	 */
    List<Chat> selectChat(Assist assist);
	/**
* Obtenez un objet Chat, requête avec l'attribut non vide dans le paramètre Objet Chat comme condition	 * @param obj
	 * @return
	 */
    Chat selectChatByObj(Chat obj);
	/**
	 * Obtenir l'objet Chat par l'identifiant du chat
	 * @param id
	 * @return
	 */
    Chat selectChatById(Integer id);
	/**
	 * Insérer Chat dans la base de données, y compris les valeurs nulles
	 * @param value
	 * @return
	 */
    int insertChat(Chat value);
	/**
	 * Insérez les données dont la valeur d'attribut n'est pas nulle dans Chat dans la base de données
	 * @param value
	 * @return
	 */
    int insertNonEmptyChat(Chat value);
	/**
	 * Insertion par lots de Chat dans la base de données, y compris les valeurs nulles
	 * @param value
	 * @return
	 */
    int insertChatByBatch(List<Chat> value);
	/**
	 * Supprimer le chat par l'identifiant du chat
	 * @param id
	 * @return
	 */
    int deleteChatById(Integer id);
	/**
	 * Suppression conditionnelle de Chat via l'assistant Assist
	 * @param assist
	 * @return
	 */
    int deleteChat(Assist assist);
	/**
	 * Mettre à jour les données dans Chat by Chat's id, y compris les valeurs nulles
	 * @param enti
	 * @return
	 */
    int updateChatById(Chat enti);
 	/**
	 * Mettre à jour les données dans Chat via les conditions de l'outil auxiliaire Assist, y compris les valeurs nulles
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateChat(@Param("enti") Chat value, @Param("assist") Assist assist);
	/**
	 * Mettre à jour les données dont l'attribut n'est pas nul dans le Chat par l'id du Chat
	 * @param enti
	 * @return
	 */
    int updateNonEmptyChatById(Chat enti);
 	/**
	 * Mettre à jour les données dont l'attribut n'est pas nul dans Chat via la condition de l'outil auxiliaire Assist
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyChat(@Param("enti") Chat value, @Param("assist") Assist assist);
}