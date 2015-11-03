package de.weltraumschaf.nas.api;

import java.util.Objects;

/**
 */
public final class Pool {

    private String name;
    private String size;
    private String alloc;
    private String free;
    private String frag;
    private String expandsz;
    private String cap;
    private String dedup;
    private String health;

    public String name() {
        return name;
    }

    public String size() {
        return size;
    }

    public String alloc() {
        return alloc;
    }

    public String free() {
        return free;
    }

    public String frag() {
        return frag;
    }

    public String expandsz() {
        return expandsz;
    }

    public String cap() {
        return cap;
    }

    public String dedup() {
        return dedup;
    }

    public String health() {
        return health;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, alloc, free, frag, expandsz, cap, dedup, health);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Pool)) {
            return false;
        }

        final Pool other = (Pool) obj;

        return Objects.equals(name, other.name())
            && Objects.equals(size, other.size())
            && Objects.equals(alloc, other.alloc())
            && Objects.equals(free, other.free())
            && Objects.equals(frag, other.frag())
            && Objects.equals(expandsz, other.expandsz())
            && Objects.equals(cap, other.cap())
            && Objects.equals(dedup, other.dedup())
            && Objects.equals(health, other.health());
    }

    @Override
    public String toString() {
        return "PoolImpl{"
            + "name=" + name + ", "
            + "size=" + size + ", "
            + "alloc=" + alloc + ", "
            + "free=" + free + ", "
            + "frag=" + frag + ", "
            + "expandsz=" + expandsz + ", "
            + "cap=" + cap + ", "
            + "dedup=" + dedup + ", "
            + "health=" + health
            + '}';
    }

    public static final class Builder {

        private final Pool product = new Pool();

        private Builder() {
            super();
        }

        public static Builder create() {
            return new Builder();
        }

        public Pool product() {
            return product;
        }

        public Builder name(final String name) {
            product.name = name;
            return this;
        }

        public Builder size(final String size) {
            product.size = size;
            return this;
        }

        public Builder alloc(final String alloc) {
            product.alloc = alloc;
            return this;
        }

        public Builder free(final String free) {
            product.free = free;
            return this;
        }

        public Builder frag(final String frag) {
            product.frag = frag;
            return this;
        }

        public Builder expandsz(final String expandsz) {
            product.expandsz = expandsz;
            return this;
        }

        public Builder cap(final String cap) {
            product.cap = cap;
            return this;
        }

        public Builder dedup(final String dedup) {
            product.dedup = dedup;
            return this;
        }

        public Builder health(final String health) {
            product.health = health;
            return this;
        }
    }
}
