package de.weltraumschaf.nas.serverstatus.impl;

import de.weltraumschaf.nas.serverstatus.api.Harddisk;
import de.weltraumschaf.nas.serverstatus.api.Pool;
import de.weltraumschaf.nas.serverstatus.api.ServerStatus;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Default implementation.
 */
public final class ServerStatusImpl implements ServerStatus {

    @Override
    public Collection<Harddisk> disks() {
        return new ArrayList<>();
    }

    @Override
    public Collection<Pool> pools() {
        return new ArrayList<>();
    }

}
