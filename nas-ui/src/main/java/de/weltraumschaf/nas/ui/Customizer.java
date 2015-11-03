package de.weltraumschaf.nas.ui;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.servlet.Servlet;
import javax.ws.rs.core.Application;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public final class Customizer implements ServiceTrackerCustomizer {

    private static final Logger LOG = LoggerFactory.getLogger(Customizer.class.getName());
    private final BundleContext context;

    Customizer(final BundleContext context) {
        super();
        this.context = context;
    }

    private Dictionary createProps(final ServiceReference reference) {
        final String alias = reference.getProperty("alias").toString();
        LOG.debug("Alias: " + alias);
        final Dictionary<String, String> props = new Hashtable<>();
        props.put("alias", alias);
        return props;
    }

    @Override
    public Object addingService(final ServiceReference reference) {
        final Application app = (Application) context.getService(reference);
        LOG.debug("Adding JAX-RS application: " + app);

        //For each JAX-RS Application, create a servlet wrapping that Application instance
        final ServletContainer servlet = new ServletContainer(app);

        final Bundle sourceBundle = reference.getBundle();
        final BundleContext sourceContext = sourceBundle.getBundleContext();
        final ServiceRegistration reg = sourceContext.registerService(
            Servlet.class.getName(), servlet, createProps(reference));

        return reg;
    }

    @Override
    public void modifiedService(final ServiceReference reference, final Object service) {
        final ServiceRegistration reg = (ServiceRegistration) service;
        LOG.debug("Modifying JAX-RS application: " + reg);
        reg.setProperties(createProps(reference));
    }

    @Override
    public void removedService(final ServiceReference reference, final Object service) {
        final ServiceRegistration reg = (ServiceRegistration) service;
        LOG.debug("Removing JAX-RS application: " + reg);
        reg.unregister();
        context.ungetService(reference);
    }
}
