package de.weltraumschaf.nas.impl;

import de.weltraumschaf.nas.api.Pool;
import java.util.Objects;

/**
 */
public final class PoolImpl implements Pool {

    private String name;
    private String size;
    private String alloc;
    private String free;
    private String frag;
    private String expandsz;
    private String cap;
    private String dedup;
    private String health;

    @Override
    public String name() {
        return name;
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public String alloc() {
        return alloc;
    }

    @Override
    public String free() {
        return free;
    }

    @Override
    public String frag() {
        return frag;
    }

    @Override
    public String expandsz() {
        return expandsz;
    }

    @Override
    public String cap() {
        return cap;
    }

    @Override
    public String dedup() {
        return dedup;
    }

    @Override
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

    static final class Builder {

        private final PoolImpl product = new PoolImpl();

        private Builder() {
            super();
        }

        static Builder create() {
            return new Builder();
        }

        Pool product() {
            return product;
        }

        Builder name(final String name) {
            product.name = name;
            return this;
        }

        Builder size(final String size) {
            product.size = size;
            return this;
        }

        Builder alloc(final String alloc) {
            product.alloc = alloc;
            return this;
        }

        Builder free(final String free) {
            product.free = free;
            return this;
        }

        Builder frag(final String frag) {
            product.frag = frag;
            return this;
        }

        Builder expandsz(final String expandsz) {
            product.expandsz = expandsz;
            return this;
        }

        Builder cap(final String cap) {
            product.cap = cap;
            return this;
        }

        Builder dedup(final String dedup) {
            product.dedup = dedup;
            return this;
        }

        Builder health(final String health) {
            product.health = health;
            return this;
        }
    }
}
