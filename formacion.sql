-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-04-2022 a las 13:41:31
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `formacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `edad` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`usuario`, `password`, `nombre`, `email`, `edad`) VALUES
('aaa', 'sseeeee', 'ordenador', 'ss@dd.es', 45),
('admin', 'a', 'tomates', 'servlet@gmail.com', 22),
('admin5', 'aaaa', 'dsd', 'dssd', 22),
('dd', 'm37MbuuDq/mt4Q/jiGXfRJm+NWjcxQeuLsO0SYnLAJM=', 'fdsf', 'dsfds@gg.es', 11),
('dfds', 'ddeeeeee', 'tomates', 'ssd@dd.es', 22),
('diego armando', 'diego', 'diego', 'diego', 0),
('fd', 'g', 'df', 'g', 4),
('java', 'OKCWOmNksJrYZ6qaZsbQCWc8IeGCAVRh2iNuw2GHf3c=', 'java', 'java@dd.com', 33),
('javato', 'T6GEvvueoevbXxbeTLMz6fk5FLZHd1RtUBcKFUes8U0=', 'aaa', 'asas@fff.es', 33),
('model', 'model', 'model', 'model@gmail', 55),
('mvcform', 'mvcform', 'form', 'form@gmail.com', 22),
('noexiste', 'wq', 'tomates', 'mvc@gmail.com', 22),
('nuevo', 'nuevo', 'h', 'nuevo@gmail.com', 22),
('nuevo10', 'nuevo10', 'nuevo', 'nuevo@gmail.com', 22),
('paco', 'aaa', 'paco', 'dsfads', 333),
('paquito', 'aaaa', 'dsdas', 'asdas', 55),
('probando', 'qqqqqqq', 'probando', 'probando@gmail.com', 23),
('prof', 'UdHmo5isvafhW2h950fn3+lfoTFU3LQKqKs38eKzk6A=', 'servlet@gmail.com', 'profe', 33),
('qa', 'qaq', 'ww', 'qw', 34),
('qq', 'qq', 'qqqqqqqqqq', 'qq', 22),
('qqq', 'qqqqqqqq', 'sdsad', 'asdasd@dd.es', 45),
('test1', 'test1', 'test1', 'test1@gmail.com', 99),
('uno', 'vw7DaU4SLgZ9mWSjjsfYQVeB30sk9EKtdntGIfuY+MU=', 'profe', 'profe@gmail.com', 22),
('webmvc', 'webmvc', 'webmvc', 'webmvc', 333);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `idCurso` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `duracion` int(10) UNSIGNED NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`idCurso`, `nombre`, `duracion`, `fechaInicio`, `precio`) VALUES
(1, 'java 10', 100, '2020-08-20', 250),
(2, 'python', 50, '2020-10-12', 125),
(3, 'php', 25, '2020-10-30', 345),
(4, 'jsf', 30, '2020-04-15', 100),
(5, 'ordenador', 120, '2020-11-08', 2),
(6, 'angular 9', 60, '2020-11-19', 170),
(7, 'javascript', 60, '2020-11-26', 160),
(8, 'microservicios spring boot', 70, '2020-11-24', 390),
(9, 'servlet', 60, '2020-11-17', 0),
(10, 'php7', 11, '2020-11-18', 0),
(11, 'ordenador', 67, '2020-12-03', 0),
(12, 'jpa', 12, '2020-12-03', 0),
(13, 'myjava', 45, '2020-12-08', 0),
(14, 'Kubernates', 60, '2021-02-11', 0),
(15, 'dockers completo', 70, '2020-12-20', 0),
(16, 'Spring', 50, '2021-05-17', 0),
(17, 'kafka', 70, '2021-06-30', 0),
(18, 'ww', 23, '2021-05-14', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matriculas`
--

CREATE TABLE `matriculas` (
  `usuario` varchar(45) NOT NULL,
  `idCurso` int(10) UNSIGNED NOT NULL,
  `nota` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `matriculas`
--

INSERT INTO `matriculas` (`usuario`, `idCurso`, `nota`) VALUES
('aaa', 1, 0),
('aaa', 17, 0),
('admin', 1, 0),
('admin', 2, 0),
('admin', 6, 3),
('admin', 14, 0),
('dd', 17, 0),
('dfds', 1, 0),
('diego armando', 2, 0),
('diego armando', 13, 7),
('model', 1, 0),
('model', 3, 0),
('model', 7, 0),
('paco', 1, 0),
('paco', 2, 8),
('probando', 1, 0),
('prof', 17, 5),
('uno', 1, 0),
('uno', 7, 0),
('uno', 17, 0),
('webmvc', 1, 4),
('webmvc', 2, 0),
('webmvc', 5, 0),
('webmvc', 6, 0),
('webmvc', 9, 0),
('webmvc', 12, 0),
('webmvc', 13, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `idPregunta` int(10) UNSIGNED NOT NULL,
  `idCurso` int(10) UNSIGNED NOT NULL,
  `enunciado` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`idPregunta`, `idCurso`, `enunciado`) VALUES
(1, 1, '¿Cuantos bytes ocupa el tipo int?'),
(2, 1, '¿Cual es una palabra reservada de Java?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `idRespuesta` int(10) UNSIGNED NOT NULL,
  `idPregunta` int(10) UNSIGNED NOT NULL,
  `texto` varchar(150) NOT NULL,
  `correcta` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`idRespuesta`, `idPregunta`, `texto`, `correcta`) VALUES
(1, 1, '2', 0),
(2, 1, '4', 1),
(3, 1, '3', 0),
(4, 1, '8', 0),
(5, 2, 'red', 0),
(6, 2, 'main', 0),
(7, 2, 'scanner', 0),
(8, 2, 'import', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`idCurso`);

--
-- Indices de la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD PRIMARY KEY (`usuario`,`idCurso`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`idPregunta`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`idRespuesta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `idCurso` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `idPregunta` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `idRespuesta` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
