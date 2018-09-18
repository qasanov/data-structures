package arrays;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OracleArraysClassTest {

    private final int[] sampleArray = {6, 4, 1, 8, 3, 9, 7, 4, 2};
    private final int minOfSampleArray = 1;
    private final int maxOfSampleArray = 9;

    @Test
    public void sortArray_ShouldDoAscendingSort() {
        Arrays.sort(sampleArray);
        assertThat(sampleArray[0]).isEqualTo(minOfSampleArray);
        assertThat(sampleArray[sampleArray.length-1]).isEqualTo(maxOfSampleArray);
    }

    @Test
    public void sortArray_WithIntegers_ShouldDoDescendingSort() {
        Comparator<Integer> integerComparator = (a, b) -> b.compareTo(a);
        Integer[] boxedSampleArray = Arrays.stream( sampleArray ).boxed().toArray( Integer[]::new );
        Arrays.sort(boxedSampleArray,integerComparator);
        assertThat(boxedSampleArray[0]).isEqualTo(maxOfSampleArray);
        assertThat(boxedSampleArray[boxedSampleArray.length-1]).isEqualTo(minOfSampleArray);
    }

    @Test
    public void sortArray_WithSpecificRange() {
        Arrays.sort(sampleArray,0,2);
        assertThat(sampleArray[0]).isEqualTo(4);
    }

    @Test
    public void parallelSort() {
        Arrays.parallelSort(sampleArray);
    }

    @Test
    public void binarySearch() {
        Arrays.sort(sampleArray);
        int indexOfKey = Arrays.binarySearch(sampleArray, minOfSampleArray);
        assertThat(indexOfKey).isEqualTo(0);
    }

    @Test
    public void copySampleArray(){
        int[] copiedArray = Arrays.copyOf(sampleArray, sampleArray.length);
        assertThat(sampleArray).isEqualTo(copiedArray);
        Arrays.sort(copiedArray);
        assertThat(sampleArray).isNotEqualTo(copiedArray);
        Arrays.sort(sampleArray);
        assertThat(sampleArray).isEqualTo(copiedArray);
    }

    @Test
    public void fillArray_WithSomeValue() {
        int[] copiedArray = Arrays.copyOf(sampleArray, sampleArray.length);
        Arrays.fill(copiedArray,-1);
        assertThat(sampleArray).isNotEqualTo(copiedArray);
        assertThat(copiedArray[0]).isEqualTo(-1);
    }

    @Test
    public void convertToList() {
        Arrays.sort(sampleArray);
        Integer[] boxedSampleArray = Arrays.stream( sampleArray ).boxed().toArray( Integer[]::new );
        List<Integer> integerList = Arrays.asList(boxedSampleArray);
        assertThat(minOfSampleArray).isEqualTo(integerList.get(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addElementToConvertedList_ShouldThrowException() {
        Integer[] boxedSampleArray = Arrays.stream( sampleArray ).boxed().toArray( Integer[]::new );
        List<Integer> integerList = Arrays.asList(boxedSampleArray);
        integerList.add(13);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeElementFromList_ShouldThrowException() {
        Integer[] boxedSampleArray = Arrays.stream( sampleArray ).boxed().toArray( Integer[]::new );
        List<Integer> integerList = Arrays.asList(boxedSampleArray);
        integerList.remove(0);
        assertThat(integerList.size()).isEqualTo(sampleArray.length-1);
    }

    @Test
    public void updateElementOnConvertedList() {
        Arrays.sort(sampleArray);
        Integer[] boxedSampleArray = Arrays.stream( sampleArray ).boxed().toArray( Integer[]::new );
        List<Integer> integerList = Arrays.asList(boxedSampleArray);
        integerList.set(0, -1);
        assertThat(integerList.get(0)).isNotEqualTo(minOfSampleArray);
    }
}
