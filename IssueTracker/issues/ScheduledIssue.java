package issues;

import java.time.LocalDateTime;

import component.Component;
import enums.IssuePriority;
import enums.IssueType;
import exceptions.InvalidReporterException;
import user.User;

public class ScheduledIssue extends Issue {
    protected LocalDateTime dueTime;

    public ScheduledIssue(IssuePriority priority, Component component, User reporter, String description,
                          LocalDateTime dueTime) throws InvalidReporterException {
        super(priority, component, reporter, description);
        this.dueTime = dueTime;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    @Override
    public IssueType getType() {
        return null;
    }
}
