package de.weltraumschaf.nas.ui;

import java.util.Dictionary;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

/**
 */
public final class ConfigurationUpdater implements ManagedService {

    private final Configuration config = new Configuration();

    @Override
    public void updated(final Dictionary input) throws ConfigurationException {
        if (null == input) {
            return;
        }

        config.setTitle((String)input.get("title"));
        config.updated();
    }

}
