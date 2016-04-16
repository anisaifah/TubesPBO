package model;
import controller.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberModel extends User{
        private Database db;
        private ResultSet rs;
        private String noTelp, alamat, message = "null";
        private int idMember;
        private boolean lagiPinjam;
        
        public MemberModel(){
            db = new Database();
        }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public void setLagiPinjam(boolean lagiPinjam) {
        this.lagiPinjam = lagiPinjam;
    }
    
        @Override
    public String getNama(){
        return nama;
    }
    
        @Override
    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
        
    public void setMessage(String message){
         this.message = message;
     }
     public String getMessage(){
         return message;
     }
        
        public void saveData(){
            String query;
            try{
            db.connect();
            query = "insert into memberdb" 
                +"(nama, noTelp, alamat, lagiPinjam)"
                + "values ('"+nama+"',"+ "'"+noTelp+"',"+ "'"+alamat+"',"+ ""+lagiPinjam+")";
            
                db.execute(query);
                rs.close();
            }catch(Exception e){}
        }
            
        public void loadData(int idMember){
            try{
                db.connect();
                String query = "select * from memberdb where idMember="+idMember+"";
                ResultSet rs= db.getData(query);
                while(rs.next()) {
                    this.idMember = rs.getInt("idMember");
                    this.nama = rs.getString("nama");
                    this.noTelp = rs.getString("noTelp");
                    this.alamat = rs.getString("alamat");
                    this.lagiPinjam = rs.getBoolean("lagiPinjam");
                }
                
                rs.close();
            }catch(Exception e){}
        }
        
        public boolean isLagiPinjam(int idMember){
            try{
                db.connect();
                String query = "select lagiPinjam from memberdb where idMember="+idMember+"";
                ResultSet rs= db.getData(query);
                while(rs.next()) {
                    this.lagiPinjam = rs.getBoolean("lagi dipinjam");
                }
                rs.close();
            }catch(Exception e){}
            return lagiPinjam;
        }
        
        public String getLog() {
            StringBuilder sb = null;
            try {
                db.connect();
                sb = new StringBuilder();
                String query = "select * from memberdb";
                rs = db.getData(query);
                while (rs.next()) {
                    for (int i = 1; i <= 5; i++) {
                        sb.append(rs.getString(i));
                        sb.append(" ; ");
                    }
                    sb.append('\n');
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("error when get log"); }
            return sb.toString();
        }
        
        public void updateNama(int idMember, String nama){
            try{
                db.connect();
                String query = "update memberdb set nama='"+nama+"' where idMember="+idMember+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MemberModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void updateNoTelp(int idMember, String noTelp){
            try{
                db.connect();
                String query = "update memberdb set noTelp='"+noTelp+"' where idMember="+idMember+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MemberModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void updateAlamat(int idMember, String alamat){
            try{
                db.connect();
                String query = "update memberdb set alamat='"+alamat+"' where idMember="+idMember+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MemberModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void updateLagiPinjam(int idMember, boolean lagiPinjam){
            try{
                db.connect();
                String query = "update memberdb set lagiPinjam="+lagiPinjam+" where idMember="+idMember+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MemberModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         public void deleteData(int idMember){
            try {
                db.connect();
                String query ="delete from memberdb where idMember='"+idMember+"'";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MemberModel.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
         public void getNextCurrentId(){
            try {
                db.connect();
                String query = "select * from memberdb order by idMember desc limit 1";
                rs= db.getData(query);
                while (rs.next()) {
                    this.idMember = rs.getInt("idMember");
                }
                this.idMember++;
                rs.close();
            } catch (SQLException ex) {
                this.idMember=this.idMember;
            }
                     
         }
        
}
