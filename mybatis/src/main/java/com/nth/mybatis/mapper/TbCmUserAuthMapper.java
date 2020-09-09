package com.nth.mybatis.mapper;

import static com.nth.mybatis.mapper.TbCmUserAuthDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nth.mybatis.model.TbCmUserAuth;
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
public interface TbCmUserAuthMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    BasicColumn[] selectList = BasicColumn.columnList(userId, authCd, useYn, regId, regDt, updId, updDt);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TbCmUserAuth> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TbCmUserAuth> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbCmUserAuthResult")
    Optional<TbCmUserAuth> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbCmUserAuthResult", value = {
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="AUTH_CD", property="authCd", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USE_YN", property="useYn", jdbcType=JdbcType.CHAR),
        @Result(column="REG_ID", property="regId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_DT", property="regDt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPD_ID", property="updId", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPD_DT", property="updDt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbCmUserAuth> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbCmUserAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbCmUserAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    default int deleteByPrimaryKey(String userId_, String authCd_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
            .and(authCd, isEqualTo(authCd_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0407923+07:00", comments="Source Table: tb_cm_user_auth")
    default int insert(TbCmUserAuth record) {
        return MyBatis3Utils.insert(this::insert, record, tbCmUserAuth, c ->
            c.map(userId).toProperty("userId")
            .map(authCd).toProperty("authCd")
            .map(useYn).toProperty("useYn")
            .map(regId).toProperty("regId")
            .map(regDt).toProperty("regDt")
            .map(updId).toProperty("updId")
            .map(updDt).toProperty("updDt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default int insertMultiple(Collection<TbCmUserAuth> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbCmUserAuth, c ->
            c.map(userId).toProperty("userId")
            .map(authCd).toProperty("authCd")
            .map(useYn).toProperty("useYn")
            .map(regId).toProperty("regId")
            .map(regDt).toProperty("regDt")
            .map(updId).toProperty("updId")
            .map(updDt).toProperty("updDt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default int insertSelective(TbCmUserAuth record) {
        return MyBatis3Utils.insert(this::insert, record, tbCmUserAuth, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(authCd).toPropertyWhenPresent("authCd", record::getAuthCd)
            .map(useYn).toPropertyWhenPresent("useYn", record::getUseYn)
            .map(regId).toPropertyWhenPresent("regId", record::getRegId)
            .map(regDt).toPropertyWhenPresent("regDt", record::getRegDt)
            .map(updId).toPropertyWhenPresent("updId", record::getUpdId)
            .map(updDt).toPropertyWhenPresent("updDt", record::getUpdDt)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default Optional<TbCmUserAuth> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbCmUserAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default List<TbCmUserAuth> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbCmUserAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default List<TbCmUserAuth> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbCmUserAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default Optional<TbCmUserAuth> selectByPrimaryKey(String userId_, String authCd_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
            .and(authCd, isEqualTo(authCd_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbCmUserAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    static UpdateDSL<UpdateModel> updateAllColumns(TbCmUserAuth record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(authCd).equalTo(record::getAuthCd)
                .set(useYn).equalTo(record::getUseYn)
                .set(regId).equalTo(record::getRegId)
                .set(regDt).equalTo(record::getRegDt)
                .set(updId).equalTo(record::getUpdId)
                .set(updDt).equalTo(record::getUpdDt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbCmUserAuth record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(authCd).equalToWhenPresent(record::getAuthCd)
                .set(useYn).equalToWhenPresent(record::getUseYn)
                .set(regId).equalToWhenPresent(record::getRegId)
                .set(regDt).equalToWhenPresent(record::getRegDt)
                .set(updId).equalToWhenPresent(record::getUpdId)
                .set(updDt).equalToWhenPresent(record::getUpdDt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default int updateByPrimaryKey(TbCmUserAuth record) {
        return update(c ->
            c.set(useYn).equalTo(record::getUseYn)
            .set(regId).equalTo(record::getRegId)
            .set(regDt).equalTo(record::getRegDt)
            .set(updId).equalTo(record::getUpdId)
            .set(updDt).equalTo(record::getUpdDt)
            .where(userId, isEqualTo(record::getUserId))
            .and(authCd, isEqualTo(record::getAuthCd))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0417885+07:00", comments="Source Table: tb_cm_user_auth")
    default int updateByPrimaryKeySelective(TbCmUserAuth record) {
        return update(c ->
            c.set(useYn).equalToWhenPresent(record::getUseYn)
            .set(regId).equalToWhenPresent(record::getRegId)
            .set(regDt).equalToWhenPresent(record::getRegDt)
            .set(updId).equalToWhenPresent(record::getUpdId)
            .set(updDt).equalToWhenPresent(record::getUpdDt)
            .where(userId, isEqualTo(record::getUserId))
            .and(authCd, isEqualTo(record::getAuthCd))
        );
    }
}