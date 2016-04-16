package controller;

import model.MemberModel;

public class MemberController extends User {
        private MemberModel memberModel;

        public MemberController() {
                memberModel= new MemberModel();
        }

        public void tambahMember(String nama, String noTelp, String alamat){
            memberModel.setNama(nama);
            memberModel.setNoTelp(noTelp);
            memberModel.setAlamat(alamat);
            memberModel.setLagiPinjam(false);
            memberModel.saveData();
        }
        
        public void deleteMember(int idMember){
            memberModel.deleteData(idMember);
        }
}
