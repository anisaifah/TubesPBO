package model;

import controller.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaksiModel implements HitungTransaksi{
        private int idTransaksi, idMember, idDvd;
        private int biayaTotal, bayar, kembalian, denda;
        private Date tglPinjam, tglKembali, tglPengembalian;
        private boolean sudahDikembalikan;
        private Database db;
        private ResultSet rs;

        public TransaksiModel(){
            db = new Database();
        }
        public int getIdTransaksi() {
                return idTransaksi;
        }

        public void setIdTransaksi() {
        }

        public int getIdMemberPeminjam() {
            return idMember;
        }

        public void setIdMemberPeminjam(int idMember) {
            this.idMember = idMember;
        }

        public int getIdDvdDipinjam() {
            return idDvd;
        }

        public void setIdDvdDipinjam(int idDvd) {
            this.idDvd = idDvd;
        }

        public boolean isSudahDikembalikan() {
            return sudahDikembalikan;
        }

        public void setSudahDikembalikan(boolean sudahDikembalikan) {
            this.sudahDikembalikan = sudahDikembalikan;
        }
        
        public int getBiayaTotal() {
            return biayaTotal;
        }

        public void setBiayaTotal(int biayaTotal) {
            this.biayaTotal = biayaTotal;
        }
        
        public int getBayar() {
            return bayar;
        }

        public void setBayar(int bayar) {
            this.bayar = bayar;
        }

        public int getKembalian() {
            return kembalian;
        }

        public void setKembalian(int kembalian) {
            this.kembalian = kembalian;
        }

        public int getDenda() {
            return denda;
        }

        public void setDenda(int denda) {
            this.denda = denda;
        }

        public Date getTglPinjam() {
            return tglPinjam;
        }

        public void setTglPinjam(Date tglPinjam) {
            this.tglPinjam = tglPinjam;
        }

        public Date getTglKembali() {
            return tglKembali;
        }

        public void setTglKembali(Date tglKembali) {
            this.tglKembali = tglKembali;
        }

        public Date getTglPengembalian() {
            return tglPengembalian;
        }

        public void setTglPengembalian(Date tglPengembalian) {
            this.tglPengembalian = tglPengembalian;
        }
        
        @Override
        public void hitungBiayaTotal(){
            
        }
        @Override
        public void hitungBiayaKembalian(){
            
        }
        @Override
        public void hitungBiayaDenda(){
            
        }
        
        public void loadData(int idTransaksi){
            try{
                db.connect();
                String query = "select * from transaksidb where idTransaksi="+idTransaksi+"";
                ResultSet rs= db.getData(query);
                while(rs.next()) {
                    this.idTransaksi = rs.getInt("idTransaksi");
                    this.idMember = rs.getInt("idMember");
                    this.idDvd = rs.getInt("idDvd");
                    this.tglPinjam = rs.getDate("tglPinjam");
                    this.tglKembali = rs.getDate("tglKembali");
                    this.sudahDikembalikan = rs.getBoolean("sudahDikembalikan");
                }
                
                rs.close();
            }catch(Exception e){}
        }
        
        public void saveData(){
            String query;
            try{
            db.connect();
            query = "insert into transaksidb" 
                +"(idMember, idDvd, tglPinjam, tglKembali, sudahDikembalikan)"
                + "values ("+idMember+","+idDvd+","+ "NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY),"+sudahDikembalikan+")";
                db.execute(query);
                rs.close();
            }catch(Exception e){}
        }
        
        public String getLog() {
            StringBuilder sb = null;
            try {
                db.connect();
                sb = new StringBuilder();
                String query = "select * from transaksidb";
                rs = db.getData(query);
                while (rs.next()) {
                    for (int i = 1; i <= 6; i++) {
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
        
        public void deleteData(int idTransaksi){
            try {
                db.connect();
                String query ="delete from transaksidb where idTransaksi="+idTransaksi+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
         public void updateSudahDikembalikan(boolean sudahDikembalikan){
            try{
                db.connect();
                String query = "update transaksidb set sudahDikembalikan="+sudahDikembalikan+" where idTransaksi="+this.idTransaksi+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void updateSudahDikembalikan(int idTransaksi, boolean sudahDikembalikan){
            try{
                db.connect();
                String query = "update transaksidb set sudahDikembalikan="+sudahDikembalikan+" where idTransaksi="+idTransaksi+"";
                db.execute(query);
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void getNextCurrentId(){
            try {
                db.connect();
                String query = "select * from transaksidb order by idTransaksi desc limit 1";
                rs= db.getData(query);
                while (rs.next()) {
                    this.idTransaksi = rs.getInt("idTransaksi");
                }
                this.idTransaksi++;
                rs.close();
            } catch (SQLException ex) {
                this.idTransaksi=this.idTransaksi;
            }
                     
         }
        
}
