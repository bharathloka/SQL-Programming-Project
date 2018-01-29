package sangu;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class LaunchSanguSql {
	static String prompt = "tadurisql>";
	public static void main(String... args) throws IOException, ParseException {
		//Display the welcome screen and the actions that could be taken up.
		welcomeScreen();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(prompt);
			String userQuery = sc.nextLine();
			userQuery = userQuery.substring(0, userQuery.indexOf(";"));
			if(userQuery.equals("exit")){
				System.exit(0);
			}else if (userQuery.equals("syntax")) {
				showSyntaxes();
			}else{
				initializeDatabase();
				QueryParser parser = new QueryParser();
				parser.parseAndExecute(userQuery);
			}
		}
	}
	
	private static void initializeDatabase() {
		StartUpShutDown schema = new StartUpShutDown();
		schema.initializeSetUp();		
	}
	private static void welcomeScreen() {
		String welcomeMessage="Welcome to sangu sql lite version 0.1!\n";
		welcomeMessage += "Your current login time is:";
		welcomeMessage += new java.util.Date();
		welcomeMessage += "\nThis lite sql version allows you to do the following operations:\n";
		welcomeMessage +="1. SHOW SCHEMAS\n";
		welcomeMessage +="2. CREATE SCHEMA\n";
		welcomeMessage +="3. USE SCHEMA\n";
		welcomeMessage +="4. SHOW TABLES\n";
		welcomeMessage +="5. CREATE TABLE\n";
		welcomeMessage +="6. INSERT INTO TABLE\n";
		welcomeMessage +="7. DROP TABLE\n";
		welcomeMessage +="8. SELECT FROM WHERE\n";
		welcomeMessage += "If you wish to exit, please enter 'exit' and press enter key\n";
		welcomeMessage += "Or if you wish to see the syntax, please enter 'syntax' and press enter key";
		System.out.println(welcomeMessage);
	}
	private static void showSyntaxes() {
		String syntaxes = "/***SHOW SCHEMAS***/\n";
		syntaxes += "SHOW SCHEMAS;\n";
		syntaxes += "***************************\n";
		syntaxes += "/***CREATE SCHEMA***/\n";
		syntaxes += "CREATE SCHEMA <schema_name>;\n";
		syntaxes += "***************************\n";
		syntaxes += "/***USE SCHEMA***/\n";
		syntaxes += "USE <schema_name>;\n";
		syntaxes += "***************************\n";
		syntaxes += "/***SHOW TABLES***/\n";
		syntaxes += "SHOW TABLES;\n";
		syntaxes += "***************************\n";
		syntaxes += "/***CREATE TABLE***/\n";
		syntaxes += "CREATE TABLE <table_name> (<col_name1> <col_type>, <col_name2> <col_type>, <col_name3> <col_type>..);\n";
		syntaxes += "***************************\n";
		syntaxes += "/***INSERT INTO TABLE***/\n";
		syntaxes += "INSERT INTO <table_name> VALUES(val1,val2,val3...);\n";
		syntaxes += "***************************\n";
		syntaxes += "/***DROP TABLE***/\n";
		syntaxes += "DROP TABLE <table_name>;\n";
		syntaxes += "***************************\n";
		syntaxes += "/***SELECT FROM WHERE***/\n";
		syntaxes += "SELECT * FROM <table_name> WHERE <col_name>=val;\n";
		syntaxes += "***************************";
		System.out.println(syntaxes);
	}
}
