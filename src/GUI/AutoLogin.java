/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import GUI.Dialog.Login_Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @author Pham The Quyen
 */
public class AutoLogin {
    static Login_Dialog dialogLogin;
    public static void main(String[] args) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerMonitorX = (int) (screenSize.getWidth()/2);
            int centerMonitorY = (int) (screenSize.getHeight()/2);
            
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", false);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                }
                dialogLogin = new Login_Dialog(new javax.swing.JFrame(), true,true);
                //caculate center point
                    int centerPointX =  centerMonitorX - dialogLogin.getBounds().width/2;
                    int centerPointY =  centerMonitorY - dialogLogin.getBounds().height/2;
                    dialogLogin.setLocation(centerPointX,centerPointY);
                    dialogLogin.setResizable(false);
                    dialogLogin.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                if(!dialogLogin.canLogin){
                    dialogLogin.setVisible(true);
                }
            }
        });
    }
}
