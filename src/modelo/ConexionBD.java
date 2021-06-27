package modelo;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConexionBD
{
    private static ConexionBD dataSource = null;
    private Connection con;

    private ConexionBD()
    {
        Properties conProperties = new Properties();

        try
        {
            conProperties.load(new FileInputStream("data/connection.properties"));

            String url = conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Successful connection");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ConexionBD getInstance()
    {
        if (dataSource == null){
            dataSource = new ConexionBD();
        }
        return dataSource;
    }

    public boolean runExecuteUpdate(String sql)
    {

        int rows=0;
        try {
            Statement statement = con.createStatement();
            rows = statement.executeUpdate(sql);
            System.out.println("Successful query: "+sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Query error: "+e.getMessage());
            return false;
        }
    }
}
