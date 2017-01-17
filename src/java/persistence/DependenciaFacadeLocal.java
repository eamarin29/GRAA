/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Dependencia;

/**
 *
 * @author andres
 */
@Local
public interface DependenciaFacadeLocal {

    void create(Dependencia dependencia);

    void edit(Dependencia dependencia);

    void remove(Dependencia dependencia);

    Dependencia find(Object id);

    List<Dependencia> findAll();

    List<Dependencia> findRange(int[] range);

    int count();
    
}
