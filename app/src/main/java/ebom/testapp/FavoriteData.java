package ebom.testapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavoriteData {
    public static HashMap<String, List<String>> getInfo() {

        HashMap<String, List<String>> favorites_info = new HashMap<String, List<String>>();
        List<String> CSIT_Favorites = new ArrayList<String>();
        CSIT_Favorites.add("Example Info 1");
        CSIT_Favorites.add("Example Info 2");
        CSIT_Favorites.add("Example Info 3");
        CSIT_Favorites.add("Example Info 4");

        favorites_info.put("CSIT Favorites", CSIT_Favorites);
        return favorites_info;
    }

}