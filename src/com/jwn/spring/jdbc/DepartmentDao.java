package com.jwn.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 不推荐使用 JdbcDaoSupport, 而推荐直接使用 JdbcTempate 作为 Dao 类的成员变量
 */
@Repository
public class DepartmentDao extends JdbcDaoSupport
{
	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}
	public Department get(Integer id)
	{
		String sql="select id,dept_name name from department where id=?";
		RowMapper<Department> rowMapper=new BeanPropertyRowMapper<>(Department.class);
		Department department = getJdbcTemplate().queryForObject(sql, rowMapper, 1);
		return department;
	}
}
