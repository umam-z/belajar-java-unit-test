package zuper.programmer.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zuper.programmer.test.data.Person;
import zuper.programmer.test.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testPersonSuccess() {
//        menambah behavior ke mock object
        Mockito.when(personRepository.selectById("mohammad")).
                thenReturn(new Person("sirajul", "umam"));

        var person = personService.get("mohammad");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("sirajul", person.getId());
        Assertions.assertEquals("umam", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Mohammad");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Mohammad", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1)).
        insert(new Person(person.getId(), "Mohammad"));
    }
}
