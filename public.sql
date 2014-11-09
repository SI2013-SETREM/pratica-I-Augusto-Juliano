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

Date: 2014-10-31 17:12:21
*/


-- ----------------------------
-- Sequence structure for "public"."seq_afc_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_afc_codigo";
CREATE SEQUENCE "public"."seq_afc_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_cai_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_cai_codigo";
CREATE SEQUENCE "public"."seq_cai_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_cat_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_cat_codigo";
CREATE SEQUENCE "public"."seq_cat_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 23
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_cid_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_cid_codigo";
CREATE SEQUENCE "public"."seq_cid_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 9
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_ctm_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_ctm_codigo";
CREATE SEQUENCE "public"."seq_ctm_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_est_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_est_codigo";
CREATE SEQUENCE "public"."seq_est_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 9
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
 START 13
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_par_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_par_codigo";
CREATE SEQUENCE "public"."seq_par_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_pes_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_pes_codigo";
CREATE SEQUENCE "public"."seq_pes_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_pro_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_pro_codigo";
CREATE SEQUENCE "public"."seq_pro_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 4
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_psc_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_psc_codigo";
CREATE SEQUENCE "public"."seq_psc_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_rcd_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_rcd_codigo";
CREATE SEQUENCE "public"."seq_rcd_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_tpc_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_tpc_codigo";
CREATE SEQUENCE "public"."seq_tpc_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 10
 CACHE 1;

-- ----------------------------
-- Sequence structure for "public"."seq_tpp_codigo"
-- ----------------------------
DROP SEQUENCE "public"."seq_tpp_codigo";
CREATE SEQUENCE "public"."seq_tpp_codigo"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 30
 CACHE 1;

-- ----------------------------
-- Table structure for "public"."fin_afcaixa"
-- ----------------------------
DROP TABLE "public"."fin_afcaixa" CASCADE;
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

-- ----------------------------
-- Table structure for "public"."fin_caixa"
-- ----------------------------
DROP TABLE "public"."fin_caixa" CASCADE;
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

-- ----------------------------
-- Table structure for "public"."fin_categoriamovimentacao"
-- ----------------------------
DROP TABLE "public"."fin_categoriamovimentacao" CASCADE;
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

