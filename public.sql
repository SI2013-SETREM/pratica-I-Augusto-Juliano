/*
Navicat PGSQL Data Transfer

Source Server         : postgresql
Source Server Version : 90304
Source Host           : localhost:5432
Source Database       : farrapos
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90304
File Encoding         : 65001

Date: 2014-11-22 03:04:41
*/


-- ----------------------------
-- Sequence structure for "public"."seq_afc_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_afc_codigo";
CREATE SEQUENCE "public"."seq_afc_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 4
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_cai_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_cai_codigo";
CREATE SEQUENCE "public"."seq_cai_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 4
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_cat_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_cat_codigo";
CREATE SEQUENCE "public"."seq_cat_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 7
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_cid_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_cid_codigo";
CREATE SEQUENCE "public"."seq_cid_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 4
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_ctm_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_ctm_codigo";
CREATE SEQUENCE "public"."seq_ctm_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_est_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_est_codigo";
CREATE SEQUENCE "public"."seq_est_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 6
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_log_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_log_codigo";
CREATE SEQUENCE "public"."seq_log_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_mar_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_mar_codigo";
CREATE SEQUENCE "public"."seq_mar_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 18
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_par_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_par_codigo";
CREATE SEQUENCE "public"."seq_par_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 18
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_pes_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_pes_codigo";
CREATE SEQUENCE "public"."seq_pes_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 11
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_pro_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_pro_codigo";
CREATE SEQUENCE "public"."seq_pro_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 7
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_psc_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_psc_codigo";
CREATE SEQUENCE "public"."seq_psc_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 7
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_rcd_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_rcd_codigo";
CREATE SEQUENCE "public"."seq_rcd_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 9
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_tpc_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_tpc_codigo";
CREATE SEQUENCE "public"."seq_tpc_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 6
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_tpp_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_tpp_codigo";
CREATE SEQUENCE "public"."seq_tpp_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 26
 CACHE 1;

