package sidd33.turbotesting;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import sidd33.turboengine.forms.annotation.FormField;
import sidd33.turboengine.forms.annotation.MaxFileSize;
import sidd33.turboengine.forms.annotation.MinFileSize;
import sidd33.turboengine.forms.type.FormData;
import sidd33.turboengine.forms.type.FormFieldType;

public class TestForm implements FormData {
    @FormField(label = "Name", fieldType = FormFieldType.TEXTINPUT)
    @NotEmpty(message = "Name is required")
    private String name;

    @FormField(label = "Date of birth", fieldType = FormFieldType.DATETIME)
    @NotNull(message = "DOB is required")
    @Min(value = 1, message = "DOB is required")
    private Long dob;

    @FormField(label = "You're Bio", fieldType = FormFieldType.RICHTEXT)
    @NotEmpty(message = "Bio is required")
    private String bio;

    @FormField(label = "Image file", fieldType = FormFieldType.FILEINPUT)
    @MinFileSize(message = "Image is required")
    @MaxFileSize(max = 512_000, message = "Image should not exceed 500kb")
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(String dateTimeString) {
        if (dateTimeString != null && !dateTimeString.isEmpty()) {
            this.dob = Long.parseLong(dateTimeString);
        }
    }

    @Override
    public String toString() {
        return "TestForm{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", file=" + file +
                ", bio='" + bio + '\'' +
                '}';
    }
}
