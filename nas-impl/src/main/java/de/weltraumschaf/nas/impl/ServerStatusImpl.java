package de.weltraumschaf.nas.impl;

import de.weltraumschaf.nas.api.Disk;
import de.weltraumschaf.nas.api.Pool;
import de.weltraumschaf.nas.api.ServerStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Default implementation.
 */
public final class ServerStatusImpl implements ServerStatus {

    @Override
    public Collection<Disk> disks() {
        final Collection<Disk> disks = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            disks.add(
                DiskImpl.Builder.create()
                .filesystem("fs" + i)
                .product());
        }

        return Collections.unmodifiableCollection(disks);
    }

    @Override
    public Collection<Pool> pools() {
        final Collection<Pool> pools = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            pools.add(
                PoolImpl.Builder.create()
                .name("foo" + i)
                .product());
        }

        return Collections.unmodifiableCollection(pools);
    }

}
