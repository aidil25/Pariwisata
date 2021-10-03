-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2019 at 04:24 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pariwisata`
--

-- --------------------------------------------------------

--
-- Table structure for table `guide`
--

CREATE TABLE `guide` (
  `id_guide` varchar(10) NOT NULL,
  `nama_guide` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `tarif_guide` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guide`
--

INSERT INTO `guide` (`id_guide`, `nama_guide`, `alamat`, `telepon`, `tarif_guide`) VALUES
('G001', 'Farhan Pratama ', 'Bukittinggi', '081266030058', '100000'),
('G002', 'Muhammad Abdur Rozak', 'Solok', '081374689076', '125000'),
('G003', 'Razitul Ikhlas', 'Padang', '081234567890', '150000'),
('G004', 'Banny Akbar', 'Padang', '081234567895', '150000'),
('G005', 'Fikri Maulana', 'Pekanbaru', '081234567896', '150000'),
('G007', 'Ramadhani', 'pasaman', '081234567898', '200000');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_penginapan`
--

CREATE TABLE `jenis_penginapan` (
  `id_jenis_penginapan` varchar(10) NOT NULL,
  `jenis_penginapan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_penginapan`
--

INSERT INTO `jenis_penginapan` (`id_jenis_penginapan`, `jenis_penginapan`) VALUES
('JP001', 'Hotel'),
('JP002', 'Wisma'),
('JP003', 'Villa');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_transportasi`
--

