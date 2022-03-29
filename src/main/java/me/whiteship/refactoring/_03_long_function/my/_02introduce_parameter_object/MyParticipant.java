package me.whiteship.refactoring._03_long_function.my._02introduce_parameter_object;

import java.util.HashMap;
import java.util.Map;

public record MyParticipant(String username, Map<Integer, Boolean> homework) {
    public MyParticipant(String username) {
        this(username, new HashMap<>());
    }

    public double getRate(double total) {
        long count = this.homework.values().stream()
                .filter(v -> v == true)
                .count();
        return count * 100 / total;
    }

    public void setHomeworkDone(int index) {
        this.homework.put(index, true);
    }

}
