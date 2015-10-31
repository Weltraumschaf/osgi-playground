package de.weltraumschaf.nas.serverstatus.impl;

import de.weltraumschaf.nas.serverstatus.api.Disk;
import java.util.Objects;

/**
 */
public final class DiskImpl implements Disk {

    private String filesystem = "";
    private String size = "";
    private String used = "";
    private String avail = "";
    private String capacity = "";
    private String mountedOn = "";

    @Override
    public String filesystem() {
        return filesystem;
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public String used() {
        return used;
    }

    @Override
    public String avail() {
        return avail;
    }

    @Override
    public String capacity() {
        return capacity;
    }

    @Override
    public String mountedOn() {
        return mountedOn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filesystem, size, used, avail, capacity, mountedOn);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Disk)) {
            return false;
        }

        final Disk other = (Disk) obj;
        return Objects.equals(filesystem, other.filesystem())
            && Objects.equals(size, other.size())
            && Objects.equals(used, other.used())
            && Objects.equals(avail, other.avail())
            && Objects.equals(capacity, other.capacity())
            && Objects.equals(mountedOn, other.mountedOn());
    }

    @Override
    public String toString() {
        return "HarddiskImpl{"
            + "filesystem=" + filesystem + ", "
            + "size=" + size + ", "
            + "used=" + used + ", "
            + "avail=" + avail + ", "
            + "capacity=" + capacity + ", "
            + "mountedOn=" + mountedOn
            + '}';
    }

    static final class Builder {

        private final DiskImpl product = new DiskImpl();

        private Builder() {
            super();
        }

        static Builder create() {
            return new Builder();
        }

        Disk product() {
            return product;
        }

        Builder filesystem(final String filesystem) {
            product.filesystem = filesystem;
            return this;
        }

        Builder size(final String size) {
            product.size = size;
            return this;
        }

        Builder used(final String used) {
            product.used = used;
            return this;
        }

        Builder avail(final String avail) {
            product.avail = avail;
            return this;
        }

        Builder capacity(final String capacity) {
            product.capacity = capacity;
            return this;
        }

        Builder mountedOn(final String mountedOn) {
            product.mountedOn = mountedOn;
            return this;
        }
    }
}
