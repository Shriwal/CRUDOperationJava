import java.sql.*;

public class CrudOperation 
{	
	public static void main( String args[])
	{
		connectDB();
		createDB();
		insertDB();
		selectDB();
		deleteDB();
		selectDB();
	}
	
	public static void connectDB()
	{
		Connection c = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:STULP.db");
			System.out.println("SQLite DB connected");
		}
		catch (Exception e)
		{	
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public static void createDB()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:STULP.db");
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = "CREATE TABLE web_blog" +
						 "(ID INTEGER PRIMARY KEY autoincrement," +
						 " NAME		CHAR(50)	NOT NULL," +
						 " message	TEXT		NOT NULL," +
						 "data_added datatime)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);	
		}
	}
	
	public static void insertDB()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:STULP.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = "INSERT INTO web_blog(NAME,message,data_added)" +
						 "VALUES('Ken', 'Bitte', datetime())," +
						 "		('Ben', 'Fragen', datetime())," +
						 "		('Ten', 'es tut mir leid', datetime())," +
						 "		('Ankit', 'keine Problem', datetime())," +
						 "		('Shriwal', 'keine ahnung', datetime())" ;
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);	
		}
	}
	
	public static void selectDB()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:STULP.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = "Select * from web_blog LIMIT 3";
			ResultSet rs  = stmt.executeQuery(sql);
			while ( rs.next() )
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String message = rs.getString("message");
				String data_added = rs.getString("data_added");
				System.out.println("ID : " + id);
				System.out.println("Name : " + name);
				System.out.println("Message : " + message);
				System.out.println("Date Added : " + data_added);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);	
		}
		System.out.println("Operation Done successfully");
	}
	
	public static void deleteDB()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:STULP.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			
			stmt =  c.createStatement();
			String sql = "DELETE from web_blog where ID=1";
			stmt.executeUpdate(sql);
			c.commit();
			
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);	
		}
		System.out.println("Operation Done successfully");
	}
}



