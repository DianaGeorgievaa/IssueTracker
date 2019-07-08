package issues;

import component.Component;
import enums.IssuePriority;
import enums.IssueType;
import exceptions.InvalidReporterException;
import user.User;

public class Bug extends Issue {

    public Bug(IssuePriority priority, Component component, User reporter, String description)
            throws InvalidReporterException {
        super(priority, component, reporter, description);
    }

    @Override
    public IssueType getType() {
        return IssueType.BUG;
    }
}
