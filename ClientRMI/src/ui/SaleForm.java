/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.IDao;
import entities.Machine;
import entities.Sale;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tarma
 */
public class SaleForm extends javax.swing.JInternalFrame {
    
    IDao<Sale> dao = null;
    DefaultTableModel model = null;
    int column = 0;
    int id=0;

    /**
     * Creates new form SaleForm
     */
    public SaleForm() {
        initComponents();
         
        try {
            
            model = (DefaultTableModel) ListSales.getModel();
            dao = (IDao<Sale>) Naming.lookup("rmi://localhost:1099/daoS"/*"rmi://"+Config.ip+":"+Config.port+"/dao"*/);
            load();
        } catch (NotBoundException ex) {
            Logger.getLogger(SaleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SaleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SaleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
     public void load(){
        try {
            model.setRowCount(0);
            for(Sale s : dao.findAll())
                model.addRow(new Object[]{
                    s.getId(),
                    s.getCode()
                });
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
        public void fillForm(){
         try {
            // TODO add your handling code here:

            Sale s= dao.findById(id);
            
            txtCode.setText(s.getCode());
            
       } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
          public void clearForm(){
         txtCode.setText("");
           
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListSales = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        edBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(644, 444));
        setMinimumSize(new java.awt.Dimension(644, 444));
        setPreferredSize(new java.awt.Dimension(798, 455));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations Salles"));

        jLabel1.setText("Code");

        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("List des Salles"));

        ListSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListSales.getTableHeader().setReorderingAllowed(false);
        ListSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListSalesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListSales);
        if (ListSales.getColumnModel().getColumnCount() > 0) {
            ListSales.getColumnModel().getColumn(0).setResizable(false);
            ListSales.getColumnModel().getColumn(0).setHeaderValue("ID");
            ListSales.getColumnModel().getColumn(1).setResizable(false);
            ListSales.getColumnModel().getColumn(1).setHeaderValue("CODE");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        addBtn.setText("Ajouter");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        delBtn.setText("Suprimer");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        edBtn.setText("Modifier");
        edBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn)
                .addGap(18, 18, 18)
                .addComponent(delBtn)
                .addGap(18, 18, 18)
                .addComponent(edBtn)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        
        
        String code=txtCode.getText();
        
         if(code.isEmpty())
                JOptionPane.showMessageDialog(this, "Merci de remplire les champ!", "Dialog",
        JOptionPane.ERROR_MESSAGE);
         else{
        try {
            dao.create(new Sale(code));
             load();
             clearForm();
        } catch (RemoteException ex) {
            Logger.getLogger(SaleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(this, "Salle ajouter avec succès", "Dialog",
        JOptionPane.INFORMATION_MESSAGE);
         }
    }//GEN-LAST:event_addBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        
          try {
            dao.delete(dao.findById(id));
            
            
// TODO add your handling code here:
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
           JOptionPane.showMessageDialog(this, "Salle supprimer avec succès", "Dialog",
        JOptionPane.INFORMATION_MESSAGE);
           clearForm();
        load();  
    }//GEN-LAST:event_delBtnActionPerformed

    private void ListSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListSalesMouseClicked
        // TODO add your handling code here:
        
             int row = ListSales.getSelectedRow();
     id = Integer.parseInt( ListSales.getModel().getValueAt(row, column).toString()); 
     
     
     fillForm();
    }//GEN-LAST:event_ListSalesMouseClicked

    private void edBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edBtnActionPerformed
        // TODO add your handling code here:
        
         try {
            // TODO add your handling code here:

             Sale s=dao.findById(id);
             
             s.setCode(txtCode.getText());
         if(s.getCode() == "")
                JOptionPane.showMessageDialog(this, "Merci de remplire les champ!", "Dialog",
        JOptionPane.ERROR_MESSAGE);
            
            else
            dao.update(s);
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
                  clearForm();
        load();  
    }//GEN-LAST:event_edBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListSales;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton edBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
