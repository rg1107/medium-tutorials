package repository;

import dto.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ToyRepository extends JpaRepository<Toy, UUID>, JpaSpecificationExecutor<Toy> {
}

