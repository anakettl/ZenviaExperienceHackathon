CREATE SEQUENCE SEQUENCE_SERV_OFFERED START WITH 1 INCREMENT BY 1;

CREATE TABLE SERVICE_OFFERED (
    UID_SERV_OFFERED BIGINT NOT NULL,
    NAME VARCHAR(200) NOT NULL,
    CODE VARCHAR(10) NOT NULL,
    FK_COMPANY_UID BIGINT NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL
);

ALTER TABLE SERVICE_OFFERED ADD CONSTRAINT PK_SERVICE_OFFERED PRIMARY KEY(UID_SERV_OFFERED);
ALTER TABLE SERVICE_OFFERED ADD CONSTRAINT FK_SERVICE_OFFERED_UID_COMPANY FOREIGN KEY (FK_COMPANY_UID) REFERENCES COMPANY (UID_COMPANY);

COMMENT ON TABLE SERVICE_OFFERED IS 'Tabela com os serviços da empresa.';
COMMENT ON COLUMN SERVICE_OFFERED.UID_SERV_OFFERED IS 'Identificador único da tabela SERVICE_OFFERED.';
COMMENT ON COLUMN SERVICE_OFFERED.NAME IS 'Nome do serviço.';
COMMENT ON COLUMN SERVICE_OFFERED.CODE IS 'Código do serviço.';
COMMENT ON COLUMN SERVICE_OFFERED.FK_COMPANY_UID IS 'Chave estrangeira referenciando o UID da empresa.';
COMMENT ON COLUMN SERVICE_OFFERED.CREATED_AT IS 'Data de criação do serviço.';