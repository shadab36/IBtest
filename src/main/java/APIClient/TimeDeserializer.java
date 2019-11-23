package APIClient;

import java.lang.reflect.Type;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class TimeDeserializer implements JsonDeserializer<Date> {

   private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
   @Override
   public Time deserialize(JsonElement jsonElement, Type typeOF,
                           JsonDeserializationContext context) throws JsonParseException {
         try {

               String s = jsonElement.getAsString();
               SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT, Locale.US);
               sdf.parse(s);
               long ms = sdf.parse(s).getTime();
               Time t = new Time(ms);
               return t;
         } catch (ParseException e) {
         }
      throw new JsonParseException("Unparseable time: \"" + jsonElement.getAsString()
               + "\". Supported formats: " + TIME_FORMAT);
   }
}