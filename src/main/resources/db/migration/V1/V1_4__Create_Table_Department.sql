CREATE SEQUENCE SEQUENCE_DEPARTMENT START WITH 1 INCREMENT BY 1;

CREATE TABLE DEPARTMENT (
    UID_DEPARTMENT BIGINT NOT NULL,
    NAME VARCHAR(200) NOT NULL,
    FK_COMPANY_UID BIGINT NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL
);

ALTER TABLE DEPARTMENT ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(UID_DEPARTMENT);
ALTER TABLE DEPARTMENT ADD CONSTRAINT FK_DEPARTMENT_UID_COMPANY FOREIGN KEY (FK_COMPANY_UID) REFERENCES COMPANY (UID_COMPANY);

COMMENT ON TABLE DEPARTMENT IS 'Tabela com os departamentos da empresa.';
COMMENT ON COLUMN DEPARTMENT.UID_DEPARTMENT IS 'Identificador único da tabela DEPARTMENT.';
COMMENT ON COLUMN DEPARTMENT.NAME IS 'Nome do departamento.';
COMMENT ON COLUMN DEPARTMENT.FK_COMPANY_UID IS 'Chave estrangeira referenciando o UID da empresa.';
COMMENT ON COLUMN DEPARTMENT.CREATED_AT IS 'Data de criação do departmento.';