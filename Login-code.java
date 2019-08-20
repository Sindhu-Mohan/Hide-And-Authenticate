package com.nura.ui.view;

import com.nura.ImageHandling.DisplayImage;
import com.nura.db.access.ValidateUser;
import constants.Constants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import logger.LoggerUtil;
public class UserLogin extends javax.swing.JFrame implements Constants {

    private final LoggerUtil log = new LoggerUtil();
    private final ImageIcon imageIcon = DisplayImage.createImageIcon(loginImage);
    /**
     * Creates new form UesrLogin
     */
    public UserLogin() {
        initComponents();
    }
@SuppressWarnings("unchecked")

private void userNameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
 private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        log.addLog("Exit the User Login page");
        System.exit(0);
    }                                    
  private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
log.addLog("Validating the user details");
        boolean validUser = ValidateUser.validateUser(userName.getText().trim(), password.getText());
        log.addLog("Valid user:-"+validUser);
        if(validUser){
            dispose();
            new MenuPage(userName.getText()).main(userName.getText());
        }
    }                                     

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        dispose();
        log.addLog("Calling the sign up page");
        log.addLog("Exit the User Login page");
        new UserRegistration().main();
    }                                      

    
    public void main() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                log.addLog("Entry of the User Login page");
                new UserLogin().setVisible(true);
            }
        });}

    // Variables declaration - do not modify                     
    private javax.swing.JButton exit;
    private javax.swing.JLabel imageLoad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signUp;
    private javax.swing.JTextField userName;
    // End of variables declaration                   
}
