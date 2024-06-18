package entities;


import lombok.*;
import org.testng.annotations.Test;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Employee {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private long salary;
    private String department;


}
