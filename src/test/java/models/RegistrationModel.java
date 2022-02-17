package models;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class RegistrationModel {

    private String zipCode;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmPassword;
}
