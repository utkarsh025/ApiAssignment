import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TestClass {

    public static void main(String[] args) throws IOException {

        getJson();
    }

   static void getJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new FileReader("C:\\Users\\asus\\Desktop\\Api Assignment\\api\\src\\main\\resources\\datajson.json"));
        JsonNode classNameJson = jsonNode.get("problems").at("/0/Diabetes/0/medications/0/medicationsClasses/0");
       // classNameJson.get(0);

        Iterator<JsonNode> itr = classNameJson.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());}


    }
}
