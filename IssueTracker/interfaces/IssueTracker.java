package interfaces;

import java.awt.*;
import java.time.LocalDateTime;

import enums.IssuePriority;
import enums.IssueType;
import enums.IssueStatus;
import enums.IssueResolution;
import issues.Issue;

public interface IssueTracker {

    Issue[] findAll(Component component, IssueStatus status);

    Issue[] findAll(Component component, IssuePriority priority);

    Issue[] findAll(Component component, IssueType type);

    Issue[] findAll(Component component, IssueResolution resolution);

    Issue[] findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime);

    Issue[] findAllBefore(LocalDateTime dueTime);
}
