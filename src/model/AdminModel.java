package model;
import controller.User;
import java.sql.ResultSet;

public class AdminModel extends User{
        private Database db;
        private ResultSet rs;
        private String passAdmin, pertanyaan, jawaban;
        private final String idAdmin = "ad-001";
        
        public AdminModel(){
            db = new Database();
        }
        
        public String getPertanyaan() {
                return pertanyaan;
        }

        public void setPertanyaan(String pertanyaan) {
                this.pertanyaan = pertanyaan;
        }

        public String getJawaban() {
                return jawaban;
        }

        public void setJawaban(String jawaban) {
                this.jawaban = jawaban;
        }
        
        @Override
        public void setNama(String nama){
            super.setNama(nama);
        }
        
        public String getIdAdmin() {
                return idAdmin;
        }

        public String getPassAdmin() {
                return passAdmin;
        }

        public void setPassAdmin(String passAdmin) {
                this.passAdmin = passAdmin;
        }
        
        public void saveData(){
            String query;
            db.connect();
            try{
            query = "insert into admindb" 
                +"(idAdmin, nama, passAdmin, pertanyaan, jawaban)"
                + "values ('"+idAdmin+"',"+ "'"+nama+"',"+ "'"+passAdmin+"',"+ "'"+pertanyaan+"',"+ "'"+jawaban+"')";
            
                db.execute(query);
                rs.close();
            }catch(Exception e){}
        }
            
        public void loadData(){
            db.connect();
            try{
                String query = "select * from admindb";
                ResultSet rs= db.getData(query);
                while(rs.next()) {
                    this.nama = rs.getString("nama");
                    this.passAdmin = rs.getString("passAdmin");
                    this.pertanyaan = rs.getString("pertanyaan");
                    this.jawaban = rs.getString("jawaban");
                }
                
                rs.close();
            }catch(Exception e){}
        }
        
}
