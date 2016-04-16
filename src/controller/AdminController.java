package controller;

import model.AdminModel;

public class AdminController {
        private AdminModel adminModel;
        
        public AdminController(){
            adminModel = new AdminModel();
        }
        
        public void daftar(String nama, String passAdmin, String pertanyaan, String jawaban){
            adminModel.setNama(nama);
            adminModel.setPassAdmin(passAdmin);
            adminModel.setPertanyaan(pertanyaan);
            adminModel.setJawaban(jawaban);
            adminModel.saveData();
        }
        public boolean login(String passAdmin){
            adminModel.loadData();
            return passAdmin.equals(adminModel.getPassAdmin());
        }
        public boolean lupaPassword(String jawaban){
            adminModel.loadData();
            return jawaban.equalsIgnoreCase(adminModel.getJawaban());
        }

}
