package issues;

import component.Component;
import enums.IssuePriority;
import enums.IssueType;
import exceptions.InvalidReporterException;
import user.User;

import java.time.LocalDateTime;

public class Task extends ScheduledIssue {
    public Task(IssuePriority priority, Component component, User reporter, String description, LocalDateTime dueTime)
            throws InvalidReporterException {
        super(priority, component, reporter, description, dueTime);
    }

    @Override
    public IssueType getType() {
        return IssueType.TASK;
    }
}
