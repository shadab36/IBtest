package APIClient.messages.login;

import java.util.Map;

import javax.ws.rs.core.NewCookie;

public class LoginResponse {

   public String clientname;
   public String clientuuid;
   public String apikey;
   public Integer logintimeoutperiod;
   public String adminemail;
   public Integer passwordexpiryperiod;
   public Integer userverificationperiod;
   public Integer offlineexpiryperiod;
   public String annotations;
   public String comments;
   public Boolean passwordexpired;
   public Boolean emailexpired;
   public String versions;
   public String firstname;
   public String lastname;
   public String useruuid;
   public String thumbnail;
   public String foldericon;
   public String rowsOnPage;
   public String colourPrimary;
   public String colourPrimaryText;
   public String colourSecondary;
   public String colourSecondaryText;
   public String colourHighlight;
   public String enableMasterSync;
   public String enableCustomBranding;
   public String enableAnnotations;
   public String enableImageReader;
   public String enableAppOpenIn;
   public Boolean isResourceMainAdmin;

   public ToolNameMapping toolNameMapping;

   public String defaultFolderSortOrder;

   // Manually added, not part of the actual resonse JSON
   public Map<String, NewCookie> Cookies;
}