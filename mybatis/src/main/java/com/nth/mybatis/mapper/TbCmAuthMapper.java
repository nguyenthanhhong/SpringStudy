package com.nth.mybatis.mapper;

import static com.nth.mybatis.mapper.TbCmAuthDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nth.mybatis.model.TbCmAuth;
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
public interface TbCmAuthMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    BasicColumn[] selectList = BasicColumn.columnList(authCd, authNm, note, useYn, regId, regDt, updId, updDt);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TbCmAuth> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TbCmAuth> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbCmAuthResult")
    Optional<TbCmAuth> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbCmAuthResult", value = {
        @Result(column="AUTH_CD", property="authCd", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="AUTH_NM", property="authNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="NOTE", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="USE_YN", property="useYn", jdbcType=JdbcType.CHAR),
        @Result(column="REG_ID", property="regId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_DT", property="regDt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPD_ID", property="updId", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPD_DT", property="updDt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbCmAuth> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbCmAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0368034+07:00", comments="Source Table: tb_cm_auth")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbCmAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default int deleteByPrimaryKey(String authCd_) {
        return delete(c -> 
            c.where(authCd, isEqualTo(authCd_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default int insert(TbCmAuth record) {
        return MyBatis3Utils.insert(this::insert, record, tbCmAuth, c ->
            c.map(authCd).toProperty("authCd")
            .map(authNm).toProperty("authNm")
            .map(note).toProperty("note")
            .map(useYn).toProperty("useYn")
            .map(regId).toProperty("regId")
            .map(regDt).toProperty("regDt")
            .map(updId).toProperty("updId")
            .map(updDt).toProperty("updDt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default int insertMultiple(Collection<TbCmAuth> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbCmAuth, c ->
            c.map(authCd).toProperty("authCd")
            .map(authNm).toProperty("authNm")
            .map(note).toProperty("note")
            .map(useYn).toProperty("useYn")
            .map(regId).toProperty("regId")
            .map(regDt).toProperty("regDt")
            .map(updId).toProperty("updId")
            .map(updDt).toProperty("updDt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default int insertSelective(TbCmAuth record) {
        return MyBatis3Utils.insert(this::insert, record, tbCmAuth, c ->
            c.map(authCd).toPropertyWhenPresent("authCd", record::getAuthCd)
            .map(authNm).toPropertyWhenPresent("authNm", record::getAuthNm)
            .map(note).toPropertyWhenPresent("note", record::getNote)
            .map(useYn).toPropertyWhenPresent("useYn", record::getUseYn)
            .map(regId).toPropertyWhenPresent("regId", record::getRegId)
            .map(regDt).toPropertyWhenPresent("regDt", record::getRegDt)
            .map(updId).toPropertyWhenPresent("updId", record::getUpdId)
            .map(updDt).toPropertyWhenPresent("updDt", record::getUpdDt)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default Optional<TbCmAuth> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbCmAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default List<TbCmAuth> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbCmAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default List<TbCmAuth> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbCmAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default Optional<TbCmAuth> selectByPrimaryKey(String authCd_) {
        return selectOne(c ->
            c.where(authCd, isEqualTo(authCd_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbCmAuth, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0378007+07:00", comments="Source Table: tb_cm_auth")
    static UpdateDSL<UpdateModel> updateAllColumns(TbCmAuth record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(authCd).equalTo(record::getAuthCd)
                .set(authNm).equalTo(record::getAuthNm)
                .set(note).equalTo(record::getNote)
                .set(useYn).equalTo(record::getUseYn)
                .set(regId).equalTo(record::getRegId)
                .set(regDt).equalTo(record::getRegDt)
                .set(updId).equalTo(record::getUpdId)
                .set(updDt).equalTo(record::getUpdDt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0387969+07:00", comments="Source Table: tb_cm_auth")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbCmAuth record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(authCd).equalToWhenPresent(record::getAuthCd)
                .set(authNm).equalToWhenPresent(record::getAuthNm)
                .set(note).equalToWhenPresent(record::getNote)
                .set(useYn).equalToWhenPresent(record::getUseYn)
                .set(regId).equalToWhenPresent(record::getRegId)
                .set(regDt).equalToWhenPresent(record::getRegDt)
                .set(updId).equalToWhenPresent(record::getUpdId)
                .set(updDt).equalToWhenPresent(record::getUpdDt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0387969+07:00", comments="Source Table: tb_cm_auth")
    default int updateByPrimaryKey(TbCmAuth record) {
        return update(c ->
            c.set(authNm).equalTo(record::getAuthNm)
            .set(note).equalTo(record::getNote)
            .set(useYn).equalTo(record::getUseYn)
            .set(regId).equalTo(record::getRegId)
            .set(regDt).equalTo(record::getRegDt)
            .set(updId).equalTo(record::getUpdId)
            .set(updDt).equalTo(record::getUpdDt)
            .where(authCd, isEqualTo(record::getAuthCd))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-09-07T22:28:29.0387969+07:00", comments="Source Table: tb_cm_auth")
    default int updateByPrimaryKeySelective(TbCmAuth record) {
        return update(c ->
            c.set(authNm).equalToWhenPresent(record::getAuthNm)
            .set(note).equalToWhenPresent(record::getNote)
            .set(useYn).equalToWhenPresent(record::getUseYn)
            .set(regId).equalToWhenPresent(record::getRegId)
            .set(regDt).equalToWhenPresent(record::getRegDt)
            .set(updId).equalToWhenPresent(record::getUpdId)
            .set(updDt).equalToWhenPresent(record::getUpdDt)
            .where(authCd, isEqualTo(record::getAuthCd))
        );
    }
}