package cc.ywxm.utils;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import cc.ywxm.action.base.Pageable;

public class RSMapper
{
	protected RSMapper()
	{
	}

	/**
	 * 将查询结果集反射到对象中返回。
	 * 
	 * @param <T>
	 * @param jdbcTemplate
	 * @param sql
	 * @param clazz
	 * @param args
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T query(JdbcTemplate jdbcTemplate, String sql,
			Class<T> clazz, Object... args) throws DataAccessException
	{
		return (T) jdbcTemplate.query(sql, args, extractorForObject(clazz));
	}

	/**
	 * 将查询结果集反射到对象列表中返回
	 * 
	 * @param <E>
	 * @param jdbcTemplate
	 * @param sql
	 * @param clazz
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> queryList(JdbcTemplate jdbcTemplate, String sql,
			Class<E> clazz, Object... args)
	{
		// System.out.println(sql);
		return (List<E>) jdbcTemplate.query(sql, args, extractorForList(clazz));
	}

	/**
	 * 将分页查询结果集反射到对象列表中返回。
	 * 
	 * @param <E>
	 * @param jdbcTemplate
	 * @param sql
	 * @param page
	 * @param clazz
	 * @param args
	 * @return
	 * @throws DataAccessException
	 */
	public static <E> List<E> queryPage(JdbcTemplate jdbcTemplate, String sql,
			Pageable page, Class<E> clazz, Object... args)
			throws DataAccessException
	{
		if (page != null)
		{
			int totalCount = jdbcTemplate.queryForInt(getCountSql(sql), args);
			page.setTotalCount(totalCount);
			if (totalCount < 1)
			{
				return Collections.emptyList();
			} else if (totalCount <= page.getPageSize())
			{
				return queryList(jdbcTemplate, sql, clazz, args);
			} else
			{
				return queryList(jdbcTemplate, getPageSql(sql, page), clazz,
						args);
			}
		}
		return queryList(jdbcTemplate, sql, clazz, args);
	}

	/**
	 * 返回查询总记录的SQL
	 * 
	 * @param sql
	 * @return
	 */
	private static String getCountSql(String sql)
	{
		StringBuffer sf = new StringBuffer();
		sf.append("SELECT count(1) FROM (").append(sql).append(") t");
		return sf.toString();
	}

	/**
	 * 返回分页查询的SQL
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private static String getPageSql(String sql, Pageable page)
	{
		StringBuffer sf = new StringBuffer();
		sf.append("SELECT a.* FROM (").append(sql).append(") a  LIMIT ")
				.append(page.getStart()).append(",").append(page.getPageSize());
		// System.out.println(sf.toString());
		return sf.toString();
	}

	/**
	 * 将结果集反射到对象中返回。
	 * 
	 * @param <T>
	 * @param rs
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	public static <T> T query(ResultSet rs, Class<T> clazz) throws SQLException
	{
		return resultSetMapForObject(rs, clazz);
	}

	/**
	 * 将结果集反射到对象列表中返回。
	 * 
	 * @param <E>
	 * @param rs
	 * @param clazz
	 * @return @throws SQLException
	 */
	public static <E> List<E> queryList(ResultSet rs, Class<E> clazz)
			throws SQLException
	{
		return resultSetMapForList(rs, clazz);
	}

	/**
	 * ResultSetExtractor for object
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	// @SuppressWarnings("rawtypes")
	private static <T> ResultSetExtractor extractorForObject(
			final Class<T> clazz)
	{
		return new ResultSetExtractor()
		{
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException
			{
				// System.out.println(rs.toString());
				return resultSetMapForObject(rs, clazz);
			}
		};
	}

	/**
	 * ResultSet to Object
	 * 
	 * @param <T>
	 * @param rs
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	private static <T> T resultSetMapForObject(ResultSet rs, Class<T> clazz)
			throws SQLException
	{
		return resultSetMapForObject(rs, clazz, filtrateSetMethodMap(clazz, rs));
	}

	/**
	 * ResultSet to Object
	 * 
	 * @param <T>
	 * @param rs
	 * @param clazz
	 * @param setMethodMap
	 * @return
	 * @throws SQLException
	 */
	protected static <T> T resultSetMapForObject(ResultSet rs, Class<T> clazz,
			Map<String, Method> setMethodMap) throws SQLException
	{
		if (rs.next())
		{
			T t = classNewInstance(clazz);
			return resultSetMap(rs, t, setMethodMap);
		}
		return null;
	}

	/**
	 * ResultSetExtractor for list
	 * 
	 * @param <E>
	 * @param clazz
	 * @return
	 */
	// @SuppressWarnings("rawtypes")
	private static <E> ResultSetExtractor extractorForList(final Class<E> clazz)
	{
		return new ResultSetExtractor()
		{
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException
			{
				return resultSetMapForList(rs, clazz);
			}
		};
	}

