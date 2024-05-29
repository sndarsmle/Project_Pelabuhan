/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAODataAdmin.AdminDAO;
import DAOImplement.AdminImplement;
import Model.DataAdmin;
import javax.swing.JOptionPane;
import view.loginAdminView;
import view.registerAdminView;

/**
 *
 * @author acer
 */
public class AdminRegisterController {
    registerAdminView frame;
    AdminImplement implDataAdmin;
    
    public AdminRegisterController(registerAdminView frame) {
        this.frame = frame;
        this.implDataAdmin = new AdminDAO();
    }
    
    public void AdminRegister() {
        String nama = frame.getTfNamaR().getText();
        String nip = frame.getTfNipR().getText();
        String password = new String(frame.getJpPasswordA().getPassword());
        String confirmPassword = new String(frame.getJpComfirmPasswordA().getPassword());
        
        if(nama.isEmpty() || nip.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Harap isi semua bidang!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
         }
        
        if (password.equals(confirmPassword)) {
            DataAdmin da = new DataAdmin();
            da.setNama(nama);
            da.setNip(nip);
            da.setPassword(password); 
            
            implDataAdmin.adminRegister(da);
            frame.dispose();
            new loginAdminView().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Password dan Konfirmasi Password tidak cocok", "Error", JOptionPane.ERROR_MESSAGE); 
            return;
        }
    }
    
}
