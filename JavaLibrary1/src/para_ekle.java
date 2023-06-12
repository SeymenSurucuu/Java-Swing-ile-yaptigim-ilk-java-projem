
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seyme
 */
public class para_ekle extends javax.swing.JFrame {

   /*static boolean bir=false; 
static int yazi;
static int tutar;
    
    */
    /**
     * Creates new form para_ekle
     */
    public para_ekle() {
        initComponents();
    }
      
        
  
   
   
    /*public int sonbakiye(int bakiye, int cevrilentutar){
      
       if(!(cevrilentutar > bakiye )){
     int  sontutar = bakiye - cevrilentutar;
      return tutar=sontutar;
      }
        if(cevrilentutar>bakiye){
        return yazi=1;
        } else {return yazi = 0;}
   }  */
   /* public void kontrolcik() throws SQLException{
       
        Connection connect = null;
        dbbaglanti db = new dbbaglanti();
        connect = db.getConnection();
        Statement oku = ( Statement) connect.createStatement();
         PreparedStatement statment = null;
          String cekilenid = idtext4.getText();
          int cevrilenid = Integer.valueOf(cekilenid);
          String sifrebilgisi = sifretext4.getText();
          String tutarbilgisi = idtext4.getText();
          int cevrilentutar = Integer.valueOf(tutarbilgisi);
        try {
          
  
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bilgilerde Bir Hata Bulunuyor!");        
        }
         ResultSet rs;
        rs = oku.executeQuery("SELECT count(id) as \"giris\", bakiye FROM dbkullanici.kullanicilar WHERE id ="+ cevrilenid +" && sifre = '"+sifrebilgisi+"'" +";");
        int i =5; 
        while (rs.next()) {
            int id = rs.getInt("giris");
             int bakiye = rs.getInt("bakiye");
            if(id ==1 ){
                bir = true;
             if(i == 5){
                 i = 7;
              sonbakiye(bakiye, cevrilentutar);
             }
         }
        }
        if(yazi== 1){
        
         JOptionPane.showMessageDialog(null, "Bakiye Yetersiz!");}
        else if(bir == true){ 
          try{ 
             
              String sql = "UPDATE dbkullanici.kullanicilar SET bakiye = ? WHERE id = ?";
                 statment = connect.prepareStatement(sql);

                statment.setInt(1, cevrilenid);
                statment.setInt(2, tutar);
                statment.executeUpdate();
                 
                 
           JOptionPane.showMessageDialog(null, "Para Başarı İle Çekildi!");
          }catch(Exception e){ 
               JOptionPane.showMessageDialog(null, "Paranızı Çekme Konusunda Hata Yaşadık! Yönetici ile iletişime geçiniz.");    
          }
          
           
           
           } else if (bir == false ){  erortext.setText("Bilgileriniz Veritabanımızda ki veriler ile eşleşmedi");}
       
         
    }
   */
    static int bakiyes1;
    static int bakiyes2;
    public void kontrol() throws SQLException{
       
        Connection connect = null;
        dbbaglanti db = new dbbaglanti();
        connect = db.getConnection();
        Statement oku = ( Statement) connect.createStatement();
         PreparedStatement statment = null;
          String cekilenid = idtext4.getText();
          int cevrilenid = Integer.valueOf(cekilenid);
          String sifrebilgisi = sifretext4.getText();
          String tutarbilgisi = tutartext.getText();
          int cevrilentutar = Integer.valueOf(tutarbilgisi);
    
         ResultSet rs;
        rs = oku.executeQuery("SELECT count(id) as \"giris\", bakiye FROM dbkullanici.kullanicilar WHERE id ="+ cevrilenid +" && sifre = '"+sifrebilgisi+"'" +";");
         while (rs.next()) {
            int id = rs.getInt("giris");
             bakiyes1 = rs.getInt("bakiye");
           if(id == 1){ bakiyes1=bakiyes1 + cevrilentutar;
          try{ 
              
              String sql = "UPDATE dbkullanici.kullanicilar SET bakiye = ? WHERE id = ?";
                 statment = connect.prepareStatement(sql);

                statment.setInt(1, bakiyes1);
                statment.setInt(2, cevrilenid);
                 statment.executeUpdate();
           JOptionPane.showMessageDialog(null, "Bakiyeniz Başarıyla Eklendi!");
          }catch(Exception e){ 
               JOptionPane.showMessageDialog(null, "Paranızı Ekleme Konusunda Hata Yaşadık! Yönetici ile iletişime geçiniz.");    
          }
          
           
           
           } else if (id == 0 ){  erortext.setText("Bilgileriniz Veritabanımızda ki veriler ile eşleşmedi");}
         }
         
       
         
    }
    
    
    
    
    
public void kontrolcik() throws SQLException{
       
        Connection connect = null;
        dbbaglanti db = new dbbaglanti();
        connect = db.getConnection();
        Statement oku = ( Statement) connect.createStatement();
         PreparedStatement statment = null;
          String cekilenid = idtext4.getText();
          int cevrilenid = Integer.valueOf(cekilenid);
          String sifrebilgisi = sifretext4.getText();
          String tutarbilgisi = tutartext.getText();
          int cevrilentutar = Integer.valueOf(tutarbilgisi);

         ResultSet rs;
        rs = oku.executeQuery("SELECT count(id) as \"giris\", bakiye FROM dbkullanici.kullanicilar WHERE id ="+ cevrilenid +" && sifre = '"+sifrebilgisi+"'" +";");
         while (rs.next()) {
            int id = rs.getInt("giris");
              bakiyes2 = rs.getInt("bakiye");
           if(id == 1){ 
          try{ 
              if(!(cevrilentutar > bakiyes2)){
                  bakiyes2 = bakiyes2 - cevrilentutar;
              String sql = "UPDATE dbkullanici.kullanicilar SET bakiye = ? WHERE id = ?";
                 statment = connect.prepareStatement(sql);

                statment.setInt(1, bakiyes2);
                statment.setInt(2, cevrilenid);
                 statment.executeUpdate();
           JOptionPane.showMessageDialog(null, "Paranız Başarıyla Çekildi"); } else { JOptionPane.showMessageDialog(null, "Bakiyeniz Yetersiz.!");}
          }catch(Exception e){ 
               JOptionPane.showMessageDialog(null, "Paranızı Çekme Konusunda Hata Yaşadık! Yönetici ile iletişime geçiniz.");    
          }
          
           
           
           } else if (id == 0 ){  erortext.setText("Bilgileriniz Veritabanımızda ki veriler ile eşleşmedi");}
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idtext4 = new javax.swing.JTextField();
        sifretext4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tutartext = new javax.swing.JTextField();
        erortext = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("ISSEY FİNANS SİSTEMİ");

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        jLabel2.setText("ISSEY ile paralarınız daha değerli");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Hesap Şifreniz: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Hesap İd Numaranızı Yazınız: ");

        jLabel7.setText("İd Numaranızı Bilmiyorsanız Kullanıcı listeleme panelinden görüntüleyebilirsiniz.");

        jButton1.setText("Ana Menü'ye Dön");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Eklemek/Çekmek İstediğiniz Tutar");

        erortext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        erortext.setForeground(new java.awt.Color(255, 0, 0));

        jButton2.setText("Para Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText(" Para Eklemi işlemi için tüm bilgileri büyük küçük harf ve boşluk dahil doğru girmelisiniz.");

        jButton3.setText("Para Çek");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idtext4)
                                            .addComponent(sifretext4)
                                            .addComponent(tutartext, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(erortext, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idtext4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sifretext4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tutartext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(erortext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            kontrol();
        } catch (SQLException ex) {
            Logger.getLogger(para_ekle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Anamenu().setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         try {
            kontrolcik();
        } catch (SQLException ex) {
            Logger.getLogger(para_ekle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(para_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(para_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(para_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(para_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new para_ekle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel erortext;
    private javax.swing.JTextField idtext4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField sifretext4;
    private javax.swing.JTextField tutartext;
    // End of variables declaration//GEN-END:variables
}
