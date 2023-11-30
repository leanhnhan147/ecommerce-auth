package com.ecommerce.auth.model.criteria;


import com.ecommerce.auth.model.Account;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeAccountCriteria implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private int kind;
    private String username;
    private Integer status;
    private String email;
    private String fullName;
    private String phone;
    private Long parentId;

    public Specification<Account> getSpecification() {
        return new Specification<Account>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if(getId() != null){
                    predicates.add(cb.equal(root.get("id"), getId()));
                }
                if(getKind() > 0){
                    predicates.add(cb.equal(root.get("kind"), getKind()));
                }
                if(getStatus() != null){
                    predicates.add(cb.equal(root.get("status"), getStatus()));
                }
                if(!StringUtils.isEmpty(getUsername())){
                    predicates.add(cb.like(cb.lower(root.get("username")), "%"+getUsername().toLowerCase()+"%"));
                }
                if(!StringUtils.isEmpty(getEmail())){
                    predicates.add(cb.like(cb.lower(root.get("email")), "%"+getEmail().toLowerCase()+"%"));
                }
                if(!StringUtils.isEmpty(getFullName())){
                    predicates.add(cb.like(cb.lower(root.get("fullName")), "%"+getFullName().toLowerCase()+"%"));
                }
                if (getParentId() != null){
                    Join<Account, Account> join = root.join("parent", JoinType.INNER);
                    predicates.add(cb.equal(join.get("id"), getParentId()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}