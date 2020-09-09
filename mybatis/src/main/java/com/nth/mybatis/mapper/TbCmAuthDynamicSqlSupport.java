package com.nth.mybatis.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbCmAuthDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0358085+07:00", comments="Source Table: tb_cm_auth")
    public static final TbCmAuth tbCmAuth = new TbCmAuth();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.AUTH_CD")
    public static final SqlColumn<String> authCd = tbCmAuth.authCd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.AUTH_NM")
    public static final SqlColumn<String> authNm = tbCmAuth.authNm;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.NOTE")
    public static final SqlColumn<String> note = tbCmAuth.note;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.USE_YN")
    public static final SqlColumn<String> useYn = tbCmAuth.useYn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.REG_ID")
    public static final SqlColumn<String> regId = tbCmAuth.regId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.REG_DT")
    public static final SqlColumn<Date> regDt = tbCmAuth.regDt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.UPD_ID")
    public static final SqlColumn<String> updId = tbCmAuth.updId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source field: tb_cm_auth.UPD_DT")
    public static final SqlColumn<Date> updDt = tbCmAuth.updDt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0358085+07:00", comments="Source Table: tb_cm_auth")
    public static final class TbCmAuth extends SqlTable {
        public final SqlColumn<String> authCd = column("AUTH_CD", JDBCType.VARCHAR);

        public final SqlColumn<String> authNm = column("AUTH_NM", JDBCType.VARCHAR);

        public final SqlColumn<String> note = column("NOTE", JDBCType.VARCHAR);

        public final SqlColumn<String> useYn = column("USE_YN", JDBCType.CHAR);

        public final SqlColumn<String> regId = column("REG_ID", JDBCType.VARCHAR);

        public final SqlColumn<Date> regDt = column("REG_DT", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updId = column("UPD_ID", JDBCType.VARCHAR);

        public final SqlColumn<Date> updDt = column("UPD_DT", JDBCType.TIMESTAMP);

        public TbCmAuth() {
            super("tb_cm_auth");
        }
    }
}