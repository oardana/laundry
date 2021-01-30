-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jan 2021 pada 07.30
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `biaya_tambahan`
--

CREATE TABLE `biaya_tambahan` (
  `kode_biaya` char(7) NOT NULL,
  `keterangan` varchar(30) NOT NULL,
  `biaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `biaya_tambahan`
--

INSERT INTO `biaya_tambahan` (`kode_biaya`, `keterangan`, `biaya`) VALUES
('KB0001', '1 hari', 3000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_order`
--

CREATE TABLE `detail_order` (
  `kode_order` char(7) NOT NULL,
  `kode_layanan` char(7) NOT NULL,
  `jenis_layanan` varchar(20) NOT NULL,
  `jumlah_unit` int(11) NOT NULL,
  `biaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detail_order`
--

INSERT INTO `detail_order` (`kode_order`, `kode_layanan`, `jenis_layanan`, `jumlah_unit`, `biaya`) VALUES
('KO0003', 'KL0003', 'cuci setengah kering', 200, 4000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `layanan`
--

CREATE TABLE `layanan` (
  `kode_layanan` char(7) NOT NULL,
  `jenis_layanan` varchar(20) NOT NULL,
  `biaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `layanan`
--

INSERT INTO `layanan` (`kode_layanan`, `jenis_layanan`, `biaya`) VALUES
('KL0001', 'cuci basah', 2000),
('KL0002', 'cuci kering', 4000),
('KL0003', 'cuci setengah kering', 4000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kode_pelanggan` char(7) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `no_telepon` varchar(16) NOT NULL,
  `alamat` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`kode_pelanggan`, `nama`, `no_telepon`, `alamat`) VALUES
('KP0002', '', '', ''),
('KP0003', 'ardana', '0876524455', 'semam');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesan`
--

CREATE TABLE `pesan` (
  `kode_order` char(7) NOT NULL,
  `kode_pelanggan` char(7) NOT NULL,
  `no_telepon` varchar(16) NOT NULL,
  `tanggal_order` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `biaya_antar` int(11) NOT NULL,
  `biaya_jemput` int(11) NOT NULL,
  `biaya_hari` int(11) NOT NULL,
  `petugas_antar` varchar(20) NOT NULL,
  `status_order` enum('belum selesai','selesai') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pesan`
--

INSERT INTO `pesan` (`kode_order`, `kode_pelanggan`, `no_telepon`, `tanggal_order`, `tanggal_selesai`, `biaya_antar`, `biaya_jemput`, `biaya_hari`, `petugas_antar`, `status_order`) VALUES
('KO0002', 'KP0002', '', '2021-01-11', '2021-01-14', 0, 0, 0, 'pilih', 'belum selesai'),
('KO0003', 'KP0003', '0876524455', '2021-01-11', '2021-01-14', 2000, 0, 3000, 'Ardana', 'belum selesai');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas_antar`
--

CREATE TABLE `petugas_antar` (
  `kode_petugas` char(7) NOT NULL,
  `nama_petugas` varchar(20) NOT NULL,
  `no_telepon` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `petugas_antar`
--

INSERT INTO `petugas_antar` (`kode_petugas`, `nama_petugas`, `no_telepon`) VALUES
('KP0001', 'Ardana', '08765432712');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `kode_user` char(7) NOT NULL,
  `nama_user` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` enum('admin','kasir') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `biaya_tambahan`
--
ALTER TABLE `biaya_tambahan`
  ADD PRIMARY KEY (`kode_biaya`);

--
-- Indeks untuk tabel `detail_order`
--
ALTER TABLE `detail_order`
  ADD PRIMARY KEY (`kode_order`),
  ADD KEY `kode_layanan` (`kode_layanan`),
  ADD KEY `kode_layanan_2` (`kode_layanan`);

--
-- Indeks untuk tabel `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`kode_layanan`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kode_pelanggan`);

--
-- Indeks untuk tabel `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`kode_order`),
  ADD KEY `kode_pelanggan` (`kode_pelanggan`),
  ADD KEY `kode_pelanggan_2` (`kode_pelanggan`);

--
-- Indeks untuk tabel `petugas_antar`
--
ALTER TABLE `petugas_antar`
  ADD PRIMARY KEY (`kode_petugas`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`kode_user`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_order`
--
ALTER TABLE `detail_order`
  ADD CONSTRAINT `detail_order_ibfk_1` FOREIGN KEY (`kode_order`) REFERENCES `pesan` (`kode_order`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_order_ibfk_2` FOREIGN KEY (`kode_layanan`) REFERENCES `layanan` (`kode_layanan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pesan`
--
ALTER TABLE `pesan`
  ADD CONSTRAINT `pesan_ibfk_1` FOREIGN KEY (`kode_pelanggan`) REFERENCES `pelanggan` (`kode_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
