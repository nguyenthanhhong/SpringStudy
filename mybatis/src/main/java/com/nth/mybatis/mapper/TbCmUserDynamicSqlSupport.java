package com.nth.mybatis.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbCmUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.020845+07:00", comments="Source Table: tb_cm_user")
    public static final TbCmUser tbCmUser = new TbCmUser();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.020845+07:00", comments="Source field: tb_cm_user.USER_ID")
    public static final SqlColumn<String> userId = tbCmUser.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.020845+07:00", comments="Source field: tb_cm_user.USER_NM")
    public static final SqlColumn<String> userNm = tbCmUser.userNm;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.USER_PW")
    public static final SqlColumn<String> userPw = tbCmUser.userPw;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.EMAIL")
    public static final SqlColumn<String> email = tbCmUser.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.PHONE")
    public static final SqlColumn<String> phone = tbCmUser.phone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.ADDRESS")
    public static final SqlColumn<String> address = tbCmUser.address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.LANG_CD")
    public static final SqlColumn<String> langCd = tbCmUser.langCd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.USE_YN")
    public static final SqlColumn<String> useYn = tbCmUser.useYn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.REG_ID")
    public static final SqlColumn<String> regId = tbCmUser.regId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.REG_DT")
    public static final SqlColumn<Date> regDt = tbCmUser.regDt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.UPD_ID")
    public static final SqlColumn<String> updId = tbCmUser.updId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0218421+07:00", comments="Source field: tb_cm_user.UPD_DT")
    public static final SqlColumn<Date> updDt = tbCmUser.updDt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.020845+07:00", comments="Source Table: tb_cm_user")
    public static final class TbCmUser extends SqlTable {
        public final SqlColumn<String> userId = column("USER_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> userNm = column("USER_NM", JDBCType.VARCHAR);

        public final SqlColumn<String> userPw = column("USER_PW", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("EMAIL", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("PHONE", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("ADDRESS", JDBCType.VARCHAR);

        public final SqlColumn<String> langCd = column("LANG_CD", JDBCType.VARCHAR);

        public final SqlColumn<String> useYn = column("USE_YN", JDBCType.CHAR);

        public final SqlColumn<String> regId = column("REG_ID", JDBCType.VARCHAR);

        public final SqlColumn<Date> regDt = column("REG_DT", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updId = column("UPD_ID", JDBCType.VARCHAR);

        public final SqlColumn<Date> updDt = column("UPD_DT", JDBCType.TIMESTAMP);

        public TbCmUser() {
            super("tb_cm_user");
        }
    }
}