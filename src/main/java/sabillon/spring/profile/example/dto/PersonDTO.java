package sabillon.spring.profile.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return "Id: " + this.id + " | Name: " + this.name + " | LastName: " + this.lastName + " | age: " + this.age;
    }
}
