package specifications;

import dto.Child;
import dto.Toy;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class ChildSpecification {

    public static Specification<Child> hasAgeGreaterThan(int age) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("age"), age);
    }

    public static Specification<Child> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }


    public static Specification<Child> hasToyPriceGreaterThan(double price) {
        return (root, query, criteriaBuilder) -> {
            Join<Child, Toy> toyJoin = root.join("toys", JoinType.INNER);
            return criteriaBuilder.greaterThan(toyJoin.get("price"), price);
        };
    }

    //add more as you like
}
