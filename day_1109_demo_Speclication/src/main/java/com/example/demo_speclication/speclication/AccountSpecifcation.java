package com.example.demo_speclication.speclication;

import com.example.demo_speclication.entity.Account;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecifcation {
    public static Specification<Account> buildWhere(String username,Integer mindId){
        Specification<Account> where = null;

        if (username != null){
            CustomSpecification userNameCus = new CustomSpecification("userName",username);
            where = Specification.where(userNameCus);
        }
        if (mindId != null){
            CustomSpecification mindIdCus = new CustomSpecification("mindId",mindId);
            if (where ==null){
                where = mindIdCus;
            }else {
                where = where.and(mindIdCus);
            }
        }
        return where;
    }
}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Account>{
    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("username")){
            return criteriaBuilder.like(root.get("username"),"%" + value.toString() + "%");
        }
        if (field.equalsIgnoreCase("mindId")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get("Id"),value.toString());
        }
        return null;
    }
}
