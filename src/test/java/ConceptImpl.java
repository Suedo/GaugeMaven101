import com.thoughtworks.gauge.Step;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConceptImpl {
    String source;
    String dest;
    private List<String> strings;
    private int wc;


    @Step("Book flight from <source> to <destination>")
    public void BookFlight(String source, String dest) {
        this.source = source;
        this.dest = dest;
        System.out.println("Booking a flight to " + dest);
    }

    @Step("Travel to airport")
    public void TravelToAirport() {
        System.out.println("Travelling to " + source + " airport");
    }

    @Step("Onboard flight")
    public void Boarding() {
        System.out.println("Getting on the plane");
    }

    @Step("Arrive at <destination>")
    public void ArriveAtDest(String dest) {
        assertThat(this.dest).isEqualToIgnoringCase(dest);
        System.out.println("We have landed at our destination " + dest);
    }

    // the doc says the file path is passed
    // but actually, the whole contents of the file is passed
//    @Step("Check that file <ipfile> exists")
//    public void fileexists(String filecontents) {
//        boolean exists = Files.exists(Path.of(path));
//        assertThat(exists).isEqualTo(true);
//        this.filepath = Path.of(path);
//    }

    @Step("Read contents of file <ipfile> into memory")
    public void readFileLines(String filecontents) {
        strings = Arrays.asList(filecontents.split(System.lineSeparator()));
        assertThat(strings.size()).isGreaterThan(0);
    }

    @Step("Count the number of words in the file")
    public void fileWordCount() {
        int count = 0;
        for (String line : this.strings) {
            count += line.trim().split(" ").length;
        }
        this.wc = count;
    }

    @Step("Display the count")
    public void printFileCount() {
        System.out.println(String.format("#words : %s", this.wc));
    }
}
