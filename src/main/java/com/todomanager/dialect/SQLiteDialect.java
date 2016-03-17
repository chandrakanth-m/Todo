/*
 * The author disclaims copyright to this source code.  In place of
 * a legal notice, here is a blessing:
 *
 *    May you do good and not evil.
 *    May you find forgiveness for yourself and forgive others.
 *    May you share freely, never taking more than you give.
 *
 */
package com.todomanager.dialect;
/**
 *
 */
import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class SQLiteDialect extends Dialect {

	/**
  *
  */
	public SQLiteDialect() {
		super();
		registerColumnType(Types.BIT, "integer");
		registerColumnType(Types.TINYINT, "tinyint");
		registerColumnType(Types.SMALLINT, "smallint");
		registerColumnType(Types.INTEGER, "integer");
		registerColumnType(Types.BIGINT, "integer");
		registerColumnType(Types.FLOAT, "float");
		registerColumnType(Types.REAL, "real");
		registerColumnType(Types.DOUBLE, "double");
		registerColumnType(Types.NUMERIC, "numeric");
		registerColumnType(Types.DECIMAL, "decimal");
		registerColumnType(Types.CHAR, "char");
		registerColumnType(Types.VARCHAR, "varchar");
		registerColumnType(Types.LONGVARCHAR, "longvarchar");
		registerColumnType(Types.DATE, "date");
		registerColumnType(Types.TIME, "time");
		registerColumnType(Types.TIMESTAMP, "datetime");
		registerColumnType(Types.BINARY, "blob");
		registerColumnType(Types.VARBINARY, "blob");
		registerColumnType(Types.LONGVARBINARY, "blob");
		// registerColumnType(Types.NULL, "null");
		registerColumnType(Types.BLOB, "blob");
		registerColumnType(Types.CLOB, "clob");
		registerColumnType(Types.BOOLEAN, "integer");
		//registerHibernateType(Types.TIMESTAMP, "date");

		registerFunction("concat", new VarArgsSQLFunction(StandardBasicTypes.STRING, "",
				"||", ""));
		registerFunction("mod", new SQLFunctionTemplate(StandardBasicTypes.INTEGER,
				"?1 % ?2"));
		registerFunction("substr", new StandardSQLFunction("substr",
                StandardBasicTypes.STRING));
		registerFunction("substring", new StandardSQLFunction("substr",
                StandardBasicTypes.STRING));
	}

	public boolean supportsIdentityColumns() {
		return true;
	}

	/*
	 * public boolean supportsInsertSelectIdentity() { return true; // As
	 * specify in NHibernate dialect }
	 */

	public boolean hasDataTypeInIdentityColumn() {
		return false; // As specify in NHibernate dialect
	}

	/*
	 * public String appendIdentitySelectToInsert(String insertString) { return
	 * new StringBuffer(insertString.length()+30). // As specify in NHibernate
	 * dialect append(insertString).
	 * append("; ").append(getIdentitySelectString()). toString(); }
	 */

	public String getIdentityColumnString() {
		return "INTEGER";
		// return "integer";
	}

	public String getIdentitySelectString() {
		return "select last_insert_rowid()";
	}

	public boolean supportsLimit() {
		return true;
	}

	public String getLimitString(String query, boolean hasOffset) {
		return new StringBuffer(query.length() + 20).append(query).append(
				hasOffset ? " limit ? offset ?" : " limit ?").toString();
	}

	public boolean supportsTemporaryTables() {
		return true;
	}

	public String getCreateTemporaryTableString() {
		return "create temporary table if not exists";
	}

	public boolean dropTemporaryTableAfterUse() {
		return false;
	}

	public boolean supportsCurrentTimestampSelection() {
		return true;
	}

	public boolean isCurrentTimestampSelectStringCallable() {
		return false;
	}

	public String getCurrentTimestampSelectString() {
		return "select current_timestamp";
	}

	public boolean supportsUnionAll() {
		return true;
	}

	public boolean hasAlterTable() {
		return false; // As specify in NHibernate dialect
	}

	public boolean dropConstraints() {
		return false;
	}

	public String getAddColumnString() {
		return "add column";
	}

	public String getForUpdateString() {
		return "";
	}

	public boolean supportsOuterJoinForUpdate() {
		return false;
	}

	public String getDropForeignKeyString() {
		throw new UnsupportedOperationException(
				"No drop foreign key syntax supported by SQLiteDialect");
	}

	public String getAddForeignKeyConstraintString(String constraintName,
			String[] foreignKey, String referencedTable, String[] primaryKey,
			boolean referencesPrimaryKey) {
		throw new UnsupportedOperationException(
				"No add foreign key syntax supported by SQLiteDialect");
	}

	public String getAddPrimaryKeyConstraintString(String constraintName) {
		throw new UnsupportedOperationException(
				"No add primary key syntax supported by SQLiteDialect");
	}

	public boolean supportsIfExistsBeforeTableName() {
		return true;
	}

	public boolean supportsCascadeDelete() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.dialect.Dialect#getTypeName(int, int, int, int)
	 */
	public String getTypeName(int code, int length, int precision, int scale)
			throws HibernateException {
		// TODO Auto-generated method stub
		return super.getTypeName(code, length, precision, scale);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.dialect.Dialect#getTypeName(int)
	 */
	public String getTypeName(int code) throws HibernateException {
		// TODO Auto-generated method stub
		System.out.println(super.getTypeName(code) + ":" + code);
		return super.getTypeName(code);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.dialect.Dialect#registerColumnType(int, int, java.lang.String)
	 */
	protected void registerColumnType(int code, int capacity, String name) {
		// TODO Auto-generated method stub
		super.registerColumnType(code, capacity, name);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.dialect.Dialect#registerColumnType(int, java.lang.String)
	 */
	@Override
	protected void registerColumnType(int code, String name) {
		// TODO Auto-generated method stub
		super.registerColumnType(code, name);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.dialect.Dialect#registerHibernateType(int, int, java.lang.String)
	 */
	protected void registerHibernateType(int code, int capacity, String name) {
		// TODO Auto-generated method stub
		System.out.println(code + "," + capacity + "," + name);
		super.registerHibernateType(code, capacity, name);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.dialect.Dialect#registerHibernateType(int, java.lang.String)
	 */
	@Override
	protected void registerHibernateType(int code, String name) {
		// TODO Auto-generated method stub
		System.out.println(code + "," +  name);
		super.registerHibernateType(code, name);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.dialect.Dialect#registerKeyword(java.lang.String)
	 */
	@Override
	protected void registerKeyword(String word) {
		// TODO Auto-generated method stub
		super.registerKeyword(word);
	}


}
