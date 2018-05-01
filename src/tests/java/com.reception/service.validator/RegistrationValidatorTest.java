package com.reception.service.validator;

import com.reception.entity.User;
import com.reception.service.validator.impl.UserValidatorImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegistrationValidatorTest {

    private final User customer = new User();

    private final UserValidatorImpl validator = new UserValidatorImpl();

    @Before
    public void setUp(){

        customer.setFirst_name("Lesha");
        customer.setLast_name("Melescheny");
        customer.setPatronymic("Vladidmirovich");
        customer.setEmail("meleschenya@tut.by");
        customer.setPassword("985598559855");
        customer.setPhoneNumber("+375259414479");
        customer.setMathResult(12);
        customer.setPhysResult(12);
        customer.setLangResult(12);
        customer.setSertResult(12);
    }



    @Test
    public void when_phone_number_has_a_letter_then_list_should_increase_at_one(){

        customer.setPhoneNumber("+375296471934s");
        boolean result = validator.validate(customer);
        assertThat(result,is(false));
    }

    @Test
    public void when_put_email_without_point_behind_domain_then_should_return_increased_at_one_list(){
        customer.setEmail("Lesha@gmailcom");
        boolean result = validator.validate(customer);
        assertThat(result,is(false));
    }

    @Test
    public void when_put_email_without_domain_separator_symbol_then_should_return_increased_at_one_llist(){
        customer.setEmail("Leshacom");
        boolean result = validator.validate(customer);
        assertThat(result,is(false));
    }

    @Test
    public void when_put_email_without_domain_then_should_return_increased_at_one_llist(){
        customer.setEmail("Lesha@.com");
        boolean result = validator.validate(customer);
        assertThat(result,is(false));
    }

    @Test
    public void when_put_correct_email_then_should_return_unchanged_list(){
        customer.setEmail("meleschenya2010@gmail.com");
        boolean result = validator.validate(customer);
        assertThat(result,is(true));

    }

    @Test
    public void when_put_password_as_null_or_empty_then_should_return_increased_at_one_list(){
        customer.setPassword("");
        boolean result = validator.validate(customer);
        assertThat(result,is(false));
        customer.setPassword(null);
        result = validator.validate(customer);
        assertThat(result,is(false));
    }

}
