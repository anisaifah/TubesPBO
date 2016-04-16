package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.DvdModel;
import model.TransaksiModel;
import model.MemberModel;

public class TransaksiController implements HitungTransaksi{
        private TransaksiModel transaksiModel;
        private MemberModel memberModel;
        private DvdModel dvdModel;
    
        public TransaksiController(){
            transaksiModel = new TransaksiModel();
            memberModel = new MemberModel();
            dvdModel = new DvdModel();
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
        
        
        public void tambahTransaksi(int idMember, int idDvd){
            transaksiModel.setIdMemberPeminjam(idMember);
            transaksiModel.setIdDvdDipinjam(idDvd);
            transaksiModel.setSudahDikembalikan(false);
            transaksiModel.saveData();           
        }
        
        public void pengembalian(int idTransaksi){
            transaksiModel.updateSudahDikembalikan(idTransaksi, true);
            
        }
        
        public void deleteDvd(int idTransaksi){
            transaksiModel.deleteData(idTransaksi);
        }
}
