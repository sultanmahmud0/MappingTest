import com.google.gson.Gson;
import mapper.ChildMapper;
import model.Child;
import model.Source;
import model.Task;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.Map;

public class TestPolopolyToArcTransform {

//    @Test
//    public void testTransform() throws Exception{
//
//        StringBuilder contentBuilder = new StringBuilder();
//        String filePath = Paths.get(getClass().getClassLoader().getResource("polopolyImage.json").toURI()).toFile().getPath();
//        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
//            stream.forEach(s -> contentBuilder.append(s).append("\n"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String polopolyData = contentBuilder.toString();
//        Doc sourceDoc = new Gson().fromJson(polopolyData, Doc.class);
//        DocData polopolyModel = sourceDoc.get_data();
//
//        ArcImage arcImage = Mappers.getMapper(ImageMapper.class).mapImage(polopolyModel);
//
//        System.out.println("Transformed Arc Image ANS: " + new Gson().toJson(arcImage));
//    }

    @Test
    public void testInheritance(){

        Map<String,Object> map = new HashMap();
        map.put("childOrder","Order123");
        map.put("childTemplate","Template123");
        map.put("childType","DATA");

        Source source = Source.builder()
                        .sourceId("456")
                        .sourceNumber(1234)
                        .sourceStatus(false)
                        .childPlace("Dhaka")
                        .childStatus(true)
                        .childTitle("Try")
                        .sourceMap(map)
                        .task(Task.builder().taskName("Task123").build())
                        .build();


        Child child = Mappers.getMapper(ChildMapper.class).mapChild(source);

        System.out.println("Transformed child object: " + new Gson().toJson(child));
    }
}
