package interfaces;
import java.time.LocalDateTime;

import enums.IssueResolution;
import enums.IssueStatus;

public interface IIssue {
    void resolve(IssueResolution resolution);

    void setStatus(IssueStatus status);

    String getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getLastModifiedAt();
}
