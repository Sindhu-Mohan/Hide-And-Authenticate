public class UserRegistration extends javax.swing.JFrame {
//Creates new form UserRegistration
  private static LoggerUtil log = new LoggerUtil();

    public UserRegistration() {
        initComponents();
    }    

private void registerActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handlingcode here:
        log.addLog("Entry of registration method");
        if (validateFields()) {
            String pvtKey = RandomInteger.main(10);
            
            String retUname, retPwd, retRePwd, retAddr, retMailId, retPhno;
            String pubKey = RandomInteger.main(10);

            boolean validFields = false;
            String groupId = RandomInteger.main(10);
            String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

            if (mailId.getText().trim().matches(EMAIL_REGEX)) {
                validFields = true;
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email address");
                validFields = false;
            }
            if (phno.getText().trim().length() == 10) {
                validFields = true;
            } else {
                JOptionPane.showMessageDialog(this, "Invalid phone number length");
                validFields = false;
            }
            //Validate mobile number as number
            try {
                Long.parseLong(phno.getText().trim());
                validFields = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Phone number:-" + phno.getText().trim());
                nfe.printStackTrace();
                validFields = false;
                JOptionPane.showMessageDialog(this, "Invalid phone number");
            }

            if (validFields) {
                Map<String, String> datas = new HashMap();

                retUname = userName.getText().trim();
                retPwd = pwd.getText().trim();
                retRePwd = rePwd.getText().trim();
                retAddr = addr.getText().trim();
                retMailId = mailId.getText().trim();
                retPhno = phno.getText().trim();

                datas.put("userName", retUname);
                datas.put("pwd", retPwd);
                datas.put("addr", retAddr);
                datas.put("mailid", retMailId);
                datas.put("phno", retPhno);
                datas.put("pvtKey", pvtKey);
                datas.put("pubKey", pubKey);
                datas.put("groupId", groupId);

                JOptionPane.showMessageDialog(this, "Primary key is :-" + pubKey);
                JOptionPane.showMessageDialog(this, "Secondary key is :-" + pvtKey);
                JOptionPane.showMessageDialog(this, "Access key is :-" + groupId);

                log.addLog("Persisting user details");
                PersistUserDetails.persistData(datas);
                log.addLog("User details persisted");
                JOptionPane.showMessageDialog(this, "User registered successfully in the                  system");
                dispose();
                new UserLogin().main();
            } else {
                log.addLog("Error in validating fields");
                JOptionPane.showMessageDialog(this, "Please check the input fields");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid fields");
        }
        log.addLog("Exit of the registration method");
    }                                        

    public boolean validateFields() {
        boolean valid = false;
        if (userName.getText().isEmpty() || pwd.getText().isEmpty()
                || rePwd.getText().isEmpty() || mailId.getText().isEmpty()
                || addr.getText().isEmpty() || phno.getText().isEmpty()) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public void clearFields() {
        userName.setText("");
        addr.setText("");
        pwd.setText("");
        rePwd.setText("");
        mailId.setText("");
        phno.setText("");
    }
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        System.exit(0);
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
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                log.addLog("Entry of User Registrtaion page");
                new UserRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField addr;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mailId;
    private javax.swing.JTextField phno;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPasswordField rePwd;
    private javax.swing.JButton register;
    private javax.swing.JTextField userName;
    // End of variables declaration                   
}   
