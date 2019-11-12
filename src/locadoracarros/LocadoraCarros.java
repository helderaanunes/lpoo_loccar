/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoracarros;

import modelo.dao.HibernateDAO;
import modelo.dao.NewHibernateUtil;
import modelo.vo.Usuario;
import org.hibernate.Session;


public class LocadoraCarros {

 
    public static void main(String[] args) {
        Session sessao = NewHibernateUtil.getSessionFactory().openSession();
        HibernateDAO<Usuario> dao =new HibernateDAO<Usuario>(Usuario.class,sessao);
        Usuario usu = new Usuario();
        usu.setLogin("Monyque");
        usu.setNome("Monyque Lima");
        usu.setSenha("Senha123");
        System.out.println("tentando salvar...");
        dao.save(usu);
        sessao.close();
        System.out.println("salvando...");
    }
    
}



