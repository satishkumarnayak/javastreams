package lectures;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import beans.Person;
import mockdata.MockData;

public class Lecture1 {

  // @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    int count = 0;
    for (Person person : people) {

      if (person.getAge() <= 18 && count < 10) {
        System.out.println(person);
        count++;
      }
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    List<Person> youngPeople = people.stream().filter(person -> person.getAge() <= 18).limit(10)
        .collect(Collectors.toList());

    youngPeople.forEach(System.out::println);

  }
}
