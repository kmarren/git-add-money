package src;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants {
    public static ArrayList<User> loadUsers() {
        ArrayList<User> user = new ArrayList<User>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) new JSONParser().parse(reader);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
