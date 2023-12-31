/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Davi Martins
 */
public class ReceitasPorClienteForm extends javax.swing.JFrame {

    /**
     * Creates new form ReceitasPorClienteForm
     */
    public ReceitasPorClienteForm() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        lblOlhoEsquerdo = new javax.swing.JLabel();
        lblOlhoDireito = new javax.swing.JLabel();
        txtOEEsferico = new javax.swing.JTextField();
        txtOEEixo = new javax.swing.JTextField();
        txtOECilindrico = new javax.swing.JTextField();
        txtODEixo = new javax.swing.JTextField();
        txtODEsferico = new javax.swing.JTextField();
        lblCilindrico = new javax.swing.JLabel();
        lblEsferico = new javax.swing.JLabel();
        lbLEixo = new javax.swing.JLabel();
        txtODCilindrico = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txtAdicao = new javax.swing.JTextField();
        lblAdicao = new javax.swing.JLabel();
        lblDnp1 = new javax.swing.JLabel();
        txtDistanciaPupilar = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Receita"));

        lblOlhoEsquerdo.setText("OLHO ESQUERDO");

        lblOlhoDireito.setText("OLHO DIREITO");

        txtOEEsferico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOEEsfericoKeyTyped(evt);
            }
        });

        txtOEEixo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOEEixoKeyTyped(evt);
            }
        });

        txtOECilindrico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOECilindricoKeyTyped(evt);
            }
        });

        txtODEixo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtODEixoKeyTyped(evt);
            }
        });

        txtODEsferico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtODEsfericoKeyTyped(evt);
            }
        });

        lblCilindrico.setText("CILÍNDRICO");

        lblEsferico.setText("ESFÉRICO");

        lbLEixo.setText("EIXO");

        txtODCilindrico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtODCilindricoKeyTyped(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOlhoEsquerdo)
                    .addComponent(lblOlhoDireito))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtODEsferico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOEEsferico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEsferico, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCilindrico)
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtOECilindrico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(txtOEEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(lbLEixo))))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtODCilindrico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(txtODEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(61, Short.MAX_VALUE))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEsferico)
                            .addComponent(lblCilindrico)
                            .addComponent(lbLEixo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOEEsferico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOEEixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOECilindrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblOlhoEsquerdo))
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblOlhoDireito))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtODEsferico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtODCilindrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtODEixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAdicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdicaoKeyTyped(evt);
            }
        });

        lblAdicao.setText("ADIÇÃO");

        lblDnp1.setText("DP");

        txtDistanciaPupilar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDistanciaPupilarKeyTyped(evt);
            }
        });

        btnRemove.setText("REMOVER");

        btnEdit.setText("EDITAR");

        btnSave.setText("SALVAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lblAdicao))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnRemove)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addGap(80, 80, 80)
                                .addComponent(btnSave))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(lblDnp1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDistanciaPupilar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdicao)
                    .addComponent(lblDnp1)
                    .addComponent(txtDistanciaPupilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnEdit)
                    .addComponent(btnSave))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOEEsfericoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOEEsfericoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOEEsfericoKeyTyped

    private void txtOEEixoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOEEixoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOEEixoKeyTyped

    private void txtOECilindricoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOECilindricoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOECilindricoKeyTyped

    private void txtDistanciaPupilarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistanciaPupilarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDistanciaPupilarKeyTyped

    private void txtODEixoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtODEixoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtODEixoKeyTyped

    private void txtODEsfericoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtODEsfericoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtODEsfericoKeyTyped

    private void txtODCilindricoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtODCilindricoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtODCilindricoKeyTyped

    private void txtAdicaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdicaoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdicaoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceitasPorClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceitasPorClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceitasPorClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceitasPorClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceitasPorClienteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbLEixo;
    private javax.swing.JLabel lblAdicao;
    private javax.swing.JLabel lblCilindrico;
    private javax.swing.JLabel lblDnp1;
    private javax.swing.JLabel lblEsferico;
    private javax.swing.JLabel lblOlhoDireito;
    private javax.swing.JLabel lblOlhoEsquerdo;
    private javax.swing.JPanel painelDados;
    private javax.swing.JTextField txtAdicao;
    private javax.swing.JTextField txtDistanciaPupilar;
    private javax.swing.JTextField txtODCilindrico;
    private javax.swing.JTextField txtODEixo;
    private javax.swing.JTextField txtODEsferico;
    private javax.swing.JTextField txtOECilindrico;
    private javax.swing.JTextField txtOEEixo;
    private javax.swing.JTextField txtOEEsferico;
    // End of variables declaration//GEN-END:variables

    
    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator5() {
        return jSeparator5;
    }

    public void setjSeparator5(JSeparator jSeparator5) {
        this.jSeparator5 = jSeparator5;
    }

    public JLabel getLbLEixo() {
        return lbLEixo;
    }

    public void setLbLEixo(JLabel lbLEixo) {
        this.lbLEixo = lbLEixo;
    }

    public JLabel getLblAdicao() {
        return lblAdicao;
    }

    public void setLblAdicao(JLabel lblAdicao) {
        this.lblAdicao = lblAdicao;
    }

    public JLabel getLblCilindrico() {
        return lblCilindrico;
    }

    public void setLblCilindrico(JLabel lblCilindrico) {
        this.lblCilindrico = lblCilindrico;
    }

    public JLabel getLblDnp1() {
        return lblDnp1;
    }

    public void setLblDnp1(JLabel lblDnp1) {
        this.lblDnp1 = lblDnp1;
    }

    public JLabel getLblEsferico() {
        return lblEsferico;
    }

    public void setLblEsferico(JLabel lblEsferico) {
        this.lblEsferico = lblEsferico;
    }

    public JLabel getLblOlhoDireito() {
        return lblOlhoDireito;
    }

    public void setLblOlhoDireito(JLabel lblOlhoDireito) {
        this.lblOlhoDireito = lblOlhoDireito;
    }

    public JLabel getLblOlhoEsquerdo() {
        return lblOlhoEsquerdo;
    }

    public void setLblOlhoEsquerdo(JLabel lblOlhoEsquerdo) {
        this.lblOlhoEsquerdo = lblOlhoEsquerdo;
    }

    public JPanel getPainelDados() {
        return painelDados;
    }

    public void setPainelDados(JPanel painelDados) {
        this.painelDados = painelDados;
    }

    public JTextField getTxtAdicao() {
        return txtAdicao;
    }

    public void setTxtAdicao(JTextField txtAdicao) {
        this.txtAdicao = txtAdicao;
    }

    public JTextField getTxtDistanciaPupilar() {
        return txtDistanciaPupilar;
    }

    public void setTxtDistanciaPupilar(JTextField txtDistanciaPupilar) {
        this.txtDistanciaPupilar = txtDistanciaPupilar;
    }

    public JTextField getTxtODCilindrico() {
        return txtODCilindrico;
    }

    public void setTxtODCilindrico(JTextField txtODCilindrico) {
        this.txtODCilindrico = txtODCilindrico;
    }

    public JTextField getTxtODEixo() {
        return txtODEixo;
    }

    public void setTxtODEixo(JTextField txtODEixo) {
        this.txtODEixo = txtODEixo;
    }

    public JTextField getTxtODEsferico() {
        return txtODEsferico;
    }

    public void setTxtODEsferico(JTextField txtODEsferico) {
        this.txtODEsferico = txtODEsferico;
    }

    public JTextField getTxtOECilindrico() {
        return txtOECilindrico;
    }

    public void setTxtOECilindrico(JTextField txtOECilindrico) {
        this.txtOECilindrico = txtOECilindrico;
    }

    public JTextField getTxtOEEixo() {
        return txtOEEixo;
    }

    public void setTxtOEEixo(JTextField txtOEEixo) {
        this.txtOEEixo = txtOEEixo;
    }

    public JTextField getTxtOEEsferico() {
        return txtOEEsferico;
    }

    public void setTxtOEEsferico(JTextField txtOEEsferico) {
        this.txtOEEsferico = txtOEEsferico;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(JButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }
    
}
