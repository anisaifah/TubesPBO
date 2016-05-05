import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
public class Transaksi implements HitungTransaksi{
	private String idTransaksi;
	private int bayar;
	private int kembalian;
	private long denda;
	private long bayarDenda;
	private long kembalianDenda;
	private Date tglPinjam;
	private Date tglKembali;
	private Date tglPengembalian;
	private Dvd dvd;
	private String statusTransaksi;
	private Scanner input = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
	
	public void setIdTransaksi(int idt){
		String stringTempTransaksi = String.format("%03d", idt);
		idTransaksi = "tr-"+stringTempTransaksi;
	}
	
	public String getIdTransaksi(){
		return idTransaksi;
	}
	
	public void setTransaksi(Dvd dvd){
		this.dvd = dvd;
		if(dvd.getStok() == 0){
			setStatusTransaksi("gagalDipinjam");
			System.out.println("Stok DVD ini sudah habis. Transaksi gagal");
		}
		else{
			dvd.setStok(dvd.getStok()-1);
			
			tglPinjam = new Date();
			Calendar kalender =  Calendar.getInstance();
			kalender.add(Calendar.DATE, 3);
			setTglPinjam(tglPinjam);
			setTglKembali(kalender.getTime());
			//System.out.println("Tanggal pinjam : "+sdf.format(getTglPinjam()));
			//System.out.println("Tanggal kembali : "+sdf.format(getTglKembali()));
			
			hitungBiayaTotal();
			
			setStatusTransaksi("berhasilDipinjam");
			System.out.println("Transaksi berhasil ditambahkan");
		}
	}
	
	public void setTglPinjam(Date tglPinjam){
		this.tglPinjam = tglPinjam;
	}
	
	public String getTglPinjam(){
		return sdf.format(tglPinjam);
	}
	
	public void setTglKembali(Date tglKembali){
		this.tglKembali = tglKembali;
	}
	
	public String getTglKembali(){
		return sdf.format(tglKembali);
	}
	
	public void setTglPengembalian(Date tglPengembalian){
		this.tglPengembalian = tglPengembalian;
	}
	
	public String getTglPengembalian(){
		return sdf.format(tglPengembalian);
	}
	
	public void hitungBiayaTotal(){
		System.out.println("Total biaya : "+dvd.getHargaSewa());
		System.out.print("Bayar : ");
		bayar = input.nextInt();
		if(bayar > dvd.getHargaSewa()){
			hitungBiayaKembalian();
		}
	}
	public void hitungBiayaKembalian(){
		kembalian = bayar - dvd.getHargaSewa();
		System.out.println("Kembalian :"+kembalian);
	}
	public void hitungBiayaDenda(){
		dvd.setStok(dvd.getStok()+1);
		setStatusTransaksi("telahDikembalikan");
		tglPengembalian = new Date();
		setTglPengembalian(tglPengembalian);
		if(tglPengembalian.after(tglKembali)){
			long selisih  = tglPengembalian.getTime() - tglKembali.getTime();
			long nHariTelat = TimeUnit.MILLISECONDS.toDays(selisih);
			denda = 2000*nHariTelat;
			System.out.println("Denda : "+denda);
			bayarDenda = input.nextLong();
			if(bayarDenda > denda){
				kembalianDenda = bayarDenda - denda;
				System.out.println("Kembalian :"+kembalianDenda);
			}
		}
		else{
			System.out.println("Tidak ada denda");
		}
	}
	
	public void setStatusTransaksi(String status){
		statusTransaksi = status;
	}
	
	public String getStatusTransaksi(){
		return statusTransaksi;
	}
	
	//public String toString(){
	//}
}