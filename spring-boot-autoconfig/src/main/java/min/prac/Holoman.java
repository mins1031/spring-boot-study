package min.prac;

public class Holoman {
    String name;

    long howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHowLong() {
        return howLong;
    }

    public void setHowLong(long howLong) {
        this.howLong = howLong;
    }

    @Override
    public String toString() {
        return "Holoman{" +
                "name='" + name + '\'' +
                ", howLong=" + howLong +
                '}';
    }
}
