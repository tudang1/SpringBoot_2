package com.example.testjpa_1123;

import com.example.testjpa_1123.entity.Category;
import com.example.testjpa_1123.entity.Employee;
import com.example.testjpa_1123.entity.Product;
import com.example.testjpa_1123.repository.CategoryRepository;
import com.example.testjpa_1123.repository.EmployeeRepository;
import com.example.testjpa_1123.repository.ProductRepository;
import com.example.testjpa_1123.repository.TagRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@SpringBootTest
class TestJpa1123ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private Faker faker;
    @Test
    void save_category() {

        for (int i = 0; i < 5; i++) {
            Category category = Category.builder()
                    .name(faker.esports().team())
                    .build();
            categoryRepository.save(category);
        }
    }

    @Test
    void save_product(){
        Random rd = new Random();

        List<Category> categories = categoryRepository.findAll();

        for (int i = 0; i < 30; i++) {


            // Random 1 category
            Category rdCategory = categories.get(rd.nextInt(categories.size()));

            // Tạo Product

            Product product = Product.builder()
                    .name(faker.leagueOfLegends().champion())
                    .category(rdCategory)
                    .build();
            productRepository.save(product);
        }
    }

    @Test
    void save_employee(){
        for (int i = 0; i < 25; i++) {
            Employee employee = Employee.builder()
                    .emailAddress(faker.internet().emailAddress())
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .build();
            employeeRepository.save(employee);
        }
    }




}
