package APIClient.messages.folder;

import java.sql.Time;


public class Folder {
   public String folderuuid;
   public String name;
   public String description;
   public Time createdtime;
   public String comments;
   public String perm;
   public FolderChildrenCount children;
   public String defaultorder;
   public String sortorder;
}