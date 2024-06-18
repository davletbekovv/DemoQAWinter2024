package utils;

import com.github.javafaker.Faker;
import entities.Employee;
import entities.PracticeFormEntity;
import entities.TextBoxEntity;
import pages.WebTablePage;

public class RandomUtils {

    Faker faker = new Faker();
    public PracticeFormEntity generateRandomPracticeFormEntities() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstName(faker.name().firstName());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setMobilePhone("0755922999");
        practiceFormEntity.setSubjects("Chemistry");
        practiceFormEntity.setCurrentAddress(faker.address().fullAddress());
        practiceFormEntity.setState("Haryana");
        practiceFormEntity.setCity("Delhi");
        return practiceFormEntity;
    }

    public  TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public Employee createMockEmployee(){
        Employee employee = new Employee();
        employee.setFirstname(faker.name().firstName());
        employee.setLastname(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18,100));
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(10000l, 20000l));
        employee.setDepartment(faker.job().position());

        return employee;
    }



}
