-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Nov-2022 às 13:00
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `semurrbd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `auditoria`
--

CREATE TABLE `auditoria` (
  `tabela` varchar(20) DEFAULT NULL,
  `acao` varchar(20) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `data_hora` datetime DEFAULT NULL,
  `chave` varchar(5) DEFAULT NULL,
  `antes` varchar(1000) DEFAULT NULL,
  `depois` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimo`
--

CREATE TABLE `emprestimo` (
  `id` int(5) NOT NULL,
  `unidade` int(7) NOT NULL,
  `tipoequip` int(7) NOT NULL,
  `equipamento` int(7) NOT NULL,
  `destino` int(7) NOT NULL,
  `nome` int(7) NOT NULL,
  `dataSaida` date NOT NULL,
  `dataDevolucao` date NOT NULL,
  `status` varchar(10) NOT NULL,
  `tipo` varchar(9) NOT NULL,
  `observacao` varchar(250) NOT NULL,
  `tombo` varchar(10) NOT NULL,
  `serie` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipamento`
--

CREATE TABLE `equipamento` (
  `id` int(7) NOT NULL,
  `unidade` int(7) NOT NULL,
  `tipoequip` int(7) NOT NULL,
  `tombo` varchar(10) DEFAULT NULL,
  `serie` varchar(30) DEFAULT NULL,
  `fornecedor` int(7) NOT NULL,
  `fabricante` int(7) NOT NULL,
  `modelo` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `equipamento` varchar(30) DEFAULT NULL,
  `observacao` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `equipamento`
--

INSERT INTO `equipamento` (`id`, `unidade`, `tipoequip`, `tombo`, `serie`, `fornecedor`, `fabricante`, `modelo`, `status`, `equipamento`, `observacao`) VALUES
(4, 1, 1, 'DT-10041', '0000', 1, 2, 'DT-10041', 'FUNCIONAL', 'ALUGADO', ''),
(7, 1, 1, 'DT-10109', 'DT-10109', 1, 2, 'DT-10109', 'FUNCIONAL', 'ALUGADO', ''),
(9, 1, 1, 'DT-10798', 'DT-10798', 1, 2, 'DT-10798', 'FUNCIONAL', 'ALUGADO', ''),
(10, 1, 1, 'DT-10063', 'DT-10063', 1, 2, 'DT-10063', 'FUNCIONAL', 'ALUGADO', ''),
(11, 1, 1, 'DT-10742', 'DT-10742', 1, 2, 'DT-10742', 'FUNCIONAL', 'ALUGADO', ''),
(12, 1, 1, 'DT-11588', 'DT-11588', 1, 2, 'DT-11588', 'FUNCIONAL', 'ALUGADO', ''),
(13, 1, 1, 'DT-10051', 'DT-10051', 1, 2, 'DT-10051', 'FUNCIONAL', 'ALUGADO', ''),
(14, 1, 1, 'DT-160203', 'DT-160203', 1, 2, 'DT-160203', 'FUNCIONAL', 'ALUGADO', ''),
(15, 1, 1, 'DT-160168', 'DT-160168', 1, 2, 'DT-160168', 'FUNCIONAL', 'ALUGADO', ''),
(16, 1, 1, 'DT-14079', 'DT-14079', 1, 2, 'DT-14079', 'FUNCIONAL', 'ALUGADO', ''),
(17, 1, 1, 'DT-160166', 'DT-160166', 1, 2, 'DT-160166', 'FUNCIONAL', 'ALUGADO', ''),
(18, 1, 1, 'DT-10554', 'DT-10554', 1, 2, 'DT-10554', 'FUNCIONAL', 'ALUGADO', ''),
(19, 1, 1, 'DT-10073', 'DT-10073', 1, 2, 'DT-10073', 'FUNCIONAL', 'ALUGADO', ''),
(20, 1, 1, 'DT-10071', 'DT-10071', 1, 2, 'DT-10071', 'FUNCIONAL', 'ALUGADO', ''),
(22, 1, 1, 'DT-10062', 'DT-10062', 1, 2, 'DT-10062', 'FUNCIONAL', 'ALUGADO', ''),
(23, 1, 1, 'DT-10058', 'DT-10058', 1, 2, 'DT-10058', 'FUNCIONAL', 'ALUGADO', ''),
(24, 1, 1, 'DT-10056', 'DT-10056', 1, 2, 'DT-10056', 'FUNCIONAL', 'ALUGADO', ''),
(25, 1, 1, 'DT-10125', 'DT-10125', 1, 2, 'DT-10125', 'FUNCIONAL', 'ALUGADO', ''),
(26, 1, 1, 'DT-10067', 'DT-10067', 1, 2, 'DT-10067', 'FUNCIONAL', 'ALUGADO', ''),
(27, 1, 1, 'CT-160162', 'CT-160162', 1, 2, 'CT-160162', 'FUNCIONAL', 'ALUGADO', ''),
(28, 1, 1, 'DT-140046', 'DT-140046', 1, 2, 'DT-140046', 'FUNCIONAL', 'ALUGADO', ''),
(29, 1, 1, 'DT-10775', 'DT-10775', 1, 2, 'DT-10775', 'FUNCIONAL', 'ALUGADO', ''),
(30, 1, 1, 'DT-10052', 'DT-10052', 1, 2, 'DT-10052', 'FUNCIONAL', 'ALUGADO', ''),
(31, 1, 1, 'DT-10061', 'DT-10061', 1, 2, 'DT-10061', 'FUNCIONAL', 'ALUGADO', ''),
(32, 1, 1, 'CT-160159', 'CT-160159', 1, 2, 'CT-160159', 'FUNCIONAL', 'ALUGADO', ''),
(33, 1, 1, 'CT-13395', 'CT-13395', 1, 2, 'CT-13395', 'FUNCIONAL', 'ALUGADO', ''),
(34, 1, 1, 'DT-14084', 'DT-14084', 1, 2, 'DT-14084', 'FUNCIONAL', 'ALUGADO', ''),
(35, 1, 3, '01243', '01243', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(36, 1, 3, '00635', '00635', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(37, 1, 3, '01322', '01322', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(38, 1, 3, '01539', '01539', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(39, 1, 3, '09681', '09681', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(40, 1, 3, '00846', '00846', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(41, 1, 3, '01533', '01533', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(45, 1, 3, '01415', '01415', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(46, 1, 3, '01093', '01093', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(47, 1, 3, '01085', '01085', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(48, 1, 3, '01126', '01126', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(49, 1, 3, '00652', '00652', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(50, 1, 3, '01130', '01130', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(51, 1, 3, '01102', '01102', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(57, 1, 3, '1531', '1531', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(58, 1, 3, '01293', '01293', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(59, 1, 3, '01256', '01256', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(60, 1, 3, '01552', '01552', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(61, 1, 3, '01890', '01890', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(62, 1, 3, '14866', '14866', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(63, 1, 3, '01104', '01104', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(64, 1, 3, '01545', '01545', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(65, 1, 3, '01125', '01125', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(66, 1, 3, '01279', '01279', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(67, 1, 3, '01295', '01295', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(68, 1, 3, '01094', '01094', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(69, 1, 3, '07167', '07167', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(70, 1, 3, '00617', '00617', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(71, 1, 3, '13395', '13395', 1, 3, 'COMTECH', 'FUNCIONAL', 'ALUGADO', ''),
(76, 1, 1, 'DT-10057', '01023648010175', 1, 3, 'DC3C-U', 'FUNCIONAL', 'ALUGADO', ''),
(77, 1, 1, 'DT-10736', '01023546010037', 1, 3, 'DC3C-U', 'FUNCIONAL', 'ALUGADO', ''),
(78, 1, 1, 'CT151040B', '7898426841672', 1, 2, 'S/M', 'FUNCIONAL', 'ALUGADO', ''),
(79, 1, 3, 'S/T', '181001286', 1, 3, '22MP55PO-B', 'FUNCIONAL', 'ALUGADO', ''),
(80, 1, 1, 'DT-10054', 'DT-10054', 1, 3, 'DT-10054', 'FUNCIONAL', 'ALUGADO', ''),
(81, 1, 1, 'DT-10059', 'DT-10059', 1, 3, 'DT-10059', 'FUNCIONAL', 'ALUGADO', ''),
(82, 1, 1, 'DT-10074', 'DT-10074', 1, 3, 'DT-10074', 'FUNCIONAL', 'ALUGADO', ''),
(83, 1, 3, '1810057', '1810057', 1, 3, '1810057', 'FUNCIONAL', 'ALUGADO', ''),
(84, 1, 3, '18901999', '18901999', 1, 3, '18901999', 'FUNCIONAL', 'ALUGADO', ''),
(85, 1, 3, '181001255', '181001255', 1, 3, '181001255', 'FUNCIONAL', 'ALUGADO', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fabricante`
--

CREATE TABLE `fabricante` (
  `id` int(7) NOT NULL,
  `fabricantenome` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `fabricante`
--

INSERT INTO `fabricante` (`id`, `fabricantenome`) VALUES
(1, 'AMD'),
(2, 'COMTECH'),
(3, 'DATEN'),
(4, 'TESTE');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id` int(7) NOT NULL,
  `fornecedornome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `fornecedornome`) VALUES
(1, 'COMTECH'),
(2, 'TESTE');

-- --------------------------------------------------------

--
-- Estrutura da tabela `importpdf`
--

CREATE TABLE `importpdf` (
  `id` int(7) NOT NULL,
  `arquivo` mediumblob NOT NULL,
  `tipo` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `id` int(6) NOT NULL,
  `usuario` varchar(14) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tipo` varchar(7) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `usuario`, `nome`, `senha`, `email`, `tipo`, `data`) VALUES
(1, 'marcos', 'marcos antonio', 'root', 'marcosone1998@gmail.com', 'Admin', '2022-08-20'),
(2, 'RTDECA', 'RUY TADEU DEL REY EÇA', '123456', 'TESTE', 'Admin', '2022-08-20'),
(4, 'REY', 'REINILSON', '123456', 'TESTE', 'Admin', '2022-08-20'),
(5, 'ROQUE.JUNIOR', 'ROQUE JUNIOR', 'jt080882', 'ROQUE.JUNIOR@SALVADOR.BA.GOV.BR', 'ADMIN', '2022-09-29');

-- --------------------------------------------------------

--
-- Estrutura da tabela `nome`
--

CREATE TABLE `nome` (
  `id` int(7) NOT NULL,
  `nomepessoa` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `nome`
--

INSERT INTO `nome` (`id`, `nomepessoa`) VALUES
(1, 'MANOEL DOS ANJOS'),
(2, 'ANA LUCIA FARIAS'),
(3, 'IVETE SACRAMENTO'),
(4, 'ROQUE JUNIOR'),
(5, 'ALISSON SODRÉ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoequipamento`
--

CREATE TABLE `tipoequipamento` (
  `id` int(7) NOT NULL,
  `tipoequipamentonome` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tipoequipamento`
--

INSERT INTO `tipoequipamento` (`id`, `tipoequipamentonome`) VALUES
(1, 'COMPUTADOR'),
(2, 'IMPRESSORA'),
(3, 'MONITOR'),
(4, 'CABO HDMI'),
(5, 'TESTE');

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidade`
--

CREATE TABLE `unidade` (
  `id` int(5) NOT NULL,
  `unidadenome` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `unidade`
--

INSERT INTO `unidade` (`id`, `unidadenome`) VALUES
(1, 'NTI'),
(2, 'GAB'),
(3, 'TESTE');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `emprestimo`
--
ALTER TABLE `emprestimo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `unidade` (`equipamento`),
  ADD KEY `unidade_2` (`unidade`),
  ADD KEY `empres_tipoequip` (`tipoequip`),
  ADD KEY `nome` (`nome`);

--
-- Índices para tabela `equipamento`
--
ALTER TABLE `equipamento`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tombo` (`tombo`),
  ADD UNIQUE KEY `serie` (`serie`),
  ADD KEY `unidade` (`unidade`),
  ADD KEY `fornecedor` (`fornecedor`),
  ADD KEY `fabricante` (`fabricante`),
  ADD KEY `tipoequip` (`tipoequip`);

--
-- Índices para tabela `fabricante`
--
ALTER TABLE `fabricante`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `importpdf`
--
ALTER TABLE `importpdf`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `nome`
--
ALTER TABLE `nome`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tipoequipamento`
--
ALTER TABLE `tipoequipamento`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `unidade`
--
ALTER TABLE `unidade`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `emprestimo`
--
ALTER TABLE `emprestimo`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `equipamento`
--
ALTER TABLE `equipamento`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT de tabela `fabricante`
--
ALTER TABLE `fabricante`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `importpdf`
--
ALTER TABLE `importpdf`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `nome`
--
ALTER TABLE `nome`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tipoequipamento`
--
ALTER TABLE `tipoequipamento`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `unidade`
--
ALTER TABLE `unidade`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `emprestimo`
--
ALTER TABLE `emprestimo`
  ADD CONSTRAINT `destino` FOREIGN KEY (`unidade`) REFERENCES `equipamento` (`unidade`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empres_tipoequip` FOREIGN KEY (`tipoequip`) REFERENCES `tipoequipamento` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empres_unidade` FOREIGN KEY (`unidade`) REFERENCES `equipamento` (`unidade`) ON UPDATE CASCADE,
  ADD CONSTRAINT `equipamento` FOREIGN KEY (`equipamento`) REFERENCES `equipamento` (`id`) ON UPDATE CASCADE;

--
-- Limitadores para a tabela `equipamento`
--
ALTER TABLE `equipamento`
  ADD CONSTRAINT `fabricante` FOREIGN KEY (`fabricante`) REFERENCES `fabricante` (`id`),
  ADD CONSTRAINT `fornecedor` FOREIGN KEY (`fornecedor`) REFERENCES `fornecedor` (`id`),
  ADD CONSTRAINT `tipoequip` FOREIGN KEY (`tipoequip`) REFERENCES `tipoequipamento` (`id`),
  ADD CONSTRAINT `unidade` FOREIGN KEY (`unidade`) REFERENCES `unidade` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
