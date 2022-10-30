package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

import java.util.Properties;

/**
 * main() class that accesses a SQL database serves as the starter class for
 * Assignment1 of 22F_CST8288 The intent of the assignment is refactor this
 * class into DAO pattern
 *
 * @author kriger
 */
public class DataSource {

    Connection connection = null;

    public DataSource() {
    }

    private Properties loadProperties(String fileName) {

        Properties props = new Properties();

        try ( InputStream in = Files.newInputStream(Paths.get("src/" + fileName));) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }// catch()
        return props;
    }

    public Connection createConnection() {

        /*  step 1: read file into instance of Properties
            and get an instance of Connection
         */
        String fileName = "database.properties";
        Properties props = loadProperties(fileName);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        //try with resources
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}//end of class
