import com.google.gson.Gson;
import mapper.ImageMapper;
import model.ArcImage;
import model.Doc;
import model.DocData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

public class TestPolopolyToArcTransform {

    @Test
    public void testTransform() throws Exception{

        StringBuilder contentBuilder = new StringBuilder();
        String filePath = Paths.get(getClass().getClassLoader().getResource("polopolyImage.json").toURI()).toFile().getPath();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String polopolyData = contentBuilder.toString();
        Doc sourceDoc = new Gson().fromJson(polopolyData, Doc.class);
        DocData polopolyModel = sourceDoc.get_data();

        ArcImage arcImage = ImageMapper.MAPPER.toArcImage(polopolyModel);
        Map<String,Object> additionalProperties = new HashMap<>();
        additionalProperties.put("originalUrl","https://images.pexels.com/photos/733475/pexels-photo-733475.jpeg");
        arcImage.setAdditionalProperties(additionalProperties);

        System.out.println("Transformed Arc Image ANS: " + new Gson().toJson(arcImage));
    }

}
