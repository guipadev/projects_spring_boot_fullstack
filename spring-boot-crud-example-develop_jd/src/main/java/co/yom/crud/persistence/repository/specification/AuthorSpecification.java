package co.yom.crud.persistence.repository.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import co.yom.crud.model.projection.AuthorProjection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthorSpecification implements Specification<AuthorProjection> {

    private static final long serialVersionUID = 9012571244166768893L;

    private String q;
    private LocalDate birthdate;
    
    @Override
    public Predicate toPredicate(Root<AuthorProjection> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicatesOr = new ArrayList<>();
        List<Predicate> predicatesAnd = new ArrayList<>();
        
        if(StringUtils.hasText(q)) {
            predicatesOr.add(criteriaBuilder.like(root.get("firstName"), "%"+q+"%"));
            predicatesOr.add(criteriaBuilder.like(root.get("lastName"), "%"+q+"%"));
        }
        
        if(birthdate != null) {
            predicatesAnd.add(criteriaBuilder.equal(root.get("birthdate"), birthdate));
        }
        
        if(predicatesOr.isEmpty() && predicatesAnd.isEmpty()) {
            return null;
        }
                
        
        if(!predicatesOr.isEmpty() && !predicatesAnd.isEmpty()) {
            Predicate predicateOr = criteriaBuilder.and(predicatesOr.toArray(new Predicate[0]));
            Predicate predicateAnd = criteriaBuilder.and(predicatesAnd.toArray(new Predicate[0]));
            
            return criteriaBuilder.and(predicateAnd, criteriaBuilder.or(predicateOr));
        }
                
        if(!predicatesOr.isEmpty()) {
            return criteriaBuilder.or(predicatesOr.toArray(new Predicate[0]));
        }
        
        if(!predicatesAnd.isEmpty()) {
            return criteriaBuilder.and(predicatesAnd.toArray(new Predicate[0]));
        }
        
        return null;
    }

}
