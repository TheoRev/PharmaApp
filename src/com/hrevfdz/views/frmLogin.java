package com.hrevfdz.views;

import com.hrevfdz.dao.UsersDAO;
import com.hrevfdz.models.Users;
import com.hrevfdz.services.IPharmacy;
import com.sun.awt.AWTUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class frmLogin extends javax.swing.JFrame {

    private List<Users> usuarios;
    private Users usuario;
    private Timer timer;

    /**
     * Creates new form Login
     */
    public frmLogin() {
        initComponents();
//        this.setTitle("Login - PharmaSystem");
        this.setLocationRelativeTo(null);
//        AWTUtilities.setWindowOpaque(this, false);
        pbarIndicador.setVisible(false);
        usuario = new Users();
    }

    public class Progreso implements Runnable {

        @Override
        public void run() {
            int n;

            for (int i = 1; i <= 100; i++) {
                pbarIndicador.setValue(i);
                pbarIndicador.repaint();
                n = pbarIndicador.getValue();
//                System.out.println("n: " + n);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }

                if (pbarIndicador.getValue() == 100) {
                    frmPrincipal princioal = new frmPrincipal();
                    princioal.setVisible(true);
                    frmLogin.this.dispose();
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pbarIndicador = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jLabel1.setText("Usuario");

        jLabel2.setText("Password");

        btnIngresar.setBackground(new java.awt.Color(34, 115, 156));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/login-24.png"))); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(188, 159, 72));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/cancelar-24.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pbarIndicador.setBackground(new java.awt.Color(0, 204, 204));
        pbarIndicador.setForeground(new java.awt.Color(0, 204, 204));
        pbarIndicador.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pbarIndicador, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(pbarIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        usuario.setUsername(txtUser.getText());
        usuario.setPassword(txtPass.getText());
        final String query = "select u from Users u where u.username='" + usuario.getUsername()
                + "' and u.password='" + usuario.getPassword() + "'";
        IPharmacy<Users> dao = new UsersDAO();

        try {
            if (!txtUser.getText().equals("") || !txtPass.equals("")) {
                List<Users> lista = dao.findByQuery(query);
                if (lista.size() == 1) {
                    for (Users u : lista) {
                        if (u.getUsername().equals(usuario.getUsername())
                                && u.getPassword().equals(usuario.getPassword())) {
                            pbarIndicador.setVisible(true);
                            new Thread(new Progreso()).start();
                        } else {
                            txtPass.setText("");
                            txtUser.requestFocus();
                            showWarningError();
                        }
                    }
                } else {
                    txtPass.setText("");
                    txtUser.requestFocus();
                    showWarningError();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios", "Campos vacios", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void showWarningError() {
        JOptionPane.showMessageDialog(this, "Usuario o Password incorrectos", "No se pudo autentificar", JOptionPane.WARNING_MESSAGE);
    }

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar pbarIndicador;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
