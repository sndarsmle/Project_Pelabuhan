/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAODataAdmin.AdminDAO;
import DAOImplement.AdminImplement;
import Model.DataAdmin;
import javax.swing.JOptionPane;
import view.adminDashboardView;
import view.loginAdminView;

/**
 *
 * @author acer
 */
public class AdminLoginController {
    loginAdminView frame;
    AdminImplement implDataAdmin;
   
    public AdminLoginController(loginAdminView frame) {
        this.frame = frame;
        this.implDataAdmin = new AdminDAO();
    }
    
    public void AdminLogin(){
        String nip = frame.getTfNip().getText();
        String password = new String(frame.getTfPasswordA().getPassword());
        
        if(nip.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Lengkapi Data", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        DataAdmin da = new DataAdmin();
        da.setNip(nip);
        da.setPassword(password);
        
        implDataAdmin.adminLogin(da);
        
        
    }
    
}
