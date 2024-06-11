package repositories;



import entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.UUID;


@ApplicationScoped
public class UserRepository  implements PanacheRepositoryBase<User, UUID> {}

