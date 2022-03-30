package com.demo.common;

import java.util.ArrayList;
import java.util.List;

/**
 * This is EUCM's helper class
 * 
 * @author Mirren
 */
public class Assist {
	// déduplication
	private String distinct;
	// tri personnalisé
	private String order;
	// Ligne de début de la pagination des données
	private Integer startRow;
	// Combien de lignes de données sont extraites à chaque fois
	private Integer rowSize;
	// Définir des colonnes de retour personnalisées
	private String resultColumn;
	// ensemble de conditions
	private List<WhereRequire<?>> require = null;

	/**
	 * Classe de condition, l'attribut require est la condition de la colonne, la valeur est la valeur de la condition et le suffixe est la fin
	 * 
	 * @author Mirren
	 */
	public class WhereRequire<T> {
		private String require;// Expressions conditionnelles
		private T value;// valeur unique
		private Object[] values;// plusieurs valeurs
		private String suffix;//déclaration de fin

		public WhereRequire(String require, T value) {
			super();
			this.require = require;
			this.value = value;
		}

		public WhereRequire(String require, T value, String suffix) {
			super();
			this.require = require;
			this.value = value;
			this.suffix = suffix;
		}

		public WhereRequire(String require, String suffix, Object... values) {
			super();
			this.require = require;
			this.values = values;
			this.suffix = suffix;
		}

		public String getRequire() {
			return require;
		}

		public void setRequire(String require) {
			this.require = require;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Object[] getValues() {
			return values;
		}

		public void setValues(Object[] values) {
			this.values = values;
		}

		public String getSuffix() {
			return suffix;
		}

		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
	}

	/**
	 * La classe de tri est utilisée pour trier le nom de la colonne et le mode est la méthode de tri.,true=asc,false=desc
	 * 
	 * @author Mirren
	 *
	 */
	public class WhereOrder {
		private String column;
		private boolean mode;

		public WhereOrder(String column, boolean mode) {
			super();
			this.column = column;
			this.mode = mode;
		}

		public String getColumn() {
			return column;
		}

		public void setColumn(String column) {
			this.column = column;
		}

		public boolean isMode() {
			return mode;
		}

		public void setMode(boolean mode) {
			this.mode = mode;
		}

	}

	/**
	 * Ajouter des conditions de requête, le paramètre est la classe interne où Require d'Assist, il est recommandé d'utiliser la méthode de condition statique d'Assist pour ajouter des conditions ;
	 * 
	 * @param require
	 *            exemple:Assist.and_lt("id",10),...
	 */
	public Assist setRequires(WhereRequire<?>... require) {
		if (this.require == null) {
			this.require = new ArrayList<Assist.WhereRequire<?>>();
		}
		for (int i = 0; i < require.length; i++) {
			this.require.add(require[i]);
		}
		return this;
	}

	/**
	 * Paramètre (nom de colonne) 1 = paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> andEq(String column, T req) {
		return new Assist().new WhereRequire<T>("and " + column + " = ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 = paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> orEq(String column, T req) {
		return new Assist().new WhereRequire<T>("or " + column + " = ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 <> (différent de) Paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table Nom de la colonne, si le même nom de colonne n'existe pas, vous pouvez lister directement le nom de la colonne
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> andNeq(String column, T req) {
		return new Assist().new WhereRequire<T>("and " + column + " <> ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 <> (différent de) Paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table Nom de la colonne, si le même nom de colonne n'existe pas, vous pouvez lister directement le nom de la colonne
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> orNeq(String column, T req) {
		return new Assist().new WhereRequire<T>("or " + column + " <> ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 < paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> andLt(String column, T req) {
		return new Assist().new WhereRequire<T>("and " + column + "< ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 < paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> orLt(String column, T req) {
		return new Assist().new WhereRequire<T>("or " + column + " < ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 <= paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> andLte(String column, T req) {
		return new Assist().new WhereRequire<T>("and " + column + " <= ", req);
	}

	/**
	 * Nombre (nom de colonne) 1 <= paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> orLte(String column, T req) {
		return new Assist().new WhereRequire<T>("or " + column + " <= ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 > paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utilisez le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> andGt(String column, T req) {
		return new Assist().new WhereRequire<T>("and " + column + " > ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 > paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utilisez le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> orGt(String column, T req) {
		return new Assist().new WhereRequire<T>("or " + column + " > ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 >= paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> andGte(String column, T req) {
		return new Assist().new WhereRequire<T>("and " + column + " >= ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 >= paramètre (condition) 2 ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> orGte(String column, T req) {
		return new Assist().new WhereRequire<T>("or " + column + " >= ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 comme 'paramètre (condition) 2' ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> andLike(String column, T req) {
		return new Assist().new WhereRequire<T>("and " + column + " like ", req);
	}

	/**
	 * Paramètre (nom de colonne) 1 comme 'paramètre (condition) 2' ; si le même nom de colonne existe dans la table, utiliser le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement
	 * 
	 * @param column
	 * @param req
	 * @return
	 */
	public static <T> WhereRequire<T> orLike(String column, T req) {
		return new Assist().new WhereRequire<T>("or " + column + " like ", req);
	}

