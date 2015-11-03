package de.weltraumschaf.nas.ui;

import de.weltraumschaf.nas.ui.resources.NasResource;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 */
public final class ContentRepositoryApplication extends Application {

    private static final Set<Class<?>> CLASSES;

    static {
        final Set<Class<?>> tmp = new HashSet<>();
        tmp.add(NasResource.class);
        CLASSES = Collections.unmodifiableSet(tmp);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return CLASSES;
    }
}
