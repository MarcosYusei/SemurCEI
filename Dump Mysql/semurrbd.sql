-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 03-Nov-2022 às 14:52
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
  `modelo` varchar(30) NOT NULL,
  `destino` int(7) NOT NULL,
  `nome` int(7) NOT NULL,
  `dataSaida` date NOT NULL,
  `dataDevolucao` date NOT NULL,
  `status` varchar(10) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `observacao` varchar(250) NOT NULL,
  `tombo` varchar(10) NOT NULL,
  `serie` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `emprestimo`
--

INSERT INTO `emprestimo` (`id`, `unidade`, `tipoequip`, `modelo`, `destino`, `nome`, `dataSaida`, `dataDevolucao`, `status`, `tipo`, `observacao`, `tombo`, `serie`) VALUES
(1, 1, 1, '22MP55PQ-BK', 1, 1, '2022-11-30', '2022-11-01', 'DISPONIVEL', 'EMPRESTIMO', '', 'S/T', '001890');

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
  `modelo` varchar(30) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  `equipamento` varchar(30) DEFAULT NULL,
  `observacao` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `equipamento`
--

INSERT INTO `equipamento` (`id`, `unidade`, `tipoequip`, `tombo`, `serie`, `fornecedor`, `fabricante`, `modelo`, `status`, `equipamento`, `observacao`) VALUES
(1, 1, 3, 'S/T', '001890', 3, 3, '22MP55PQ-BK', 'FUNCIONAL', 'PATRIMONIO', '');

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
(2, 'TESTE'),
(3, 'SEMUR');

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
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `equipamento`
--
ALTER TABLE `equipamento`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `fabricante`
--
ALTER TABLE `fabricante`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  ADD CONSTRAINT `empres_unidade` FOREIGN KEY (`unidade`) REFERENCES `equipamento` (`unidade`) ON UPDATE CASCADE;

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