	/**
	 * ResultSet to Object list
	 * 
	 * @param <E>
	 * @param rs
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	private static <E> List<E> resultSetMapForList(ResultSet rs, Class<E> clazz)
			throws SQLException
	{
		return resultSetMapForList(rs, clazz, filtrateSetMethodMap(clazz, rs));
	}

	/**
	 * ResultSet to Object list
	 * 
	 * @param <E>
	 * @param rs
	 * @param clazz
	 * @param setMethodMap
	 * @return
	 * @throws SQLException
	 */
	protected static <E> List<E> resultSetMapForList(ResultSet rs,
			Class<E> clazz, Map<String, Method> setMethodMap)
			throws SQLException
	{
		List<E> es = new ArrayList<E>();
		while (rs.next())
		{
			E e = classNewInstance(clazz);
			es.add(resultSetMap(rs, e, setMethodMap));
		}
		return es;
	}

	/**
	 * Class.newInstance()
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	private static <T> T classNewInstance(Class<T> clazz)
	{
		try
		{
			return clazz.newInstance();
		} catch (Exception e)
		{
			throw new IllegalStateException(clazz.getName()
					+ "cant't be instance!" + e);
		}
	}

	/**
	 * return query column's names equalsIgnoreCase field's names
	 * 
	 * @param clazz
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	protected static Map<String, Method> filtrateSetMethodMap(Class<?> clazz,
			ResultSet rs) throws SQLException
	{
		return filtrateSetMethodMap(clazz, queryColumn(rs));
	}

	/**
	 * return query column's names equalsIgnoreCase field's names
	 * 
	 * @param clazz
	 * @param queryColumnNames
	 * @return
	 */
	private static Map<String, Method> filtrateSetMethodMap(Class<?> clazz,
			List<String> queryColumnNames)
	{
		Map<String, Method> setMap = new HashMap<String, Method>(
				queryColumnNames.size());
		Map<String, Method> setMethodMap = getSetMethodMap(clazz);
		Set<String> names = setMethodMap.keySet();
		for (String name : names)
		{
			if (queryColumnNames.contains(name.toLowerCase()))
			{
				setMap.put(name, setMethodMap.get(name));
			}
		}
		return setMap;
	}

	/**
	 * return query column's names
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static List<String> queryColumn(ResultSet rs) throws SQLException
	{
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		List<String> queryColumnNames = new ArrayList<String>(columnCount);
		for (int i = 1; i <= columnCount; i++)
		{
			queryColumnNames.add(rsmd.getColumnName(i).toLowerCase());
		}
		return queryColumnNames;
	}

	/**
	 * return Class's setter
	 * 
	 * @param clazz
	 * @return
	 */
	private static Map<String, Method> getSetMethodMap(Class<?> clazz)
	{
		return ClassMethodUtil.getSetMethodMap(clazz);
	}

	/**
	 * single ResultSet to one Object
	 * 
	 * @param <T>
	 * @param rs
	 * @param t
	 * @param setMethodMap
	 * @return
	 */
	private static <T> T resultSetMap(ResultSet rs, T t,
			Map<String, Method> setMethodMap)
	{
		Set<String> names = setMethodMap.keySet();
		for (String name : names)
		{
			Method setMethod = setMethodMap.get(name);
			invoke(t, setMethod, rs, name);
		}
		return t;
	}

	/**
	 * invoke
	 * 
	 * @param object
	 * @param setMethod
	 * @param rs
	 * @param name
	 */
	private static void invoke(Object object, Method setMethod, ResultSet rs,
			String name)
	{
		try
		{
			Object parameter = null;
			Class<?> type = setMethod.getParameterTypes()[0];
			if (type.equals(String.class))
			{
				parameter = rs.getString(name);
			} else if (type.equals(int.class) || type.equals(Integer.class))
			{
				parameter = rs.getInt(name);
			} else if (type.equals(long.class) || type.equals(Long.class))
			{
				parameter = rs.getLong(name);
			} else if (type.equals(byte.class) || type.equals(Byte.class))
			{
				parameter = rs.getByte(name);
			} else if (type.equals(short.class) || type.equals(Short.class))
			{
				parameter = rs.getShort(name);
			} else if (type.equals(float.class) || type.equals(Float.class))
			{
				parameter = rs.getFloat(name);
			} else if (type.equals(double.class) || type.equals(Double.class))
			{
				parameter = rs.getDouble(name);
			} else if (type.equals(Date.class) || type.equals(Timestamp.class))
			{
				parameter = rs.getTimestamp(name);
			} else
			{ /* doNothing */
			}
			if (parameter != null)
			{
				setMethod.invoke(object, parameter);
			}
		} catch (Exception e)
		{
			// log.error(e);
		}
	}

	// private static Logger log = Logger.getLogger(RSMapper.class);
}