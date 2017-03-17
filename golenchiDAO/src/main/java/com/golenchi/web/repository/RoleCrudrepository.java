package  com.golenchi.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.golenchi.web.roles.Role;

public interface RoleCrudrepository extends CrudRepository<Role, Long> {

}