	/**
	 * Condition de requête personnalisée : paramètre (instruction de début personnalisée) 1 paramètre (valeur de la condition) 2 paramètre (instruction de fin personnalisée) 3
* ; Si le même nom de colonne existe dans la table, utilisez le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement <br>
* Exemple de sous-requête :<br>
* Paramètre 1 = nom de la colonne dans (select renvoie le nom de la colonne à partir du nom de la table où nom de la colonne = <br>
* Paramètre 2= 123456<br>
* paramètre 3= ) <br>
* Supposons qu'il y ait une table utilisateur avec une colonne id et que le résultat soit : <br>
* sélectionnez * à partir de l'utilisateur où l'identifiant se trouve (sélectionnez l'identifiant à partir de l'utilisateur où l'identifiant = 123456)<br>
* <b>Il est important de noter que lorsqu'il y a plus d'une condition dans où, vous devez ajouter et ou ou, selon votre propre situation, utiliser des méthodes surchargées pour plusieurs valeurs</b>
	 * 
	 * @param prefix
	 * @param value
	 * @param suffix
	 * @return
	 */
	public static <T> WhereRequire<T> customRequire(String prefix, T value, String suffix) {
		return new Assist().new WhereRequire<T>(prefix, value, suffix);
	}

	/**
	 ** Conditions de requête personnalisées : paramètre (instruction de début personnalisée) 1 paramètre (valeur de la condition) 2 paramètre (instruction de fin personnalisée) 3
* ; Si le même nom de colonne existe dans la table, utilisez le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement <br>
* Exemple : Assist.customRequire("select in (",")",1,2,3,4)
	 * 
	 * @param prefix
	 * @param suffix
	 * @param value
	 * @return
	 */
	public static <T> WhereRequire<T> customRequire(String prefix, String suffix, Object... value) {
		return new Assist().new WhereRequire<T>(prefix, suffix, value);
	}

	/**
	* Obtenir un objet de tri, trier (nom de colonne) paramètre 1 par paramètre 2 (true=ASC/false=DESC)<br>
* ; Si le même nom de colonne existe dans la table, utilisez le nom de la table. Nom de la colonne, si le même nom de colonne n'existe pas, le nom de la colonne peut être directement <br>
*
	 * @param column
	 *           nom de colonne
	 * @param mode
	 *            Type de tri, true=asc, false=desc
	 * @return
	 */
	public static WhereOrder order(String column, boolean mode) {
		return new Assist().new WhereOrder(column, mode);
	}

	/**
	 * Définissez l'ordre par Assist.order(nom de colonne, méthode de tri)<br>Exemple : assist.setOrder(Assist.order("id",true))//Trier l'identifiant dans l'ordre positif
	 * 
	 * @param column
	 * @param mode
	 */
	public Assist setOrder(WhereOrder... order) {
		if (order == null || order.length == 0) {
			this.order = null;
			return this;
		}
		if (order.length == 1) {
			if (order[0].isMode()) {
				this.order = "order By " + order[0].getColumn() + " asc";
			} else {
				this.order = "order By " + order[0].getColumn() + " desc";
			}
			return this;
		}
		StringBuffer sql = new StringBuffer("order By ");
		for (int i = 0; i < order.length; i++) {
			if (i == 0) {
				if (order[i].isMode()) {
					sql.append(order[i].getColumn() + " asc");
				} else {
					sql.append(order[i].getColumn() + " desc");
				}
			} else {
				if (order[i].isMode()) {
					sql.append(", " + order[i].getColumn() + " asc");
				} else {
					sql.append(", " + order[i].getColumn() + " desc");
				}
			}
		}

		this.order = sql.toString();
		return this;
	}

	/**
	 * s'il faut dédupliquer
	 * 
	 * @return
	 */
	public String getDistinct() {
		return distinct;
	}

	/**
	 * s'il faut dédupliquer
	 * 
	 * @param distinct
	 */
	public Assist setDistinct(boolean distinct) {
		if (distinct) {
			this.distinct = "distinct";
			return this;
		}
		return this;
	}

	/**
	 * être trié
	 * 
	 * @return
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * commencer la ligne de pagination
	 * 
	 * @return
	 */
	public Integer getStartRow() {
		return startRow;
	}

	/**
	 * Définir le nombre de lignes à partir desquelles extraire les données
	 * 
	 * @param startRow
	 */
	public Assist setStartRow(Integer startRow) {
		this.startRow = startRow;
		return this;
	}

	/**
	 * Obtenir le nombre de lignes de données extraites à chaque fois
	 * 
	 * @return
	 */
	public Integer getRowSize() {
		return rowSize;
	}

	/**
	 * Définir la quantité de données à récupérer à chaque fois
	 * 
	 * @param rowSize
	 */
	public Assist setRowSize(Integer rowSize) {
		this.rowSize = rowSize;
		return this;
	}

	/**
	 * get renvoie la colonne spécifiée
	 * 
	 * @return
	 */
	public String getResultColumn() {
		return resultColumn;
	}

	/**
	 * Définir pour renvoyer plusieurs colonnes de la colonne spécifiée séparées par des virgules ; il convient de noter que la colonne renvoyée doit être aliasée et que l'alias est basé sur la colonne de resultMap dans le mappeur ;
     * Généralement le nom de la classe plus le numéro de séquence de l'attribut,
	 * 
	 * @return
	 */
	public Assist setResultColumn(String resultColumn) {
		this.resultColumn = resultColumn;
		return this;
	}

	/**
	 *obtenir un ensemble de conditions
	 * 
	 * @return
	 */
	public List<WhereRequire<?>> getRequire() {
		return require;
	}

	public Assist() {
		super();
	}

	/**
	 * Ce constructeur est utilisé pour utiliser la méthode de condition statique d'Assist pour ajouter dynamiquement des conditions
	 * 
	 * @param require
	 *            exemple:Assist.lt("A.ID",10)...
	 */
	public Assist(WhereRequire<?>... require) {
		super();
		if (this.require == null) {
			this.require = new ArrayList<Assist.WhereRequire<?>>();
		}
		for (int i = 0; i < require.length; i++) {
			this.require.add(require[i]);
		}
	}
}

