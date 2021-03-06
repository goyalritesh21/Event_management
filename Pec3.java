/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author ritesh
 */
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.text.SimpleDateFormat;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
public class Pec3 extends javax.swing.JFrame {
Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String club;
    /**
     * Creates new form Pec3
     */
    public Pec3(String club) {
        initComponents();
        this.club=club;
        conn = PecConnector.ConnectorDb();
        //Update();
        java.util.Date date = new java.util.Date();
        Rejected();
        delete();
        from_date.getJCalendar().setMinSelectableDate(date);
        to_date.getJCalendar().setMinSelectableDate(date);
    }
private void Update() {
        try {
            String sql = "select * from cricket_ground";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Audi_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
                //conn.close();
            } catch (Exception e) {
            }
        }
    }
private void delete(){
    try{
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date_f=sdf.format(date);
    String sql="delete from cricket_ground (where to_date<? or Status='Rejected') and Club_Society=?";
    pst.setString(2,club);
    pst = conn.prepareStatement(sql);
    pst.setString(1,date_f);
    pst.execute();
    }
    catch(Exception e){
        
    }finally {
            try {
                rs.close();
                pst.close();
                //conn.close();
            } catch (Exception e) {
            }
        }
}
private void Rejected(){
    try {
            String sql = "select * from cricket_ground where Status='Rejected' and Club_Society=?";
            pst = conn.prepareStatement(sql);
            
            pst.setString(1,club);
            rs = pst.executeQuery();
            Audi_table.setModel(DbUtils.resultSetToTableModel(rs));
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Some of your previous booking requests have been rejected.\n Please contact officer incharge for further details.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
                //conn.close();
            } catch (Exception e) {
            }
        }
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Audi_table = new javax.swing.JTable();
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
        BookVenue = new javax.swing.JButton();
        CheckStatus = new javax.swing.JButton();
        CancelBooking = new javax.swing.JButton();
        ViewBookings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Venue: Cricket Ground");

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

        to_time2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 55, 5));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText(":");

        BookVenue.setText("Book Venue");
        BookVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookVenueActionPerformed(evt);
            }
        });

        CheckStatus.setText("Check Status");
        CheckStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckStatusActionPerformed(evt);
            }
        });

        CancelBooking.setText("Cancel Booking");
        CancelBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBookingActionPerformed(evt);
            }
        });

        ViewBookings.setText("View Bookings");
        ViewBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBookingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(to_time2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(from_time2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(CheckStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ViewBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBooking)
                    .addComponent(BookVenue)
                    .addComponent(CheckStatus)
                    .addComponent(CancelBooking)
                    .addComponent(ViewBookings))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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

            String sql = "select * from cricket_ground where (from_date=? and to_date=?) and Club_Society=?";
            
            pst = conn.prepareStatement(sql);
            String fromDate = ((JTextField) from_date.getDateEditor().getUiComponent()).getText()+" "+from_time.getValue().toString()+":"+from_time2.getValue().toString();
            String toDate = ((JTextField) to_date.getDateEditor().getUiComponent()).getText()+" "+to_time.getValue().toString()+":"+to_time2.getValue().toString();
            if(from_date.getDate()==null || to_date.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please select From Date and To Date!");
            }
            else
            {
                pst.setString(1, fromDate);
                pst.setString(2, toDate);
                pst.setString(3,club);
                rs = pst.executeQuery();
                Audi_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs = pst.executeQuery();
                if (!rs.next())
                {

                    JOptionPane.showMessageDialog(null, "You have no booking of this slot!");
                }
                else
                {
                    String sql1="delete from cricket_ground where (from_date=? and to_date=?) and Club_Society=?";
                    pst=conn.prepareStatement(sql1);
                    pst.setString(1, fromDate);
                    pst.setString(2, toDate);
                    pst.setString(3,club);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Please enter new values!");
                    Pec3Updation uf2 = new Pec3Updation("cricket_ground",fromDate,toDate,club);
                    uf2.setVisible(true);
                    //actionPerformed(evt,fromDate,toDate);

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
                SpinnerModel spinner2 = new SpinnerNumberModel(0,0,55,5);
                to_time.setModel(spinner1);
                to_time2.setModel(spinner2);
            }
            else{
                SpinnerModel spinner1=new SpinnerNumberModel(7,7,23,1);
                SpinnerModel spinner2=new SpinnerNumberModel(0,0,55,5);
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

    private void BookVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookVenueActionPerformed
        try {
            String sql1 = "select * from cricket_ground where (from_date<=? and to_date>=?) and Club_Society=?";
            
            String sql2="insert into cricket_ground values (?,?,?,?)";
            String status="Booked";
            pst = conn.prepareStatement(sql1);
            String fromDate = ((JTextField) from_date.getDateEditor().getUiComponent()).getText()+" "+from_time.getValue().toString()+":"+from_time2.getValue().toString();
            String toDate = ((JTextField) to_date.getDateEditor().getUiComponent()).getText()+" "+to_time.getValue().toString()+":"+to_time2.getValue().toString();
            if(from_date.getDate()==null || to_date.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please select From Date and To Date!");
            }
            else
            {
                pst.setString(1, toDate);
                pst.setString(2, fromDate);
                pst.setString(3,club);
                rs = pst.executeQuery();
                Audi_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs = pst.executeQuery();
                if (!rs.next())
                {
                    pst=conn.prepareStatement(sql2);
                    pst.setString(1,club);
                    pst.setString(2, status);
                    pst.setString(3, fromDate);
                    pst.setString(4, toDate);
                    pst.execute();
                    Update();
                    JOptionPane.showMessageDialog(null, "Request for Cricket Ground booking for "+fromDate+" to "+toDate+" is successfull.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Cricket Ground is not available for booking");
                }
            }
        }
        catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_BookVenueActionPerformed

    private void CheckStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckStatusActionPerformed
        try {
            String sql = "select * from cricket_ground where (from_date<=? and to_date>=?) and Club_Society=?";
            
            pst = conn.prepareStatement(sql);
            String fromDate = ((JTextField) from_date.getDateEditor().getUiComponent()).getText()+" "+from_time.getValue().toString()+":"+from_time2.getValue().toString();
            String toDate = ((JTextField) to_date.getDateEditor().getUiComponent()).getText()+" "+to_time.getValue().toString()+":"+to_time2.getValue().toString();
            if(from_date.getDate()==null || to_date.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please select From Date and To Date!");
            }
            else
            {
                pst.setString(1, toDate);
                pst.setString(2, fromDate);
                pst.setString(3,club);
                rs = pst.executeQuery();
                Audi_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs = pst.executeQuery();
                if (!rs.next())
                {
                    JOptionPane.showMessageDialog(null, "Cricket Ground is available for booking");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Cricket Groundis not available for booking");
                }
            }
        }
        catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_CheckStatusActionPerformed

    private void CancelBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBookingActionPerformed
        try{
            String sql2= "select * from cricket_ground where (from_date=? and to_date=?) and Club_Society=?";
            
            Connection conn2=PecConnector.ConnectorDb();
            PreparedStatement pst2=conn2.prepareStatement(sql2);
            ResultSet rs2=null;
            String sql="delete from cricket_ground where (from_date=? and to_date=?) and Club_Society=?";
            pst=conn.prepareStatement(sql);
            String fromDate = ((JTextField) from_date.getDateEditor().getUiComponent()).getText()+" "+from_time.getValue().toString()+":"+from_time2.getValue().toString();
            String toDate = ((JTextField) to_date.getDateEditor().getUiComponent()).getText()+" "+to_time.getValue().toString()+":"+to_time2.getValue().toString();
            if(from_date.getDate()==null || to_date.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please select From Date and To Date!");
            }
            else{
                pst2.setString(1, fromDate);
                pst2.setString(2, toDate);
                pst.setString(3,club);
                rs2=pst2.executeQuery();
                if(rs2.next()){
                pst.setString(1, fromDate);
                pst.setString(2,toDate);
                pst.setString(3,club);
                int confirm=JOptionPane.showConfirmDialog(null,"Do you really want to cancel the booking?");
                if(confirm==0){
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Booking cancelled!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Cancellation Aborted");
                }
                }
                else{
                    JOptionPane.showMessageDialog(null,"You have no bookings of this slot!");
                }
            }
        }
        catch(Exception e){

        }
    }//GEN-LAST:event_CancelBookingActionPerformed

    private void ViewBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBookingsActionPerformed
        try {
            String sql = "select * from cricket_ground where ((from_date>=? and to_date<=?) or(from_date<=? and to_date>=?) or (from_date<=? and to_date>=?)) and Club_Society=?";
            
            pst = conn.prepareStatement(sql);
            String fromDate = ((JTextField) from_date.getDateEditor().getUiComponent()).getText()+" "+from_time.getValue().toString()+":"+from_time2.getValue().toString();
            String toDate = ((JTextField) to_date.getDateEditor().getUiComponent()).getText()+" "+to_time.getValue().toString()+":"+to_time2.getValue().toString();
            if(from_date.getDate()==null || to_date.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please select From Date and To Date!");
            }
            else
            {
                pst.setString(1, fromDate);
                pst.setString(2, toDate);
                pst.setString(4, fromDate);
                pst.setString(3, fromDate);
                pst.setString(5, toDate);
                pst.setString(6, toDate);
                pst.setString(7,club);
                rs = pst.executeQuery();
                if(!rs.next()){
                    JOptionPane.showMessageDialog(null, "No bookings of this slot!");
                }else{
                    rs=pst.executeQuery();
                    Audi_table.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }
        }
        catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ViewBookingsActionPerformed

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
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pec3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pec3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pec3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pec3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Pec3().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Audi_table;
    private javax.swing.JButton BookVenue;
    private javax.swing.JButton CancelBooking;
    private javax.swing.JButton CheckStatus;
    private javax.swing.JButton ViewBookings;
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
