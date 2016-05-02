-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06 Mei 2015 pada 11.13
-- Versi Server: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tubespbodb`
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
('ad-001', 'mimin', '123456', 'Dimana saya lahir?', 'Indonesia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dvddb`
--

CREATE TABLE IF NOT EXISTS `dvddb` (
`idDvd` int(100) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `tahun` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `dvddb`
--

INSERT INTO `dvddb` (`idDvd`, `judul`, `tahun`, `stok`) VALUES
(1, 'world class university', 2015, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data untuk tabel `memberdb`
--

INSERT INTO `memberdb` (`idMember`, `nama`, `noTelp`, `alamat`, `lagiPinjam`) VALUES
(1, 'rifqi', '87687868', 'bandung', 1),
(2, 'tito', '14045', 'bandung', 1),
(3, 'ema', '080989999', 'bandung', 1),
(4, 'ipeh', '8768768', 'bandung', 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data untuk tabel `transaksidb`
--

INSERT INTO `transaksidb` (`idTransaksi`, `idMember`, `idDvd`, `tglPinjam`, `tglKembali`, `sudahDikembalikan`) VALUES
(1, 1, 1, '2015-05-06', '2015-05-08', 0),
(2, 2, 1, '2015-05-06', '2015-05-08', 0),
(3, 3, 1, '2015-05-06', '2015-05-08', 0);

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
MODIFY `idDvd` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `memberdb`
--
ALTER TABLE `memberdb`
MODIFY `idMember` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `transaksidb`
--
ALTER TABLE `transaksidb`
MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
