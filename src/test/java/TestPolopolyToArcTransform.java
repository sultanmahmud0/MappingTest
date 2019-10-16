import com.google.gson.Gson;
import mapper.ImageMapper;
import mapper.SimpleMapper;
import model.*;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

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

        System.out.println("Transformed Arc Image ANS: " + new Gson().toJson(arcImage));
    }

    @Test
    public void testSimpleMapping(){

        Map<String,Object> map = new HashMap<>();
        map.put("hiddenMessage","true");
        map.put("hiddenPlace","Dhaka");

        Source source = new Source();
        source.setId(1234);
        source.setDate(new Date());
        source.setSourceMap(map);

        Target target = SimpleMapper.MAPPER.toTarget(source);
        System.out.println("Target : " + new Gson().toJson(target));
    }

}
