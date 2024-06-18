package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PracticeFormEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String mobilePhone;
    private String subjects;
    private String currentAddress;
    private String state;
    private String city;


}
