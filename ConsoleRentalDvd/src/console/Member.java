public class Member extends User{
	private String idMember;
	private String noTelp;
	private String alamat;
	private Transaksi transaksi;
	private String dvdYangDipinjam;
	private String judulDvdYangDipinjam;
	//private int nTransaksi;

	public Member(){
		super("member");
	}

	public void setIdMember(int idm){
		String stringTempMember = String.format("%03d", idm);
		idMember = "mb-"+stringTempMember;
	}
	
	public String getIdMember(){
		return idMember;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}
	
	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}
	
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}
	
	public void pinjam(Dvd dvd, String dvdID, String dvdJudul){
		transaksi = new Transaksi();
		transaksi.setTransaksi(dvd);
		if(transaksi.getStatusTransaksi() == "gagalDipinjam"){
			transaksi = null;
		}
		else if(transaksi.getStatusTransaksi() == "berhasilDipinjam"){
			//transaksi.setIdTransaksi(nTransaksi);
			setDvdYangDipinjam(dvdID);
			setJudulDvdYangDipinjam(dvdJudul);
			//nTransaksi++;
		}
	}
	
	public void setDvdYangDipinjam(String dvdID){
		dvdYangDipinjam = dvdID;
	}
	
	public String getDvdYangDipinjam(){
		return dvdYangDipinjam;
	}
	
	public void setJudulDvdYangDipinjam(String dvdJudul){
		judulDvdYangDipinjam = dvdJudul;
	}
	
	public void statusTransaksi(){
		System.out.println("ID transaksi : "+transaksi.getIdTransaksi());
		System.out.println("PEMINJAM:");
		System.out.println("ID peminjam : "+idMember);
		System.out.println("Nama : "+nama);
		System.out.println("MEMINJAM:");
		System.out.println("ID DVD : "+dvdYangDipinjam);
		System.out.println("Judul : "+judulDvdYangDipinjam);
		System.out.println("DETAIL TANGGAL:");
		System.out.println("Tanggal peminjaman : "+transaksi.getTglPinjam());
		System.out.println("Tanggal Pengembalian : "+transaksi.getTglKembali()+"\n");
	}
		
	public void kembali(){
		transaksi.hitungBiayaDenda();
		setDvdYangDipinjam(null);
		setJudulDvdYangDipinjam(null);
		transaksi = null;
	}
}