import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.twilio.jwt.client.ClientCapability;
import com.twilio.jwt.client.IncomingClientScope;
import com.twilio.jwt.client.Scope;

public class TwilioServlet extends HttpServlet {

  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<Scope> scopes = Lists.newArrayList(new IncomingClientScope("jenny"));

    ClientCapability capability = new ClientCapability.Builder(ACCOUNT_SID, AUTH_TOKEN)
      .scopes(scopes)
      .build();

    String token = capability.toJwt();

    response.setContentType("application/jwt");
    response.getWriter().print(token);
  }
}
