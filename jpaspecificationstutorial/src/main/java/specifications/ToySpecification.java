package specifications;

import dto.Toy;
import org.springframework.data.jpa.domain.Specification;

public class ToySpecification {

    public static Specification<Toy> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Toy> hasPriceLessThanOrEqualTo(double price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Toy> hasFun() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("hasFun"), true);
    }

    //add more as you like
}
