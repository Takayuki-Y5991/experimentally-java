package com.example.javautilslibrary.infrastructure.repository.mybatis;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.BookTagEntityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.javautilslibrary.infrastructure.entity.mybatis.BookTagEntity;
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
public interface BookTagEntityMapper extends CommonSelectMapper, CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.175293902+09:00", comments="Source Table: book_tag")
    BasicColumn[] selectList = BasicColumn.columnList(tagId, bookId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.170897848+09:00", comments="Source Table: book_tag")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT uuid()", keyProperty="row.bookId", before=true, resultType=String.class)
    int insert(InsertStatementProvider<BookTagEntity> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.172788362+09:00", comments="Source Table: book_tag")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookTagEntityResult", value = {
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<BookTagEntity> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.173337853+09:00", comments="Source Table: book_tag")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookTagEntityResult")
    Optional<BookTagEntity> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.173539516+09:00", comments="Source Table: book_tag")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, bookTagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.173726176+09:00", comments="Source Table: book_tag")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, bookTagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.173912938+09:00", comments="Source Table: book_tag")
    default int deleteByPrimaryKey(Long tagId_, String bookId_) {
        return delete(c -> 
            c.where(tagId, isEqualTo(tagId_))
            .and(bookId, isEqualTo(bookId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.174114309+09:00", comments="Source Table: book_tag")
    default int insert(BookTagEntity row) {
        return MyBatis3Utils.insert(this::insert, row, bookTagEntity, c ->
            c.map(tagId).toProperty("tagId")
            .map(bookId).toProperty("bookId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.174800046+09:00", comments="Source Table: book_tag")
    default int insertSelective(BookTagEntity row) {
        return MyBatis3Utils.insert(this::insert, row, bookTagEntity, c ->
            c.map(tagId).toPropertyWhenPresent("tagId", row::getTagId)
            .map(bookId).toProperty("bookId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.175726697+09:00", comments="Source Table: book_tag")
    default Optional<BookTagEntity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, bookTagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.1758912+09:00", comments="Source Table: book_tag")
    default List<BookTagEntity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, bookTagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.176078753+09:00", comments="Source Table: book_tag")
    default List<BookTagEntity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, bookTagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.176386278+09:00", comments="Source Table: book_tag")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, bookTagEntity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.176562554+09:00", comments="Source Table: book_tag")
    static UpdateDSL<UpdateModel> updateAllColumns(BookTagEntity row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tagId).equalTo(row::getTagId)
                .set(bookId).equalTo(row::getBookId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.176755092+09:00", comments="Source Table: book_tag")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(BookTagEntity row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tagId).equalToWhenPresent(row::getTagId)
                .set(bookId).equalToWhenPresent(row::getBookId);
    }
}