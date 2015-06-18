/**
 * 
 */
package mg.fjkm.ankadifotsy.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.acegisecurity.AuthenticationException;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilterEntryPoint;

/**
 * @author rija
 *
 */
public class FjkmAnkadifotsyAuthenticationProcessingFilterEntryPoint extends AuthenticationProcessingFilterEntryPoint {

	@Override
	public void commence(ServletRequest req, ServletResponse resp, AuthenticationException ex) throws IOException, ServletException {
		setLoginFormUrl("/login.jsp");			
		super.commence(req, resp, ex);
	}

}