-- ----------------------------
-- Table structure for "public"."fin_afcaixa"
-- ----------------------------
DROP TABLE "public"."fin_afcaixa";
CREATE TABLE "public"."fin_afcaixa" (
"afc_codigo" int4 NOT NULL,
"afc_dataabertura" timestamp(6),
"afc_datafechamento" timestamp(6),
"afc_valorabertura" float8 NOT NULL,
"afc_valorfechamento" float8 NOT NULL,
"cai_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of fin_afcaixa
-- ----------------------------
INSERT INTO "public"."fin_afcaixa" VALUES ('1', '2014-11-22 02:45:57.12', null, '2000', '0', '3');
INSERT INTO "public"."fin_afcaixa" VALUES ('2', '2014-11-22 02:46:02.737', null, '100', '0', '1');
INSERT INTO "public"."fin_afcaixa" VALUES ('3', '2014-11-22 02:46:07.482', null, '1000', '0', '2');
INSERT INTO "public"."fin_afcaixa" VALUES ('4', '2014-11-22 02:46:12.756', null, '5000', '0', '4');

-- ----------------------------
-- Table structure for "public"."fin_caixa"
-- ----------------------------
DROP TABLE "public"."fin_caixa";
CREATE TABLE "public"."fin_caixa" (
"cai_codigo" int4 NOT NULL,
"cai_descricao" varchar(255),
"cai_valorinicial" float8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of fin_caixa
-- ----------------------------
INSERT INTO "public"."fin_caixa" VALUES ('1', 'CAIXA REGISTRADORA', '100');
INSERT INTO "public"."fin_caixa" VALUES ('2', 'CC - SICREDI', '1000');
INSERT INTO "public"."fin_caixa" VALUES ('3', 'CC - BANCO DO BRASIL', '2000');
INSERT INTO "public"."fin_caixa" VALUES ('4', 'CC - CAIXA ECONOMICA FEDERAL', '5000');

-- ----------------------------
-- Table structure for "public"."fin_categoriamovimentacao"
-- ----------------------------
DROP TABLE "public"."fin_categoriamovimentacao";
CREATE TABLE "public"."fin_categoriamovimentacao" (
"ctm_codigo" int4 NOT NULL,
"ctm_descricao" varchar(255),
"ctm_entradasaida" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of fin_categoriamovimentacao
-- ----------------------------
INSERT INTO "public"."fin_categoriamovimentacao" VALUES ('1', 'ENTRADA (E)', 'E');
INSERT INTO "public"."fin_categoriamovimentacao" VALUES ('2', 'SAIDA (S)', 'S');

-- ----------------------------
-- Table structure for "public"."fin_movimentacaoprodutos"
-- ----------------------------
DROP TABLE "public"."fin_movimentacaoprodutos";
CREATE TABLE "public"."fin_movimentacaoprodutos" (
"pro_desconto" float8 NOT NULL,
"pro_quantidade" float8 NOT NULL,
"pro_valorbruto" float8 NOT NULL,
"pro_valorliquido" float8 NOT NULL,
"pro_valorunitario" float8 NOT NULL,
"rcd_codigo" int4 NOT NULL,
"pro_codigo" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of fin_movimentacaoprodutos
-- ----------------------------

-- ----------------------------
-- Table structure for "public"."fin_parcela"
-- ----------------------------
DROP TABLE "public"."fin_parcela";
CREATE TABLE "public"."fin_parcela" (
"par_codigo" int4 NOT NULL,
"par_datacadastro" timestamp(6),
"par_datapagamento" timestamp(6),
"par_datavencimento" timestamp(6),
"par_numerodocumento" varchar(255),
"par_status" bool NOT NULL,
"par_valorpago" float8 NOT NULL,
"par_valortotal" float8 NOT NULL,
"afc_codigo" int4,
"par_pai" int4,
"rcd_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of fin_parcela
-- ----------------------------
INSERT INTO "public"."fin_parcela" VALUES ('1', '0014-11-22 00:00:00', null, '0014-10-15 00:00:00', '0202', 'f', '0', '200', '2', null, '1');
INSERT INTO "public"."fin_parcela" VALUES ('2', '0014-11-22 00:00:00', null, '0014-10-22 00:00:00', '0203', 'f', '0', '25.48', '2', null, '2');
INSERT INTO "public"."fin_parcela" VALUES ('3', '0014-11-22 00:00:00', '0014-11-10 00:00:00', '0014-11-10 00:00:00', '404', 't', '500', '500', '1', null, '3');
INSERT INTO "public"."fin_parcela" VALUES ('4', '0014-11-22 00:00:00', '0014-10-10 00:00:00', '0014-10-10 00:00:00', '47849997-1', 't', '500', '500', '4', null, '4');
INSERT INTO "public"."fin_parcela" VALUES ('5', '0014-11-22 00:00:00', '0014-11-10 00:00:00', '0014-11-10 00:00:00', '47849997-2', 't', '500', '500', '4', null, '4');
INSERT INTO "public"."fin_parcela" VALUES ('6', '0014-11-22 00:00:00', null, '0014-12-10 00:00:00', '47849997-3', 'f', '0', '500', '4', null, '4');
INSERT INTO "public"."fin_parcela" VALUES ('7', '0014-11-22 00:00:00', null, '0015-01-10 00:00:00', '47849997-4', 'f', '0', '500', '4', null, '4');
INSERT INTO "public"."fin_parcela" VALUES ('8', '0014-11-22 00:00:00', null, '0015-02-10 00:00:00', '47849997-5', 'f', '0', '500', '2', null, '4');
INSERT INTO "public"."fin_parcela" VALUES ('9', '0014-11-22 00:00:00', null, '0015-03-10 00:00:00', '47849997-6', 'f', '0', '500', '4', null, '4');
INSERT INTO "public"."fin_parcela" VALUES ('10', '0014-11-22 00:00:00', '0014-11-10 00:00:00', '0014-11-10 00:00:00', '0465', 't', '112.15', '112.15', '2', null, '5');
INSERT INTO "public"."fin_parcela" VALUES ('11', '0014-11-22 00:00:00', '0014-08-10 00:00:00', '0014-08-10 00:00:00', '0448-1', 't', '197.49', '197.49', '2', null, '6');
INSERT INTO "public"."fin_parcela" VALUES ('12', '0014-11-22 00:00:00', '0014-09-10 00:00:00', '0014-09-10 00:00:00', '0448-2', 't', '179.49', '179.49', '2', null, '6');
INSERT INTO "public"."fin_parcela" VALUES ('13', '0014-11-22 00:00:00', '0014-10-10 00:00:00', '0014-10-10 00:00:00', '0448-3', 't', '197.49', '197.49', '2', null, '6');
INSERT INTO "public"."fin_parcela" VALUES ('14', '0014-11-22 00:00:00', '0014-11-10 00:00:00', '0014-11-10 00:00:00', '0448-4', 't', '500', '500', '2', null, '6');
INSERT INTO "public"."fin_parcela" VALUES ('15', '0014-11-22 00:00:00', null, '0015-01-10 00:00:00', '4489-1', 'f', '0', '340', '3', null, '7');
INSERT INTO "public"."fin_parcela" VALUES ('16', '0014-11-22 00:00:00', null, '0015-02-10 00:00:00', '4489-2', 'f', '0', '340', '1', null, '7');
INSERT INTO "public"."fin_parcela" VALUES ('17', '0014-11-22 00:00:00', null, '0015-05-10 00:00:00', '9999-1', 'f', '0', '500', '4', null, '8');
INSERT INTO "public"."fin_parcela" VALUES ('18', '0014-11-22 00:00:00', '0014-11-22 00:00:00', '0015-03-10 00:00:00', '9874-1', 't', '1274.8', '1274.8', '2', null, '9');

-- ----------------------------
-- Table structure for "public"."fin_receitadespesa"
-- ----------------------------
DROP TABLE "public"."fin_receitadespesa";
CREATE TABLE "public"."fin_receitadespesa" (
"rcd_codigo" int4 NOT NULL,
"rcd_datacadastro" date,
"rcd_datainicio" date,
"rcd_desconto" float8 NOT NULL,
"rcd_fixa" bool NOT NULL,
"rcd_numeronota" varchar(255),
"rcd_observacao" varchar(255),
"rcd_valorbruto" float8 NOT NULL,
"rcd_valorliquido" float8 NOT NULL,
"ctm_codigo" int4,
"pes_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of fin_receitadespesa
-- ----------------------------
INSERT INTO "public"."fin_receitadespesa" VALUES ('1', '2014-11-22', null, '0', 'f', '200', 'COMPRA DE BEBIDAS ALCÓLICAS', '200', '200', '1', '3');
INSERT INTO "public"."fin_receitadespesa" VALUES ('2', '2014-11-22', null, '0', 'f', '0203', '', '25.48', '25.48', '1', '3');
INSERT INTO "public"."fin_receitadespesa" VALUES ('3', '2014-11-22', null, '0', 'f', '0404', '', '500', '500', '1', '4');
INSERT INTO "public"."fin_receitadespesa" VALUES ('4', '2014-11-22', null, '0', 'f', '00047849997', '', '3000', '3000', '2', '11');
INSERT INTO "public"."fin_receitadespesa" VALUES ('5', '2014-11-22', null, '0', 'f', '0465', '			', '112.15', '112.15', '1', '2');
INSERT INTO "public"."fin_receitadespesa" VALUES ('6', '2014-11-22', null, '0', 'f', '0448', 'RANCHO', '1074.47', '1074.47', '1', '5');
INSERT INTO "public"."fin_receitadespesa" VALUES ('7', '2014-11-22', null, '0', 'f', '4489', '', '680', '680', '2', '10');
INSERT INTO "public"."fin_receitadespesa" VALUES ('8', '2014-11-22', null, '0', 'f', '9999', '	', '500', '500', '1', '6');
INSERT INTO "public"."fin_receitadespesa" VALUES ('9', '2014-11-22', null, '0', 'f', '9874', 'COMPRA LOTE ERVA DA BOA', '1274.8', '1274.8', '2', '9');

-- ----------------------------
-- Table structure for "public"."pro_categoria"
-- ----------------------------
DROP TABLE "public"."pro_categoria";
CREATE TABLE "public"."pro_categoria" (
"cat_codigo" int4 NOT NULL,
"cat_descricao" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pro_categoria
-- ----------------------------
INSERT INTO "public"."pro_categoria" VALUES ('1', 'PRODUTOS DE LIMPEZA');
INSERT INTO "public"."pro_categoria" VALUES ('2', 'PRODUTOS DE HIGIÊNE');
INSERT INTO "public"."pro_categoria" VALUES ('3', 'ALIMENTOS NÃO PERECÍVEIS');
INSERT INTO "public"."pro_categoria" VALUES ('4', 'ALIMENTOS PERECÍVEIS');
INSERT INTO "public"."pro_categoria" VALUES ('5', 'CONGELADOS');
INSERT INTO "public"."pro_categoria" VALUES ('6', 'BEBIDAS COM ALCOOL');
INSERT INTO "public"."pro_categoria" VALUES ('7', 'BEBIDAS SEM ALCOOL');

-- ----------------------------
-- Table structure for "public"."pro_marcas"
-- ----------------------------
DROP TABLE "public"."pro_marcas";
CREATE TABLE "public"."pro_marcas" (
"mar_codigo" int4 NOT NULL,
"mar_descricao" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pro_marcas
-- ----------------------------
INSERT INTO "public"."pro_marcas" VALUES ('1', 'SKOL');
INSERT INTO "public"."pro_marcas" VALUES ('2', 'HEINEKEN');
INSERT INTO "public"."pro_marcas" VALUES ('3', 'BOHEMIA');
INSERT INTO "public"."pro_marcas" VALUES ('4', 'BRAHMA');
INSERT INTO "public"."pro_marcas" VALUES ('5', 'COCA-COLA');
INSERT INTO "public"."pro_marcas" VALUES ('6', 'FRUKI');
INSERT INTO "public"."pro_marcas" VALUES ('7', 'ÁGUA DA PEDRA');
INSERT INTO "public"."pro_marcas" VALUES ('8', 'KUAT');
INSERT INTO "public"."pro_marcas" VALUES ('9', 'COLGATE');
INSERT INTO "public"."pro_marcas" VALUES ('10', 'SORISSO');
INSERT INTO "public"."pro_marcas" VALUES ('11', 'CLEAR UP');
INSERT INTO "public"."pro_marcas" VALUES ('12', 'CLEAR MAN');
INSERT INTO "public"."pro_marcas" VALUES ('13', 'DOVE');
INSERT INTO "public"."pro_marcas" VALUES ('14', 'SEDA');
INSERT INTO "public"."pro_marcas" VALUES ('15', 'TRIDENT');
INSERT INTO "public"."pro_marcas" VALUES ('16', 'VIER');
INSERT INTO "public"."pro_marcas" VALUES ('17', 'TERRA-MATE');
INSERT INTO "public"."pro_marcas" VALUES ('18', 'TURMA DA MÔNICA');

-- ----------------------------
-- Table structure for "public"."pro_produto"
-- ----------------------------
DROP TABLE "public"."pro_produto";
CREATE TABLE "public"."pro_produto" (
"pro_codigo" int4 NOT NULL,
"pro_datacadastro" timestamp(6),
"pro_descricao" varchar(255),
"pro_valorcompra" float8 NOT NULL,
"pro_valorvenda" float8 NOT NULL,
"cat_codigo" int4,
"mar_codigo" int4,
"tpp_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pro_produto
-- ----------------------------
INSERT INTO "public"."pro_produto" VALUES ('1', '2014-11-22 02:30:47.854', 'AGUA MINERAL COM GAS 600MLS', '1', '2.25', '7', '7', '21');
INSERT INTO "public"."pro_produto" VALUES ('2', '2014-11-22 02:31:03.739', 'AGUA MINERAL SEM GAS 600MLS', '1', '2.25', '7', '7', '22');
INSERT INTO "public"."pro_produto" VALUES ('3', '2014-11-22 02:31:29.643', 'CERVEJA BRAHMA 600MLS', '2', '3.5', '6', '4', '1');
INSERT INTO "public"."pro_produto" VALUES ('4', '2014-11-22 02:31:50.44', 'CERVEJA BRAHMA 1 LITRO', '3', '4.5', '6', '4', '1');
INSERT INTO "public"."pro_produto" VALUES ('5', '2014-11-22 02:32:13.205', 'CREME DENTAL COLGATE TOTAL 12', '2', '4.5', '2', '9', '4');
INSERT INTO "public"."pro_produto" VALUES ('6', '2014-11-22 02:32:41.75', 'REFRIGERANTE COCA-COLA 2 LITROS', '3', '4.25', '7', '5', '22');
INSERT INTO "public"."pro_produto" VALUES ('7', '2014-11-22 02:33:14.924', 'CONDICIONADOR DOVE 425 MLS', '4', '6.25', '2', '13', '6');

-- ----------------------------
-- Table structure for "public"."pro_tipoproduto"
-- ----------------------------
DROP TABLE "public"."pro_tipoproduto";
CREATE TABLE "public"."pro_tipoproduto" (
"tpp_codigo" int4 NOT NULL,
"tpp_descricao" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pro_tipoproduto
-- ----------------------------
INSERT INTO "public"."pro_tipoproduto" VALUES ('1', 'CERVEJA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('2', 'REFRIGERANTE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('3', 'PAPEL HIGIENICO');
INSERT INTO "public"."pro_tipoproduto" VALUES ('4', 'CREME DENTAL');
INSERT INTO "public"."pro_tipoproduto" VALUES ('5', 'SHAMPOO');
INSERT INTO "public"."pro_tipoproduto" VALUES ('6', 'CONDICIONADOR');
INSERT INTO "public"."pro_tipoproduto" VALUES ('7', 'ERVA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('8', 'PIZZA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('9', 'ARROZ');
INSERT INTO "public"."pro_tipoproduto" VALUES ('10', 'FEIJAO');
INSERT INTO "public"."pro_tipoproduto" VALUES ('11', 'MASSAS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('12', 'SAL');
INSERT INTO "public"."pro_tipoproduto" VALUES ('13', 'AÇUCAR');
INSERT INTO "public"."pro_tipoproduto" VALUES ('14', 'TEMPEROS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('15', 'BALA DE GOMA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('18', 'DETERGENTE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('19', 'SORVETE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('20', 'PICOLÉ');
INSERT INTO "public"."pro_tipoproduto" VALUES ('21', 'ÁGUA MINERAL COM GÁS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('22', 'ÁGUA MINERAL SEM GÁS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('23', 'SUCO CAIXA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('24', 'SUCO PACOTE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('25', 'LEITE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('26', 'SALGADOS');

-- ----------------------------
-- Table structure for "public"."pub_cidade"
-- ----------------------------
DROP TABLE "public"."pub_cidade";
CREATE TABLE "public"."pub_cidade" (
"cid_codigo" int4 NOT NULL,
"cid_cep" varchar(255),
"cid_descricao" varchar(255),
"est_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pub_cidade
-- ----------------------------
INSERT INTO "public"."pub_cidade" VALUES ('1', '98918-000', 'BOA VISTA DO BURICA', '1');
INSERT INTO "public"."pub_cidade" VALUES ('2', '98910-000', 'TRES DE MAIO', '1');
INSERT INTO "public"."pub_cidade" VALUES ('3', '98915-000', 'INDEPENDENCIA', '1');
INSERT INTO "public"."pub_cidade" VALUES ('4', '95000-000', 'XANXERE', '2');

-- ----------------------------
-- Table structure for "public"."pub_estado"
-- ----------------------------
DROP TABLE "public"."pub_estado";
CREATE TABLE "public"."pub_estado" (
"est_codigo" int4 NOT NULL,
"est_descricao" varchar(255),
"est_sigla" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pub_estado
-- ----------------------------
INSERT INTO "public"."pub_estado" VALUES ('1', 'RIO GRANDE DO SUL', 'RS');
INSERT INTO "public"."pub_estado" VALUES ('2', 'SANTA CATARINA', 'SC');
INSERT INTO "public"."pub_estado" VALUES ('3', 'PARANÁ', 'PR');
INSERT INTO "public"."pub_estado" VALUES ('4', 'SÃO PAULO', 'SP');
INSERT INTO "public"."pub_estado" VALUES ('5', 'RIO DE JANEIRO', 'RJ');
INSERT INTO "public"."pub_estado" VALUES ('6', 'MINAS GERAIS', 'MG');

-- ----------------------------
-- Table structure for "public"."pub_log"
-- ----------------------------
DROP TABLE "public"."pub_log";
CREATE TABLE "public"."pub_log" (
"log_codigo" int4 NOT NULL,
"log_acao" varchar(255),
"log_data" varchar(255),
"log_newvalue" varchar(255),
"log_oldvalue" varchar(255),
"log_tabela" varchar(255),
"pes_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pub_log
-- ----------------------------

-- ----------------------------
-- Table structure for "public"."pub_pessoa"
-- ----------------------------
DROP TABLE "public"."pub_pessoa";
CREATE TABLE "public"."pub_pessoa" (
"pes_codigo" int4 NOT NULL,
"pes_bairro" varchar(255),
"pes_cnpjcpf" varchar(255),
"pes_complemento" varchar(255),
"pes_datacadastro" timestamp(6),
"pes_login" varchar(255),
"pes_logradouro" varchar(255),
"pes_nivelacesso" varchar(255),
"pes_nomefantasia" varchar(255),
"pes_numero" int4 NOT NULL,
"pes_observacoes" varchar(255),
"pes_razaosocial" varchar(255),
"pes_senha" varchar(255),
"pes_status" bool NOT NULL,
"pes_tipo" varchar(255),
"pes_tipopessoa" varchar(255),
"cid_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pub_pessoa
-- ----------------------------
INSERT INTO "public"."pub_pessoa" VALUES ('1', null, null, null, '2014-11-22 02:20:40.487', 'JP0067517', null, 'A', null, '0', null, 'JULIANO PIRES', 'a3c4d148ed56c6956613720933ddc89a', 'f', null, null, null);
INSERT INTO "public"."pub_pessoa" VALUES ('2', 'CENTRO', '025.432.860-12', 'SALA 02', '2014-11-22 02:33:53.179', null, 'RUA SOROCABA', null, '', '24', null, 'JULIANO PIRES', null, 't', 'C', 'P', '1');
INSERT INTO "public"."pub_pessoa" VALUES ('3', 'CENTRO', '923.881.465-18', '', '2014-11-22 02:37:08.68', null, 'AVENIDA URUGUAI', null, '', '272', null, 'AUGUSTO RICARDO TISCHLER ZVOBOTER', null, 't', 'C', 'P', '2');
INSERT INTO "public"."pub_pessoa" VALUES ('4', 'CENTRO', '231.390.150-54', '', '2014-11-22 02:37:58.942', null, 'AVENIDA SÃO JOSÉ', null, '', '242', null, 'DINEI ANDRE ROCKENBACH', null, 't', 'C', 'P', '1');
INSERT INTO "public"."pub_pessoa" VALUES ('5', 'CENTRO', '412.898.130-35', '', '2014-11-22 02:39:03.829', null, 'AV. PASQUALINI', null, '', '644', null, 'NADINE ANDERLE', null, 't', 'C', 'P', '2');
INSERT INTO "public"."pub_pessoa" VALUES ('6', 'CENTRO', '644.157.112-94', '', '2014-11-22 02:39:36.162', null, 'RUA UNICA', null, '', '1', null, 'RICARDO PIEPER', null, 't', 'C', 'P', '3');
INSERT INTO "public"."pub_pessoa" VALUES ('8', 'CENTRO', '539.070.186-05', '', '2014-11-22 02:41:38.722', null, 'AV. URUGUAI', null, '', '555', null, 'RAFAEL RADÜNZ', null, 't', 'C', 'P', '2');
INSERT INTO "public"."pub_pessoa" VALUES ('9', 'CENTRO', '19.321.095/0001-73', '', '2014-11-22 02:42:31.186', null, 'RUA DOS ALMIRANTES', null, 'TERRA-MATE LTDA', '655', null, 'TERRA-MATE INDUSTRIA DE ERVAS LTDA', null, 't', 'F', 'P', '4');
INSERT INTO "public"."pub_pessoa" VALUES ('10', 'BAIRRO DOS ATIRADORES', '04.551.233/0001-33', 'SALA 02', '2014-11-22 02:44:39.485', null, 'RUA ALFREDO JACONI', null, 'COLGATE IND E COMERCIO', '647', null, 'COLGATE DISTRIBUIDORA LTDA', null, 't', 'F', 'P', '4');
INSERT INTO "public"."pub_pessoa" VALUES ('11', 'RUA DO AÇUCAR', '12.511.927/0001-75', 'PREDIO 2', '2014-11-22 02:45:22.648', null, 'SETE PASSOS', null, 'COKE', '447', null, 'COCA-COLA DISTRIBUIDORA DE BEBIDAS', null, 't', 'F', 'P', '4');

-- ----------------------------
-- Table structure for "public"."pub_pessoacontatos"
-- ----------------------------
DROP TABLE "public"."pub_pessoacontatos";
CREATE TABLE "public"."pub_pessoacontatos" (
"psc_codigo" int4 NOT NULL,
"psc_contato" varchar(255),
"pes_codigo" int4,
"tpc_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pub_pessoacontatos
-- ----------------------------
INSERT INTO "public"."pub_pessoacontatos" VALUES ('1', 'JULIANO.PIRES18', '2', '3');
INSERT INTO "public"."pub_pessoacontatos" VALUES ('2', 'dineiar@gmail.com', '4', '2');
INSERT INTO "public"."pub_pessoacontatos" VALUES ('3', '(55) 9631-5144', '4', '5');
INSERT INTO "public"."pub_pessoacontatos" VALUES ('4', 'nadine.anderle', '5', '1');
INSERT INTO "public"."pub_pessoacontatos" VALUES ('5', 'nadine.anderle484', '5', '3');
INSERT INTO "public"."pub_pessoacontatos" VALUES ('6', '(55) 3535-4600', '5', '6');
INSERT INTO "public"."pub_pessoacontatos" VALUES ('7', '(52) 4533-2114', '10', '6');

-- ----------------------------
-- Table structure for "public"."pub_tipocontato"
-- ----------------------------
DROP TABLE "public"."pub_tipocontato";
CREATE TABLE "public"."pub_tipocontato" (
"tpc_codigo" int4 NOT NULL,
"tpc_descricao" varchar(255),
"tpc_status" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pub_tipocontato
-- ----------------------------
INSERT INTO "public"."pub_tipocontato" VALUES ('1', 'SKYPE', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('2', 'E-MAIL', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('3', 'FACEBOOK', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('4', 'WHATSAPP', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('5', 'CELULAR', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('6', 'TELEFONE FIXO', 't');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table "public"."fin_afcaixa"
-- ----------------------------
ALTER TABLE "public"."fin_afcaixa" ADD PRIMARY KEY ("afc_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."fin_caixa"
-- ----------------------------
ALTER TABLE "public"."fin_caixa" ADD PRIMARY KEY ("cai_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."fin_categoriamovimentacao"
-- ----------------------------
ALTER TABLE "public"."fin_categoriamovimentacao" ADD PRIMARY KEY ("ctm_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."fin_movimentacaoprodutos"
-- ----------------------------
ALTER TABLE "public"."fin_movimentacaoprodutos" ADD PRIMARY KEY ("rcd_codigo", "pro_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."fin_parcela"
-- ----------------------------
ALTER TABLE "public"."fin_parcela" ADD PRIMARY KEY ("par_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."fin_receitadespesa"
-- ----------------------------
ALTER TABLE "public"."fin_receitadespesa" ADD PRIMARY KEY ("rcd_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pro_categoria"
-- ----------------------------
ALTER TABLE "public"."pro_categoria" ADD PRIMARY KEY ("cat_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pro_marcas"
-- ----------------------------
ALTER TABLE "public"."pro_marcas" ADD PRIMARY KEY ("mar_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pro_produto"
-- ----------------------------
ALTER TABLE "public"."pro_produto" ADD PRIMARY KEY ("pro_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pro_tipoproduto"
-- ----------------------------
ALTER TABLE "public"."pro_tipoproduto" ADD PRIMARY KEY ("tpp_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pub_cidade"
-- ----------------------------
ALTER TABLE "public"."pub_cidade" ADD PRIMARY KEY ("cid_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pub_estado"
-- ----------------------------
ALTER TABLE "public"."pub_estado" ADD PRIMARY KEY ("est_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pub_log"
-- ----------------------------
ALTER TABLE "public"."pub_log" ADD PRIMARY KEY ("log_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pub_pessoa"
-- ----------------------------
ALTER TABLE "public"."pub_pessoa" ADD PRIMARY KEY ("pes_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pub_pessoacontatos"
-- ----------------------------
ALTER TABLE "public"."pub_pessoacontatos" ADD PRIMARY KEY ("psc_codigo");

-- ----------------------------
-- Primary Key structure for table "public"."pub_tipocontato"
-- ----------------------------
ALTER TABLE "public"."pub_tipocontato" ADD PRIMARY KEY ("tpc_codigo");

-- ----------------------------
-- Foreign Key structure for table "public"."fin_afcaixa"
-- ----------------------------
ALTER TABLE "public"."fin_afcaixa" ADD FOREIGN KEY ("cai_codigo") REFERENCES "public"."fin_caixa" ("cai_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."fin_movimentacaoprodutos"
-- ----------------------------
ALTER TABLE "public"."fin_movimentacaoprodutos" ADD FOREIGN KEY ("pro_codigo") REFERENCES "public"."pro_produto" ("pro_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."fin_movimentacaoprodutos" ADD FOREIGN KEY ("rcd_codigo") REFERENCES "public"."fin_receitadespesa" ("rcd_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."fin_parcela"
-- ----------------------------
ALTER TABLE "public"."fin_parcela" ADD FOREIGN KEY ("afc_codigo") REFERENCES "public"."fin_afcaixa" ("afc_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."fin_parcela" ADD FOREIGN KEY ("par_pai") REFERENCES "public"."fin_parcela" ("par_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."fin_parcela" ADD FOREIGN KEY ("rcd_codigo") REFERENCES "public"."fin_receitadespesa" ("rcd_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."fin_receitadespesa"
-- ----------------------------
ALTER TABLE "public"."fin_receitadespesa" ADD FOREIGN KEY ("pes_codigo") REFERENCES "public"."pub_pessoa" ("pes_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."fin_receitadespesa" ADD FOREIGN KEY ("ctm_codigo") REFERENCES "public"."fin_categoriamovimentacao" ("ctm_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."pro_produto"
-- ----------------------------
ALTER TABLE "public"."pro_produto" ADD FOREIGN KEY ("mar_codigo") REFERENCES "public"."pro_marcas" ("mar_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."pro_produto" ADD FOREIGN KEY ("tpp_codigo") REFERENCES "public"."pro_tipoproduto" ("tpp_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."pro_produto" ADD FOREIGN KEY ("cat_codigo") REFERENCES "public"."pro_categoria" ("cat_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."pub_cidade"
-- ----------------------------
ALTER TABLE "public"."pub_cidade" ADD FOREIGN KEY ("est_codigo") REFERENCES "public"."pub_estado" ("est_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."pub_log"
-- ----------------------------
ALTER TABLE "public"."pub_log" ADD FOREIGN KEY ("pes_codigo") REFERENCES "public"."pub_pessoa" ("pes_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."pub_pessoa"
-- ----------------------------
ALTER TABLE "public"."pub_pessoa" ADD FOREIGN KEY ("cid_codigo") REFERENCES "public"."pub_cidade" ("cid_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."pub_pessoacontatos"
-- ----------------------------
ALTER TABLE "public"."pub_pessoacontatos" ADD FOREIGN KEY ("pes_codigo") REFERENCES "public"."pub_pessoa" ("pes_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."pub_pessoacontatos" ADD FOREIGN KEY ("tpc_codigo") REFERENCES "public"."pub_tipocontato" ("tpc_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
