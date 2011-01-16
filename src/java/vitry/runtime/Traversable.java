package vitry.runtime;

public interface Traversable<T>
    {
        Traversable<T> parent();

        Seq<Traversable<T>> children();

        boolean hasParentLink();

        boolean classHasParentLink();
    }
