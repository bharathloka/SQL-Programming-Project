package sangu;

import java.util.ArrayList;
import java.util.List;

public class QueryContents {
	private String operationType;//SHOW,USE,CREATE,DROP,INSERT,SELECT
	private String operationContent;//SCHEMA(S), TABLE(S) 
	private ArrayList<String> insertValues;//Values to be inserted
	private ArrayList<String> selectValues;
	private ArrayList<String> columnNames;
	private ArrayList<String> dataTypes;
	private String whereLHS;
	private String whereCondition;
	private String whereRHS;
	private String tableName;
	
	public QueryContents(){
		this.operationType = "";
		this.operationContent ="";
		this.insertValues = new ArrayList<String>();
		this.selectValues = new ArrayList<String>();
		this.whereLHS = "";
		this.whereCondition = "";
		this.whereRHS = "";
	}
	
	public String getOperationType() {
		return operationType;
	}
	
	/**
	 * SHOW,USE,CREATE,DROP,INSERT,SELECT
	 * @param operationType
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	public String getOperationContent() {
		return operationContent;
	}
	
	/**
	 * SCHEMA(S), TABLE(S) 
	 * @param operationContent
	 */
	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
	}
	public List<String> getInsertValues() {
		return insertValues;
	}
	public void setInsertValues(ArrayList<String> insertValues) {
		this.insertValues = insertValues;
	}
	
	public List<String> getSelectValues() {
		return selectValues;
	}

	public void setSelectValues(ArrayList<String> selectValues) {
		this.selectValues = selectValues;
	}
	
	public String getWhereLHS() {
		return whereLHS;
	}
	
	public void setWhereLHS(String whereLHS) {
		this.whereLHS = whereLHS;
	}
	
	public String getWhereCondition() {
		return whereCondition;
	}
	
	public void setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
	}
	
	public String getWhereRHS() {
		return whereRHS;
	}
	
	public void setWhereRHS(String whereRHS) {
		this.whereRHS = whereRHS;
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}

	public ArrayList<String> getDataTypes() {
		return dataTypes;
	}

	public void setDataTypes(ArrayList<String> dataTypes) {
		this.dataTypes = dataTypes;
	}
}
