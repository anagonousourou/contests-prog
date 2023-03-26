import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    LocalDateTime after;
    public Gigasecond(LocalDate moment) {
        this.after = moment.atTime(0, 0).plusSeconds(1_000_000_000L);
    }

    public Gigasecond(LocalDateTime moment) {
        this.after = moment.plusSeconds(1_000_000_000L);
    }

    public LocalDateTime getDateTime() {
        return this.after;
    }
}
