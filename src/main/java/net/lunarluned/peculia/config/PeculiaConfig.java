package net.lunarluned.peculia.config;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class PeculiaConfig {
    private static final HashMap<String, Integer> INT_OPTIONS = new HashMap<>();

    public static int getIntValue(String key) {
        if (!INT_OPTIONS.containsKey(key)) {
            System.out.println(key);
        }
        return INT_OPTIONS.getOrDefault(key, null);
    }

    public static void init() {
        INT_OPTIONS.put("echo_chance", 25);
        INT_OPTIONS.put("soul_scythe_chance", 10);
    }
    public static void loadConfig() {
        JsonObject json;
        json = Config.getJsonObject(Config.readFile(new File("config/peculia/value_config.json5")));
        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            INT_OPTIONS.put(entry.getKey(), entry.getValue().getAsInt());
        }
    }

    public static void generateConfigs(boolean overwrite) {
        StringBuilder config = new StringBuilder("{\n");
        int i = 0;
        for (String item : INT_OPTIONS.keySet()) {
            config.append("  \"").append(item).append("\": ").append(INT_OPTIONS.get(item));
            ++i;
            if (i < INT_OPTIONS.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        Config.createFile("config/peculia/value_config.json5", config.toString(), overwrite);
    }
}
