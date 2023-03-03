package ec.org.inspi.cirev.collection.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.User;

@RepositoryRestResource(path="users")
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	User findFirstByOrderByIdDesc();
	User findById(Integer userId);
	List<User> findAllByIsInternalAndActiveTrue(boolean isInternal);
	List<User> findByActiveTrue();
}
