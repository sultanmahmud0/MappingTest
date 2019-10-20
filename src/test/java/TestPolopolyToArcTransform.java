import com.google.gson.Gson;
import mapper.ChildMapper;
import model.*;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

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

        Source source = Source.builder()
                        .sourceId("456")
                        .sourceNumber(1234)
                        .sourceStatus(false)
                        .subTitle("subTitle")
                        .build();

        Child child = Mappers.getMapper(ChildMapper.class).mapChild(source);

        System.out.println("Transformed Arc Image ANS: " + new Gson().toJson(child));
    }
}
