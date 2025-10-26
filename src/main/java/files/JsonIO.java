package files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.Graph;
import data.ResultsMst;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonIO {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Map<String, Graph> readGraphs(String path) {
        try (FileReader reader = new FileReader(path)) {
            Type type = new TypeToken<Map<String, Graph>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading " + path, e);
        }
    }

    public static void writeResults(String path, Map<String, ResultsMst> results) {
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(results, writer);
        } catch (Exception e) {
            throw new RuntimeException("Error while writing JSON to " + path, e);
        }
    }
}
