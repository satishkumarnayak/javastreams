package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 1, 2);

    Optional<Integer> min = numbers.stream().min((num1, num2) -> {
      if (num1 == num2) {
        return 0;
      } else if (num1 > num2) {
        return 1;
      } else {
        return -1;
      }
    });

    Optional<Integer> min2 = numbers.stream().min((num1, num2) -> {
      return num1 > num2 ? 1 : -1;
    });


    System.out.println(min.get());
    System.out.println(min2.get());

  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 101, 23, 93, 99);

    Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
    System.out.println(max.get());
  }
}
