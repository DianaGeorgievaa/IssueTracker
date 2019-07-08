package issues;

import java.time.LocalDateTime;

import component.Component;
import enums.IssueType;
import enums.IssuePriority;
import exceptions.InvalidReporterException;
import user.User;

public class NewFeature extends ScheduledIssue {
    public NewFeature(IssuePriority priority, Component component, User reporter, String description,
                      LocalDateTime dueTime) throws InvalidReporterException {
        super(priority, component, reporter, description, dueTime);
    }

    @Override
    public IssueType getType() {
        return IssueType.NEW_FEATURE;
    }
}
