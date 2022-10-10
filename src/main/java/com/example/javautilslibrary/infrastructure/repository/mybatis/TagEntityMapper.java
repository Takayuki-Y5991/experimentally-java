package com.example.javautilslibrary.infrastructure.repository.mybatis;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.TagEntityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.javautilslibrary.infrastructure.entity.mybatis.TagEntity;
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
public interface TagEntityMapper extends CommonSelectMapper, CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178713744+09:00", comments="Source Table: tag")
    BasicColumn[] selectList = BasicColumn.columnList(tagId, tagName);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178564007+09:00", comments="Source Table: tag")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="row.tagId", before=true, resultType=Long.class)
    int insert(InsertStatementProvider<TagEntity> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178594167+09:00", comments="Source Table: tag")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TagEntityResult", value = {
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR)
    })
    List<TagEntity> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178622294+09:00", comments="Source Table: tag")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TagEntityResult")
    Optional<TagEntity> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178637944+09:00", comments="Source Table: tag")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178651262+09:00", comments="Source Table: tag")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178662361+09:00", comments="Source Table: tag")
    default int deleteByPrimaryKey(Long tagId_) {
        return delete(c -> 
            c.where(tagId, isEqualTo(tagId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178675955+09:00", comments="Source Table: tag")
    default int insert(TagEntity row) {
        return MyBatis3Utils.insert(this::insert, row, tagEntity, c ->
            c.map(tagId).toProperty("tagId")
            .map(tagName).toProperty("tagName")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178691868+09:00", comments="Source Table: tag")
    default int insertSelective(TagEntity row) {
        return MyBatis3Utils.insert(this::insert, row, tagEntity, c ->
            c.map(tagId).toProperty("tagId")
            .map(tagName).toPropertyWhenPresent("tagName", row::getTagName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178723941+09:00", comments="Source Table: tag")
    default Optional<TagEntity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178737191+09:00", comments="Source Table: tag")
    default List<TagEntity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178748349+09:00", comments="Source Table: tag")
    default List<TagEntity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178759681+09:00", comments="Source Table: tag")
    default Optional<TagEntity> selectByPrimaryKey(Long tagId_) {
        return selectOne(c ->
            c.where(tagId, isEqualTo(tagId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178773833+09:00", comments="Source Table: tag")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178793729+09:00", comments="Source Table: tag")
    static UpdateDSL<UpdateModel> updateAllColumns(TagEntity row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tagId).equalTo(row::getTagId)
                .set(tagName).equalTo(row::getTagName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178815748+09:00", comments="Source Table: tag")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TagEntity row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tagId).equalToWhenPresent(row::getTagId)
                .set(tagName).equalToWhenPresent(row::getTagName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178834727+09:00", comments="Source Table: tag")
    default int updateByPrimaryKey(TagEntity row) {
        return update(c ->
            c.set(tagName).equalTo(row::getTagName)
            .where(tagId, isEqualTo(row::getTagId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178851314+09:00", comments="Source Table: tag")
    default int updateByPrimaryKeySelective(TagEntity row) {
        return update(c ->
            c.set(tagName).equalToWhenPresent(row::getTagName)
            .where(tagId, isEqualTo(row::getTagId))
        );
    }
}