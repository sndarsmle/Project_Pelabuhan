/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.adminDashboardView;
import DAODataTiket.TiketDAO;
import Model.DataTiket;
import Model.ModelTabelTiket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author acer
 */
public class TiketController {
    adminDashboardView frame;
    TiketDAO implDataTiket;
    List<DataTiket> dt;
    
    public TiketController(adminDashboardView frame) {
        this.frame = frame;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pelabuhan", "root", "");
            implDataTiket = new TiketDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dt = implDataTiket.getAll();
    }
    
    public void isitabel() {
        dt = implDataTiket.getAll();
        ModelTabelTiket mt = new ModelTabelTiket(dt);
        frame.getTabelTiket().setModel(mt);
    }
    
    
    
    public void updateTiket(DataTiket tiket) {
        try {
            implDataTiket.update(tiket);
            JOptionPane.showMessageDialog(frame, "Update sukses!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Update gagal: " + e.getMessage());
        }
        isitabel();
    }
    
    public void deleteTiket(DataTiket tiket) {
        try {
            implDataTiket.delete(tiket);
            JOptionPane.showMessageDialog(frame, "Hapus sukses!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Hapus gagal: " + e.getMessage());
        }
        isitabel();
    }
}
