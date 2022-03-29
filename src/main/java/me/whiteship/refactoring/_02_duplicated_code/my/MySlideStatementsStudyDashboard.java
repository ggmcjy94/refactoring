package me.whiteship.refactoring._02_duplicated_code.my;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//Slide Statements
// 관련있는 코드끼리 묶여있어야 코드를 더 쉽게 이해할 수 있다.
// 함수에서 사용할 변수를 상단에 미리 정의하기 보다는, 해당변수를 사용하는 코드 바로 위에 선언
// 관련있는 코드끼리 묶은 다음 함수 추출하기(Extract Function)를 사용해서 더 깔끔하게 분리할 수도 있다.
// * 메서드내 지역변수는 사용직전 선언하자 위에 뭉탱이로 올려 놓지 말고 ㅋㅋㅋㅋ
public class MySlideStatementsStudyDashboard {

    private void printParticipants(int eventId) throws IOException {
        // Get github issue to check homework
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);

        // Get participants
        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));

        // Print participants
        participants.forEach(System.out::println);
    }

    private void printReviewers() throws IOException {
        // Get github issue to check homework
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        // Get reviewers
        Set<String> reviewers = new HashSet<>();
        issue.getComments().forEach(c -> reviewers.add(c.getUserName()));

        // Print reviewers
        reviewers.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        MySlideStatementsStudyDashboard studyDashboard = new MySlideStatementsStudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);

    }

}
