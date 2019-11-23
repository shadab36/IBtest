package APIClient;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import APIClient.endpoints.LoginEndpoint;
import APIClient.endpoints.ResourcesEndpoint;
import APIClient.messages.login.LoginResponse;

public class IB_V2_API {

   private JerseyClient _client;
   private LoginResponse _token;

   public LoginEndpoint Login;
   public ResourcesEndpoint Resources;

   public IB_V2_API(String username, String password, String sitebaseurl, String sitename) {

      JerseyClientBuilder jerseyClientBuilder = new JerseyClientBuilder();
      // .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
      _client = jerseyClientBuilder.build();
      
      Login = new LoginEndpoint(_client, sitebaseurl);
      _token = Login.post(username, password, sitename);

      Resources = new ResourcesEndpoint(_client, sitebaseurl, _token);
   }

   public LoginResponse getToken() {
      return _token;
   }

}