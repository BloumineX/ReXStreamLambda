import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by xavierbloumine on 06/04/2016.
 */

public class ComparatorTest {




    @Test
    public void should_compare_array_with_comparable() {
        List<Integer> listToSort = Arrays.<Integer>asList(4,5,2,1,3);
        Collections.sort(listToSort);

        List<Integer> lambdaList = Arrays.<Integer>asList(4,5,2,1,3);
        System.out.println("lambda 1 : " + lambdaList);
        lambdaList.sort((value1, value2) -> value1 < value2 ? -1 : 1);
        assertThat(lambdaList).isEqualTo(listToSort);
        System.out.println("lambda 2 : " + lambdaList);
        Comparator<Integer> c = (Integer i1, Integer i2) -> i1 > i2 ? -1 : 1;

        lambdaList.sort(c);
        System.out.println("lambda 3 : " + lambdaList);

    }

    @Test
    public void should_doing_stuff_on_collection() {
        List<Integer> list = new ArrayList<>(Arrays.<Integer>asList(4,5,2,1,3, 8, 9, 13));
        List<Integer> resultList = new ArrayList<>(list);
        //enlever les éléments impaires
        for (Integer i : list) {
            if (i%2 == 0)
                resultList.remove(i);
        }
//enlever les doublons
        Set< Integer> setInte = new HashSet<>(resultList);
//Multiplier par 2 les élements et renvoyer la somme
        Integer result = 0;
        for (Integer i : setInte) {
            result = result + i * 2;
        }

        System.out.println("result total : " + result);

    }

    @Test
    public void should_doing_lambda_stuff_on_collection() {
        List<Integer> list = new ArrayList<>(Arrays.<Integer>asList(4,5,2,1,3, 8, 9, 13));

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        list.stream().forEach(consumer);

        System.out.println("result total : " + list.stream()
                .filter((i -> i%2 != 0))
                .map(i -> i = i*2)
                .distinct()
                .reduce(0, (val1, val2) -> val1 + val2)
        );
    }

}
