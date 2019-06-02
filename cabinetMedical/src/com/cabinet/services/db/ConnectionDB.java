package com.cabinet.services.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ConnectionDB {

    public Statement statement;
    public Connection connection;

    public ConnectionDB(Statement statement, Connection connection) {
        this.statement = statement;
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ConnectionDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myconnection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/cabinet?serverTimezone=UTC",
                            "root", "12345");
            Statement mystatement = myconnection.createStatement();

            this.statement= mystatement;
            this.connection = myconnection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


