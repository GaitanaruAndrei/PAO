package com;
import com.cabinet.models.pacienti.Pacient;
import com.cabinet.models.utilizatori.User;
import com.cabinet.services.Service3;
import com.cabinet.services.db.ServiceDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AppMainForm {


    private JPanel mainPanel; // setat din FORM
    private JButton showUserFormButton;
    private JScrollPane mainJScrollPanel;
    private JTable userTable;
    private JButton loadTableButton;
    private JButton addButton;
    private JTabbedPane tabbedPane;
    private JTabbedPane tabbedPane2;
    private JTextArea textArea1;

    public AppMainForm() {
        showUserFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserForm userForm = new UserForm();
                userForm.showUserForm();
                System.out.println("what form told us" + userForm.getUserByForm());
                userForm.dispose();
            }
        });
        loadTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Pacient>, String> stringSwingWorker = new SwingWorker<List<Pacient>, String>() {
                    @Override
                    protected List<Pacient> doInBackground() throws Exception {
                        return Service3.getInstance().pacientiBatrani();
                    }

                    @Override
                    protected void done() {
                        try {
                            List<Pacient> result = get();
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //uper.isCellEditable(row, column);
                                        }
                                    };
                                    defaultTableModel.addColumn("idpacient");
                                    defaultTableModel.addColumn("nume");
                                    defaultTableModel.addColumn("telefon");
                                    defaultTableModel.addColumn("adresa");
                                    defaultTableModel.addColumn("varsta");

                                    for (Pacient pacient : result) {
                                        defaultTableModel.addRow(new Object[]{
                                                pacient.getId(),
                                                pacient.getNume(),
                                                pacient.getTelefon(),
                                                pacient.getAdresa(),
                                                pacient.getVarsta()

                                        });
                                    }
                                    userTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        } catch (ExecutionException e1) {
                            e1.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    ServiceDB.getInstance().insertPacientDB(textFieldCNP.getText(), textFieldName.getText(),
//                            textFieldTelephone.getText(), Integer.parseInt(textFieldAge.getText()));
//                    JOptionPane.showMessageDialog(null, "Patient successfully inserted !", "Atenție", JOptionPane.INFORMATION_MESSAGE);
//
//                    textFieldCNP.setText("");
//                    textFieldName.setText("");
//                    textFieldTelephone.setText("");
//                    textFieldAge.setText("");
//
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            }
//        });
//    }
    }
    private void  initFrameWithMenu(){
        JFrame jFrame = new JFrame("Cabinet Medical"); // numele
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pentru a se inchide total
        jFrame.setPreferredSize(new Dimension(800,600)); // lungime latime
        jFrame.setContentPane(this.mainPanel);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(exitMenuItem);
        jMenuBar.add(fileMenu);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.pack();
        jFrame.setVisible(true);

    }

    public static void main (String[] args){
    AppMainForm appMainForm = new AppMainForm();


    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            appMainForm.initFrameWithMenu();
        }
    });
    }
    private void createUIComponents () {
        JButton oneButton = new JButton("do something!!!!");
        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button 'do something!!!!' was pressed!");
            }
        });

    }
}


