package me.whiteship.refactoring._03_long_function.my._03preserve_whole_object;

import java.util.HashMap;
import java.util.Map;

public record MyParticipant(String username, Map<Integer, Boolean> homework) {
    public MyParticipant(String username) {
        this(username, new HashMap<>());
    }

    public void setHomeworkDone(int index) {
        this.homework.put(index, true);
    }


    double getRate(int myStudyDashboard) {
        long count = homework().values().stream()
                .filter(v -> v == true)
                .count();
        return (double) (count * 100 / myStudyDashboard);
    }
}
