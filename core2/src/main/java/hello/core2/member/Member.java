package hello.core2.member;

public class Member {
    private Long id;
    private String username;
    private Grade grade;

    public Member(Long id, String username, Grade grade) {
        this.id = id;
        this.username = username;
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
