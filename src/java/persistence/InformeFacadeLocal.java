/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Informe;

/**
 *
 * @author andres
 */
@Local
public interface InformeFacadeLocal {

    void create(Informe informe);

    void edit(Informe informe);

    void remove(Informe informe);

    Informe find(Object id);

    List<Informe> findAll();

    List<Informe> findRange(int[] range);

    int count();
    
}
