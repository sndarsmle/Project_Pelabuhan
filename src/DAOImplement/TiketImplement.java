/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;

import Model.DataTiket;
import java.util.List;

/**
 *
 * @author acer
 */
public interface TiketImplement {
    public void insert(DataTiket p);
    public void update(DataTiket p);
    public void delete(DataTiket p);
    public List<DataTiket>getAll();
}
