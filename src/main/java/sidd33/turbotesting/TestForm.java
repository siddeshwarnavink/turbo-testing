package sidd33.turbotesting;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import sidd33.turboengine.forms.annotation.FormField;
import sidd33.turboengine.forms.annotation.MaxFileCount;
import sidd33.turboengine.forms.annotation.MaxFileSize;
import sidd33.turboengine.forms.annotation.MinFileCount;
import sidd33.turboengine.forms.annotation.MinFileSize;
import sidd33.turboengine.forms.type.FormData;
import sidd33.turboengine.forms.type.FormFieldType;

@Data
@ToString
public class TestForm implements FormData {
    @FormField(label = "Name", fieldType = FormFieldType.TEXT)
    @NotEmpty(message = "Name is required")
    private String name;

    @FormField(label = "Date of birth", fieldType = FormFieldType.DATE)
    @NotNull(message = "DOB is required")
    @Min(value = 1, message = "DOB is required")
    private Long dob;

    @FormField(label = "You're Bio", fieldType = FormFieldType.RICHTEXT)
    @NotEmpty(message = "Bio is required")
    private String bio;

    @FormField(label = "Image file", fieldType = FormFieldType.FILE)
    @MinFileSize(message = "Image is required")
    @MaxFileSize(max = 512_000, message = "Image should not exceed 500kb")
    private MultipartFile file;

    @FormField(label = "Multiple file", fieldType = FormFieldType.FILE)
    @MaxFileSize(max = 512_000, message = "Images should not exceed 500kb") 
    @MinFileCount(length = 2, message = "Atleast 2 file is needed")
    @MaxFileCount(length = 4, message = "We don't need more than 4 files")
    private MultipartFile[] multifile;
}
