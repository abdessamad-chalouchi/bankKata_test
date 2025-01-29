package bankKata;

import java.time.LocalDate;
import java.util.List;

public interface DateProvider {
    LocalDate getCurrentDate();
}

// Production implementation (uses real dates)
class SystemDateProvider implements DateProvider {
    @Override
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}

// For Test implementation
class MockDateProvider implements DateProvider {
    private final List<LocalDate> dates;
    private int index = 0;

    public MockDateProvider(List<LocalDate> dates) {
        this.dates = dates;
    }

    @Override
    public LocalDate getCurrentDate() {
        return dates.get(index++);
    }
}