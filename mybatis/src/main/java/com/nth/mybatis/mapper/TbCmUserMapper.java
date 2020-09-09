package com.nth.mybatis.mapper;

import static com.nth.mybatis.mapper.TbCmUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nth.mybatis.model.TbCmUser;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TbCmUserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0298232+07:00", comments="Source Table: tb_cm_user")
    BasicColumn[] selectList = BasicColumn.columnList(userId, userNm, userPw, email, phone, address, langCd, useYn, regId, regDt, updId, updDt);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0228399+07:00", comments="Source Table: tb_cm_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0238367+07:00", comments="Source Table: tb_cm_user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0238367+07:00", comments="Source Table: tb_cm_user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TbCmUser> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0248344+07:00", comments="Source Table: tb_cm_user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TbCmUser> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0248344+07:00", comments="Source Table: tb_cm_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbCmUserResult")
    Optional<TbCmUser> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0248344+07:00", comments="Source Table: tb_cm_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbCmUserResult", value = {
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USER_NM", property="userNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_PW", property="userPw", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="LANG_CD", property="langCd", jdbcType=JdbcType.VARCHAR),
        @Result(column="USE_YN", property="useYn", jdbcType=JdbcType.CHAR),
        @Result(column="REG_ID", property="regId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_DT", property="regDt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPD_ID", property="updId", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPD_DT", property="updDt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbCmUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0258317+07:00", comments="Source Table: tb_cm_user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0268312+07:00", comments="Source Table: tb_cm_user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbCmUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0268312+07:00", comments="Source Table: tb_cm_user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbCmUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0268312+07:00", comments="Source Table: tb_cm_user")
    default int deleteByPrimaryKey(String userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0278291+07:00", comments="Source Table: tb_cm_user")
    default int insert(TbCmUser record) {
        return MyBatis3Utils.insert(this::insert, record, tbCmUser, c ->
            c.map(userId).toProperty("userId")
            .map(userNm).toProperty("userNm")
            .map(userPw).toProperty("userPw")
            .map(email).toProperty("email")
            .map(phone).toProperty("phone")
            .map(address).toProperty("address")
            .map(langCd).toProperty("langCd")
            .map(useYn).toProperty("useYn")
            .map(regId).toProperty("regId")
            .map(regDt).toProperty("regDt")
            .map(updId).toProperty("updId")
            .map(updDt).toProperty("updDt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0288265+07:00", comments="Source Table: tb_cm_user")
    default int insertMultiple(Collection<TbCmUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbCmUser, c ->
            c.map(userId).toProperty("userId")
            .map(userNm).toProperty("userNm")
            .map(userPw).toProperty("userPw")
            .map(email).toProperty("email")
            .map(phone).toProperty("phone")
            .map(address).toProperty("address")
            .map(langCd).toProperty("langCd")
            .map(useYn).toProperty("useYn")
            .map(regId).toProperty("regId")
            .map(regDt).toProperty("regDt")
            .map(updId).toProperty("updId")
            .map(updDt).toProperty("updDt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0288265+07:00", comments="Source Table: tb_cm_user")
    default int insertSelective(TbCmUser record) {
        return MyBatis3Utils.insert(this::insert, record, tbCmUser, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userNm).toPropertyWhenPresent("userNm", record::getUserNm)
            .map(userPw).toPropertyWhenPresent("userPw", record::getUserPw)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(langCd).toPropertyWhenPresent("langCd", record::getLangCd)
            .map(useYn).toPropertyWhenPresent("useYn", record::getUseYn)
            .map(regId).toPropertyWhenPresent("regId", record::getRegId)
            .map(regDt).toPropertyWhenPresent("regDt", record::getRegDt)
            .map(updId).toPropertyWhenPresent("updId", record::getUpdId)
            .map(updDt).toPropertyWhenPresent("updDt", record::getUpdDt)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0308206+07:00", comments="Source Table: tb_cm_user")
    default Optional<TbCmUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbCmUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0308206+07:00", comments="Source Table: tb_cm_user")
    default List<TbCmUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbCmUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0308206+07:00", comments="Source Table: tb_cm_user")
    default List<TbCmUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbCmUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0318176+07:00", comments="Source Table: tb_cm_user")
    default Optional<TbCmUser> selectByPrimaryKey(String userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0318176+07:00", comments="Source Table: tb_cm_user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbCmUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0318176+07:00", comments="Source Table: tb_cm_user")
    static UpdateDSL<UpdateModel> updateAllColumns(TbCmUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(userNm).equalTo(record::getUserNm)
                .set(userPw).equalTo(record::getUserPw)
                .set(email).equalTo(record::getEmail)
                .set(phone).equalTo(record::getPhone)
                .set(address).equalTo(record::getAddress)
                .set(langCd).equalTo(record::getLangCd)
                .set(useYn).equalTo(record::getUseYn)
                .set(regId).equalTo(record::getRegId)
                .set(regDt).equalTo(record::getRegDt)
                .set(updId).equalTo(record::getUpdId)
                .set(updDt).equalTo(record::getUpdDt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0328149+07:00", comments="Source Table: tb_cm_user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbCmUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(userNm).equalToWhenPresent(record::getUserNm)
                .set(userPw).equalToWhenPresent(record::getUserPw)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(langCd).equalToWhenPresent(record::getLangCd)
                .set(useYn).equalToWhenPresent(record::getUseYn)
                .set(regId).equalToWhenPresent(record::getRegId)
                .set(regDt).equalToWhenPresent(record::getRegDt)
                .set(updId).equalToWhenPresent(record::getUpdId)
                .set(updDt).equalToWhenPresent(record::getUpdDt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0338127+07:00", comments="Source Table: tb_cm_user")
    default int updateByPrimaryKey(TbCmUser record) {
        return update(c ->
            c.set(userNm).equalTo(record::getUserNm)
            .set(userPw).equalTo(record::getUserPw)
            .set(email).equalTo(record::getEmail)
            .set(phone).equalTo(record::getPhone)
            .set(address).equalTo(record::getAddress)
            .set(langCd).equalTo(record::getLangCd)
            .set(useYn).equalTo(record::getUseYn)
            .set(regId).equalTo(record::getRegId)
            .set(regDt).equalTo(record::getRegDt)
            .set(updId).equalTo(record::getUpdId)
            .set(updDt).equalTo(record::getUpdDt)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0338127+07:00", comments="Source Table: tb_cm_user")
    default int updateByPrimaryKeySelective(TbCmUser record) {
        return update(c ->
            c.set(userNm).equalToWhenPresent(record::getUserNm)
            .set(userPw).equalToWhenPresent(record::getUserPw)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(langCd).equalToWhenPresent(record::getLangCd)
            .set(useYn).equalToWhenPresent(record::getUseYn)
            .set(regId).equalToWhenPresent(record::getRegId)
            .set(regDt).equalToWhenPresent(record::getRegDt)
            .set(updId).equalToWhenPresent(record::getUpdId)
            .set(updDt).equalToWhenPresent(record::getUpdDt)
            .where(userId, isEqualTo(record::getUserId))
        );
    }
}