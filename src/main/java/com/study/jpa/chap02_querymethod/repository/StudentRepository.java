package com.study.jpa.chap02_querymethod.repository;

import com.study.jpa.chap02_querymethod.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, String> {

  List<Student> findByName(String name);
  List<Student> findByCityAndMajor(String city, String major);

  List<Student> findByMajorContaining(String major);

  // 네이티브 쿼리 사용
  @Query(value = "SELECT * FROM tbl_student WHERE stu_name = :nm", nativeQuery = true)
  Student findNameWithSQL(@Param("nm") String name);

//  @Query(value = "SELECT * FROM tbl_surdent WHERE city = ?1", nativeQuery = true)
  @Query("SELECT s FROM Student s WHERE s.city=?1")
 Student getByCityWithJPQL(String city);


  @Query("SELECT st FROM Student st WHERE st.name LIKE %:nm%")
  Student searchMyNamesWithJPQL(@Param("nm") String name);

  // JPQL로 수정 삭제 쿼리 쓰기
  @Modifying // 조회가 아닐 경우 무조건 붙여야함
  @Query("DELETE FROM Student s WHERE s.name =?1")
  void deleteByNameWithJPQL(String name);

}
