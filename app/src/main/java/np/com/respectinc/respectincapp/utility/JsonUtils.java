package np.com.respectinc.respectincapp.utility;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author prabin
 *
 */
public class JsonUtils {

	public static <T> T toObject(String data, Class<T> type) {
		Gson gson = new Gson();
		return gson.fromJson(data, type);
	}

	public static String toString(Object src) {
		Gson gson = new Gson();
		return gson.toJson(src);
	}


	public static Map toHashMap(Object src) {
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>() {
		}.getType();
		HashMap<String, String> params = gson.fromJson(toString(src), type);
		return params;
	}


	public static String getDataUsingKey(String data) {
		String message = "";
		JsonParser parser = new JsonParser();
		JsonObject jObj = (JsonObject) parser.parse(data);
		for (Map.Entry<String, JsonElement> e : jObj.entrySet()) {
			LoggerUtils.log(e.getKey());
			LoggerUtils.log(e.getValue().toString());
			JsonElement values = e.getValue();
			JsonArray jsonArray = values.getAsJsonArray();

			message = message + e.getKey() + ":";
			for (int i = 0; i < jsonArray.size(); i++) {
				message = message + jsonArray.get(i).getAsString();
			}
			message = message + "\n";
		}
		return message;
	}
}
