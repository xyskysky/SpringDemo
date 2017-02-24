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
	 * 可以为参数起名字. 
	 * 1. 好处: 若有多个参数, 则不用再去对应位置, 直接对应参数名, 便于维护
	 * 2. 缺点: 较为麻烦. 
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
	 * 获取单个列的值, 或做统计查询 使用 queryForObject(String sql, Class<Long> requiredType)
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
	 * 从数据库中获取一条记录, 实际得到对应的一个对象 注意不是调用 queryForObject(String sql, Class
	 * <Employee> requiredType, Object... args) 方法! 而需要调用 queryForObject(String
	 * sql, RowMapper<Employee> rowMapper, Object... args) 1. 其中的 RowMapper
	 * 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper 2. 使用 SQL 中列的别名完成列名和类的属性名的映射.
	 * 例如 last_name lastName 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM
	 * 框架
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
