package me.whiteship.refactoring._02_duplicated_code.my.pullup;

import java.io.IOException;

public class MyReviewerDashboard extends MyDashboard {

    public void printReviewers() throws IOException {
        super.printUsernames(30);
    }


}