CREATE TABLE `jenis_transportasi` (
  `id_jenis_transportasi` varchar(10) NOT NULL,
  `jenis_transportasi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_transportasi`
--

INSERT INTO `jenis_transportasi` (`id_jenis_transportasi`, `jenis_transportasi`) VALUES
('JT01', 'Mobil'),
('JT03', 'Bus'),
('JTO2', 'MiniBus');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_wisata`
--

CREATE TABLE `jenis_wisata` (
  `id_jenis_wisata` varchar(10) NOT NULL,
  `jenis_wisata` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_wisata`
--

INSERT INTO `jenis_wisata` (`id_jenis_wisata`, `jenis_wisata`) VALUES
('JW001', 'Alam'),
('JW002', 'Air');

-- --------------------------------------------------------

--
-- Table structure for table `kuliner`
--

CREATE TABLE `kuliner` (
  `id_kuliner` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `paket_travel`
--

CREATE TABLE `paket_travel` (
  `id_paket_travel` varchar(10) NOT NULL,
  `id_wisata` varchar(10) NOT NULL,
  `nama_wisata` varchar(50) NOT NULL,
  `tarif_wisata` varchar(25) NOT NULL,
  `id_transportasi` varchar(10) NOT NULL,
  `nama_kendaraan` varchar(30) NOT NULL,
  `tarif_transportasi` varchar(25) NOT NULL,
  `id_penginapan` varchar(10) NOT NULL,
  `nama_penginapan` varchar(50) NOT NULL,
  `tarif_penginapan` varchar(25) NOT NULL,
  `lama_wisata` varchar(25) NOT NULL,
  `jumlah_rombongan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paket_travel`
--

INSERT INTO `paket_travel` (`id_paket_travel`, `id_wisata`, `nama_wisata`, `tarif_wisata`, `id_transportasi`, `nama_kendaraan`, `tarif_transportasi`, `id_penginapan`, `nama_penginapan`, `tarif_penginapan`, `lama_wisata`, `jumlah_rombongan`) VALUES
('PT001', 'W001', 'Pantai Padang - Jam Gadang - Lembah Harau', '350000', 'TPT001', 'Avanza', '200000', 'PP001', 'Rocky  Hotel', '300000', '3', '6'),
('PT002', 'W002', 'Ngarai Sianok - Puncak Lawang - Danau Singkarak', '350000', 'TPT003', 'Mitsubishi', '300000', 'PP003', 'Villa Bukik', '120000', '3', '15'),
('PT003', 'W003', 'Pantai Carocok - Pulau Sirandah - Pulau Sikuai', '500000', 'TPT003', 'Mitsubishi', '300000', 'PP003', 'Villa Bukik', '120000', '3', '10'),
('PT004', 'W004', 'Puncak Mandeh - Danau Singkarak - Mifan', '400000', 'TPT001', 'Avanza', '200000', 'PP002', 'Wisma Kirana', '150000', '3', '6'),
('PT005', 'W005', 'Kebun Teh - Danau Kembar - Seribu Rumah Gadang', '350000', 'TPT002', 'Toyota', '500000', 'PP002', 'Wisma Kirana', '150000', '3', '15'),
('PT006', 'W001', 'Pantai Padang - Jam Gadang - Lembah Harau', '350000', 'TPT002', 'Toyota', '500000', 'PP002', 'Wisma Kirana', '150000', '3', '12');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` varchar(10) NOT NULL,
  `id_pemesanan` varchar(10) NOT NULL,
  `total_bayar` varchar(25) NOT NULL,
  `jumlah_bayar` varchar(25) NOT NULL,
  `sisa` varchar(25) NOT NULL,
  `tanggal_transaksi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_pemesanan`, `total_bayar`, `jumlah_bayar`, `sisa`, `tanggal_transaksi`) VALUES
('PMB001', 'PMS001', '4590000.0', '5000000.0', '410000.0', '2019-06-28'),
('PMB002', 'PMS002', '8316000.0', '9000000.0', '684000.0', '2019-07-01'),
('PMB003', 'PMS003', '8316000.0', '9000000.0', '684000.0', '2019-06-28'),
('PMB004', 'PMS004', '4050000.0', '4100000.0', '50000.0', '2019-07-01'),
('PMB005', 'PMS006', '9000000.0', '9000000.0', '0.0', '2019-07-02');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pemesanan` varchar(10) NOT NULL,
  `id_guide` varchar(10) NOT NULL,
  `id_wisatawan` varchar(10) NOT NULL,
  `pilih_paket` varchar(25) NOT NULL,
  `id_paket_travel` varchar(10) NOT NULL,
  `id_wisata` varchar(10) NOT NULL,
  `id_transportasi` varchar(10) NOT NULL,
  `id_penginapan` varchar(10) NOT NULL,
  `lama_wisata` varchar(25) NOT NULL,
  `jumlah_rombongan` varchar(10) NOT NULL,
  `tanggal_perjalanan` date NOT NULL,
  `total_bayar` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`id_pemesanan`, `id_guide`, `id_wisatawan`, `pilih_paket`, `id_paket_travel`, `id_wisata`, `id_transportasi`, `id_penginapan`, `lama_wisata`, `jumlah_rombongan`, `tanggal_perjalanan`, `total_bayar`) VALUES
('PMS001', 'G002', 'WN001', 'paket', 'PT001', 'W001', 'TPT001', 'PP001', '3', '6', '2019-06-24', '4590000.0'),
('PMS002', 'G003', 'WN002', 'paket', 'PT002', 'W002', 'TPT003', 'PP003', '3', '15', '2019-06-28', '8316000.0'),
('PMS003', 'G001', 'WN003', 'paket', 'PT003', 'W003', 'TPT003', 'PP003', '3', '10', '2019-06-29', '7176000.0'),
('PMS004', 'G004', 'WN004', 'paket', 'PT004', 'W004', 'TPT001', 'PP002', '3', '6', '2019-06-29', '4050000.0'),
('PMS006', 'G005', 'WN005', 'paket', 'PT006', 'W001', 'TPT002', 'PP002', '3', '12', '2019-07-01', '9000000.0');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` varchar(10) NOT NULL,
  `id_pemesanan` varchar(10) NOT NULL,
  `tanggal_perjalanan` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `terlambat` varchar(11) NOT NULL,
  `denda` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `penginapan`
--

CREATE TABLE `penginapan` (
  `id_penginapan` varchar(10) NOT NULL,
  `nama_penginapan` varchar(50) NOT NULL,
  `id_jenis_penginapan` varchar(10) NOT NULL,
  `tarif_penginapan` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penginapan`
--

INSERT INTO `penginapan` (`id_penginapan`, `nama_penginapan`, `id_jenis_penginapan`, `tarif_penginapan`) VALUES
('PP001', 'Rocky  Hotel', 'JP001', '300000'),
('PP002', 'Wisma Kirana', 'JP002', '150000'),
('PP003', 'Villa Bukik', 'JP003', '120000');

-- --------------------------------------------------------

--
-- Table structure for table `transportasi`
--

CREATE TABLE `transportasi` (
  `id_transportasi` varchar(10) NOT NULL,
  `nama_kendaraan` varchar(30) NOT NULL,
  `id_jenis_transportasi` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `tarif_transportasi` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transportasi`
--

INSERT INTO `transportasi` (`id_transportasi`, `nama_kendaraan`, `id_jenis_transportasi`, `status`, `tarif_transportasi`) VALUES
('TPT001', 'Avanza', 'JT01', 'ada', '200000'),
('TPT002', 'Toyota', 'JT03', 'ada', '500000'),
('TPT003', 'Mitsubishi', 'JTO2', 'ada', '300000');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` text NOT NULL,
  `jenis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `jenis`) VALUES
('admin', 'admin', 0),
('admin', 'admin', 0),
('admin', '21232f297a57a5a743894a0e4a801fc3', 1),
('admin', '21232f297a57a5a743894a0e4a801fc3', 1),
('sidiq', '9c51d2a1fac7deab665b77ae1c5fc39c', 1),
('admin', 'c6aeb702d8a7c203cdcb4d909bbc8aa6', 1);

-- --------------------------------------------------------

--
-- Table structure for table `wisata`
--

CREATE TABLE `wisata` (
  `id_wisata` varchar(10) NOT NULL,
  `nama_wisata` varchar(50) NOT NULL,
  `id_jenis_wisata` varchar(10) NOT NULL,
  `tarif_wisata` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wisata`
--

INSERT INTO `wisata` (`id_wisata`, `nama_wisata`, `id_jenis_wisata`, `tarif_wisata`) VALUES
('W001', 'Pantai Padang - Jam Gadang - Lembah Harau', 'JW001', '350000'),
('W002', 'Ngarai Sianok - Puncak Lawang - Danau Singkarak', 'JW001', '350000'),
('W003', 'Pantai Carocok - Pulau Sirandah - Pulau Sikuai', 'JW002', '500000'),
('W004', 'Puncak Mandeh - Danau Singkarak - Mifan', 'JW001', '400000'),
('W005', 'Kebun Teh - Danau Kembar - Seribu Rumah Gadang', 'JW001', '350000');

-- --------------------------------------------------------

--
-- Table structure for table `wisatawan`
--

CREATE TABLE `wisatawan` (
  `id_wisatawan` varchar(10) NOT NULL,
  `nama_wisatawan` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wisatawan`
--

INSERT INTO `wisatawan` (`id_wisatawan`, `nama_wisatawan`, `alamat`, `telepon`) VALUES
('WN001', 'Muhammad Aidil Putra', 'Padang', '082283272890'),
('WN002', 'Rizkhan Hadi', 'Padang', '081234567890'),
('WN003', 'Bobby Putra', 'Padang', '081234567891'),
('WN004', 'Andre Desrizaldi', 'Medan', '081234567893'),
('WN005', 'Hidayatul Siddiq', 'Padang Panjang', '081234567894');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guide`
--
ALTER TABLE `guide`
  ADD PRIMARY KEY (`id_guide`);

--
-- Indexes for table `jenis_penginapan`
--
ALTER TABLE `jenis_penginapan`
  ADD PRIMARY KEY (`id_jenis_penginapan`);

--
-- Indexes for table `jenis_transportasi`
--
ALTER TABLE `jenis_transportasi`
  ADD PRIMARY KEY (`id_jenis_transportasi`);

--
-- Indexes for table `jenis_wisata`
--
ALTER TABLE `jenis_wisata`
  ADD PRIMARY KEY (`id_jenis_wisata`);

--
-- Indexes for table `kuliner`
--
ALTER TABLE `kuliner`
  ADD PRIMARY KEY (`id_kuliner`);

--
-- Indexes for table `paket_travel`
--
ALTER TABLE `paket_travel`
  ADD PRIMARY KEY (`id_paket_travel`),
  ADD KEY `id_wisatawan` (`id_wisata`,`id_transportasi`),
  ADD KEY `id_kuliner` (`id_penginapan`),
  ADD KEY `id_transportasi` (`id_transportasi`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `id_paket_travel` (`id_pemesanan`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_pemesanan`),
  ADD KEY `idpaket` (`id_paket_travel`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `id_pemesanan` (`id_pemesanan`);

--
-- Indexes for table `penginapan`
--
ALTER TABLE `penginapan`
  ADD PRIMARY KEY (`id_penginapan`),
  ADD KEY `id_jenis_penginapan` (`id_jenis_penginapan`);

--
-- Indexes for table `transportasi`
--
ALTER TABLE `transportasi`
  ADD PRIMARY KEY (`id_transportasi`),
  ADD KEY `fk_transportasi` (`id_jenis_transportasi`);

--
-- Indexes for table `wisata`
--
ALTER TABLE `wisata`
  ADD PRIMARY KEY (`id_wisata`),
  ADD KEY `id_jenis_wisata` (`id_jenis_wisata`);

--
-- Indexes for table `wisatawan`
--
ALTER TABLE `wisatawan`
  ADD PRIMARY KEY (`id_wisatawan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `paket_travel`
--
ALTER TABLE `paket_travel`
  ADD CONSTRAINT `paket_travel_ibfk_1` FOREIGN KEY (`id_penginapan`) REFERENCES `penginapan` (`id_penginapan`),
  ADD CONSTRAINT `paket_travel_ibfk_2` FOREIGN KEY (`id_wisata`) REFERENCES `wisata` (`id_wisata`),
  ADD CONSTRAINT `paket_travel_ibfk_4` FOREIGN KEY (`id_transportasi`) REFERENCES `transportasi` (`id_transportasi`);

--
-- Constraints for table `transportasi`
--
ALTER TABLE `transportasi`
  ADD CONSTRAINT `fk_transportasi` FOREIGN KEY (`id_jenis_transportasi`) REFERENCES `jenis_transportasi` (`id_jenis_transportasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `wisata`
--
ALTER TABLE `wisata`
  ADD CONSTRAINT `wisata_ibfk_1` FOREIGN KEY (`id_jenis_wisata`) REFERENCES `jenis_wisata` (`id_jenis_wisata`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