-- ----------------------------
-- Table structure for "public"."fin_movimentacaoprodutos"
-- ----------------------------
DROP TABLE "public"."fin_movimentacaoprodutos" CASCADE;
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
DROP TABLE "public"."fin_parcela" CASCADE;
CREATE TABLE "public"."fin_parcela" (
"par_codigo" int4 NOT NULL,
"par_datacadastro" timestamp(6),
"par_datapagamento" timestamp(6),
"par_datavencimento" timestamp(6),
"par_numerodocumento" varchar(255),
"par_status" bool NOT NULL,
"par_valorpago" float8 NOT NULL,
"par_valortotal" float8 NOT NULL,
"cai_codigo" int4,
"par_pai_par_codigo" int4,
"rcd_codigo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of fin_parcela
-- ----------------------------

-- ----------------------------
-- Table structure for "public"."fin_receitadespesa"
-- ----------------------------
DROP TABLE "public"."fin_receitadespesa" CASCADE;
CREATE TABLE "public"."fin_receitadespesa" (
"rcd_codigo" int4 NOT NULL,
"rcd_datacadastro" timestamp(6),
"rcd_datainicio" timestamp(6),
"rcd_desconto" float8 NOT NULL,
"rcd_fixa" bool NOT NULL,
"rcd_numeronota" float8 NOT NULL,
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

-- ----------------------------
-- Table structure for "public"."pro_categoria"
-- ----------------------------
DROP TABLE "public"."pro_categoria" CASCADE;
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
INSERT INTO "public"."pro_categoria" VALUES ('2', 'PRODUTOS DE HIGIENE PESSOAL');
INSERT INTO "public"."pro_categoria" VALUES ('3', 'PRODUTOS ALIMENTÍCIOS NÃO PERECÍVEIS');
INSERT INTO "public"."pro_categoria" VALUES ('4', 'PRODUTOS ALIMENTÍCIOS PERECÍVEIS');
INSERT INTO "public"."pro_categoria" VALUES ('5', 'BEBIDAS ALCÓLICAS');
INSERT INTO "public"."pro_categoria" VALUES ('6', 'BEBIDAS SEM ALCOOL');

-- ----------------------------
-- Table structure for "public"."pro_marcas"
-- ----------------------------
DROP TABLE "public"."pro_marcas" CASCADE;
CREATE TABLE "public"."pro_marcas" (
"mar_codigo" int4 NOT NULL,
"mar_descricao" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pro_marcas
-- ----------------------------
INSERT INTO "public"."pro_marcas" VALUES ('4', 'DOVE');
INSERT INTO "public"."pro_marcas" VALUES ('6', 'CLEAR');

-- ----------------------------
-- Table structure for "public"."pro_produto"
-- ----------------------------
DROP TABLE "public"."pro_produto" CASCADE;
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
INSERT INTO "public"."pro_produto" VALUES ('1', null, 'CONDICIONADOR CLEAR MAN 40G', '6.75', '9.32', '2', '6', '22');
INSERT INTO "public"."pro_produto" VALUES ('2', '2014-10-31 11:33:02.485', '23QWQAEEWQEWEWQEWEQWQ', '23', '33', '2', '4', '15');
INSERT INTO "public"."pro_produto" VALUES ('3', '2014-10-31 11:35:37.299', 'ASDASDASDASDAS', '32.22', '34.12', '5', '6', '30');
INSERT INTO "public"."pro_produto" VALUES ('4', '2014-10-31 11:37:00.95', 'SECADOR DE CABELO BLACK POWER 3000', '555.22', '1000.14', '5', '6', '30');

-- ----------------------------
-- Table structure for "public"."pro_tipoproduto"
-- ----------------------------
DROP TABLE "public"."pro_tipoproduto" CASCADE;
CREATE TABLE "public"."pro_tipoproduto" (
"tpp_codigo" int4 NOT NULL,
"tpp_descricao" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pro_tipoproduto
-- ----------------------------
INSERT INTO "public"."pro_tipoproduto" VALUES ('4', 'SABONETE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('5', 'SHAMPOO');
INSERT INTO "public"."pro_tipoproduto" VALUES ('6', 'ERVAS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('7', 'ARROZ');
INSERT INTO "public"."pro_tipoproduto" VALUES ('8', 'LEITE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('9', 'REFRIGERANTE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('10', 'SUCOS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('11', 'PAPEL HIGIÊNICO');
INSERT INTO "public"."pro_tipoproduto" VALUES ('12', 'PASTA DE DENTE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('13', 'CERVEJA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('14', 'DESODORANTE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('15', 'CACHAÇA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('16', 'VODKA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('17', 'FIXADOR DE CABELOS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('18', 'GEL');
INSERT INTO "public"."pro_tipoproduto" VALUES ('19', 'LIMPA VIDROS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('20', 'ÁGUA SANITÁRIA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('21', 'DETERGENTE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('22', 'CONDICIONADOR');
INSERT INTO "public"."pro_tipoproduto" VALUES ('23', 'GUARDANAPOS');
INSERT INTO "public"."pro_tipoproduto" VALUES ('24', 'PALITO DE DENTES');
INSERT INTO "public"."pro_tipoproduto" VALUES ('25', 'SORVETE');
INSERT INTO "public"."pro_tipoproduto" VALUES ('26', 'PIZZA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('27', 'LASANHA');
INSERT INTO "public"."pro_tipoproduto" VALUES ('28', 'PEITO DE FRANGO');
INSERT INTO "public"."pro_tipoproduto" VALUES ('29', 'PICOLÉ');
INSERT INTO "public"."pro_tipoproduto" VALUES ('30', 'ÁGUA MINERAL');

-- ----------------------------
-- Table structure for "public"."pub_cidade"
-- ----------------------------
DROP TABLE "public"."pub_cidade" CASCADE;
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
INSERT INTO "public"."pub_cidade" VALUES ('5', '98910-000', 'TRES DE MAIO', '9');
INSERT INTO "public"."pub_cidade" VALUES ('6', '98918-000', 'BOA VISTA DO BURICA', '2');
INSERT INTO "public"."pub_cidade" VALUES ('7', '98915-000', 'INDEPENDENCIA', '2');
INSERT INTO "public"."pub_cidade" VALUES ('8', '95147-000', 'TRES PASSOS', '8');

-- ----------------------------
-- Table structure for "public"."pub_estado"
-- ----------------------------
DROP TABLE "public"."pub_estado" CASCADE;
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
INSERT INTO "public"."pub_estado" VALUES ('2', 'RIO GRANDE DO SUL', 'RS');
INSERT INTO "public"."pub_estado" VALUES ('3', 'SANTA CATARINA', 'SC');
INSERT INTO "public"."pub_estado" VALUES ('4', 'PARANÁ', 'PR');
INSERT INTO "public"."pub_estado" VALUES ('5', 'SÃO PAULO', 'SP');
INSERT INTO "public"."pub_estado" VALUES ('6', 'RIO DE JANEIRO', 'RJ');
INSERT INTO "public"."pub_estado" VALUES ('7', 'MATO GROSSO DO SUL', 'MS');
INSERT INTO "public"."pub_estado" VALUES ('8', 'MATO GROSSO', 'MT');
INSERT INTO "public"."pub_estado" VALUES ('9', 'MINAS GERAIS', 'MG');

-- ----------------------------
-- Table structure for "public"."pub_log"
-- ----------------------------
DROP TABLE "public"."pub_log" CASCADE;
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
DROP TABLE "public"."pub_pessoa" CASCADE;
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

-- ----------------------------
-- Table structure for "public"."pub_pessoacontatos"
-- ----------------------------
DROP TABLE "public"."pub_pessoacontatos" CASCADE;
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

-- ----------------------------
-- Table structure for "public"."pub_tipocontato"
-- ----------------------------
DROP TABLE "public"."pub_tipocontato" CASCADE;
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
INSERT INTO "public"."pub_tipocontato" VALUES ('2', 'TELEFONE CELULAR', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('3', 'TELEFONE FIXO', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('4', 'TELEFONE TRABALHO', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('5', 'TELEFONE RESIDENCIAL', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('6', 'TELEFONE FAX', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('7', 'E-MAIL', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('8', 'SKYPE', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('9', 'FACEBOOK', 't');
INSERT INTO "public"."pub_tipocontato" VALUES ('10', 'WHATSAPP', 't');

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
ALTER TABLE "public"."fin_parcela" ADD FOREIGN KEY ("cai_codigo") REFERENCES "public"."fin_caixa" ("cai_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."fin_parcela" ADD FOREIGN KEY ("rcd_codigo") REFERENCES "public"."fin_receitadespesa" ("rcd_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."fin_parcela" ADD FOREIGN KEY ("par_pai_par_codigo") REFERENCES "public"."fin_parcela" ("par_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."fin_receitadespesa"
-- ----------------------------
ALTER TABLE "public"."fin_receitadespesa" ADD FOREIGN KEY ("ctm_codigo") REFERENCES "public"."fin_categoriamovimentacao" ("ctm_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."fin_receitadespesa" ADD FOREIGN KEY ("pes_codigo") REFERENCES "public"."pub_pessoa" ("pes_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."pro_produto"
-- ----------------------------
ALTER TABLE "public"."pro_produto" ADD FOREIGN KEY ("mar_codigo") REFERENCES "public"."pro_marcas" ("mar_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."pro_produto" ADD FOREIGN KEY ("cat_codigo") REFERENCES "public"."pro_categoria" ("cat_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."pro_produto" ADD FOREIGN KEY ("tpp_codigo") REFERENCES "public"."pro_tipoproduto" ("tpp_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;

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
ALTER TABLE "public"."pub_pessoacontatos" ADD FOREIGN KEY ("tpc_codigo") REFERENCES "public"."pub_tipocontato" ("tpc_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."pub_pessoacontatos" ADD FOREIGN KEY ("pes_codigo") REFERENCES "public"."pub_pessoa" ("pes_codigo") ON DELETE NO ACTION ON UPDATE NO ACTION;
