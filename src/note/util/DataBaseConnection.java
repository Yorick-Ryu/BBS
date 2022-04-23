package note.util;

import java.sql.* ;

public class DataBaseConnection
{
    private Connection conn	= null ;

    public DataBaseConnection()
    {
        try
        {
            String DBDRIVER = "com.mysql.cj.jdbc.Driver";
            Class.forName(DBDRIVER) ;
            String DBURL = "jdbc:mysql://localhost:3306/notes?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
            String DBUSER = "root";
            String DBPASSWORD = "964538";
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD) ;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Connection getConnection()
    {
        return this.conn ;
    }
    public void close()
    {
        try
        {
            this.conn.close() ;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
