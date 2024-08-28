package zuper.programmer.test.repository;

import zuper.programmer.test.data.Person;

public interface PersonRepository {
    Person selectById(String id);
    Person insert(Person person);
}
