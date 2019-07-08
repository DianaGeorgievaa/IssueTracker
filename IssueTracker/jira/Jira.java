package jira;

import enums.IssuePriority;
import enums.IssueStatus;
import interfaces.IssueTracker;
import issues.Issue;

import java.awt.Component;
import java.time.LocalDateTime;

import enums.IssueType;
import enums.IssueResolution;
import issues.ScheduledIssue;

public class Jira implements IssueTracker {

    private Issue[] issues;

    public Jira(Issue[] issues) {
        this.issues = issues;
    }

    @Override
    public Issue[] findAll(Component component, IssueStatus status) {
        int size = this.issues.length;
        Issue[] filteredIssues = new Issue[size];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            Issue issue = this.issues[i];
            if (issue != null && component.getName().equals(issue.getComponent().getName()) && status == issue.getStatus()) {
                filteredIssues[currentIndex++] = issue;
            }
        }
        return filteredIssues;

    }

    @Override
    public Issue[] findAll(Component component, IssuePriority priority) {
        int size = this.issues.length;
        Issue[] filteredIssues = new Issue[size];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            Issue issue = issues[i];
            if (issue != null && component.getName().equals(issue.getComponent().getName()) && priority == issue.getPriority()) {
                filteredIssues[currentIndex++] = issue;
            }
        }

        return filteredIssues;
    }

    @Override
    public Issue[] findAll(Component component, IssueType type) {
        int size = this.issues.length;
        Issue[] filteredIssues = new Issue[size];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            Issue issue = issues[i];
            if (issue != null && component.getName().equals(issue.getComponent().getName()) && type == issue.getType()) {
                filteredIssues[currentIndex++] = issue;
            }
        }

        return filteredIssues;
    }

    @Override
    public Issue[] findAll(Component component, IssueResolution resolution) {
        int size = this.issues.length;
        Issue[] filteredIssues = new Issue[size];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            Issue issue = issues[i];
            if (issue != null && component.getName().equals(issue.getComponent().getName()) && resolution == issue.getResolution()) {
                filteredIssues[currentIndex++] = issue;
            }
        }

        return filteredIssues;
    }

    @Override
    public Issue[] findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime) {
        int size = this.issues.length;
        Issue[] filteredIssues = new Issue[size];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            Issue issue = issues[i];
            if (issue != null && issue.getCreatedAt().isAfter(startTime) && issue.getCreatedAt().isBefore(endTime)) {
                filteredIssues[currentIndex++] = issue;
            }
        }

        return filteredIssues;
    }

    @Override
    public Issue[] findAllBefore(LocalDateTime dueTime) {
        int size = this.issues.length;
        Issue[] filteredIssues = new Issue[size];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            Issue issue = issues[i];
            if (issue != null && (issue.getType() == IssueType.NEW_FEATURE || issue.getType() == IssueType.TASK)) {
                ScheduledIssue scheduledIssue = (ScheduledIssue) issue;
                if (scheduledIssue.getDueTime().isBefore(dueTime)) {
                    filteredIssues[currentIndex++] = scheduledIssue;
                }
            }
        }

        return filteredIssues;
    }
}
