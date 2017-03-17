package  com.golenchi.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.golenchi.web.product.Modules;

public interface ModulesCrudrepository extends CrudRepository<Modules, Long> {

	public Modules findByModuleName(String moduleName);

}
