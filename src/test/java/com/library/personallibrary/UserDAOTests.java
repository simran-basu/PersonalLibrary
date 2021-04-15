package com.library.personallibrary;

import com.library.personallibrary.dao.UserDAO;
import com.library.personallibrary.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserDAOTests {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("vaishnavi@gmail.com");
        user.setPassword("vaish2020");
        user.setFirstName("vaishnavi");
        user.setLastName("dhulipalla");
        User savedUser = userDAO.save(user);
        User existingUser = entityManager.find(User.class, savedUser.getUserid());
        assertThat(existingUser.getEmail()).isEqualTo(user.getEmail());
    }
    @Test
    public void testFindUserByEmail(){
        String email = "simran18@gmail.com";
        User user = userDAO.findByEmail(email);
        assertThat(user).isNotNull();
    }
}

