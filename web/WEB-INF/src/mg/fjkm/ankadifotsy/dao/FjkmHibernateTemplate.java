/**
 * 
 */
package mg.fjkm.ankadifotsy.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Utilitaire hibernate
 * @author Rija
 *
 */
public class FjkmHibernateTemplate extends HibernateTemplate{
	private static Logger sfLogger = Logger.getLogger(FjkmHibernateTemplate.class);

	public FjkmHibernateTemplate() {
		super();
	}

	public FjkmHibernateTemplate(SessionFactory arg0, boolean arg1) {
		super(arg0, arg1);
	}

	public FjkmHibernateTemplate(SessionFactory arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see #findByPage(String, Integer, Integer)
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#findByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedParamAndPage(final String queryString, final String[] paramNames, final Object[] values
			, final Integer pageNo, final Integer maxResults) throws DataAccessException {
		final Integer firstResult = pageNo.intValue() * maxResults.intValue();

		loggerDebugHQLQueryAndParamNamesAndParamValues(queryString, paramNames, values, firstResult, maxResults);

		List result = (List) execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(queryString.toString());
				prepareQuery(query) ;
				applySetNamedParametersToQuery(query, paramNames, values );
				applySetFirstResultAndMaxResultsToQuery(query, firstResult, maxResults) ;		
				return query.list();
			}
		}, true) ;
		
		return result ;
	}

	/**
	 * @see #findByPage(String, Integer, Integer)
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#find(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public List findByPage(final String queryString, final Object[] values
			, final Integer pageNo, final Integer maxResults) throws DataAccessException {
		final Integer firstResult = pageNo.intValue() * maxResults.intValue();
		
		loggerDebugHQLQueryAndValues(queryString, values, firstResult, maxResults);
		List result = (List) execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(queryString.toString());
				prepareQuery(query) ;
				applySetParametersValuesToQuery(query, values );
				applySetFirstResultAndMaxResultsToQuery(query, firstResult, maxResults) ;		
				return query.list();
			}
		}, true) ;
		
		return result ;
	}

	private void applySetNamedParametersToQuery(Query query, String[] paramNames, Object[] values) {
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				applyNamedParameterToQuery(query, paramNames[i], values[i]);
			}
		}
	}

	private void applySetFirstResultAndMaxResultsToQuery(Query query, Integer firstResult, Integer maxResults ) {
		if (firstResult != null && maxResults != null){
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults);
		}		
	}

	private void loggerDebugHQLQueryAndParamNamesAndParamValues(String queryString, String[] paramNames, Object[] values, Integer firstResult, Integer maxResults) {
		StringBuffer sb = new StringBuffer() ;
		append(sb,
				"\nHQL: ", queryString, 
				"\nParamNames: ", Arrays.toString(paramNames), 
				"\nParamValues: ",  Arrays.toString(values) ) ;
		applyAppendFirstResultMaxResultToStringBuffer(sb, firstResult, maxResults ) ;
				
		sfLogger.debug(sb.toString()) ;
	}

	/** @return sb avec l'ajout de  <obj1.toString()><obj2.toString()>..... */
	public static StringBuffer append(StringBuffer sb, Object ...objects) {
		for (Object object : objects) {
			sb.append(String.valueOf(object)) ;
		}
		return sb ;
	}

	private StringBuffer applyAppendFirstResultMaxResultToStringBuffer(StringBuffer sb, Integer firstResult, Integer maxResults) {
		append(sb, 
			firstResult != null || maxResults != null ? "\n" : "",
			firstResult != null ? "First result: " + firstResult  + "   ": "",
			maxResults != null ? "Max results: " + maxResults : "") ;
		return sb ;
	}

	private void loggerDebugHQLQueryAndValues(final String queryString, final Object[] values, Integer firstResult, Integer maxResults) {
		StringBuffer sb = new StringBuffer() ;
		append(sb,
				"\nHQL: ", queryString, 
				"\nValues: ", Arrays.toString(values) ) ;
		applyAppendFirstResultMaxResultToStringBuffer(sb, firstResult, maxResults ) ;
				
		sfLogger.debug(sb.toString()) ;
	} 

	private void applySetParametersValuesToQuery(Query query, Object[] values) {
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
	}

}
