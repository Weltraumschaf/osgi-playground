package de.weltraumschaf.nas.ui;

import de.weltraumschaf.nas.api.ServerStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.weltraumschaf.nas.api.Task;
import de.weltraumschaf.nas.api.TaskService;

public final class TaskListServlet extends HttpServlet {

    private static final long serialVersionUID = 34992072289535683L;

    private TaskService taskService;

    private ServerStatus serverStatusService;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final String taskId = req.getParameter("taskId");
        final PrintWriter writer = resp.getWriter();

        if (taskId != null && taskId.length() > 0) {
            showTask(writer, taskId);
        } else {
            showTaskList(writer);
        }
    }

    private void showTaskList(final PrintWriter writer) {
        writer.println("<h1>Tasks</h1>");
        final Collection<Task> tasks = taskService.getTasks();

        for (Task task : tasks) {
            writer.println("<a href=\"?taskId=" + task.getId() + "\">"
                + task.getTitle() + "</a><br/>");
        }
    }

    private void showTask(final PrintWriter writer, final String taskId) {
        final SimpleDateFormat sdf = new SimpleDateFormat();
        final Task task = taskService.getTask(taskId);

        if (task != null) {
            writer.println("<h1>Task " + task.getTitle() + " </h1>");

            if (task.getDueDate() != null) {
                writer.println("Due date: " + sdf.format(task.getDueDate()) + "<br/>");
            }

            writer.println(task.getDescription());
        } else {
            writer.println("Task with id " + taskId + " not found");
        }

    }

    public void setTaskService(final TaskService taskService) {
        this.taskService = taskService;
    }

    public void setServerStatusService(final ServerStatus serverStatusService) {
        this.serverStatusService = serverStatusService;
    }

}
