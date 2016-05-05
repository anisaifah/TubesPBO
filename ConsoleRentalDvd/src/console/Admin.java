import java.util.Scanner;
public class Admin extends User{
	private String idAdmin;
	private String passAdmin;
	private Dvd[] dvd = new Dvd[100];
	private Member[] member = new Member[100];
	private int nMember = 0, nMemberForId = 0;
	private int nDvd = 0, nDvdForId = 0;
	private boolean statusLogIn = false;
	private Scanner input = new Scanner(System.in);
	private Scanner input1 = new Scanner(System.in);

	public Admin(){
		super("123456");
		passAdmin = "123456";
		//meng-generate id dvd
		String stringTempAdmin = String.format("%03d", 1);
		idAdmin = "ad-"+stringTempAdmin;
	}
	
	public void logIn(){
		boolean ulang = false;
		String konfirmasi;
		outer: do{
			System.out.println("\nSilahkan masukkan data anda");
			System.out.print("ID : ");
			String id = input.next();
			System.out.print("Password : ");
			String pass = input.next();
			if(id.equalsIgnoreCase(idAdmin) && pass.equals(passAdmin)){ //jika id dan password cocok
				System.out.println("Login berhasil");
				statusLogIn = true;
				ulang = false;
				menuAdmin();
			}
			else if(id.equalsIgnoreCase(idAdmin)){ //jika id saja yg cocok
				System.out.println("Login gagal. Password salah");
				inner: for(;;){
					System.out.print("Coba lagi? (y/n)");
					konfirmasi = input.next();
					if(konfirmasi.equalsIgnoreCase("y")){
						ulang = true;
						continue outer;
					}
					else if(konfirmasi.equalsIgnoreCase("n")){
						ulang = false;
						break;
					}
					else{
						System.out.print("Input tidak valid. ");
						continue inner;
					}
				}
			}
			else if(pass.equals(passAdmin)){ //jika password saja yg cocok
				System.out.println("Login gagal. ID salah");
				inner: for(;;){
					System.out.print("Coba lagi? (y/n)");
					konfirmasi = input.next();
					if(konfirmasi.equalsIgnoreCase("y")){
						ulang = true;
						continue outer;
					}
					else if(konfirmasi.equalsIgnoreCase("n")){
						ulang = false;
						break;
					}
					else{
						System.out.print("Input tidak valid. ");
						continue inner;
					}
				}
			}
			else{ //jika keduanya beda
				System.out.println("Login gagal. ID dan Password salah");
				inner: for(;;){
					System.out.print("Coba lagi? (y/n)");
					konfirmasi = input.next();
					if(konfirmasi.equalsIgnoreCase("y")){
						ulang = true;
						continue outer;
					}
					else if(konfirmasi.equalsIgnoreCase("n")){
						ulang = false;
						break;
					}
					else{
						System.out.print("Input tidak valid. ");
						continue inner;
					}
				}
			}
		}while(ulang);
	}
	
	public void setNama(String nama){
		this.nama = nama;
	}
	
	public void setPassAdmin(String passAdmin){
		this.passAdmin = passAdmin;
	}
	
	public String getIdAdmin(){
		return idAdmin;
	}
	
	public String getNama(){
		return nama;
	}

	public String getPassAdmin(){
		return passAdmin;
	}
	
