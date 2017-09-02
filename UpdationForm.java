/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ritesh
 */
public class UpdationForm extends javax.swing.JFrame {
PreparedStatement pst=null;
Connection conn=null;
ResultSet rs=null;
String fromDate="";
String toDate="";
String venue="";
String club;
    /**
     * Creates new form UpdationForm
     */
    public UpdationForm(String venue,String frDate,String tDate,String club) {
        initComponents();
        this.venue=venue;
        this.club=club;
        fromDate=frDate;
        toDate=tDate;
        conn=PecConnector.ConnectorDb();
    }
private void close(){
    WindowEvent winClose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose); 
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        to_date = new com.toedter.calendar.JDateChooser();
        from_date = new com.toedter.calendar.JDateChooser();
        updateBooking = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        from_time = new javax.swing.JSpinner();
        to_time = new javax.swing.JSpinner();
        from_time2 = new javax.swing.JSpinner();
        to_time2 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Audi_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("To:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Date From:");

        to_date.setDateFormatString("yyyy-MM-dd");
        to_date.setInheritsPopupMenu(true);
        to_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                to_datePropertyChange(evt);
            }
        });

        from_date.setDateFormatString("yyyy-MM-dd");
        from_date.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        from_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                from_dateFocusGained(evt);
            }
        });
        from_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                from_dateMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                from_dateMouseClicked(evt);
            }
        });
        from_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                from_datePropertyChange(evt);
            }
        });

        updateBooking.setText("Update Booking");
        updateBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookingActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Time From:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("To:");

        from_time.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));
        from_time.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                from_timeStateChanged(evt);
            }
        });

        to_time.setModel(new javax.swing.SpinnerNumberModel(7, 7, 23, 1));
        to_time.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                to_timeStateChanged(evt);
            }
        });

        from_time2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 10));
        from_time2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                from_time2StateChanged(evt);
            }
        });

        to_time2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText(":");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(from_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(to_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(from_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(to_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(to_time2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(from_time2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(updateBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from_time)
                    .addComponent(from_time2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(to_date, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(to_time)
                    .addComponent(to_time2))
                .addGap(18, 18, 18)
                .addComponent(updateBooking)
                .addGap(41, 41, 41))
        );

        Audi_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "From Date", "To Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Audi_table);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("* Note: Do not close this window forcefully otherwise your booking will be cancelled !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void to_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_to_datePropertyChange

    }//GEN-LAST:event_to_datePropertyChange

    private void from_dateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_from_dateFocusGained

    }//GEN-LAST:event_from_dateFocusGained

    private void from_dateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_from_dateMousePressed

    }//GEN-LAST:event_from_dateMousePressed

    private void from_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_from_dateMouseClicked

    }//GEN-LAST:event_from_dateMouseClicked

    private void from_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_from_datePropertyChange
        to_date.setMinSelectableDate(from_date.getDate());
        SpinnerModel spinner1 = new SpinnerNumberModel(Integer.parseInt(from_time.getValue().toString())+1,Integer.parseInt(from_time.getValue().toString())+1,23,1);
        SpinnerModel spinner2 = new SpinnerNumberModel(0,0,55,5);
        to_time.setModel(spinner1);
        to_time2.setModel(spinner2);
    }//GEN-LAST:event_from_datePropertyChange

    private void updateBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookingActionPerformed
        try {
            String sql1 = "select * from auditorium where (from_date<=? and to_date>=?) and Club_Society=?";
            String sql2="insert into auditorium values (?,?,?,?)";
            String status="Pending";
            String status2="Booked";
            pst = conn.prepareStatement(sql1);
            String fromDate1 = ((JTextField) from_date.getDateEditor().getUiComponent()).getText()+" "+from_time.getValue().toString()+":"+from_time2.getValue().toString();
            String toDate1 = ((JTextField) to_date.getDateEditor().getUiComponent()).getText()+" "+to_time.getValue().toString()+":"+to_time2.getValue().toString();
            if(from_date.getDate()==null || to_date.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please select From Date and To Date!");
            }
            else
            {
                pst.setString(1, toDate1);
                pst.setString(2, fromDate1);
                pst.setString(3, club);
                rs = pst.executeQuery();
                Audi_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs = pst.executeQuery();
                if (!rs.next())
                {
                    pst=conn.prepareStatement(sql2);
                    pst.setString(1, club);
                    pst.setString(2, status);
                    pst.setString(3, fromDate1);
                    pst.setString(4, toDate1);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Request for Auditorium booking for "+fromDate1+" to "+toDate1+" is successfull.");
                    close();
                }
                else
                {
                    pst=conn.prepareStatement(sql2);
                    pst.setString(1, club);
                    pst.setString(2, status2);
                    pst.setString(3, fromDate);
                    pst.setString(4, toDate);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Auditorium is not available for booking");
                    close();
                }
            }
        }
        catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateBookingActionPerformed

    private void from_timeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_from_timeStateChanged
        //Object[] values={"07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00"};
        //int length=values.length;
        String fromDate = ((JTextField) from_date.getDateEditor().getUiComponent()).getText();
        String toDate = ((JTextField) to_date.getDateEditor().getUiComponent()).getText();
        if(from_date.getDate()==null || to_date.getDate()==null)
        {
            JOptionPane.showMessageDialog(null, "Please select From Date and To Date!");
        }
        else
        {
            if(fromDate.equals(toDate)){

                SpinnerModel spinner1 = new SpinnerNumberModel(Integer.parseInt(from_time.getValue().toString())+1,Integer.parseInt(from_time.getValue().toString())+1,23,1);
                SpinnerModel spinner2 = new SpinnerNumberModel(0,0,50,10);
                to_time.setModel(spinner1);
                to_time2.setModel(spinner2);
            }
            else{
                SpinnerModel spinner1=new SpinnerNumberModel(7,7,23,1);
                SpinnerModel spinner2=new SpinnerNumberModel(0,0,50,10);
                to_time.setModel(spinner1);
                to_time2.setModel(spinner2);
            }
        }
    }//GEN-LAST:event_from_timeStateChanged

    private void to_timeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_to_timeStateChanged

    }//GEN-LAST:event_to_timeStateChanged

    private void from_time2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_from_time2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_from_time2StateChanged

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
            java.util.logging.Logger.getLogger(UpdationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UpdationForm().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Audi_table;
    private com.toedter.calendar.JDateChooser from_date;
    private javax.swing.JSpinner from_time;
    private javax.swing.JSpinner from_time2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser to_date;
    private javax.swing.JSpinner to_time;
    private javax.swing.JSpinner to_time2;
    private javax.swing.JButton updateBooking;
    // End of variables declaration//GEN-END:variables
}
