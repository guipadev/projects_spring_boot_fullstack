package co.yom.crud.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.yom.crud.model.projection.BookProjection;
import co.yom.crud.persistence.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import co.yom.crud.exception.ApiException;
import co.yom.crud.model.vo.BookVo;
import co.yom.crud.persistence.repository.specification.BookSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BookDaoImpl implements BookDao {
    
    //@PersistenceContext
    //private EntityManager entityManager;
    @Autowired    
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Page<BookProjection> findAllToPage(BookSpecification bookSpec, Pageable pageable) throws ApiException{
               
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        
        StringBuilder sqlQuery = new StringBuilder()
                .append("SELECT b.book_id as bookId, b.title as title, b.publication_date as publicationDate, b.online_availability as onlineAvailability, ")
                .append("GROUP_CONCAT(CONCAT(a.first_name,' ',a.last_name) SEPARATOR ', ') as concatAuthors ");
                
        StringBuilder sqlRows = new StringBuilder()
                .append("SELECT COUNT(b.book_id) as result ");
        
        StringBuilder sqlFrom = new StringBuilder()
                .append("FROM book_authors ba ")
                .append("INNER JOIN books b ON ba.book_id = b.book_id ")
                .append("INNER JOIN authors a ON ba.author_id = a.author_id ");
                        
        StringBuilder sqlGroupBy = new StringBuilder()        
                .append("GROUP BY b.book_id ");
        
        StringBuilder sqlLimit = new StringBuilder()
                .append("LIMIT :offset, :pageSize  ");
        
        StringBuilder sqlOrderBy = new StringBuilder()
                .append("ORDER BY ");
        
        for (Order o : pageable.getSort()) {
            
            if(o.getProperty().equals("bookId")) {                
                sqlOrderBy.append("b.book_id " + o.getDirection().toString()+" ");
            }
        }
        
        SqlParameter sqlParameters = getWhereParams(bookSpec);
        String queryRows = sqlRows.toString() + sqlFrom.toString() + sqlParameters.getSqlWhere() + sqlGroupBy + sqlOrderBy;
        
        queryRows = "select count(c.result) from ("+queryRows+") c";
        log.info(queryRows);
        
        Long rows = 0L;
        try {        
        	rows = template.queryForObject(queryRows, sqlParameters.getQueryParams(), Long.class);        	        	
        }catch(DataAccessException e) {
        	log.error(e.getMessage());
        	throw new ApiException("Error in query count",HttpStatus.NOT_FOUND);
        }
        
        if(rows==0) {
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }
        
        sqlParameters.getQueryParams().addValue("offset",(int) pageable.getPageNumber()*pageable.getPageSize(), Types.INTEGER);
        sqlParameters.getQueryParams().addValue("pageSize",pageable.getPageSize(),Types.INTEGER);
        
        String query = sqlQuery.toString() + sqlFrom.toString() + sqlParameters.getSqlWhere()+ sqlGroupBy+ sqlOrderBy + sqlLimit.toString();
        log.debug(query);
        List<BookProjection> books = template.query(query, sqlParameters.getQueryParams(),
                new BookRowMapper());
        
        Pageable newPageable = PageRequest.of(pageable.getPageNumber(), books.size(), pageable.getSort());        
        return new PageImpl<>(books, newPageable, rows);
    }
    
    private SqlParameter getWhereParams(BookSpecification bookSpec) {
        
        MapSqlParameterSource queryParams = new MapSqlParameterSource();
        StringBuilder sqlWhere = new StringBuilder();
        boolean flag = false;
        if(StringUtils.hasText(bookSpec.getQ())) {
            
            if(flag) {
                sqlWhere.append("OR ");
            }
            
            queryParams.addValue("q", "%"+bookSpec.getQ()+"%");
            sqlWhere.append("b.title LIKE :q ");
            flag = true;
        }
        
        if(bookSpec.getPublicationDate()!=null) {
            if(flag) {
                sqlWhere.append("AND ");
            }
            
            queryParams.addValue("publicationDate", bookSpec.getPublicationDate(),Types.DATE);
            sqlWhere.append("b.publication_date = :publicationDate ");
            
            flag = true;
        }
        
        if(flag) {
            sqlWhere.insert(0, "WHERE ");
        }
        
        
        return new SqlParameter(sqlWhere.toString(),queryParams);
    }
    
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    class SqlParameter {
        private String sqlWhere;
        private MapSqlParameterSource queryParams;        
        
    }
    
    class BookRowMapper implements RowMapper<BookProjection> {

        @Override
        public BookProjection mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            LocalDate publicationDate = rs.getDate("publicationDate") !=null ? rs.getDate("publicationDate").toLocalDate() : null;
            
            return BookVo.builder()
                    .bookId(rs.getInt("bookId"))
                    .title(rs.getString("title"))
                    .publicationDate(publicationDate)
                    .concatAuthors(rs.getString("concatAuthors"))
                    .onlineAvailability(rs.getBoolean("onlineAvailability"))
                    .build();
        }
        
        
    }
    
    class CountBookAuthorMapper implements RowMapper<Long> {

        @Override
        public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                        
            return rs.getLong("result");
        }
        
        
    }
}
