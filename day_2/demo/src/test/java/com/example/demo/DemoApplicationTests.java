package com.example.demo;

import com.example.demo.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class DemoApplicationTests {

    @Test
    void save_todos() {
        Todo todo1 = Todo.builder().title("Lam bai tap").build();
        Todo todo2 = Todo.builder().title("di choi").status(true).build();
        Todo todo3 = Todo.builder().title("da bong").build();


    }

}
