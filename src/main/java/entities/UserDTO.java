package entities;

import java.io.Serializable;
import java.util.UUID;

public record UserDTO(UUID userId, String name, int age, double balance, int quantity) implements Serializable {
}
