package APIClient.endpoints;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyWebTarget;

import APIClient.messages.login.LoginResponse;

public class LoginEndpoint extends EndPointBase {

   private JerseyClient _client;
   private String _target;
   private String _endpoint = "login";

   // Example url: "https://preprodsel.intelligencebank.com"
   public LoginEndpoint(JerseyClient client, String sitebaseurl) {
      _client = client;
      _target = sitebaseurl + "/webapp/1.0";
   }

   // Sitename example: "preprodsel.intelligencebank.com"
   public LoginResponse post(String username, String password, String sitename) {

      Form form = new Form();
      form.param("p70", username);
      form.param("p80", password);
      form.param("p90", sitename);

      logger.debug("Username: " + username);
      logger.debug("Password: " + "**********");  //password);
      logger.debug("Sitename: " + sitename);
      logger.debug("target: " + _target);
      logger.debug("endpoint url: " + _endpoint);

      JerseyWebTarget jerseyWebTarget = _client.target(_target).path(_endpoint);

      Response response =  jerseyWebTarget.request(MediaType.APPLICATION_JSON)
                              .post(Entity.form(form));

      Map<String, NewCookie> cookies = response.getCookies(); //store cookies

      Gson g = new Gson();
      String output = response.readEntity(String.class);

      LoginResponse responseObject = g.fromJson(output, LoginResponse.class);   
      responseObject.Cookies = cookies;
      return responseObject;      
   }
}