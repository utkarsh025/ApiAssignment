import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new FileReader("C:\\Users\\asus\\Desktop\\Api Assignment\\api\\src\\main\\resources\\datajson.json"));
        String expectedJson = "className2";
        getJson(jsonNode, expectedJson);
    }

    static void getJson(JsonNode jsonNode, String expectedJson) throws IOException {

        if (jsonNode.isObject()) {
            ObjectNode objectNode = (ObjectNode) jsonNode;
            Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
            Map.Entry<String, JsonNode> entry = null;
            while (iter.hasNext()) {
                entry = iter.next();
                if (entry.getKey().equals(expectedJson)) {
                    jsonNode = entry.getValue();
                    System.out.println(jsonNode);
                    break;
                }
                getJson(entry.getValue(), expectedJson);
            }
        } else if (jsonNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            for (int i = 0; i < arrayNode.size(); i++) {
                if (arrayNode.get(i).isObject())
                    getJson(arrayNode.get(i),expectedJson);
            }
        }
    }
}
