package com.cabinet.services.db;

import com.cabinet.services.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ServiceDB  extends  ConnectionDB {

    public static ServiceDB ourInstance = new ServiceDB();

    public static ServiceDB getInstance() {
        return ourInstance;
    }

    private ServiceDB() {

    }

    public void insertMedicamentDB(String denumire) throws IOException {


        try {
            Statement statement = connection.createStatement();
            statement.execute("insert into medicament(denumire) values (" + denumire + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectMedicamentBD() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" select * from medicament");


        ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();

        while (resultSet.next()) {
            System.out.println("denumire" + resultSet.getString(1));
        }
    }

    public void insertPacientDB(String nume, String telefon, String adresa, Integer varsta) throws IOException {

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("insert into pacient(nume, telefon, adresa, varsta) values (" + nume + ", '" + telefon+ "', '" + adresa + "', "+varsta+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectPacientBD() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" select * from pacient");


        ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();

        while (resultSet.next()) {
            System.out.println("nume=" + resultSet.getString(2)
                    + ", telefnon=" + resultSet.getString(3)
                    + ", adresa=" + resultSet.getString(4)
                    + ", varsta=" + resultSet.getInt(5));
        }
    }


    public void stergeMedicamentBd( String denumire ) throws IOException {


        String sql = "delete from medicament where name=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql); // query parametrizat
            pst.setString(1, denumire);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void stergePacientBD_dupaNume(String nume) throws IOException {

        String sql = "delete from pacient where name=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, nume);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updatePacientBD_dupaNume(String nume, String telefon) throws IOException {

        String sql = "update pacient set telefon=? where nume='" + nume+ "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, telefon);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
