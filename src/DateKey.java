public class DateKey {
    private final int month;
    private final int day;

    public DateKey(int month, int day) {
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateKey)) return false;
        DateKey key = (DateKey) o;
        return month == key.month && day == key.day;
    }

    @Override
    public int hashCode() {
        return (month << 16) + day;
    }
}