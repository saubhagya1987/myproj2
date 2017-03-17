package  com.golenchi.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.golenchi.web.product.Features;
import com.golenchi.web.product.Modules;

public interface FeaturesCrudrepository extends CrudRepository<Features, Long> {
	public Features findByFeatureName(String featureName);
	public List<Features> findByModules(Modules modules);
}
