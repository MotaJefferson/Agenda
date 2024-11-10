package agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    private static String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Agenda;encrypt=true;trustServerCertificate=true;";
    private static String user = "sa";
    private static String password = "P@ssw0rd";
    
    public static Connection conectar()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionString, user, password);            
        }
        catch(Exception ex)
        {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public static void desconectar(Connection con)
    {
        try
        {            
            con.close();            
        }
        catch(Exception ex)
        {
            System.out.println("Erro ao desconectar: "+ ex.getMessage());
        }
    }    
}
