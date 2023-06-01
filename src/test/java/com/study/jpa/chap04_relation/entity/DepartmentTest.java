package com.study.jpa.chap04_relation.entity;

import com.study.jpa.chap04_relation.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DepartmentTest {

  @Autowired
  DepartmentRepository departmentRepository;
}