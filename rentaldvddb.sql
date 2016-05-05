-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 05 Mei 2016 pada 11.00
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rentaldvddb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admindb`
--

CREATE TABLE IF NOT EXISTS `admindb` (
  `idAdmin` varchar(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `passAdmin` varchar(20) NOT NULL,
  `pertanyaan` varchar(100) DEFAULT NULL,
  `jawaban` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admindb`
--

INSERT INTO `admindb` (`idAdmin`, `nama`, `passAdmin`, `pertanyaan`, `jawaban`) VALUES
('ad-001', 'mimin', '123456', 'Dimana saya lahir', 'Indonesia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dvddb`
--

CREATE TABLE IF NOT EXISTS `dvddb` (
`idDvd` int(100) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `tahun` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dvddb`
--

INSERT INTO `dvddb` (`idDvd`, `judul`, `tahun`, `stok`) VALUES
(1, 'naruto', 2012, 3),
(2, 'aadc', 2014, 5),
(6, 'Conjuring', 2013, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `memberdb`
--

CREATE TABLE IF NOT EXISTS `memberdb` (
`idMember` int(100) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `noTelp` varchar(15) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `lagiPinjam` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `memberdb`
--

INSERT INTO `memberdb` (`idMember`, `nama`, `noTelp`, `alamat`, `lagiPinjam`) VALUES
(1, 'Parlin Nando', '08213123409', 'sukabirus', 0),
(2, 'Jun Andre', '08391238179', 'sukapura', 0),
(3, 'Anisa Nur Arifah', '083923819387', 'pga', 0),
(4, 'parlin', '093123818', 'sukabirus', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksidb`
--

CREATE TABLE IF NOT EXISTS `transaksidb` (
`idTransaksi` int(11) NOT NULL,
  `idMember` int(11) NOT NULL,
  `idDvd` int(11) NOT NULL,
  `tglPinjam` date NOT NULL,
  `tglKembali` date NOT NULL,
  `sudahDikembalikan` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksidb`
--

INSERT INTO `transaksidb` (`idTransaksi`, `idMember`, `idDvd`, `tglPinjam`, `tglKembali`, `sudahDikembalikan`) VALUES
(1, 2, 1, '2016-04-26', '2016-04-28', 1),
(2, 1, 1, '2016-04-28', '2016-04-30', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admindb`
--
ALTER TABLE `admindb`
 ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `dvddb`
--
ALTER TABLE `dvddb`
 ADD PRIMARY KEY (`idDvd`);

--
-- Indexes for table `memberdb`
--
ALTER TABLE `memberdb`
 ADD PRIMARY KEY (`idMember`);

--
-- Indexes for table `transaksidb`
--
ALTER TABLE `transaksidb`
 ADD PRIMARY KEY (`idTransaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dvddb`
--
ALTER TABLE `dvddb`
MODIFY `idDvd` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `memberdb`
--
ALTER TABLE `memberdb`
MODIFY `idMember` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `transaksidb`
--
ALTER TABLE `transaksidb`
MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
