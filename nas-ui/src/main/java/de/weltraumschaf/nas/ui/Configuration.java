package de.weltraumschaf.nas.ui;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
public final class Configuration {

    static final String PID = "nas.cfg";

    private static final Logger LOG = Logger.getLogger(Configuration.class.getName());

    private String title = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void updated() {
        LOG.log(Level.CONFIG, "Config updated: {0}", this.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Configuration)) {
            return false;
        }

        final Configuration other = (Configuration) obj;
        return Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
        return "Configuration{"
            + "title=" + title
            + '}';
    }

}
