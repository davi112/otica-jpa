/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view;

import javax.swing.*;

/**
 *
 * @author Davi Martins
 */
public class PainelFuncionarioForm extends javax.swing.JFrame {

    /**
     * Creates new form PainelFuncionarioForm
     */
    public PainelFuncionarioForm() {
        initComponents();
        setLookAndFeel();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel(new ImageIcon(getClass().getResource("/logoOtica.png")));
        jMenuBar1 = new javax.swing.JMenuBar();
        menuListagem = new javax.swing.JMenu();
        listaCliente = new javax.swing.JMenuItem();
        menuFunc = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenuItem();
        menuProduto = new javax.swing.JMenuItem();
        menuCadastros = new javax.swing.JMenu();
        menuClienteCadastro = new javax.swing.JMenuItem();
        menuFuncCadastro = new javax.swing.JMenuItem();
        menuVendaCadastro = new javax.swing.JMenuItem();
        menuProdutoCadas = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        btnExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        //jLabel1.setIcon(n); // NOI18N
        jLabel1.setText("jLabel1");

        menuListagem.setText("Listagens");

        listaCliente.setText("Listar Clientes");
        listaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClienteActionPerformed(evt);
            }
        });
        menuListagem.add(listaCliente);

        menuFunc.setText("Listar Funcionários");
        menuListagem.add(menuFunc);

        menuVenda.setText("Listar Vendas");
        menuListagem.add(menuVenda);

        menuProduto.setText("Produto");
        menuListagem.add(menuProduto);

        jMenuBar1.add(menuListagem);

        menuCadastros.setText("Cadastros");

        menuClienteCadastro.setText("Cliente");
        menuCadastros.add(menuClienteCadastro);

        menuFuncCadastro.setText("Funcionario");
        menuCadastros.add(menuFuncCadastro);

        menuVendaCadastro.setText("Venda");
        menuCadastros.add(menuVendaCadastro);

        menuProdutoCadas.setText("Produto");
        menuCadastros.add(menuProdutoCadas);

        jMenuBar1.add(menuCadastros);

        menuUsuario.setText("Usuario");

        menuLogout.setText("Logout");
        menuUsuario.add(menuLogout);

        btnExit.setText("Sair");
        menuUsuario.add(btnExit);

        jMenuBar1.add(menuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaClienteActionPerformed
      
    }//GEN-LAST:event_listaClienteActionPerformed

    private void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PainelFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem listaCliente;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuClienteCadastro;
    private javax.swing.JMenuItem menuFunc;
    private javax.swing.JMenuItem menuFuncCadastro;
    private javax.swing.JMenu menuListagem;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuProduto;
    private javax.swing.JMenuItem menuProdutoCadas;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem menuVenda;
    private javax.swing.JMenuItem menuVendaCadastro;
    // End of variables declaration//GEN-END:variables

    public JMenu getjMenu2() {
        return menuCadastros;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.menuCadastros = jMenu2;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenuItem getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(JMenuItem listaCliente) {
        this.listaCliente = listaCliente;
    }

    public JMenu getMenuListagem() {
        return menuListagem;
    }

    public void setMenuListagem(JMenu menuListagem) {
        this.menuListagem = menuListagem;
    }

    public JMenu getMenuCadastros() {
        return menuCadastros;
    }

    public void setMenuCadastros(JMenu menuCadastros) {
        this.menuCadastros = menuCadastros;
    }

    public JMenuItem getMenuClienteCadastro() {
        return menuClienteCadastro;
    }

    public void setMenuClienteCadastro(JMenuItem menuClienteCadastro) {
        this.menuClienteCadastro = menuClienteCadastro;
    }

    public JMenuItem getMenuFunc() {
        return menuFunc;
    }

    public void setMenuFunc(JMenuItem menuFunc) {
        this.menuFunc = menuFunc;
    }

    public JMenuItem getMenuFuncCadastro() {
        return menuFuncCadastro;
    }

    public void setMenuFuncCadastro(JMenuItem menuFuncCadastro) {
        this.menuFuncCadastro = menuFuncCadastro;
    }

    public JMenuItem getMenuVenda() {
        return menuVenda;
    }

    public void setMenuVenda(JMenuItem menuVenda) {
        this.menuVenda = menuVenda;
    }

    public JMenuItem getMenuVendaCadastro() {
        return menuVendaCadastro;
    }

    public void setMenuVendaCadastro(JMenuItem menuVendaCadastro) {
        this.menuVendaCadastro = menuVendaCadastro;
    }    

    public JMenuItem getMenuProduto() {
        return menuProduto;
    }

    public void setMenuProduto(JMenuItem menuProduto) {
        this.menuProduto = menuProduto;
    }

    public JMenuItem getMenuProdutoCadas() {
        return menuProdutoCadas;
    }

    public void setMenuProdutoCadas(JMenuItem menuProdutoCadas) {
        this.menuProdutoCadas = menuProdutoCadas;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JMenuItem getMenuLogout() {
        return menuLogout;
    }

    public void setMenuLogout(JMenuItem menuLogout) {
        this.menuLogout = menuLogout;
    }

    public JMenu getMenuUsuario() {
        return menuUsuario;
    }

    public void setMenuUsuario(JMenu menuUsuario) {
        this.menuUsuario = menuUsuario;
    }

    public JMenuItem getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JMenuItem btnExit) {
        this.btnExit = btnExit;
    }
    
    
}
