package repository;

import dto.Child;
import dto.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ChildRepository extends JpaRepository<Child, UUID>, JpaSpecificationExecutor<Child> {
}
