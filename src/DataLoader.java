package src;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants {

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) parser.parse(reader);

            for (Object obj : userJSON) {
                JSONObject userObj = (JSONObject) obj;
                int type = Integer.parseInt(userObj.get(USER_TYPE).toString());
                String firstName = (String) userObj.get(USER_FIRST_NAME);
                String lastName = (String) userObj.get(USER_LAST_NAME);
                String email = (String) userObj.get(USER_EMAIL);
                String username = (String) userObj.get(USER_USERNAME);
                String password = (String) userObj.get(USER_PASSWORD);
                if (type == 1) {
                    users.add(new Student(firstName, lastName, email, username, password));
                } else {

                }

            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
