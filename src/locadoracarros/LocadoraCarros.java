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
import visao.TelaInicial;

public class LocadoraCarros {

    public static void main(String[] args) {
        new TelaInicial().setVisible(true);
    }

}
