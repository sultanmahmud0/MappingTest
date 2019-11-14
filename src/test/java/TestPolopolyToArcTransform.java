import com.google.gson.Gson;
import mapper.Author;
import mapper.AuthorMapper;
import mapper.ImageMapper;
import no.mentordigital.etlmodel.ans.image.Image;
import no.mentordigital.etlmodel.polopoly.PolopolyDoc;
import no.mentordigital.etlmodel.polopoly.PolopolyModel;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        PolopolyDoc sourceDoc = new Gson().fromJson(polopolyData, PolopolyDoc.class);
        PolopolyModel polopolyModel = sourceDoc.get_data();

        Image arcImage = Mappers.getMapper(ImageMapper.class).mapArcImage(polopolyModel);

        System.out.println("Transformed Arc Image ANS: " + new Gson().toJson(arcImage));
    }

    @Test
    public void testAuthorTransform() throws Exception{

        StringBuilder contentBuilder = new StringBuilder();
        String filePath = Paths.get(getClass().getClassLoader().getResource("polopolyAuthor.json").toURI()).toFile().getPath();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String polopolyData = contentBuilder.toString();
        PolopolyModel polopolyModel = new Gson().fromJson(polopolyData, PolopolyModel.class);

        Author arcAuthor = Mappers.getMapper(AuthorMapper.class).mapArcAuthor(polopolyModel);

        System.out.println("Transformed Arc Author ANS: " + new Gson().toJson(arcAuthor));
    }
}
