package APIClient.endpoints;

import java.sql.Time;
import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyWebTarget;

import APIClient.DateDeserializer;
import APIClient.TimeDeserializer;
import APIClient.messages.folder.FolderResponse;
import APIClient.messages.login.LoginResponse;

public class ResourcesEndpoint extends EndPointBase {

   private JerseyClient _client;
   private String _target;
   private String _endpoint = "resources";

   private LoginResponse _token;

   public ResourcesEndpoint(JerseyClient client, String sitebaseurl, LoginResponse token) {
      _client = client;
      _target = sitebaseurl + "/webapp/1.0";

      _token = token;
   }

   public FolderResponse folderExists(String folder_uuid) {

      JerseyWebTarget jerseyWebTarget = _client.target(_target).path(_endpoint)
         .queryParam("p10", _token.apikey)
         .queryParam("p20", _token.useruuid)
         .queryParam("folderuuid", folder_uuid);

      //         .cookie(new Cookie("_aid", "cafa77537d308521acfd5c34f2c15096_8b3h0ha6cs6ge9l8192kddl5b0_default"))

      Response response = jerseyWebTarget.request(MediaType.APPLICATION_JSON)
         .cookie(_token.Cookies.get("_aid"))
         .get();

      if (response.getStatus() != 200) {
         String errorMessage = "Failed : HTTP error code : " + response.getStatus();
         logger.error(errorMessage);
         throw new RuntimeException(errorMessage);
      }

      String output = response.readEntity(String.class);    
   
      GsonBuilder gSonBuilder=  new GsonBuilder();
         gSonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
         gSonBuilder.registerTypeAdapter(Time.class, new TimeDeserializer());
      Gson gSon = gSonBuilder.create();
   
      return gSon.fromJson(output, FolderResponse.class);
   }
   
}