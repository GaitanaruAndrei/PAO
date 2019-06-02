package com.gui;

import com.cabinet.models.pacienti.Pacient;
import com.cabinet.models.medic.Medic;
import com.cabinet.services.Service3;
import com.cabinet.services.db.ServiceDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AppMain {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JPanel dbStorage;
    private JScrollPane mainJScrollPanel;
    private JTable userTable;
    private JButton pacientBatranTable;
    private JButton pacientiCopiiButton;
    private JButton mediciButton;
    private JTextField numeField;
    private JTextField telefonField;
    private JTextField adresaField;
    private JTextField varstaField;
    private JButton adaugaButton;
    private JButton stergePacientDupaNumeButton;
    private JButton updateTelefonDupaNumeButton;
    private JTextField medicamentField;
    private JButton adaugaMedicamentButton;
    private JButton stergeMedicamentButton;
    private JPanel mainPane;

    public AppMain() {
        pacientBatranTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingWorker<java.util.List<Pacient>, String> stringSwingWorker = new SwingWorker<java.util.List<Pacient>, String>() {
                    @Override
                    protected java.util.List<Pacient> doInBackground() throws Exception {
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
        pacientiCopiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingWorker<java.util.List<Pacient>, String> stringSwingWorker = new SwingWorker<java.util.List<Pacient>, String>() {
                    @Override
                    protected java.util.List<Pacient> doInBackground() throws Exception {
                        return Service3.getInstance().pacientiCopii();
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
        mediciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<java.util.List<Medic>, String> stringSwingWorker = new SwingWorker<java.util.List<Medic>, String>() {
                    @Override
                    protected java.util.List<Medic> doInBackground() throws Exception {
                        return Service3.getInstance().medici();
                    }

                    @Override
                    protected void done() {
                        try {
                            List<Medic> result = get();
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

                                    for (Medic medic : result) {
                                        defaultTableModel.addRow(new Object[]{
                                               medic.getId(),
                                               medic.getNume(),
                                                medic.getTelefon(),
                                               medic.getAdresa()


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
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ServiceDB.getInstance().insertPacientDB(numeField.getText(), telefonField.getText(),
                            adresaField.getText(), Integer.parseInt(varstaField.getText()));
                    JOptionPane.showMessageDialog(null, "Pacientul a fost introdus !", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    numeField.setText("");
                    telefonField.setText("");
                    adresaField.setText("");
                    varstaField.setText("");

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        stergePacientDupaNumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ServiceDB.getInstance().stergePacientBD_dupaNume(numeField.getText());
                    JOptionPane.showMessageDialog(null, "Pacientul a fost sters !", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    numeField.setText("");
                    telefonField.setText("");
                    adresaField.setText("");
                    varstaField.setText("");

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        updateTelefonDupaNumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    ServiceDB.getInstance().updatePacientBD_dupaNume(numeField.getText(),telefonField.getText());
                    JOptionPane.showMessageDialog(null, "Numarul de telefon a fost updatat!", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    numeField.setText("");
                    telefonField.setText("");
                    adresaField.setText("");
                    varstaField.setText("");

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        adaugaMedicamentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ServiceDB.getInstance().insertMedicamentDB(medicamentField.getText());
                    JOptionPane.showMessageDialog(null, "Medicamentul a fost adaugat", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    medicamentField.setText("");


                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        stergeMedicamentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    ServiceDB.getInstance().stergeMedicamentBd(medicamentField.getText());
                    JOptionPane.showMessageDialog(null, "Medicamentul a fost sters", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    medicamentField.setText("");


                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void initFrameWithMenu(){
        JFrame jFrame = new JFrame("Cabinet");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(this.mainPanel);
        jFrame.setPreferredSize(new Dimension(800,600));
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String [] args){

        AppMain appMain = new AppMain();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                appMain.initFrameWithMenu();
            }
        });

    }
}
