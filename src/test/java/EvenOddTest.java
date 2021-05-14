import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EvenOddTest {

    String[] arr = "2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97".split(", ");
    List<String> somePrimes = Arrays.asList(arr);


    @Step("The number <number> is <status>.")
    public void setLanguageVowels(Integer number, String evenodd) {
        String status = number % 2 == 0 ? "even" : "odd";
        assertThat(status).isEqualToIgnoringCase(evenodd);
        System.out.println(String.format("%d is %s", number, status));
    }

    @Step("The number <number> is <status> <table>")
    public void implementation1(String number, String status, Table numberTable) {
        for (TableRow row : numberTable.getTableRows()) {
            String actual = isPrime(row.getCell("number"));
            String expected = row.getCell("status");
            System.out.println(row.getCell("number") + " :: " + actual);
            assertThat(expected).isEqualToIgnoringCase(actual);
        }
    }

    @Step("Check numbers in this table <table>")
    public void numberCheck(Table numberTable) {
        for (TableRow row : numberTable.getTableRows()) {
            String actual = isPrime(row.getCell("number"));
            String expected = row.getCell("status");
            System.out.println(row.getCell("number") + " :: " + actual);
            assertThat(expected).isEqualToIgnoringCase(actual);
        }
    }

    private String isPrime(String number) {
        return somePrimes.contains(number) ? "prime" : "nope";
    }


}
