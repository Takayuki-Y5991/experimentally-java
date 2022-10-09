package com.example.javautilslibrary.infrastructure.repository.mybatis;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.MemberEntityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.javautilslibrary.infrastructure.entity.mybatis.MemberEntity;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonSelectMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface MemberEntityMapper extends CommonSelectMapper, CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180726782+09:00", comments="Source Table: member")
    BasicColumn[] selectList = BasicColumn.columnList(memberId, accountName, birthday, contact, email, name, password, sex);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180527829+09:00", comments="Source Table: member")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="row.memberId", before=true, resultType=Long.class)
    int insert(InsertStatementProvider<MemberEntity> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180560988+09:00", comments="Source Table: member")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MemberEntityResult", value = {
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_name", property="accountName", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER)
    })
    List<MemberEntity> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180597117+09:00", comments="Source Table: member")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MemberEntityResult")
    Optional<MemberEntity> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180622912+09:00", comments="Source Table: member")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, memberEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180637084+09:00", comments="Source Table: member")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, memberEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180649282+09:00", comments="Source Table: member")
    default int deleteByPrimaryKey(Long memberId_) {
        return delete(c -> 
            c.where(memberId, isEqualTo(memberId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180663001+09:00", comments="Source Table: member")
    default int insert(MemberEntity row) {
        return MyBatis3Utils.insert(this::insert, row, memberEntity, c ->
            c.map(memberId).toProperty("memberId")
            .map(accountName).toProperty("accountName")
            .map(birthday).toProperty("birthday")
            .map(contact).toProperty("contact")
            .map(email).toProperty("email")
            .map(name).toProperty("name")
            .map(password).toProperty("password")
            .map(sex).toProperty("sex")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180685816+09:00", comments="Source Table: member")
    default int insertSelective(MemberEntity row) {
        return MyBatis3Utils.insert(this::insert, row, memberEntity, c ->
            c.map(memberId).toProperty("memberId")
            .map(accountName).toPropertyWhenPresent("accountName", row::getAccountName)
            .map(birthday).toPropertyWhenPresent("birthday", row::getBirthday)
            .map(contact).toPropertyWhenPresent("contact", row::getContact)
            .map(email).toPropertyWhenPresent("email", row::getEmail)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(password).toPropertyWhenPresent("password", row::getPassword)
            .map(sex).toPropertyWhenPresent("sex", row::getSex)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180738695+09:00", comments="Source Table: member")
    default Optional<MemberEntity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, memberEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180752111+09:00", comments="Source Table: member")
    default List<MemberEntity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, memberEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180763709+09:00", comments="Source Table: member")
    default List<MemberEntity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, memberEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180777855+09:00", comments="Source Table: member")
    default Optional<MemberEntity> selectByPrimaryKey(Long memberId_) {
        return selectOne(c ->
            c.where(memberId, isEqualTo(memberId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180793829+09:00", comments="Source Table: member")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, memberEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180807732+09:00", comments="Source Table: member")
    static UpdateDSL<UpdateModel> updateAllColumns(MemberEntity row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(memberId).equalTo(row::getMemberId)
                .set(accountName).equalTo(row::getAccountName)
                .set(birthday).equalTo(row::getBirthday)
                .set(contact).equalTo(row::getContact)
                .set(email).equalTo(row::getEmail)
                .set(name).equalTo(row::getName)
                .set(password).equalTo(row::getPassword)
                .set(sex).equalTo(row::getSex);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18083966+09:00", comments="Source Table: member")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MemberEntity row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(memberId).equalToWhenPresent(row::getMemberId)
                .set(accountName).equalToWhenPresent(row::getAccountName)
                .set(birthday).equalToWhenPresent(row::getBirthday)
                .set(contact).equalToWhenPresent(row::getContact)
                .set(email).equalToWhenPresent(row::getEmail)
                .set(name).equalToWhenPresent(row::getName)
                .set(password).equalToWhenPresent(row::getPassword)
                .set(sex).equalToWhenPresent(row::getSex);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18086993+09:00", comments="Source Table: member")
    default int updateByPrimaryKey(MemberEntity row) {
        return update(c ->
            c.set(accountName).equalTo(row::getAccountName)
            .set(birthday).equalTo(row::getBirthday)
            .set(contact).equalTo(row::getContact)
            .set(email).equalTo(row::getEmail)
            .set(name).equalTo(row::getName)
            .set(password).equalTo(row::getPassword)
            .set(sex).equalTo(row::getSex)
            .where(memberId, isEqualTo(row::getMemberId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180896497+09:00", comments="Source Table: member")
    default int updateByPrimaryKeySelective(MemberEntity row) {
        return update(c ->
            c.set(accountName).equalToWhenPresent(row::getAccountName)
            .set(birthday).equalToWhenPresent(row::getBirthday)
            .set(contact).equalToWhenPresent(row::getContact)
            .set(email).equalToWhenPresent(row::getEmail)
            .set(name).equalToWhenPresent(row::getName)
            .set(password).equalToWhenPresent(row::getPassword)
            .set(sex).equalToWhenPresent(row::getSex)
            .where(memberId, isEqualTo(row::getMemberId))
        );
    }
}