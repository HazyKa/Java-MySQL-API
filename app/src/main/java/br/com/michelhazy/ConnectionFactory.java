package br.com.michelhazy;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "121531";
    private static final String DATABESE_URL = "jdbc:mysql://localhost:3306/consultacep";

    public static Connection createConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABESE_URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception{
        Connection conn = createConnection();

        if(conn != null){
            System.out.println("Concetado");
            conn.close();
        }
    }
}