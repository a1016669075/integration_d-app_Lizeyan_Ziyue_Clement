package com.demo.dao;
import java.util.List;
import com.demo.common.Assist;
import com.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Param;
public interface UserinfoDao{
	/**
* Pour obtenir le nombre total de lignes de données Userinfo, vous pouvez utiliser l'outil auxiliaire Assist pour effectuer une requête conditionnelle, s'il n'y a pas de condition, passez null	
     * @param assist
	 * @return
	 */
    long getUserinfoRowCount(Assist assist);
	/**
* Pour obtenir l'ensemble de données Userinfo, vous pouvez interroger la condition via l'outil auxiliaire Assist, s'il n'y a pas de condition, passez null	 
     * @param assist
	 * @return
	 */
    List<Userinfo> selectUserinfo(Assist assist);
	/**
* Obtenir un objet Userinfo et interroger avec les propriétés non nulles dans le paramètre objet Userinfo comme condition	 
     * @param obj
	 * @return
	 */
    Userinfo selectUserinfoByObj(Userinfo obj);
	/**
	 * Obtenir l'objet Userinfo par ID Userinfo
	 * @param id
	 * @return
	 */
    Userinfo selectUserinfoById(Integer id);
	/**
* Insérer les informations utilisateur dans la base de données, y compris la valeur nulle	 
     * @param value
	 * @return
	 */
    int insertUserinfo(Userinfo value);
	/**
	 * Insérez les données dont la valeur d'attribut dans Userinfo n'est pas nulle dans la base de données
	 * @param value
	 * @return
	 */
    int insertNonEmptyUserinfo(Userinfo value);
	/**
* Insertion en masse des informations utilisateur dans la base de données, y compris les valeurs nulles	 
	 * @param value
	 * @return
	 */
    int insertUserinfoByBatch(List<Userinfo> value);
	/**
	 * * Supprimer Userinfo par l'identifiant de Userinfo
	 * @param id
	 * @return
	 */
    int deleteUserinfoById(Integer id);
	/**
	 * Suppression des informations utilisateur en fonction de l'état de l'assistance Assist
	 * @param assist
	 * @return
	 */
    int deleteUserinfo(Assist assist);
	/**
	 * Mettre à jour les données dans Userinfo par l'identifiant de Userinfo, y compris les valeurs nulles
	 * @param enti
	 * @return
	 */
    int updateUserinfoById(Userinfo enti);
 	/**
	 * Mettre à jour les données dans Userinfo via les conditions de l'outil auxiliaire Assist, y compris les valeurs nulles
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateUserinfo(@Param("enti") Userinfo value, @Param("assist") Assist assist);
	/**
	 * Mettre à jour les données dont l'attribut n'est pas nul dans Userinfo par l'id de Userinfo
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUserinfoById(Userinfo enti);
 	/**
	 * Mettre à jour les données dont l'attribut n'est pas nul dans Userinfo via la condition de l'outil auxiliaire Assist
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyUserinfo(@Param("enti") Userinfo value, @Param("assist") Assist assist);
}