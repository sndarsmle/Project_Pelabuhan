/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author acer
 */
public class ModelTabelTiket extends AbstractTableModel{
    List<DataTiket> dt;
    
    public ModelTabelTiket(List<DataTiket> dt){
        this.dt = dt;
    }

    @Override
    public int getRowCount() {
        return dt.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "KODE TIKET";
            case 1:
                return "PLAT KENDARAAN";
            case 2:
                return "ASAL";
            case 3:
                return "TUJUAN";
            case 4:
                return "GOLONGAN";
            case 5:
                return "JAM KEBERANGKATAN";
            default:
                return null;   
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return dt.get(rowIndex).getKode();
            case 1:
                return dt.get(rowIndex).getPlat();
            case 2:
                return dt.get(rowIndex).getAsal();
            case 3:
                return dt.get(rowIndex).getTujuan();
            case 4:
                return dt.get(rowIndex).getGolongan();
            case 5:
                return dt.get(rowIndex).getJam();
            default:
                return null;   
        }
    }
}
    

