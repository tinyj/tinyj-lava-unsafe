package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaSupplier;

import java.util.function.Supplier;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * A supplier of values.
 * <p>
 * This interface bridges {@link LavaSupplier} and {@link Supplier} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * There is no requirement that a new or distinct result be returned each time
 * the supplier is invoked.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedGet}.
 *
 * @param <R> type of supplied values
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeSupplier<R, E extends Exception>
    extends Supplier<R>, LavaSupplier<R, E> {

  /**
   * Produce a value.
   * Any exception raised during invocation will be passed on unchecked.
   */
  @Override
  default R get() {
    return asUnchecked(this).checkedGet();
  }

  /**
   * Safely casts between different {@link UnsafeSupplier} parametrization
   *
   * @param <R> required result type
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return {@code supplier} casted to the compatible parametrization
   *     {@link UnsafeSupplier}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <R, E extends Exception>
  UnsafeSupplier<R, E> castDown(UnsafeSupplier<? extends R, ? extends E> supplier) {
    return (UnsafeSupplier<R, E>) supplier;
  }
}
