/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoracarros;

import java.util.ArrayList;
import modelo.dao.HibernateDAO;
import modelo.dao.NewHibernateUtil;
import modelo.vo.Marca;
import modelo.vo.Usuario;
import org.hibernate.Session;

public class LocadoraCarros {

    public static void main(String[] args) {
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        Session sessao = NewHibernateUtil.getSessionFactory().openSession();
        HibernateDAO<Marca> dao = new HibernateDAO<Marca>(Marca.class, sessao);
        String sql = "select * from Marca where descricao like ?";
        String[] atributos = new String[]{"descricao"};
        String[] valores = new String[]{""+"%"};
        marcas = (ArrayList<Marca>) dao.getListBySQL(sql, atributos, valores);
        for (Marca m : marcas) {
            System.out.println(m);

        }
    }

}
