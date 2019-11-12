/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author helder
 * @param <T>
 */
public interface InterfaceDAO<T> {
    
    void save(T entity);
    void update(T entity);
    void remove(T entity);
    void merge(T entity);
    T getEntity(Serializable id);
    T getEntityByCriteria(Criteria criteria);
    List<T> getEntities();    
    List<T> getListByCriteria(Criteria criteria);  
    T getEntityBySQL(String sql,String [] parametros,String [] valores);
    List<T> getListBySQL(String sql,String [] parametros,String [] valores);
     void getDeleteBySQL(String sql, String[] parametros, String[] valores) ;
}
