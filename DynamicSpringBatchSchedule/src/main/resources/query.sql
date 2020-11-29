create table ACEVNPRD2.T_SETTING_JOB_SCHEDULE(
    JOB_ID NUMBER(10,0) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) NOT NULL,
    JOB_NAME VARCHAR2(50) NOT NULL,
    DESCRIPTION VARCHAR2(100),
    CLASS_PATH VARCHAR2(50) NOT NULL,
    PARAMETER VARCHAR2(50),
    CRON_EXPRESSION VARCHAR2(50) NOT NULL,
    USE_YN CHAR(1) DEFAULT 1 NOT NULL,
    REG_ID VARCHAR2(20),
    REG_DT DATE DEFAULT SYSDATE NOT NULL,
    UPD_ID VARCHAR2(20),
    UPD_DT DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT "PK_T_SETTING_JOB_SCHEDULE" PRIMARY KEY ("JOB_ID")
);
GRANT SELECT, DELETE, INSERT, UPDATE ON ACEVNPRD2.T_SETTING_JOB_SCHEDULE TO "ACEVNPRD2APP";

create table ACEVNPRD2.T_JOB_EXEC_LOG (
    EXE_ID NUMBER(10,0) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) NOT NULL,
    JOB_ID NUMBER(10,0),
    RUN_DATE DATE DEFAULT SYSDATE NOT NULL,
    START_DT DATE DEFAULT SYSDATE NOT NULL,
    END_DT DATE,
    CONDITION VARCHAR2(50),
    JOB_STATUS CHAR(1),
    MSG blob,
    CONSTRAINT "PK_T_JOB_EXEC_LOG" PRIMARY KEY ("EXE_ID")
);
GRANT SELECT, DELETE, INSERT, UPDATE ON ACEVNPRD2.T_JOB_EXEC_LOG TO "ACEVNPRD2APP";