package user;

import java.time.LocalDateTime;

public class User {

    private String name;
    private LocalDateTime creationTime;

    public User(String name, LocalDateTime creationTime) {
        this.name = name;
        this.setCreationTime(creationTime);
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "User [userName=" + name + ", createdAt=" + creationTime + "]";
    }

}
