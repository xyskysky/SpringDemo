package com.jwn.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * ���Ƽ�ʹ�� JdbcDaoSupport, ���Ƽ�ֱ��ʹ�� JdbcTempate ��Ϊ Dao ��ĳ�Ա����
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
