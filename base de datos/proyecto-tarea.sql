-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2021 a las 09:54:58
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_tarea`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_incidente`
--

CREATE TABLE `tb_incidente` (
  `id_incidente` int(11) NOT NULL,
  `codigo_incidente` varchar(10) CHARACTER SET utf8 NOT NULL,
  `descripcion_incidente` text DEFAULT 'descripcion de prueba',
  `fecha_incidente` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado_incidente` tinyint(1) NOT NULL,
  `calificacion_incidente` int(2) NOT NULL,
  `resuelto_incidente` tinyint(1) DEFAULT 0,
  `id_usuario_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_incidente`
--

INSERT INTO `tb_incidente` (`id_incidente`, `codigo_incidente`, `descripcion_incidente`, `fecha_incidente`, `estado_incidente`, `calificacion_incidente`, `resuelto_incidente`, `id_usuario_fk`) VALUES
(4, 'TT555655', 'descripcion de prueba', '2021-05-13 05:51:33', 1, 15, 0, 28),
(9, 'T1257', 'descripcion de prueba', '2021-05-13 05:54:05', 1, 20, 0, 1),
(10, 'T12JAJ56', 'descripcion de prueba', '2021-05-13 06:03:07', 0, 10, 0, 7),
(12, 'TRABA12', 'descripcion de prueba', '2021-05-13 19:05:14', 0, 23, 0, 1),
(14, 'WEEE23', 'descripcion de prueba', '2021-05-13 19:10:57', 0, 11, 0, 1),
(17, 'EWW23', 'descripcion de prueba', '2021-05-13 19:38:12', 0, 2, 0, 1),
(18, 'werfsd', 'descripcion de prueba', '2021-05-13 22:52:32', 0, 4, 0, 1),
(19, 'DD3', 'descripcion de 1', '2021-05-13 22:52:45', 0, 3, 0, 24),
(20, 'we', 'descripcion de prueba', '2021-05-13 22:55:29', 1, 3, 0, 1),
(21, 'REEE23', 'descripcion de prueba', '2021-05-14 05:11:49', 1, 2, 0, 1),
(22, 'REEE34', 'descripcion de prueba', '2021-05-14 05:19:18', 1, 2, 0, 26),
(23, 'YYT', 'descripcion de prueba', '2021-05-14 05:29:28', 0, 23, 0, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_informe_final`
--

CREATE TABLE `tb_informe_final` (
  `id_informe` int(11) NOT NULL,
  `hora_final_informe` datetime DEFAULT current_timestamp(),
  `descripcion` text CHARACTER SET utf8 NOT NULL,
  `id_incidente_fk` int(11) NOT NULL,
  `id_problema_fk` int(11) NOT NULL,
  `id_solucion_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_informe_final`
--

INSERT INTO `tb_informe_final` (`id_informe`, `hora_final_informe`, `descripcion`, `id_incidente_fk`, `id_problema_fk`, `id_solucion_fk`) VALUES
(13, '2021-05-13 18:52:38', 'CAMBIA 2', 19, 14, 1),
(14, '2021-05-13 18:52:43', 'JUAN', 19, 14, 1),
(16, '2021-05-13 18:56:52', 'CAMBIA', 19, 14, 1),
(17, '2021-05-13 18:57:15', 'CAMBIA 1', 19, 14, 1),
(19, '2021-05-13 19:37:02', 'Informe del kasjaskas', 9, 18, 4),
(20, '2021-05-13 19:37:18', 'Descripción 123', 20, 17, 5),
(21, '2021-05-13 20:20:13', 'SSS', 9, 17, 2),
(22, '2021-05-13 20:20:31', 'rr', 20, 39, 5),
(24, '2021-05-13 20:21:32', 'Rtre', 12, 14, 4),
(25, '2021-05-13 20:39:51', 'YUUU', 20, 39, 5),
(26, '2021-05-14 00:46:07', 'El problema ha sido resuelto-.....', 23, 14, 1),
(27, '2021-05-14 01:46:41', 'Codigo 1', 21, 17, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_problema`
--

CREATE TABLE `tb_problema` (
  `id_problema` int(11) NOT NULL,
  `codigo_problema` varchar(10) CHARACTER SET utf8 NOT NULL,
  `descripcion_problema` text CHARACTER SET utf8 NOT NULL,
  `prioridad_problema` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_problema`
--

INSERT INTO `tb_problema` (`id_problema`, `codigo_problema`, `descripcion_problema`, `prioridad_problema`) VALUES
(14, '0001-F', 'Problema de cables', 1),
(17, 'TTT-32', 'problemas externos', 3),
(18, 'FF-43', 'Problema interno', 0),
(19, 'RRR-34', 'Esta descripción es...', 2),
(22, 'wer435', 'Código', 2),
(25, 'dfsf43', 'Junó', 4),
(26, 'adsds34543', 'zfsdf+oó', 4),
(27, 'TTT-763', 'cambio del rocó', 0),
(28, 'UUU777', 'prueba', 0),
(29, 'EEE322', 'Pró', 0),
(30, 'OOO0001', 'Cracká', 2),
(31, 'TTTY43', 'dwrerw', 0),
(33, 'TRRR23', 'wjajajajerew', 0),
(35, '3434', 'fsd', 0),
(36, 'tttttttttt', '345', 0),
(37, 'PRUEBA113', 'rrt', 4),
(38, 'LOOOOO23', 'descripción de prueba', 2),
(39, 'EEE23', 'Prueba 12', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_solucion`
--

CREATE TABLE `tb_solucion` (
  `id_solucion` int(11) NOT NULL,
  `codigo_solucion` varchar(10) CHARACTER SET utf8 NOT NULL,
  `descripcion_solucion` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_solucion`
--

INSERT INTO `tb_solucion` (`id_solucion`, `codigo_solucion`, `descripcion_solucion`) VALUES
(1, 'YTY3', 'Lugubré'),
(2, 'REW12', 'Descripcián'),
(4, 'RTE34', 'Olé'),
(5, '34544534', 'Yulé');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombres_usuario` varchar(20) CHARACTER SET utf8 NOT NULL,
  `apellidos_usuario` varchar(20) CHARACTER SET utf8 NOT NULL,
  `correo_usuario` varchar(50) CHARACTER SET utf8 NOT NULL,
  `telefono_usuario` int(9) NOT NULL,
  `codigo_usuario` varchar(30) CHARACTER SET utf8 NOT NULL,
  `contra_usuario` varchar(30) CHARACTER SET utf8 NOT NULL,
  `tipo_usuario` tinyint(1) NOT NULL DEFAULT 0,
  `estado_usuario` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`id_usuario`, `nombres_usuario`, `apellidos_usuario`, `correo_usuario`, `telefono_usuario`, `codigo_usuario`, `contra_usuario`, `tipo_usuario`, `estado_usuario`) VALUES
(1, 'Juanit', 'Pedro', 'kaja@gmail.com', 772142, 'Luis23', 'contra123', 0, 0),
(3, 'Juanisdft', 'Luis', 'khhhh@gmail.com', 772142, 'Luihhs23', '23', 0, 0),
(4, 'sdf', 'AJJa', 'luca@gmaail.com', 34234, 'sdsds', 'Sss', 0, 1),
(7, 'Cr7', 'Messi', 'juanito@gmail.com', 772142, 'Alcachofa', '23', 0, 0),
(11, 'Juanito', 'AJJa', 'luasdasdca@gmaail.com', 34234, 'sdasdasdsds', 'Sss', 0, 0),
(12, 'fdsfsd', 'sdfsdf', 'sdfsdfsd@gmail.com', 3545345, 'fsdfsdf', 'sdfsdfds', 0, 0),
(13, 'sdfsdfsd', 'sdfsdfsd', 'sdfsdf@asjdhj.com', 324234234, 'sdfdfsdfds', 'sdfsdfsd', 0, 0),
(14, 'wrwerew', 'werwerw', 'werwere@gmail.com', 24324324, 'sadasdasd', 'adasdas', 0, 0),
(15, 'dfgdgdfgdf', 'dfgfgdg', 'dfgfgdfgfd@gmail.com', 43545435, 'sdfsdfdsfffffffff', 'sdfsd', 0, 0),
(17, 'Alonso', 'Siesquen', 'asdasd@gmail.com', 234324234, 'asdasdasdasd', 'sad', 0, 0),
(18, 'Carlos', 'Poló', 'polq@gmail.com', 344354, 'Polo1334', '3434', 0, 0),
(20, 'YulÃ¡', 'Furia', 'fusiak@gmail.com', 45345, 'Ruty12', '23234', 0, 0),
(21, 'Junior', 'Custodio', 'juniowito@gmail.com', 86786787, 'Junior123', '123', 0, 0),
(22, 'Ricardo', 'TArrillo', 'tarrillo223@gmail.com', 3432423, 'Tarrillo32', '3423', 0, 0),
(23, 'Admin', 'Admin', 'admin123@gmail.com', 993212, 'Admin123', 'admin123', 1, 0),
(24, 'Luis', 'Siesquen', 'jJAJ@gmail.cpm', 968389881, '+51', '123', 0, 0),
(25, 'Luis', 'Siesquen', 'asdas@gmail.com', 968389881, '+51asds', 'asdasd', 0, 0),
(26, 'Prueba', 'No Prueba', 'pro@gmail.com', 4332212, 'TTEE12', 'asdasd', 0, 0),
(27, 'Luis', 'Siesquen', 'adsd@gmail.com', 968389881, '+51dsa', 'adsasd', 0, 0),
(28, 'LuisPP', 'Siesquen', 'real@gmail.com', 968389881, 'qweqweqweqw', 'wqeqwe', 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_incidente`
--
ALTER TABLE `tb_incidente`
  ADD PRIMARY KEY (`id_incidente`),
  ADD UNIQUE KEY `codigo_incidente` (`codigo_incidente`),
  ADD KEY `id_usuario_fk` (`id_usuario_fk`);

--
-- Indices de la tabla `tb_informe_final`
--
ALTER TABLE `tb_informe_final`
  ADD PRIMARY KEY (`id_informe`),
  ADD KEY `id_incidente_fk` (`id_incidente_fk`),
  ADD KEY `id_problema_fk` (`id_problema_fk`),
  ADD KEY `id_solucion_fk` (`id_solucion_fk`);

--
-- Indices de la tabla `tb_problema`
--
ALTER TABLE `tb_problema`
  ADD PRIMARY KEY (`id_problema`),
  ADD UNIQUE KEY `codigo_problema` (`codigo_problema`);

--
-- Indices de la tabla `tb_solucion`
--
ALTER TABLE `tb_solucion`
  ADD PRIMARY KEY (`id_solucion`),
  ADD UNIQUE KEY `codigo_solucion` (`codigo_solucion`);

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `codigo_usuario` (`codigo_usuario`),
  ADD UNIQUE KEY `correo_usuario` (`correo_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_incidente`
--
ALTER TABLE `tb_incidente`
  MODIFY `id_incidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `tb_informe_final`
--
ALTER TABLE `tb_informe_final`
  MODIFY `id_informe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `tb_problema`
--
ALTER TABLE `tb_problema`
  MODIFY `id_problema` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `tb_solucion`
--
ALTER TABLE `tb_solucion`
  MODIFY `id_solucion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_incidente`
--
ALTER TABLE `tb_incidente`
  ADD CONSTRAINT `tb_incidente_ibfk_1` FOREIGN KEY (`id_usuario_fk`) REFERENCES `tb_usuario` (`id_usuario`);

--
-- Filtros para la tabla `tb_informe_final`
--
ALTER TABLE `tb_informe_final`
  ADD CONSTRAINT `tb_informe_final_ibfk_1` FOREIGN KEY (`id_incidente_fk`) REFERENCES `tb_incidente` (`id_incidente`),
  ADD CONSTRAINT `tb_informe_final_ibfk_3` FOREIGN KEY (`id_solucion_fk`) REFERENCES `tb_solucion` (`id_solucion`),
  ADD CONSTRAINT `tb_informe_final_ibfk_4` FOREIGN KEY (`id_problema_fk`) REFERENCES `tb_problema` (`id_problema`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
