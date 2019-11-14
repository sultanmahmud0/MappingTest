package mapper;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.mentordigital.etlmodel.ans.BaseContent;
import no.mentordigital.etlmodel.ans.image.Image;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseContent implements Serializable {

    Image image;

    @SerializedName("first_name")
    String firstName;

    @SerializedName("last_name")
    String lastName;

}
