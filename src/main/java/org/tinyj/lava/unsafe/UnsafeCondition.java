package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaCondition;

import java.util.function.BooleanSupplier;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * A supplier of values.
 * <p>
 * This interface bridges {@link LavaCondition} and {@link BooleanSupplier} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * There is no requirement that a new or distinct result be returned each time
 * the supplier is invoked.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedTest}.
 *
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeCondition<E extends Exception>
    extends BooleanSupplier, LavaCondition<E> {

  /**
   * Produce a value.
   * Any exception raised during invocation will be passed on unchecked.
   *
   *
   * @return a value
   */
  @Override
  default boolean getAsBoolean() {
    return asUnchecked(this).checkedTest();
  }

  /**
   * Safely casts between different {@link UnsafeCondition} parametrization
   *
   * @param <E> required exception limit
   * @param condition condition to adopt
   * @return {@code condition} casted to the compatible parametrization {@link UnsafeCondition}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  UnsafeCondition<E> castDown(UnsafeCondition<? extends E> condition) {
    return (UnsafeCondition<E>) condition;
  }
}
