import java.sql.*;
import javax.swing.*;

public class SqliteConnection {
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rlpla_000\\Downloads\\sqlite-shell-win32-x86-3080704\\OPA.db");
			return c;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

}
