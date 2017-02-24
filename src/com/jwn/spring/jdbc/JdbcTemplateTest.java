package com.jwn.spring.jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JdbcTemplateTest
{

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	
	private EmployeeDao employeeDao;
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		
		employeeDao=ctx.getBean(EmployeeDao.class);
		namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	/**
	 * ����Ϊ����������. 
	 * 1. �ô�: ���ж������, ������ȥ��Ӧλ��, ֱ�Ӷ�Ӧ������, ����ά��
	 * 2. ȱ��: ��Ϊ�鷳. 
	 */
	@Test
	public void testNamedParameterJdbcTemplate()
	{
		String sql="insert into employees(last_name,email,dept_id)values(:ln,:email,:deptid);";
	
	}
	@Test
	public void testEmployeeDao()
	{
		System.out.println(employeeDao.get(1));
	}

	/**
	 * ��ȡ�����е�ֵ, ����ͳ�Ʋ�ѯ ʹ�� queryForObject(String sql, Class<Long> requiredType)
	 */
	@Test
	public void testQueryForObject2()
	{
		String sql="select count(*) from employees";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println("result======count:"+count);
		System.out.println("==========================================================");
		String sql2="select last_name from employees where id=?";
		String lastName = jdbcTemplate.queryForObject(sql2, String.class, 1);
		System.out.println(lastName);
	}
	
	@Test
	public void testQueryForList()
	{
		String sql = "select id,last_name lastname,email,dept_id deptid from employees where id>?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(
				Employee.class);
		List<Employee> query = jdbcTemplate.query(sql, rowMapper, 1);
		System.out.println(query);
	}

	@Test
	public void testUpdate()
	{
		String sql = "update employees set last_name=? where id=?";
		int update = jdbcTemplate.update(sql, "jwn_xieyong", 3);
		System.out.println("result=====" + update);
	}
	/**
	 * �����ݿ��л�ȡһ����¼, ʵ�ʵõ���Ӧ��һ������ ע�ⲻ�ǵ��� queryForObject(String sql, Class
	 * <Employee> requiredType, Object... args) ����! ����Ҫ���� queryForObject(String
	 * sql, RowMapper<Employee> rowMapper, Object... args) 1. ���е� RowMapper
	 * ָ�����ȥӳ����������, ���õ�ʵ����Ϊ BeanPropertyRowMapper 2. ʹ�� SQL ���еı�����������������������ӳ��.
	 * ���� last_name lastName 3. ��֧�ּ�������. JdbcTemplate ������һ�� JDBC ��С����, ������ ORM
	 * ���
	 */
	@Test
	public void testQueryForObject()
	{
		String sql = "select id,last_name lastname,email,dept_id deptid from employees where id=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(
				Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}
	@Test
	public void testBatchUpdate()
	{
		String sql = "insert into employees(last_name,email,dept_id)values(?,?,?);";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"jack", "jack12232@163.com", 1});
		batchArgs.add(new Object[]{"Marc", "macKjne@163.com", 1});

		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	@Test
	public void testDataSource()
	{
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource);
	}

}
