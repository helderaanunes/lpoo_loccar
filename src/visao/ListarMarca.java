/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.HibernateDAO;
import modelo.dao.NewHibernateUtil;
import modelo.vo.Marca;
import org.hibernate.Session;

/**
 *
 * @author paula
 */
public class ListarMarca extends javax.swing.JPanel {

    /**
     * Creates new form ListarMarca
     */
    ArrayList<Marca> marcas = new ArrayList<Marca>();

    private TelaInicial telaInicial;
    public ListarMarca(TelaInicial telaInicial) {
        initComponents();
        carregarTabela();
        this.telaInicial= telaInicial;
    }

    private void carregarTabela() {
        //pegando as marcas do banco de dados
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        Session sessao = NewHibernateUtil.getSessionFactory().openSession();
        HibernateDAO<Marca> dao = new HibernateDAO<Marca>(Marca.class, sessao);
        String sql = "select * from Marca where descricao like ? order by descricao asc";
        String[] atributos = new String[]{"descricao"};
        String[] valores = new String[]{descricao.getText() + "%"};
        marcas = (ArrayList<Marca>) dao.getListBySQL(sql, atributos, valores);

        //removendo linhas da tabela.
        DefaultTableModel tabela = ((DefaultTableModel) jTable1.getModel());
        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }

        //dicionando linhas da tabela
        for (Marca m : marcas) {
            tabela.addRow(new Object[]{m.getId(), m.getDescricao()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Listar Marcas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Descrição:");

        descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descricaoKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descricao))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descricaoKeyReleased
        carregarTabela();
    }//GEN-LAST:event_descricaoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            // pegar id de quem queremos remover...
            DefaultTableModel tabela = ((DefaultTableModel) jTable1.getModel());
            // pegar valor na linha X e coluna Y
            int id = Integer.parseInt("" + tabela.getValueAt(jTable1.getSelectedRow(), 0));
            //criar o DAO
            ArrayList<Marca> marcas = new ArrayList<Marca>();
            Session sessao = NewHibernateUtil.getSessionFactory().openSession();
            HibernateDAO<Marca> dao = new HibernateDAO<Marca>(Marca.class, sessao);
            //remover o objeto com o id especifico
            String sql = "Delete from Marca where id like ? ";
            String[] atributos = new String[]{"id"};
            String[] valores = new String[]{id + ""};
            dao.getDeleteBySQL(sql, atributos, valores);
            JOptionPane.showMessageDialog(null, "Marca Removida com sucesso.");

            //carregar a tabela novamente.
            carregarTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! nenhuma celula selecionada.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            // pegar id de quem queremos remover...
            DefaultTableModel tabela = ((DefaultTableModel) jTable1.getModel());
            // pegar valor na linha X e coluna Y
            int id = Integer.parseInt("" + tabela.getValueAt(jTable1.getSelectedRow(), 0));
            //criar o DAO
            Session sessao = NewHibernateUtil.getSessionFactory().openSession();
            HibernateDAO<Marca> dao = new HibernateDAO<Marca>(Marca.class, sessao);
            //utilizando o dao para pegar a marca que contenha o id especifico
            Marca marca = dao.getEntity(id);

            JInternalFrame jif = new JInternalFrame("Editar Marca");
            EditarMarca painel = new EditarMarca(marca,telaInicial);
            jif.setSize(400, 300);
            jif.setVisible(true);
            jif.add(painel);
            jif.setClosable(true);
            this.telaInicial.getDesktop().add(jif);
        } else {
            JOptionPane.showMessageDialog(null, "Erro! nenhuma celula selecionada.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descricao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
