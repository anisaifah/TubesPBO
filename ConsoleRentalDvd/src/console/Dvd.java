import java.util.Scanner;
public class Dvd{
	private String idDvd; //id DVD akan di generate secara auto
	private String judul; 
	private int tahun;
	private String[] genre; //maksimal genre yg dapat diinput: 5
	private final int HARGA_SEWA = 2000; //constanta harga sewa per dvd per hari
	private int stok = 0; //jumlah DVD per judul
	private boolean status = false; //apakah tersedia atau tidak
	
	public Dvd(){
		status = true;
		stok = 1;
	}
	
	public void setIdDvd(int iddvd){
		//meng-generate id dvd
		String stringTempDvd = String.format("%03d", iddvd);
		idDvd = "dv-"+stringTempDvd;
	}
	
	public String getIdDvd(){
		return idDvd;
	}
	
	public void setJudul(String judul){
		this.judul = judul;
	}
	
	public String getJudul(){
		return judul;
	}
	
	public void setTahun(int tahun){
		this.tahun = tahun;
	}
	
	public int getTahun(){
		return tahun;
	}
	
	public void setStok(int stok){
		this.stok = stok;
	}
	
	public int getStok(){
		return stok;
	}
	
	public void setGenre(int indeks, String isiGenre){
		genre[indeks] = isiGenre;
	}
	
	public void setGenre(){
		int i, j;
		String genreIsi, konfirmasi;
		genre = new String[5];
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.println("Genre :\nDapat menginputkan hingga 5 genre. Tekan tombol '0' untuk berhenti");
		outer: for(i=0; i<5;){
			j=i+1;
			System.out.print("Genre ke-"+j+" : ");
			genreIsi = input.nextLine();
			//START Pengecekan terhadap tombol 0
			if(genreIsi.equals("0")){
				System.out.print("Anda yakin? (y/n) : ");
				konfirmasi = input1.next();
				if(konfirmasi.equalsIgnoreCase("n")){
					continue;
				}
				else if(konfirmasi.equalsIgnoreCase("y")){
					break;
				}
			}
			//END Pengecekan terhadap tombol 0.
			//START input genre
			else{
				//START Pengecekan genre yang sama
				if(i == 0){
					genre[i] = genreIsi;
					i++;
				}
				else{
					for(int k=0 ; k<5; k++){
						while(genre[k] != null){
							if(genre[k].equalsIgnoreCase(genreIsi)){
								System.out.println("Genre sudah ada");
								continue outer;
							}
							k++;
						}
					}
					genre[i] = genreIsi;
					i++;
				}
				//END Pengecekan genre yang sama
			}
			//END input genre
		}
	}
	
	public void getGenre(){
		for(int i=0 ; i<5 ; i++){
			if(genre[i] == null){
				System.out.println("Genre ke-"+(i+1)+" : -");
			}
			else{
				System.out.println("Genre ke-"+(i+1)+" : "+genre[i]);
			}
		}
		System.out.println("\n");
	}
	public String getGenre(int indeks){
		if(genre[indeks] == null){
			return null;
		}
		else{
			return genre[indeks];
		}
	}
	public int getHargaSewa(){
		return HARGA_SEWA;
	}
	
	
	/*
	public void cek(){
		
	}
	public String toString(){
		
	}
	
	
	public static void main(String[] args){ //method main cuma untuk testing aja
		int i;
		Dvd dvd = new Dvd();
		
		//ID
		System.out.println("\nID : "+dvd.getIdDvd());
		
		//Judul
		dvd.setJudul("Ganteng-ganteng Berbulu Domba");
		System.out.println("JUDUL :"+dvd.getJudul());
		
		//Tahun
		dvd.setTahun(2017);
		System.out.println("TAHUN :"+dvd.getTahun());
		
		//Genre
		dvd.setGenre();
		dvd.getGenre();
	}*/
}