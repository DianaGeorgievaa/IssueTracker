package issues;
import java.time.LocalDateTime;
import component.Component;
import generators.IdGenerator;
import interfaces.IIssue;
import user.User;

import enums.IssuePriority;
import enums.IssueResolution;
import enums.IssueStatus;
import enums.IssueType;

import exceptions.InvalidReporterException;
import exceptions.InvalidPriorityException;
import exceptions.InvalidDescriptionException;
import exceptions.InvalidComponentException;


public abstract class Issue implements IIssue {

    private String id;
    private Component component;
    private IssuePriority priority;
    private IssueResolution resolution;
    private IssueStatus status;
    private User assignee;
    private User reporter;
    private LocalDateTime creationTime;
    private LocalDateTime lastModifiedAt;
    private String description;

    public Issue(IssuePriority priority, Component component, User reporter, String description)
            throws InvalidReporterException {
        validateReporter(reporter);
        validateDescription(description);
        validatePriority(priority);
        validateComponent(component);
        this.priority = priority;
        this.component = component;
        this.reporter = reporter;
        this.id = component.getShortName() + "-" + IdGenerator.generate();
        this.description = description;
        setCreatedAt(LocalDateTime.now());
        this.status = IssueStatus.OPEN;
        this.resolution = IssueResolution.UNRESOLVED;
    }

    public abstract IssueType getType();

    public IssuePriority getPriority() {
        return this.priority;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
        setLastModifiedAt(LocalDateTime.now());
    }

    public Component getComponent() {
        return this.component;
    }

    public void setComponent(Component component) {
        this.component = component;
        setLastModifiedAt(LocalDateTime.now());
    }

    public IssueStatus getStatus() {
        return this.status;
    }

    public IssueResolution getResolution() {
        return this.resolution;
    }

    public User getAssignee() {
        return this.assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
        setLastModifiedAt(LocalDateTime.now());
    }

    public User getReporter() {
        return this.reporter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        setLastModifiedAt(LocalDateTime.now());
    }

    @Override
    public void resolve(IssueResolution resolution) {
        setResolution(resolution);
    }

    @Override
    public void setStatus(IssueStatus status) {
        this.status = status;
        setLastModifiedAt(LocalDateTime.now());
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.creationTime;
    }

    @Override
    public LocalDateTime getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    private void validateReporter(User user) throws InvalidReporterException {
        if (user == null) {
            throw new InvalidReporterException("Reporter could not be null");
        }
    }

    private void validateDescription(String descrition) {
        if (descrition == null) {
            throw new InvalidDescriptionException("Invalid description");
        }
    }

    private void validatePriority(IssuePriority priority) {
        if (priority == null) {
            throw new InvalidPriorityException("Invalid priority");
        }
    }

    private void validateComponent(Component component) {
        if (component == null) {
            throw new InvalidComponentException("Invalid component");
        }
    }

    private void setResolution(IssueResolution resolution) {
        this.resolution = resolution;
        setLastModifiedAt(LocalDateTime.now());
    }

    private void setCreatedAt(LocalDateTime creationTime) {
        this.creationTime = creationTime;
        setLastModifiedAt(creationTime);
    }

    private void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

}
