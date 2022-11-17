package com.example.test.specification;

import com.example.test.entity.Employee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeSpecification {
    public static Specification<Employee> buildWhere(String fullName,String email){
        Specification<Employee> where = null;

        if (fullName != null){
            CustomSpecification fullNameCus = new CustomSpecification("fullName",fullName);
            where = fullNameCus;
        }
        if (email != null){
            CustomSpecification emailCus = new CustomSpecification("email",email);
            if (where == null){
                where = Specification.where(emailCus);
            }else {
                where = where.and(emailCus);
            }
        }

        return where;
    }

}
@RequiredArgsConstructor
class CustomSpecification implements Specification<Employee>{

    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("fullName")){
            return criteriaBuilder.like(root.get("fullName"),"%" + value + "%");
        }
        if (field.equalsIgnoreCase("email")){
            return criteriaBuilder.like(root.get("email"),"%" + value + "%");
        }

        return null;
    }
}
