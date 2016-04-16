package controller;

import model.DvdModel;

public class DvdController {
        private DvdModel dvdModel;
        private String idDvd, judul;
        private int tahun, stok = 0;
    
        public DvdController() {
            dvdModel = new DvdModel();
        }

        public void tambahDvd(String judul, int tahun, int stok){
            dvdModel.setJudul(judul);
            dvdModel.setTahun(tahun);
            dvdModel.setStok(stok);
            dvdModel.saveData();
        }
        
        public void deleteDvd(int idDvd){
            dvdModel.deleteData(idDvd);
        }
}
