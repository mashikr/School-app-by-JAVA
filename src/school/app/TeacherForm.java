/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ashik
 */
public class TeacherForm extends javax.swing.JFrame {

    /**
     * Creates new form TeacherForm
     */
    public TeacherForm() {
        initComponents();
        fillTable();
    }
    
    public Connection getMysqlConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_database", "root", "");
            //JOptionPane.showMessageDialog(null, "Mysql DB Connection is Successful ....");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e);
            return null;
        }                
    }
   
    //show / add the the data to table
    public ArrayList<Teacher_Bean> getAllTeacherData(){
        ArrayList<Teacher_Bean> al=null;
        al=new ArrayList<Teacher_Bean>();
        try{
            Connection con=getMysqlConnection();
           String qry="select * from teacher";
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(qry);
           Teacher_Bean teacher;           
           while(rs.next()){
             teacher=new Teacher_Bean(Integer.parseInt(rs.getString(1)),
                     rs.getString("name"), Float.parseFloat(rs.getString(3)),
                     rs.getString(4),rs.getString("address"),rs.getString(6));
             al.add(teacher);
             System.out.print("\n"+Integer.parseInt(rs.getString(1)));
             System.out.print(rs.getString("name"));
             System.out.println(Float.parseFloat(rs.getString(3)));
             System.out.println(rs.getString(4));
             System.out.println(rs.getString("address"));
             System.out.println(rs.getString(6)+"\n");
             //return al;             remove the teacher mistakely Excuse....
                
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in getAllTeacherData()"+e);
            return al;
        }
        return al;
    } 
    
    public void fillTable(){
        ArrayList<Teacher_Bean> al=getAllTeacherData();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[6];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getSalary();
            row[3]=al.get(i).getDob();
            row[4]=al.get(i).getAddress();
            row[5]=al.get(i).getSubject();
            model.addRow(row);
        }                
    }
    
    public void showItemToFieldsTeacher(int index){
        jTextField1_id.setText(Integer.toString(getAllTeacherData().get(index).getId()));
        jTextField2_name.setText(getAllTeacherData().get(index).getName());
        jTextField3_salary.setText(Float.toString(getAllTeacherData().get(index).getSalary()));
        try{
            java.util.Date dob=null;
            dob=new SimpleDateFormat("dd-MM-yyyy").parse((String)getAllTeacherData().get(index).getDob());
            jDateChooser1_dob.setDate(dob);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error showItemToFieldsTeacher() "+e);
        }
        jTextArea1_address.setText(getAllTeacherData().get(index).getAddress());
        jTextField5_subject.setText(getAllTeacherData().get(index).getSubject());        
    }
    
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1_id = new javax.swing.JTextField();
        jButton1_Clear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField3_salary = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField2_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1_dob = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jButton2_save = new javax.swing.JButton();
        jButton3_edit = new javax.swing.JButton();
        jButton4_delete = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField1_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1_address = new javax.swing.JTextArea();
        jTextField5_subject = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Computer Science and Telecommunication Engineering");

        jLabel2.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Noakhali Science and Technogoly University");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Teacher Information");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("ID:");

        jTextField1_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1_Clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1_Clear.setForeground(new java.awt.Color(0, 0, 255));
        jButton1_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/app/images/ok.png"))); // NOI18N
        jButton1_Clear.setText("New");
        jButton1_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_ClearActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Teacher Name:");

        jTextField3_salary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Salary:");

        jTextField2_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Address:");

        jDateChooser1_dob.setDateFormatString("dd-MM-yyyy");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Date of Birth:");

        jButton2_save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2_save.setForeground(new java.awt.Color(0, 0, 255));
        jButton2_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/app/images/save.png"))); // NOI18N
        jButton2_save.setText("Insert/Save");
        jButton2_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_saveActionPerformed(evt);
            }
        });

        jButton3_edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3_edit.setForeground(new java.awt.Color(0, 0, 255));
        jButton3_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/app/images/update.png"))); // NOI18N
        jButton3_edit.setText("Update");
        jButton3_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_editActionPerformed(evt);
            }
        });

        jButton4_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4_delete.setForeground(new java.awt.Color(0, 0, 255));
        jButton4_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/app/images/bluedelete.png"))); // NOI18N
        jButton4_delete.setText("Delete");
        jButton4_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_deleteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("Search by name:");

        jTextField1_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1_searchKeyReleased(evt);
            }
        });

        jTextArea1_address.setColumns(20);
        jTextArea1_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1_address.setForeground(new java.awt.Color(51, 0, 51));
        jTextArea1_address.setRows(5);
        jScrollPane1.setViewportView(jTextArea1_address);

        jTextField5_subject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Course:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/app/images/Webp.net-compress-image.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher Id", "Teacher Name", "Salary", "Date of Birth", "Address", "Subject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton_home.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_home.setForeground(new java.awt.Color(0, 0, 255));
        jButton_home.setText("Home");
        jButton_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField5_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser1_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel9)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(jLabel10)))
                                                .addGap(31, 31, 31))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(126, 126, 126)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton4_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3_edit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2_save, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1_Clear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1_search)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(196, 196, 196))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(107, 107, 107))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField3_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton3_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(5, 5, 5)
                                .addComponent(jButton4_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser1_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(51, 51, 51)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField1_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_home, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     //To Clear the all the fields
    private void jButton1_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_ClearActionPerformed
        jTextField1_id.setText("");
        jTextField2_name.setText("");
        jTextField3_salary.setText("");
        jTextField5_subject.setText("");
        jTextArea1_address.setText(""); 
    }//GEN-LAST:event_jButton1_ClearActionPerformed

    //To insert or Save the teaher Data
    private void jButton2_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_saveActionPerformed
        //Validation logic to check whether all input filds are entered or Not
        if (jTextField1_id.getText().toString().equals("") || 
                jTextField2_name.getText().toString().equals("") || 
                jTextField3_salary.getText().toString().equals("") || 
                jTextField3_salary.getText().toString().equals("") || 
                jTextField5_subject.getText().toString().equals("") || 
                jTextArea1_address.getText().toString().equals("")) {
            
            JOptionPane.showMessageDialog(null, "All Fields are compulsory ....");
            
        }else{
            
            try{
                Connection conn=getMysqlConnection();
                String qry="insert into teacher(id,name,salary,dob,address,subject) values(?,?,?,?,?,?)";                
                PreparedStatement ps=conn.prepareStatement(qry);
                ps.setInt(1,Integer.parseInt(jTextField1_id.getText().toString()));
                ps.setString(2,jTextField2_name.getText().toString());
                ps.setFloat(3,Float.parseFloat(jTextField3_salary.getText().toString()));
                
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                String dob1=sdf.format(jDateChooser1_dob.getDate());
                ps.setString(4,dob1);
                
                ps.setString(5,jTextArea1_address.getText().toString());
                ps.setString(6,jTextField5_subject.getText().toString());
                
                int result=ps.executeUpdate();
fillTable(); //fillTable() called to display the data after newly inserted teacher into database table                
                if (result>=1) {
                    JOptionPane.showMessageDialog(null,result+" Teacher Saved Successfully to Database ....");                                
                }else{
                    JOptionPane.showMessageDialog(null,result+" Teacher Insertion failde Try Again..."); 
                }
                if (ps!=null) {
                    ps.close();
                }
                if (conn!=null) {
                    conn.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error in insert "+e);
            }
            //clear the fields
        jTextField1_id.setText("");
        jTextField2_name.setText("");
        jTextField3_salary.setText("");
        jTextField5_subject.setText("");
        jTextArea1_address.setText("");                
        
        }
        
        
    }//GEN-LAST:event_jButton2_saveActionPerformed

    //logic to Edit the Information
    private void jButton3_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_editActionPerformed
        //Validation logic to check whether all input filds are entered or Not
        if (jTextField1_id.getText().toString().equals("") || 
                jTextField2_name.getText().toString().equals("") || 
                jTextField3_salary.getText().toString().equals("") || 
                jTextField3_salary.getText().toString().equals("") || 
                jTextField5_subject.getText().toString().equals("") || 
                jTextArea1_address.getText().toString().equals("")) {
            
            JOptionPane.showMessageDialog(null, "All Fields are compulsory ....");
            
        }else{
            
            try{
                Connection conn=getMysqlConnection();
                String qry="update teacher set name=?, salary=?, dob=?, address=?, subject=? where id=?";                
                PreparedStatement ps=conn.prepareStatement(qry);
                
                ps.setString(1,jTextField2_name.getText().toString());
                ps.setFloat(2,Float.parseFloat(jTextField3_salary.getText().toString()));
                
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                String dob1=sdf.format(jDateChooser1_dob.getDate());
                ps.setString(3,dob1);
                
                ps.setString(4,jTextArea1_address.getText().toString());
                ps.setString(5,jTextField5_subject.getText().toString());
                
                ps.setInt(6,Integer.parseInt(jTextField1_id.getText().toString()));
                
                int result=ps.executeUpdate();
                fillTable(); //fillTable() called to display the data after newly updated teacher into database table
                if (result>=1) {
                    //JOptionPane.showMessageDialog(null,result+" Teacher Updated Successfully to Database. Teacher Name:  "+jTextField2_name.getText().toString());                                
                    JOptionPane.showMessageDialog(null,result+" Teacher Updated Successfully");                                
                }else{
                    JOptionPane.showMessageDialog(null," Teacher Updation failed Try Again...");                                
                }
                if (ps!=null) {
                    ps.close();
                }
                if (conn!=null) {
                    conn.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error in Update "+e);
            }
            //clear the fields
        jTextField1_id.setText("");
        jTextField2_name.setText("");
        jTextField3_salary.setText("");
        jTextField5_subject.setText("");
        jTextArea1_address.setText("");                        
        }             

       
    }//GEN-LAST:event_jButton3_editActionPerformed
    
    //Logic to delete the teacher from database table
    private void jButton4_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_deleteActionPerformed
        //Validation logic to check whether all input filds are entered or Not
        if (jTextField1_id.getText().toString().equals("")) {            
            JOptionPane.showMessageDialog(null, "All Fields are compulsory ....");            
        }else{            
            try{
                Connection conn=getMysqlConnection();
                String qry="delete from teacher where id=?";                
                PreparedStatement ps=conn.prepareStatement(qry);
                ps.setInt(1,Integer.parseInt(jTextField1_id.getText().toString()));
                int result=ps.executeUpdate();
                fillTable(); //fillTable() called to display the data after newly deleted teacher from database table
                if (result>=1) {
                    JOptionPane.showMessageDialog(null,result+" Teacher Deleted "
                            + "Successfully to Database. Id is : "+jTextField1_id.getText().toString());                                
                }else{
                    JOptionPane.showMessageDialog(null," Teacher Deletion failed Try Again...");                                
                }
                if (ps!=null) {
                    ps.close();
                }
                if (conn!=null) {
                    conn.close();
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error in Delete "+e);
            }
            //clear the fields
        jTextField1_id.setText("");
        jTextField2_name.setText("");
        jTextField3_salary.setText("");
        jTextField5_subject.setText("");
        jTextArea1_address.setText("");                
        
        }
    }//GEN-LAST:event_jButton4_deleteActionPerformed
    
    //when the Stakeholder Clicks the cells of jTable then get the data and add to input fields
    
    
    private void jTextField1_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_searchKeyReleased
         ArrayList<Teacher_Bean> al=null;
        al=new ArrayList<Teacher_Bean>();
        String val=jTextField1_search.getText().toString();
        
       try{
           Connection con=getMysqlConnection();
           String qry="select * from teacher where name like '%"+val+"%'";
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(qry);
           Teacher_Bean teacher;
           while (rs.next()) {
                teacher=new Teacher_Bean(Integer.parseInt(rs.getString(1)),
                     rs.getString("name"), Float.parseFloat(rs.getString(3)),
                     rs.getString(4),rs.getString("address"),rs.getString(6));
             al.add(teacher);
           }
           if (st!=null) {
                    st.close();
                }
           if (con!=null) {
                    con.close();
                }
                
                
           //search ed teachers to be added to datatable
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[6];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getSalary();
            row[3]=al.get(i).getDob();
            row[4]=al.get(i).getAddress();
            row[5]=al.get(i).getSubject();
            model.addRow(row);
        }                
           
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error at jTextField1_searchKeyReleased "+e);
       }
        
    }//GEN-LAST:event_jTextField1_searchKeyReleased

    //when the Stakeholder Clicks the cells of jTable then get the data and add to input fields
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int ind=jTable1.getSelectedRow();
       showItemToFieldsTeacher(ind);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_homeActionPerformed
        setVisible(false);
        SchoolApp ob = new SchoolApp();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton_homeActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_Clear;
    private javax.swing.JButton jButton2_save;
    private javax.swing.JButton jButton3_edit;
    private javax.swing.JButton jButton4_delete;
    private javax.swing.JButton jButton_home;
    private com.toedter.calendar.JDateChooser jDateChooser1_dob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1_address;
    private javax.swing.JTextField jTextField1_id;
    private javax.swing.JTextField jTextField1_search;
    private javax.swing.JTextField jTextField2_name;
    private javax.swing.JTextField jTextField3_salary;
    private javax.swing.JTextField jTextField5_subject;
    // End of variables declaration//GEN-END:variables
}
