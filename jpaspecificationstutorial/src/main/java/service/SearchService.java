package service;

import dto.Child;
import dto.Toy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.ChildRepository;
import repository.ToyRepository;
import specifications.ChildSpecification;
import specifications.ToySpecification;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    private final ChildRepository childRepository;
    private final ToyRepository toyRepository;

    public SearchService(ChildRepository childRepository, ToyRepository toyRepository) {
        this.childRepository = childRepository;
        this.toyRepository = toyRepository;
    }

    public List<Toy> searchToyWithNameAndPrice(String name, Optional<Double> price) {
        Specification<Toy> spec = Specification.where(ToySpecification.hasName(name)).or(ToySpecification.hasFun());
        if (price.isPresent()) {
            spec = spec.and(ToySpecification.hasPriceLessThanOrEqualTo(price.get()));
        }
        return toyRepository.findAll(spec);
    }

    public Page<Child> searchChildByAge(int age, int page, int size) {
        return childRepository.findAll(ChildSpecification.hasAgeGreaterThan(age), PageRequest.of(page, size));
    }

    public void deleteAdults() {
        childRepository.delete(ChildSpecification.hasAgeGreaterThan(18));
    }
}