	public void menuAdmin(){
		int pil, pil1, pil2;
		String idMember, idMember1, idDvd, dvdID = null, dvdJudul = null;
		int iMember, iDvd, jMember, kMember;
		boolean dvdDitemukan = false, memberDitemukan = false, memberDapatMeminjam = false, adaTransaksi = false;;
		Dvd dvdFound;
		outer: do{
			System.out.println("\nMENU");
			System.out.println("1. Kelola Member");
			System.out.println("2. Kelola DVD");
			System.out.println("3. Kelola Transaksi");
			System.out.println("4. Log out");
			System.out.print("Pilihan: ");
			pil = input.nextInt();
			switch(pil){
				case 1:
				inner: for(;;){
					System.out.println("\nSUB-MENU: Kelola Member");
					System.out.println("1. Tambah member");
					System.out.println("2. Hapus member");
					System.out.println("3. Edit");
					System.out.println("4. Lihat");
					System.out.println("5. Cari");
					System.out.println("0. Kembali ke menu utama");
					System.out.print("Pilihan: ");
					pil1 = input.nextInt();
					switch(pil1){
						case 0:
							continue outer;
						case 1:
							tambahMember();
							break;
						case 2:
							hapusMember();
							break;
						case 3:
							editMember();
							break;
						case 4:
							lihatSemuaMember();
							break;
						case 5:
							cariMember();
							break;
					}
				}
				
				case 2:
				inner: for(;;){
					System.out.println("\nSUB-MENU: Kelola DVD");;
					System.out.println("1. Tambah DVD");
					System.out.println("2. Hapus DVD");
					System.out.println("3. Edit");
					System.out.println("4. Lihat");
					System.out.println("5. Cari");
					System.out.println("0. Kembali ke menu utama");
					System.out.print("Pilihan: ");
					pil1 = input.nextInt();
					switch(pil1){
						case 0:
							continue outer;
						case 1:
							tambahDVD();
							break;
						case 2:
							hapusDVD();
							break;
						case 3:
							editDVD();
							break;
						case 4:
							lihatSemuaDVD();
							break;
						case 5:
							superInner: for(;;){
								System.out.println("\nSUB-MENU KELOLA DVD: Cari");
								System.out.println("1. Cari menurut nama");
								System.out.println("2. Cari menurut genre");
								System.out.println("0. Kembali ke menu sebelumnya");
								System.out.print("Pilihan : ");
								pil2 = input.nextInt();
								switch(pil2){
									case 1:
										cariDvdNama();
										continue superInner;
									case 2:
										cariDvdGenre();
										continue superInner;
									case 0:
										continue inner;
								}
							}
					}
				}
				
				case 3:
				inner: for(;;){
					System.out.println("\nSUB-MENU: Kelola Transaksi");
					System.out.println("1. Peminjaman");
					System.out.println("2. Pengembalian");
					System.out.println("3. Lihat");
					System.out.println("0. Kembali ke menu utama");
					System.out.print("Pilihan: ");
					pil1 = input.nextInt();
					switch(pil1){
						case 0:
							continue outer;
						case 1:
							System.out.print("\nInputkan nama atau ID member : ");
							idMember = input1.nextLine();
							System.out.print("Inputkan judul atau ID DVD : ");
							idDvd = input1.nextLine();
							dvdFound = null;
							for(iMember = 0 ; iMember<member.length ; iMember ++){ //mencari member sesuai inputan
								if(member[iMember] == null){memberDapatMeminjam = false; memberDitemukan = false; break;}
								else if((member[iMember].getIdMember().equalsIgnoreCase(idMember)) || (member[iMember].getNama().equalsIgnoreCase(idMember))){
									memberDitemukan = true;
									if(member[iMember].getDvdYangDipinjam() != null){
										memberDapatMeminjam = false;
									}
									else if(member[iMember].getDvdYangDipinjam() == null){
										memberDapatMeminjam = true; //tiap member hanya boleh satu transaksi
									}
									break;
								}
							}
							for(iDvd = 0 ; iDvd<dvd.length ; iDvd++){ //mencari dvd sesuai inputan
								if(dvd[iDvd] == null){dvdDitemukan = false; break;}
								else if((dvd[iDvd].getIdDvd().equalsIgnoreCase(idDvd)) || (dvd[iDvd].getJudul().equalsIgnoreCase(idDvd))){
									dvdFound = dvd[iDvd];
									dvdID = dvd[iDvd].getIdDvd();
									dvdJudul = dvd[iDvd].getJudul();
									dvdDitemukan = true;
									break;
								}
							}
							if(memberDitemukan && dvdDitemukan && memberDapatMeminjam){
								member[iMember].pinjam(dvdFound, dvdID, dvdJudul);
								break;
							}
							else if(!memberDitemukan && dvdDitemukan){System.out.println("Member tidak ditemukan");break;}
							else if(memberDitemukan && !dvdDitemukan){System.out.println("DVD tidak ditemukan");break;}
							else if(!memberDitemukan && !dvdDitemukan){System.out.println("Member dan DVD tidak ditemukan");break;}
							else if(memberDitemukan && dvdDitemukan && !memberDapatMeminjam){System.out.println("Tidak dapat melanjutkan. Member ini masih dalam status peminjaman");break;}
							//break;
						case 2:
							System.out.print("\nInputkan nama atau ID member : ");
							idMember1 = input1.nextLine();
							for(kMember = 0 ; kMember < member.length ; kMember++){
								if(member[kMember] == null){break;}
								else if((member[kMember].getIdMember().equalsIgnoreCase(idMember1)) || (member[kMember].getNama().equalsIgnoreCase(idMember1))){
									if(member[kMember].getDvdYangDipinjam() != null){
										member[kMember].kembali();
										System.out.println("Proses pengembalian DVD selesai");
										break;
									}
									else if(member[kMember].getDvdYangDipinjam() == null){
										System.out.println("Member ini tidak sedang meminjam");
										break;
									}
								}
							}
							break;
						case 3:
							for(jMember = 0 ; jMember<member.length ; jMember ++){
								if((jMember > 0) && (member[jMember] == null) && (adaTransaksi == false)){
									System.out.println("Tidak ada transaksi");
									break;
								}
								else  if(member[jMember] == null){break;}
								else if(member[jMember].getDvdYangDipinjam() != null){
									System.out.println("\n");
									adaTransaksi = true;
									member[jMember].statusTransaksi();
									continue;
								}
								else if(member[jMember].getDvdYangDipinjam() == null){
									continue;
								}
								else{System.out.println("Tidak ditemukan");}
							}
							break;
					}
				}
				
				case 4:
				statusLogIn = false;
				System.out.println("\nAnda telah log out");
				System.out.println("Tekan 1 untuk log in kembali, atau tekan lainnya untuk keluar program");
				String logInKembali = input.next();
				if(logInKembali.equals("1")){
					logIn();
					break;
				}
			}
		}while(pil>0 && pil <4);
	}
	public void tambahMember(){
		int konfirmasi; boolean sama = false;
		System.out.print("Nama : ");
		String nama = input1.nextLine();
		System.out.print("No. telp. : ");
		String noTelp = input.next();
		System.out.print("Alamat : ");
		String alamat = input1.nextLine();
		for(int i = 0; i < member.length; i++){ //mencari lalu membandingkan inputan dgn member yg sudah ada. untuk mencegah member duplikat
			if(member[i] == null){break;}
			else{
				if(member[i].getNama().equalsIgnoreCase(nama)){
					sama = true;
					System.out.println("Sudah ada member dengan nama "+nama+" Detail:");
					System.out.println("ID : "+member[i].getIdMember());
					System.out.println("Nama : "+member[i].getNama());
					System.out.println("No. telp. : "+member[i].getNoTelp());
					System.out.println("Alamat : "+member[i].getAlamat());
					break;
				}
			}
		}
		if(sama == false){
			member[nMember] = new Member();
			member[nMember].setIdMember(nMemberForId+1);
			member[nMember].setNama(nama);
			member[nMember].setNoTelp(noTelp);
			member[nMember].setAlamat(alamat);
			nMember++;
			nMemberForId++;
			System.out.println("Berhasil menambah member baru");
		}
	}
	public void hapusMember(){
		String konfirmasi;
		System.out.print("\nInputkan nama atau id member :");
		String inputan = input1.nextLine();
		for(int i = 0; i < member.length; i++){
			if(member[i] == null){
				System.out.println("Tidak ada hasil untuk "+inputan);
				break;
			}
			else{
				if((member[i].getNama().equalsIgnoreCase(inputan)) || (member[i].getIdMember().equalsIgnoreCase(inputan))){
					System.out.println("Member ditemukan. Detail:");
					System.out.println("ID : "+member[i].getIdMember());
					System.out.println("Nama : "+member[i].getNama());
					System.out.println("No. telp. : "+member[i].getNoTelp());
					System.out.println("Alamat : "+member[i].getAlamat());
					System.out.print("Anda yakin ingin menghapus member ini (y/n)? : ");
					konfirmasi = input.next();
					if(konfirmasi.equalsIgnoreCase("y")){
						if(member[i].getDvdYangDipinjam() != null){
							System.out.println("Tidak dapat melanjutkan. Member ini masih dalam tahap peminjaman");
						}
						else if(member[i].getDvdYangDipinjam() == null){
							member[i] = null; //menghapus member yg dipilih
							for (int j=0; j<member.length; j++){ //START memindahkan null ke akhir array
								if (member[j]==null){
									for (int k=j+1; k<member.length; k++){
										member[k-1] = member[k];
									}
									//member[member.length-1] = null;
									break;
								}
							}  //END memindahkan null ke akhir array
							nMember--;
							System.out.println("Berhasil dihapus");
						}
					}
					else if(konfirmasi.equalsIgnoreCase("n")){
						break;
					}
					break;
				}
			}
		}
	}
	public void editMember(){
		int pil; String nama, noTelp, alamat;
		System.out.print("\nInputkan ID atau nama member :");
		String inputan = input1.nextLine();
		for(int i = 0; i < member.length; i++){
			if(member[i] == null){
				System.out.println("Tidak ada hasil untuk "+inputan);
				break;
			}
			else{
				if((member[i].getNama().equalsIgnoreCase(inputan)) || (member[i].getIdMember().equalsIgnoreCase(inputan))){
					System.out.println("Member ditemukan. Detail:");
					System.out.println("ID : "+member[i].getIdMember());
					System.out.println("Nama : "+member[i].getNama());
					System.out.println("No. telp. : "+member[i].getNoTelp());
					System.out.println("Alamat : "+member[i].getAlamat());

					System.out.println("\nMENU EDIT");
					System.out.println("1. Nama");
					System.out.println("2. No. telp.");
					System.out.println("3. Alamat");
					System.out.println("0. Batal");
					System.out.print("Pilihan : ");
					pil = input.nextInt();
					switch(pil){
						case 0:
							break;
						case 1:
							System.out.print("Inputkan data baru : ");
							nama = input1.nextLine();
							member[i].setNama(nama);
							System.out.println("Nama berhasil diperbaharui");
							break;
						case 2:
							System.out.print("Inputkan data baru : ");
							noTelp = input.next();
							member[i].setNoTelp(noTelp);
							System.out.println("No. telp. berhasil diperbaharui");
							break;
						case 3:
							System.out.print("Inputkan data baru : ");
							alamat = input.nextLine();
							member[i].setAlamat(alamat);
							System.out.println("Alamat berhasil diperbaharui");
							break;
					}
					break;
				}
			}
		}
	}
	public void lihatSemuaMember(){
		for(int i = 0; i < member.length; i++){
			if(i==0 && member[i] == null){System.out.println("\nTidak ada member"); break;}
			else if(member[i] == null){break;}
			else{
				System.out.println("\n==========Member "+(i+1)+"==========");
				System.out.println("ID : "+member[i].getIdMember());
				System.out.println("Nama : "+member[i].getNama());
				System.out.println("No. telp. : "+member[i].getNoTelp());
				System.out.println("Alamat : "+member[i].getAlamat());
			}
		}
	}
	public void cariMember(){
		System.out.print("\nInputkan ID atau nama member yang ingin dicari : ");
		String inputan = input1.nextLine();
		for(int i = 0; i < member.length; i++){
			if(member[i] == null){
				System.out.println("Tidak ada hasil untuk "+inputan);
				break;
			}
			else{
				if((member[i].getNama().equalsIgnoreCase(inputan)) || (member[i].getIdMember().equalsIgnoreCase(inputan))){
					System.out.println("\nMember ditemukan. Detail:");
					System.out.println("ID : "+member[i].getIdMember());
					System.out.println("Nama : "+member[i].getNama());
					System.out.println("No. telp. : "+member[i].getNoTelp());
					System.out.println("Alamat : "+member[i].getAlamat());
					break;
				}
			}
		}
	}
	public void tambahDVD(){
		int konfirmasi; boolean sama = false;
		System.out.print("Judul : ");
		String judul = input1.nextLine();
		System.out.print("Tahun : ");
		int tahun = input.nextInt();
		System.out.print("Stok : ");
		int stok = input.nextInt();
		for(int i = 0; i < dvd.length; i++){ //mencari lalu membandingkan inputan dgn dvd yg sudah ada. untuk mencegah dvd duplikat
			if(dvd[i] == null){break;}
			else{
				if(dvd[i].getJudul().equalsIgnoreCase(judul)){
					sama = true;
					System.out.println("Sudah ada DVD dengan judul "+judul);
					System.out.println("Apakah anda ingin menambahkan stok DVD tersebut?");
					System.out.println("1. Ya, tambahkan stok sebanyak "+stok+" buah");
					System.out.println("2. Tidak, batalkan menginput DVD baru");
					System.out.print("Pilihan : ");
					konfirmasi = input.nextInt();
					if(konfirmasi == 1){
						dvd[i].setStok(dvd[i].getStok()+stok);
						System.out.println("Berhasil menambah stok ");
					}
					else if(konfirmasi == 2){
						break;
					}
				}
			}
		}
		if(sama == false){
			dvd[nDvd] = new Dvd();
			dvd[nDvd].setIdDvd(nDvdForId+1);
			dvd[nDvd].setJudul(judul);
			dvd[nDvd].setTahun(tahun);
			dvd[nDvd].setStok(stok);
			dvd[nDvd].setGenre();
			nDvd++;
			nDvdForId++;
		}
	}
	public void hapusDVD(){
		int iMember;
		String konfirmasi;
		boolean dvdDapatDihapus = true;
		System.out.print("\nInputkan judul atau id DVD :");
		String inputan = input1.nextLine();
		for(int i = 0; i < dvd.length; i++){
			if(dvd[i] == null){
				System.out.println("Tidak ada hasil untuk "+inputan);
				break;
			}
			else{
				if((dvd[i].getJudul().equalsIgnoreCase(inputan)) || (dvd[i].getIdDvd().equalsIgnoreCase(inputan))){		
					System.out.println("DVD ditemukan. Detail:");
					System.out.println("ID : "+dvd[i].getIdDvd());
					System.out.println("Judul : "+dvd[i].getJudul());
					System.out.println("Tahun : "+dvd[i].getTahun());
					System.out.println("Stok : "+dvd[i].getStok());
					System.out.println("Genre : ");
					dvd[i].getGenre();
					System.out.print("Anda yakin ingin menghapus DVD ini (y/n)? : ");
					konfirmasi = input.next();
					if(konfirmasi.equalsIgnoreCase("y")){
						for(iMember = 0 ; iMember < member.length; iMember++){
							if(member[iMember] == null){dvdDapatDihapus = true; break;}
							else if(member[iMember].getDvdYangDipinjam() == dvd[i].getIdDvd()){
								System.out.println("DVD ini tidak dapat dihapus karena masih dipinjam oleh member dengan ID "+member[iMember].getIdMember());
								dvdDapatDihapus = false;
								break;
							}
						}
						if(dvdDapatDihapus){
							dvd[i] = null;
							for (int j=0; j<dvd.length; j++){ //START memindahkan null ke akhir array
								if (dvd[j]==null){
									for (int k=j+1; k<dvd.length; k++){
										dvd[k-1] = dvd[k];
									}
									dvd[dvd.length-1] = null;
									break;
								}
							}  //END memindahkan null ke akhir array
							nDvd--;
							System.out.println("Berhasil dihapus");
						}
					}
					else if(konfirmasi.equalsIgnoreCase("n")){
						break;
					}
					break;
				}
			}
		}
	}
	public void editDVD(){
		int pil, pil1, tahun, stok; String judul, genre, hapusGenre; boolean ditemukan = false;
		System.out.print("\nInputkan judul atau id DVD yang ingin diedit : ");
		String inputan = input1.nextLine();
		outer: for(int i = 0; i < dvd.length; i++){
			if(dvd[i] == null){
				System.out.println("Tidak ada hasil untuk "+inputan);
				break;
			}
			else{
				if((dvd[i].getJudul().equalsIgnoreCase(inputan)) || (dvd[i].getIdDvd().equalsIgnoreCase(inputan))){
					System.out.println("DVD ditemukan. Detail:");
					System.out.println("ID : "+dvd[i].getIdDvd());
					System.out.println("Judul : "+dvd[i].getJudul());
					System.out.println("Tahun : "+dvd[i].getTahun());
					System.out.println("Stok : "+dvd[i].getStok());
					System.out.println("Genre : ");
					dvd[i].getGenre();
					System.out.println("\nMENU EDIT");
					System.out.println("1. Judul");
					System.out.println("2. Tahun");
					System.out.println("3. Stok");
					System.out.println("4. Genre");
					System.out.println("0. Batal");
					System.out.print("Pilihan : ");
					pil = input.nextInt();
					switch(pil){
						case 0:
							break outer;
						case 1:
							System.out.print("Inputkan data baru : ");
							judul = input1.nextLine();
							dvd[i].setJudul(judul);
							System.out.println("Judul berhasil diperbaharui");
							break outer;
						case 2:
							System.out.print("Inputkan data baru : ");
							tahun = input.nextInt();
							dvd[i].setTahun(tahun);
							System.out.println("Tahun berhasil diperbaharui");
							break outer;
						case 3:
							System.out.print("Inputkan data baru : ");
							stok = input.nextInt();
							dvd[i].setStok(stok);
							System.out.println("Stok berhasil diperbaharui");
							break outer;
						case 4:
							System.out.println("1. Tambah genre baru");
							System.out.println("2. Hapus genre yang sudah ada");
							System.out.println("0. Batal");
							System.out.print("Pilihan : ");
							pil1 = input.nextInt();
							switch(pil1){
								case 0: break outer;
								case 1:
									if(dvd[i].getGenre(4) != null){
										System.out.print("Tidak dapat menginputkan data karena array sudah penuh");
									}
									else {
										System.out.print("\nInputkan genre: ");
										genre = input1.nextLine();
										for(int j = 0; j < 5; j++){ //memeriksa apakah ada genre yg sama
											if(dvd[i].getGenre(j) == null){break;}
											else if(dvd[i].getGenre(j).equalsIgnoreCase(genre)){
												System.out.println("Genre sudah ada");
												ditemukan = true;
												break;
											}
										}
										if(!ditemukan){
											for(int k = 0; k < 5; k++){ //menelusuri genre
												if(dvd[i].getGenre(k) == null){
													dvd[i].setGenre(k, genre);
													System.out.println("Genre berhasil ditambahkan");
													break;
												}
											}
										}
									}
									break outer;
								case 2:
									System.out.print("Inputkan genre yang ingin dihapus : ");
									hapusGenre = input1.nextLine();
									for(int l=0 ; l<5; l++){
										if((l == 0) && (dvd[i].getGenre(l) == null)){System.out.println("DVD ini tidak memiliki genre apapun");break;}
										else if(dvd[i].getGenre(l) == null){break;}
										else if(dvd[i].getGenre(l).equalsIgnoreCase(hapusGenre)){
											dvd[i].setGenre(l, null);
											for (int m=0; m<5; m++){ //START memindahkan null ke akhir array
												if (dvd[i].getGenre(m)==null){
													for (int n=m+1; n<5; n++){
														dvd[i].setGenre(n-1, dvd[i].getGenre(n));
													}
													dvd[i].setGenre(4, null);
													break;
												}
											}  //END memindahkan null ke akhir array
											System.out.print("genre berhasil dihapus");
											break;
										}
									}
									break outer;
							}
					}
				}
			}
		}
	}
	public void lihatSemuaDVD(){
		for(int i = 0; i < dvd.length; i++){
			if(i==0 && dvd[i] == null){System.out.println("\nTidak ada DVD"); break;}
			else if(dvd[i] == null){break;}
			else{
				System.out.println("\n===========DVD "+(i+1)+"===========");
				System.out.println("ID : "+dvd[i].getIdDvd());
				System.out.println("Judul : "+dvd[i].getJudul());
				System.out.println("Tahun : "+dvd[i].getTahun());
				System.out.println("Stok : "+dvd[i].getStok());
				System.out.println("Genre : ");
				dvd[i].getGenre();
			}
		}
	}
	public void cariDvdNama(){
		System.out.print("\nJudul DVD yang ingin dicari : ");
		String judul = input1.nextLine();
		for(int i = 0; i < dvd.length; i++){
			if(dvd[i] == null){
				System.out.println("Tidak ada hasil untuk "+judul);
				break;
			}
			else{
				if(dvd[i].getJudul().equalsIgnoreCase(judul)){
					System.out.println("\nDVD ditemukan. Detail:");
					System.out.println("ID : "+dvd[i].getIdDvd());
					System.out.println("Judul : "+dvd[i].getJudul());
					System.out.println("Tahun : "+dvd[i].getTahun());
					System.out.println("Stok : "+dvd[i].getStok());
					System.out.println("Genre : ");
					dvd[i].getGenre();
					break;
				}
			}
		}
	}
	public void cariDvdGenre(){
		int nDitemukan = 0;
		String judulTemp = "";
		System.out.print("\nGenre yang ingin dicari: ");
		String genre = input1.nextLine();
		for(int i = 0; i < dvd.length; i++){ //menelusuri DVD satu2
			if(dvd[i] == null){break;}
			else{
				for(int j = 0; j < 5; j++){ //menulusuri genre pada DVD tsb
					if(dvd[i].getGenre(j) == null){break;}
					else{
						if(dvd[i].getGenre(j).equalsIgnoreCase(genre)){
							System.out.println("\n===========DVD "+(i+1)+"===========");
							System.out.println("ID : "+dvd[i].getIdDvd());
							System.out.println("Judul : "+dvd[i].getJudul());
							System.out.println("Tahun : "+dvd[i].getTahun());
							System.out.println("Stok : "+dvd[i].getStok());
							System.out.println("Genre : ");
							dvd[i].getGenre();
							nDitemukan += 1;
							break;
						}
					}
				}
			}
		}
		if(nDitemukan == 0){
			System.out.println("\nTidak ada hasil untuk "+genre);
		}
		else{
			System.out.println("Total: "+nDitemukan+" DVD dengan genre "+genre);
		}
	}
	/*
	public void addMember(Member member){
		this.member[nMember] = member;
		this.nMember++;
	}

	public int getnMember(){
		return nMember;
	}	
	
	
	
	//Login
		admin.logIn();
		
		//Jika loggin benar
		admin.menuAdmin();
		
		//ID
		System.out.println("\nID : "+dvd[nDvd].getIdDvd());
		
		//Judul
		System.out.println("JUDUL :"+dvd[nDvd].getJudul());
		
		//Tahun
		System.out.println("TAHUN :"+dvd[nDvd].getTahun());
		
		//Genre
		dvd[nDvd].getGenre();
	*/
}