/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAODataTiket;

import DAOImplement.TiketImplement;
import Model.DataTiket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author acer
 */
public class TiketDAO implements TiketImplement{
    Connection connection; 

    final String select = "SELECT * FROM tiket";
    final String update = "UPDATE tiket SET jam = ? WHERE kode = ?";
    final String delete = "DELETE FROM tiket WHERE kode = ?";
    
    // Konstruktor untuk menginisialisasi koneksi
    public TiketDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(DataTiket p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(DataTiket p) {
        try {
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, p.getJam());
            ps.setInt(2, p.getKode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TiketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(DataTiket p) {
        try {
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, p.getKode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TiketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<DataTiket> getAll() {
        List<DataTiket> dt = new ArrayList<>();
        try {
            Statement st = connection.createStatement(); // Menggunakan metode createStatement yang benar
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                DataTiket tiket = new DataTiket();
                tiket.setKode(rs.getInt("kode"));
                tiket.setPlat(rs.getString("plat"));
                tiket.setAsal(rs.getString("asal"));
                tiket.setTujuan(rs.getString("tujuan"));
                tiket.setGolongan(rs.getInt("golongan"));
                tiket.setJam(rs.getString("jam"));
                dt.add(tiket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dt;
    }
}
