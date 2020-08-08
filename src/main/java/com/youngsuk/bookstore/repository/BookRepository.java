package com.youngsuk.bookstore.repository;

import com.youngsuk.bookstore.dto.BookDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.youngsuk.bookstore.common.utils.constants.MyBatisNameSpaceConstants.BookRepositoryNameSpace;

@Repository
public class BookRepository {

  @Autowired
  private SqlSession sqlSession;

  public List<BookDTO> selectBookByCategory(BookDTO bookDTO) {
    return sqlSession.selectList(BookRepositoryNameSpace
        + "selectBookByCategory", bookDTO);
  }

}
