package Connector;

import java.sql.*;

public class sql_connecor {

    public static String dburl = "jdbc:mysql://localhost:3306/individual_project";// add the database name before using
    public static String dbuser = "root";
    public static String dbpass = "";
    public static String driver = "com.mysql.jdbc.Driver";

    public Connection con;
    public Statement st;

    public sql_connecor() throws Exception {
        Class.forName(driver);
        con = DriverManager.getConnection(dburl, dbuser, dbpass);
        st = con.createStatement();
        // this.con = con;
    }
}