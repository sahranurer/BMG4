-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.2.13-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- proje için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `proje` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proje`;

-- tablo yapısı dökülüyor proje.aday
CREATE TABLE IF NOT EXISTS `aday` (
  `id` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `ad` varchar(50) DEFAULT NULL,
  `soyad` varchar(50) DEFAULT NULL,
  `yas` varchar(50) DEFAULT NULL,
  `egitim_durumu` varchar(50) DEFAULT NULL,
  `adres` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- proje.aday: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `aday` DISABLE KEYS */;
INSERT INTO `aday` (`id`, `ad`, `soyad`, `yas`, `egitim_durumu`, `adres`) VALUES
	(1, 'Fatma Özlem', 'Acar', '20', 'Ortaokul', 'Ümraniye'),
	(2, 'Özde', 'Acarkan', '25', 'Universite', 'Ümraniye'),
	(3, 'Atahan', 'Adanır', '30', 'Universite', 'Ümraniye'),
	(4, 'Hacı Mehmet', 'Adıgüzel', '45', 'Universite', 'Çekmeköy'),
	(5, 'Mükerrem Zeynep', 'Ağca', '54', 'Ortaokul', 'Üsküdar'),
	(6, 'Bestami', '	Ağırağaç', '26', 'Universite', 'Esenler'),
	(7, 'Aykanat', 'Ağıroğlu', '21', 'Universite', 'Üsküdar'),
	(8, 'Şennur', 'Ağnar', '35', 'Lise', 'Çekmeköy'),
	(9, 'Tutkum', '	Ahmadı Asl', '40', 'Lise', 'Ümraniye'),
	(10, 'Mügenur', 'Ahmet', '33', 'Ortaokul', 'Ümraniye');
/*!40000 ALTER TABLE `aday` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.arac
CREATE TABLE IF NOT EXISTS `arac` (
  `id` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `plaka` varchar(50) NOT NULL DEFAULT '0',
  `arac_tur` varchar(50) NOT NULL DEFAULT '0',
  `uretim_yil` int(11) DEFAULT NULL,
  `sigorta_durum` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- proje.arac: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `arac` DISABLE KEYS */;
INSERT INTO `arac` (`id`, `plaka`, `arac_tur`, `uretim_yil`, `sigorta_durum`) VALUES
	(1, '06 ET XXXX', 'Özel araçlar', 2019, 'var'),
	(2, '22 Fx 999', 'Özel araçlar', 2020, 'var'),
	(3, '34 Lxx 999', 'Özel araçlar', 2015, 'var'),
	(4, '41 P 9999', 'Özel araçlar', 2015, 'var'),
	(5, '06 Pxx 99', 'Özel araçlar', 2014, 'var'),
	(6, '99 A 9999', 'İl yönetimi ve rektörler', 2016, 'var'),
	(7, '99 A 9999', 'İl yönetimi ve rektörler', 2008, 'yok'),
	(8, '36 DP 8045 ', 'otomobil', 2005, 'var'),
	(9, '06 ET 7845', 'İlçe Aracı', 2013, 'var'),
	(10, '45 ES 5412', 'Otomobil', 2014, 'var');
/*!40000 ALTER TABLE `arac` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.ders
CREATE TABLE IF NOT EXISTS `ders` (
  `id` int(30) unsigned NOT NULL AUTO_INCREMENT,
  `ders_ad` varchar(50) DEFAULT NULL,
  `ders_tur` varchar(50) DEFAULT NULL,
  `ders_kont` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- proje.ders: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `ders` DISABLE KEYS */;
INSERT INTO `ders` (`id`, `ders_ad`, `ders_tur`, `ders_kont`) VALUES
	(1, 'Trafik', 'Sozel', '60'),
	(2, 'İLK Yardım', 'Pratik', '23'),
	(3, 'Motor', 'Pratik', '32'),
	(4, 'Direksiyon', 'Pratik', '32'),
	(5, 'İLK Yardım', 'Pratik', '54'),
	(7, 'Motor', 'Pratik', '18'),
	(8, 'Direksiyon', 'Pratik', '10'),
	(9, 'Trafik', 'Sozel', '32'),
	(10, 'Motor', 'Pratik', '33');
/*!40000 ALTER TABLE `ders` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.dersprogram
CREATE TABLE IF NOT EXISTS `dersprogram` (
  `pid` int(50) unsigned NOT NULL AUTO_INCREMENT,
  `gunler` varchar(50) DEFAULT NULL,
  `saatler` varchar(50) DEFAULT NULL,
  `ders` int(30) unsigned NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK_dersprogram_ders` (`ders`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- proje.dersprogram: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `dersprogram` DISABLE KEYS */;
INSERT INTO `dersprogram` (`pid`, `gunler`, `saatler`, `ders`) VALUES
	(1, '14.04.2021', '13.00', 1),
	(2, '15.04.2021', '14.00', 2),
	(3, '16.04.2021', '15.00', 3),
	(4, '04.04.2021', '17.00', 5),
	(5, '12.05.2021', '16.30', 3),
	(6, '17.05.2021', '10.00', 5),
	(7, '18.05.2021', '10.30', 9),
	(8, '19.05.2021', '17.40', 10),
	(9, '20.05.2021', '15.30', 6),
	(10, '21.05.2021', '11.30', 4);
/*!40000 ALTER TABLE `dersprogram` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.egitmen
CREATE TABLE IF NOT EXISTS `egitmen` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ad` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `soyad` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `brans` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- proje.egitmen: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `egitmen` DISABLE KEYS */;
INSERT INTO `egitmen` (`id`, `ad`, `soyad`, `brans`) VALUES
	(1, 'aleyna', 'oksuz', 'motor'),
	(2, 'tugce', 'kayalı', 'ilk yardım'),
	(3, 'emre', 'kose', 'ilk yardım'),
	(5, 'yiğit', 'aslan', 'trafik'),
	(6, 'murat', 'yalçın', 'motor'),
	(7, 'demir', 'ökse', 'trafik'),
	(8, 'tunç', 'kose', 'motor'),
	(9, 'ENSAR', 'Tunc', 'motor'),
	(10, 'SUZAN', 'EROĞLU', 'ilkYardım');
/*!40000 ALTER TABLE `egitmen` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.egitmen_perfs
CREATE TABLE IF NOT EXISTS `egitmen_perfs` (
  `per_id` int(20) NOT NULL AUTO_INCREMENT,
  `adsoyad` varchar(50) DEFAULT NULL,
  `performans` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- proje.egitmen_perfs: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `egitmen_perfs` DISABLE KEYS */;
INSERT INTO `egitmen_perfs` (`per_id`, `adsoyad`, `performans`) VALUES
	(1, 'SAHRA ER', '%95'),
	(2, 'ALEYNA OKSUZ', '%85'),
	(3, 'TUGCE KAYALI', '%85'),
	(4, 'EMRE KOSE', '%60'),
	(5, 'YİĞİT ASLAN', '%95'),
	(6, 'MURAT YALÇIN', '%50'),
	(7, 'DEMİR ÖKSE', '%75'),
	(8, 'TUNÇ KOSE', '%87'),
	(9, 'ENSAR TUNÇ', '%96'),
	(10, 'SUZAN EROĞLU', '%87');
/*!40000 ALTER TABLE `egitmen_perfs` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.ehliyet
CREATE TABLE IF NOT EXISTS `ehliyet` (
  `eh_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sinif` varchar(50) DEFAULT '0',
  `kullanma_yetkisi` varchar(50) DEFAULT '0',
  `egitmen_alan` varchar(50) DEFAULT NULL,
  `surucu_aday` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`eh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- proje.ehliyet: ~16 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `ehliyet` DISABLE KEYS */;
INSERT INTO `ehliyet` (`eh_id`, `sinif`, `kullanma_yetkisi`, `egitmen_alan`, `surucu_aday`) VALUES
	(1, 'M', 'Motorlu Bisiklet', 'Motor', 'Fatma Özlem Acar '),
	(2, 'A1', '	125 cc’ye Kadar Motosiklet', 'Motor', 'Özde Acarkan '),
	(3, 'A2', '35 kw’yi Geçmeyen Motosiklet', 'Motor', 'Atahan Adanır '),
	(4, 'A', '	35 kw’yi Geçen Motosiklet', 'Motor', 'Hacı Mehmet Adıgüzel '),
	(5, 'B1', '4 Tekerli Motosiklet', 'Motor', 'Mükerrem Zeynep Ağca '),
	(6, 'B', 'Otomobil ve Kamyonet', 'Motor', 'Bestami Ağırağaç '),
	(7, 'BE', 'Römorklu Otomobil ve Kamyonet', 'Motor', 'Aykanat Ağıroğlu '),
	(8, 'C1', '	7500 kg’a Kadar Kamyon ve Çekici', 'Motor', 'Şennur Ağnar '),
	(9, 'C1E', '	12000 KG’A Kadar Kamyon ve Çekici', 'Motor', 'Tutkum Ahmadı Asl '),
	(10, 'CE', 'Kamyon ve Çekici', 'Motor', 'Mügenur Ahmet '),
	(11, 'D1', 'Römorklu Kamyon ve Çekici', 'Motor', 'Ahmet Ahmet '),
	(12, 'D1E', 'Minibüs', 'Motor', '-'),
	(13, 'D', 'Römorklu Minibüs', 'Motor', '-'),
	(14, 'DE', '	Minibüs ve Otobüs', 'Motor', '-'),
	(15, 'F', '	Römorklu Minibüs ve Otobüs', 'Motor', '-'),
	(16, 'G', '	İş Makinesi', 'Motor', '-');
/*!40000 ALTER TABLE `ehliyet` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.fatura
CREATE TABLE IF NOT EXISTS `fatura` (
  `fid` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `adsoyad` varchar(50) DEFAULT '0',
  `il` varchar(50) DEFAULT '0',
  `ilce` varchar(50) DEFAULT '0',
  `vergino` int(50) DEFAULT 0,
  `aciklama` varchar(50) DEFAULT '0',
  `tutar` varchar(10) DEFAULT '0',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- proje.fatura: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `fatura` DISABLE KEYS */;
INSERT INTO `fatura` (`fid`, `adsoyad`, `il`, `ilce`, `vergino`, `aciklama`, `tutar`) VALUES
	(1, 'Fatma Özlem	Acar', 'istanbul', 'ümraniye', 784578, '2.taksit', '350TL'),
	(2, 'Özde Acarkan', 'istanbul', 'ümraniye', 1547842, '1.taksit', '150 TL'),
	(3, 'Atahan Adanır', 'istanbul', 'ümraniye', 214578, '3.taksit', '350 TL'),
	(4, 'Hacı Mehmet Adıgüzel', 'istanbul', 'çekmeköy', 1451247, '2.taksit', '350 TL'),
	(5, 'Mükerrem Zeynep	Ağca', 'istanbul', 'üsküdar', 5421784, '1.taksit', '150 TL'),
	(6, 'Bestami Ağırağaç', 'istanbul', 'esenler', 2451247, '2.taksit', '350 TL'),
	(7, 'Aykanat Ağıroğlu', 'İstanbul', 'Üsküdar', 45178451, '3.taksit', '350TL'),
	(8, 'Şennur Ağnar', 'İstanbul', 'Çekmeköy', 412031457, '3.taksit', '350TL'),
	(9, 'Tutkum Ahmadı Asıl', 'İstanbul', 'Ümraniye', 984754124, '1.Taksit', '150TL'),
	(10, 'Mugenur Ahmet', 'İstanbul', 'Ümraniye', 784512478, 'Peşin', '3.400 TL');
/*!40000 ALTER TABLE `fatura` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.kullanici
CREATE TABLE IF NOT EXISTS `kullanici` (
  `id` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `ad` varchar(50) DEFAULT NULL,
  `sifre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- proje.kullanici: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` (`id`, `ad`, `sifre`) VALUES
	(1, 'sahranur', '123');
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.randevu
CREATE TABLE IF NOT EXISTS `randevu` (
  `rid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `egitmen_adsoyad` varchar(50) DEFAULT '0',
  `aday_adsoyad` varchar(50) DEFAULT '0',
  `gun` varchar(50) DEFAULT '0',
  `saat` varchar(50) DEFAULT '0',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- proje.randevu: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `randevu` DISABLE KEYS */;
INSERT INTO `randevu` (`rid`, `egitmen_adsoyad`, `aday_adsoyad`, `gun`, `saat`) VALUES
	(1, 'ALEYNA OKSUZ', 'Fatma Özlem Acar', 'Pazartesi', '13.00'),
	(2, 'EMRE KOSE', 'Özde Acarkan', '15.04.2021', '14.00'),
	(3, 'MURAT YALÇIN', 'Atahan Adanır', '15.04.2021', '14.00'),
	(4, 'ENSAR TUNÇ', 'Bestami AğıAğaç', '16.04.2021', '15.00'),
	(5, 'SUZAN EROĞLU', 'Mukerrem Zeynep Ağca', '16.04.2021', '15.00'),
	(6, 'TUNÇ KOSE', 'Hacı Mehmet AdıGüzel', '16.04.2021', '15.00'),
	(7, 'DEMİR OKSE', 'Aykanat Ağıroğlu', '16.04.2021', '15.00'),
	(8, 'YİĞİT ASLAN', 'Tutkum Ahmadı Asıl', '16.04.2021', '15.00'),
	(9, 'TUĞÇE KAYALI', 'Mugenur Ahmet', '16.04.2021', '15.00'),
	(10, 'EMRE KOSE', 'Özde Acarkan', '16.04.2021', '15.00');
/*!40000 ALTER TABLE `randevu` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.rapor
CREATE TABLE IF NOT EXISTS `rapor` (
  `rap_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `radsoyad` varchar(50) DEFAULT '0',
  `ehliyet` varchar(50) DEFAULT '0',
  `performans` varchar(50) DEFAULT '0',
  `egitmenad` varchar(50) DEFAULT '0',
  PRIMARY KEY (`rap_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- proje.rapor: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `rapor` DISABLE KEYS */;
INSERT INTO `rapor` (`rap_id`, `radsoyad`, `ehliyet`, `performans`, `egitmenad`) VALUES
	(1, 'Fatma Özlem Acar', 'A', '%90', 'aleynaöksüz'),
	(2, 'Özde Acarkan', 'B', '%85', 'Emre Kose');
/*!40000 ALTER TABLE `rapor` ENABLE KEYS */;

-- tablo yapısı dökülüyor proje.sinif_perfs
CREATE TABLE IF NOT EXISTS `sinif_perfs` (
  `s_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `sinif_ad` varchar(50) DEFAULT NULL,
  `performans` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- proje.sinif_perfs: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `sinif_perfs` DISABLE KEYS */;
INSERT INTO `sinif_perfs` (`s_id`, `sinif_ad`, `performans`) VALUES
	(1, 'A', '%85'),
	(2, 'B', '%70'),
	(3, 'C-1', '%90'),
	(4, 'C-2', '%67'),
	(5, 'C-3', '%84');
/*!40000 ALTER TABLE `sinif_perfs` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
