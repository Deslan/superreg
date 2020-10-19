package com.example.superreg.services.impl;

import com.example.superreg.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplUnitTest {

    @Mock
    private UserRepository mockRespository;

    @Autowired
    UserServiceImpl userService = new UserServiceImpl(mockRespository);

    @Test
    void testTheIsValidNameMethod() {
        assert (userService.nameIsValid("") == false);
        assert (userService.nameIsValid("Ayesha Matwadia") == true);
        assert (userService.nameIsValid("Ayesha") == true);
        assert (userService.nameIsValid("@Ayesha Matwadia") == false);
        assert (userService.nameIsValid("Ayesha1Matwadia") == false);
        assert (userService.nameIsValid("Ayesha+Matwadia") == false);
    }

    @Test
    void testTheValidTelephoneNumberMethod() {
        assert (userService.telephoneNumberIsValid("") == false);
        assert (userService.telephoneNumberIsValid("$27830985673") == false);
        assert (userService.telephoneNumberIsValid("+27830985673") == true);
        assert (userService.telephoneNumberIsValid("+278309856") == false);
        assert (userService.telephoneNumberIsValid("+278309856efg") == false);

    }
}
