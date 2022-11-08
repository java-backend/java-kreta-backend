-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Nov 08. 10:43
-- Kiszolgáló verziója: 10.1.24-MariaDB
-- PHP verzió: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `kreta`
--
CREATE DATABASE IF NOT EXISTS `kreta` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci;
USE `kreta`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `schoolclass`
--

CREATE TABLE `schoolclass` (
  `id` bigint(20) NOT NULL,
  `class_type` char(1) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `school_class` int(11) DEFAULT NULL,
  `teacher_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `schoolclass`
--

INSERT INTO `schoolclass` (`id`, `class_type`, `school_class`, `teacher_id`) VALUES
(1, 'a', 9, 1),
(2, 'b', 10, 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `name` varchar(30) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `iswoman` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `subject`
--

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `subject`
--

INSERT INTO `subject` (`id`, `name`) VALUES
(1, 'Magyar nyelv'),
(2, 'Matematika');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `schoolclass`
--
ALTER TABLE `schoolclass`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `schoolclass`
--
ALTER TABLE `schoolclass`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT a táblához `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
