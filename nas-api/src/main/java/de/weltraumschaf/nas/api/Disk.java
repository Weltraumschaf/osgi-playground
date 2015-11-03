package de.weltraumschaf.nas.api;

import java.util.Objects;

/**
 */
public final class Disk {

    private String filesystem = "";
    private String size = "";
    private String used = "";
    private String avail = "";
    private String capacity = "";
    private String mountedOn = "";

    public String filesystem() {
        return filesystem;
    }

    public String size() {
        return size;
    }

    public String used() {
        return used;
    }

    public String avail() {
        return avail;
    }

    public String capacity() {
        return capacity;
    }

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

    public static final class Builder {

        private final Disk product = new Disk();

        private Builder() {
            super();
        }

        public static Builder create() {
            return new Builder();
        }

        public Disk product() {
            return product;
        }

        public Builder filesystem(final String filesystem) {
            product.filesystem = filesystem;
            return this;
        }

        public Builder size(final String size) {
            product.size = size;
            return this;
        }

        public Builder used(final String used) {
            product.used = used;
            return this;
        }

        public Builder avail(final String avail) {
            product.avail = avail;
            return this;
        }

        public Builder capacity(final String capacity) {
            product.capacity = capacity;
            return this;
        }

        public Builder mountedOn(final String mountedOn) {
            product.mountedOn = mountedOn;
            return this;
        }
    }
}
