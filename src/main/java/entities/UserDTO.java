package entities;

import java.io.Serializable;

public record UserDTO(Long userId, String name, int age, double balance, int quantity) implements Serializable {
}
