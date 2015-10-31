package de.weltraumschaf.nas.api;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public final class Task implements Serializable {

    /**
     * Only needed for ECF generic transport
     */
    private static final long serialVersionUID = 5117254163782139591L;

    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private boolean finished;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(final boolean finished) {
        this.finished = finished;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, finished);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Task)) {
            return false;
        }

        final Task other = (Task) obj;

        return Objects.equals(id, other.id)
            && Objects.equals(title, other.title)
            && Objects.equals(description, other.description)
            && Objects.equals(dueDate, other.dueDate)
            && Objects.equals(finished, other.finished);
    }

    @Override
    public String toString() {
        return "Task{"
            + "id=" + id + ", "
            + "title=" + title + ", "
            + "description=" + description + ", "
            + "dueDate=" + dueDate + ", "
            + "finished=" + finished
            + '}';
    }
}
