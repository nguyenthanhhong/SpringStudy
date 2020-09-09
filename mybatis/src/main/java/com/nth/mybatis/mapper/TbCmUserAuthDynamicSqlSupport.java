package com.nth.mybatis.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbCmUserAuthDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0397937+07:00", comments="Source Table: tb_cm_user_auth")
    public static final TbCmUserAuth tbCmUserAuth = new TbCmUserAuth();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source field: tb_cm_user_auth.USER_ID")
    public static final SqlColumn<String> userId = tbCmUserAuth.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source field: tb_cm_user_auth.AUTH_CD")
    public static final SqlColumn<String> authCd = tbCmUserAuth.authCd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source field: tb_cm_user_auth.USE_YN")
    public static final SqlColumn<String> useYn = tbCmUserAuth.useYn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source field: tb_cm_user_auth.REG_ID")
    public static final SqlColumn<String> regId = tbCmUserAuth.regId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source field: tb_cm_user_auth.REG_DT")
    public static final SqlColumn<Date> regDt = tbCmUserAuth.regDt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source field: tb_cm_user_auth.UPD_ID")
    public static final SqlColumn<String> updId = tbCmUserAuth.updId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source field: tb_cm_user_auth.UPD_DT")
    public static final SqlColumn<Date> updDt = tbCmUserAuth.updDt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    public static final class TbCmUserAuth extends SqlTable {
        public final SqlColumn<String> userId = column("USER_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> authCd = column("AUTH_CD", JDBCType.VARCHAR);

        public final SqlColumn<String> useYn = column("USE_YN", JDBCType.CHAR);

        public final SqlColumn<String> regId = column("REG_ID", JDBCType.VARCHAR);

        public final SqlColumn<Date> regDt = column("REG_DT", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updId = column("UPD_ID", JDBCType.VARCHAR);

        public final SqlColumn<Date> updDt = column("UPD_DT", JDBCType.TIMESTAMP);

        public TbCmUserAuth() {
            super("tb_cm_user_auth");
        }
    }
}