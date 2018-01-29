package sangu;

public class ColumnDataTypeMapper {
	private String dataType;
	private boolean isPrimaryKey;
	private boolean isNOTNULL;
	private String columnName;
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}
	public void setIsPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	public boolean getIsNOTNULL() {
		return isNOTNULL;
	}
	public void setIsNOTNULL(boolean isNOTNULL) {
		this.isNOTNULL = isNOTNULL;
	}
	
}

