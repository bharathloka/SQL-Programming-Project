package sangu;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


public class QueryParser {
	public void parseAndExecute(String query) throws IOException, ParseException {
		String[] queryParts = query.split(" ");
		QueryContents contents = new QueryContents();
		if(queryParts[0].equalsIgnoreCase("show") && queryParts[1].equalsIgnoreCase("schemas")){
			RunQuery rQuery = new RunQuery();
			rQuery.displaySchemas();
		}else if(queryParts[0].equalsIgnoreCase("create") && queryParts[1].equalsIgnoreCase("schema")){
			RunQuery rQuery = new RunQuery();
			rQuery.createSchema(queryParts[2]);
		}else if(queryParts[0].equalsIgnoreCase("show") && queryParts[1].equalsIgnoreCase("tables")){
			RunQuery rQuery = new RunQuery();
			rQuery.showTables();
		}else if(queryParts[0].equalsIgnoreCase("use")){
			RunQuery rQuery = new RunQuery();
			rQuery.useSchema(queryParts[1]);
		}else if(queryParts[0].equalsIgnoreCase("create") && queryParts[1].equalsIgnoreCase("table")){
			contents.setTableName(queryParts[2]);
			ArrayList<String> columns = new ArrayList<>();
			ArrayList<String> dataTypes = new ArrayList<>();
			for(int i=3; i < queryParts.length; i++){
				if(queryParts[i].toUpperCase().contains("VARCHAR")){
					String dataType = queryParts[i].substring(0, queryParts[i].length()-1);
					dataTypes.add(dataType);
				}else if(queryParts[i].toUpperCase().contains("CHAR")){
					String dataType = queryParts[i].substring(0, queryParts[i].length()-1);
					dataTypes.add(dataType);
				}else if(queryParts[i].startsWith("(")){
					String columnName = queryParts[i].substring(1);
					columns.add(columnName);
				}else if(queryParts[i].endsWith(",")) {
					String dataType = queryParts[i].substring(0, queryParts[i].indexOf(","));
					dataTypes.add(dataType);
				}else if(queryParts[i].endsWith(")")){
					String dataType = queryParts[i].substring(0, queryParts[i].indexOf(")"));
					dataTypes.add(dataType);
				}else{
					String columnName = queryParts[i];
					columns.add(columnName);
				}
			}
			contents.setColumnNames(columns);
			contents.setDataTypes(dataTypes);
			RunQuery rQuery = new RunQuery();
			rQuery.createTable(contents);
		}else if(queryParts[0].equalsIgnoreCase("insert") && queryParts[1].equalsIgnoreCase("into")) {
			contents.setTableName(queryParts[2]);
			String vals = query.substring(query.indexOf("("), query.length());
			//System.out.println(vals);
			String[] valueParts = vals.split(",");
			for (int i=0;i<valueParts.length;i++)
				System.out.println(valueParts[i]);
			ArrayList<String> values = new ArrayList<>();
			for(int i = 0; i < valueParts.length; i++){
				if(valueParts[i].startsWith("(")){
					String value = valueParts[i].substring(1);
					//System.out.println("Value"+value);
					values.add(value);
				}else if(valueParts[i].endsWith(")")){
					String value = valueParts[i].substring(0, valueParts[i].length()-1);
					//System.out.println("Value"+value);
					values.add(value);
				}else if(valueParts[i].startsWith(" ")){
					String value = valueParts[i].substring(1);
					//System.out.println("Value"+value);
					values.add(value);
				}
				else if(valueParts[i].startsWith("")){
					String value = valueParts[i].substring(0);
					//System.out.println("Value"+value);
					values.add(value);
				}
			}
			contents.setInsertValues(values);
			//System.out.println("values "+values);
			RunQuery rQuery = new RunQuery();
			rQuery.insertIntoTable(contents.getTableName(), values);
		}else if(queryParts[0].equalsIgnoreCase("select") && queryParts[1].equalsIgnoreCase("*") && queryParts[2].equalsIgnoreCase("from")){
			contents.setTableName(queryParts[3]);
			if(queryParts.length > 4){
			contents.setWhereLHS(queryParts[5]);
			contents.setWhereCondition(queryParts[6]);
			contents.setWhereRHS(queryParts[7]);
			}
			RunQuery rQuery = new RunQuery();
			rQuery.selectFromTable(contents);
		}else if(queryParts[0].equalsIgnoreCase("drop") && queryParts[1].equalsIgnoreCase("table")) {
			contents.setTableName(queryParts[2]);
			RunQuery rQuery = new RunQuery();
			rQuery.dropTable(contents);
		}
		else{
			System.out.println("Work on others is still in progress");
		}
	}
}
