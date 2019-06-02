package com;

import javax.swing.*;
import java.awt.event.*;

public class UserForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public UserForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        System.out.println("Ok button was pressed");
        //dispose();
        this.setVisible(false);
    }

    private void onCancel() {
        System.out.println("Cancel button was pressed");
        dispose();
    }
    public void showUserForm(){
        UserForm dialog = new UserForm();
        dialog.pack();
        dialog.setVisible(true);
    }
    public String getUserByForm(){
        return "userul este aici ca parametru";
    }

    public static void main(String[] args) {
        UserForm dialog = new UserForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
