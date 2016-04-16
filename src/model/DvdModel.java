package model;

import controller.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DvdModel {
        private Database db;
        private ResultSet rs;
        private String judul;
        private int idDvd, tahun, stok = 0;
    
        public DvdModel() {
            db = new Database();
        }

        public int getIdDvd() {
            return idDvd;
        }

        public void setIdDvd(int idDvd) {
            this.idDvd = idDvd;
        }
        
        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public int getTahun() {
            return tahun;
        }

        public void setTahun(int tahun) {
            this.tahun = tahun;
        }

        public int getStok() {
            return stok;
        }

        public void setStok(int stok) {
            this.stok = stok;
        }
        
        public void saveData(){
            String query;
            try{
            db.connect();
            query = "insert into dvddb" 
                +"(judul, tahun, stok)"
                + "values ('"+judul+"',"+ ""+tahun+","+ ""+stok+")";
            
                db.execute(query);
                rs.close();
            }catch(Exception e){}
        }
            
        public void loadData(int idDvd){
            try{
                db.connect();
                String query = "select * from dvddb where idDvd="+idDvd+"";
                ResultSet rs= db.getData(query);
                while(rs.next()) {
                    this.idDvd = rs.getInt("idDvd");
                    this.judul = rs.getString("nama");
                    this.tahun = rs.getInt("tahun");
                    this.stok = rs.getInt("stok");
                }
                
                rs.close();
            }catch(Exception e){}
        }
        
        public int loadDataStok(int idDvd){
            try{
                db.connect();
                String query = "select stok from dvddb where idDvd="+idDvd+"";
                ResultSet rs= db.getData(query);
                while(rs.next()) {
                    this.stok = rs.getInt("stok");
                }
                rs.close();
            }catch(Exception e){}
            return stok;
        }
        
        
        public String getLog() {
            StringBuilder sb = null;
            try {
                db.connect();
                sb = new StringBuilder();
                String query = "select * from dvddb";
                rs = db.getData(query);
                while (rs.next()) {
                    for (int i = 1; i <= 4; i++) {
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
        
        public void updateJudul(int idDvd, String judul){
            try{
                db.connect();
                String query = "update dvddb set judul='"+judul+"' where idDvd="+idDvd+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DvdModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void updateTahun(int idDvd, int tahun){
            try{
                db.connect();
                String query = "update dvddb set tahun="+tahun+" where idDvd="+idDvd+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DvdModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void updateStok(int idDvd, int stok){
            try{
                db.connect();
                String query = "update dvddb set stok="+stok+" where idDvd="+idDvd+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DvdModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         public void deleteData(int idDvd){
            try {
                db.connect();
                String query ="delete from dvddb where idDvd="+idDvd+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DvdModel.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
         public void getNextCurrentId(){
            try {
                db.connect();
                String query = "select * from dvddb order by idDvd desc limit 1";
                rs= db.getData(query);
                while (rs.next()) {
                    this.idDvd = rs.getInt("idDvd");
                }
                this.idDvd++;
                rs.close();
            } catch (SQLException ex) {
                this.idDvd=this.idDvd;
            }
                     
         }
        
}
