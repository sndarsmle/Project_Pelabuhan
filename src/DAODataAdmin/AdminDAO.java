/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAODataAdmin;

import DAOImplement.AdminImplement;
import Koneksi.ConnectorDB;
import Model.DataAdmin;
import java.sql. *;
import view.adminDashboardView;
import Controller.AdminLoginController;

/**
 *
 * @author acer
 */
public class AdminDAO implements AdminImplement{

    Connection connection;
    
    final String AdminLogin = "SELECT nip FROM admin WHERE nip=? and password=?;"; 
    final String AdminRegister = "INSERT INTO admin (nama, nip, password) VALUES (?, ?, ?);";
    
    public AdminDAO(){
        connection = ConnectorDB.connection();
    }
    
    @Override
    public void adminLogin(DataAdmin p) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
       
            statement = connection.prepareStatement(AdminLogin);
            statement.setString(1, p.getNip());
            statement.setString(2, p.getPassword());
            
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                System.out.println("login berhasil");
                adminDashboardView dashboard = new adminDashboardView();
                dashboard.setVisible(true);
                dashboard.setLocationRelativeTo(null);
    
                
            } else {
                System.out.println("login gagal: NIM atau Password salah");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("login gagal: Terjadi kesalahan SQL");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void adminRegister(DataAdmin p) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(AdminRegister);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getNip());
            statement.setString(3, p.getPassword());
            statement.executeUpdate();
            System.out.println("Register berhasil");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Register gagal: Terjadi kesalahan SQL");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
