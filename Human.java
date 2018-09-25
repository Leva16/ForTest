package library;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private int readSkill;

    public List<String> bookName = new ArrayList<>();

    public Human(final String name, final int readSkill) {
        this.name = name;
        this.readSkill = readSkill;
    }

    public String getName() {
        return name;
    }

    public int getReadSkill() {
        return readSkill;
    }

}
