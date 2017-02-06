package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaBiConsumer;

import java.util.function.BiConsumer;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * An operation on two input values.
 * <p>
 * This interface bridges {@link LavaBiConsumer} and {@link BiConsumer} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * Usually invoking a bi-consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedAccept}.
 *
 * @param <X> first consumed value type
 * @param <Y> second consumed value type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeBiConsumer<X, Y, E extends Exception>
    extends BiConsumer<X, Y>, LavaBiConsumer<X, Y, E> {

  /**
   * Perform operation on inputs.
   * Any exception raised during invocation will be passed on unchecked.
   *
   * @param x first consumed value
   * @param y second consumed value
   */
  @Override
  default void accept(X x, Y y) {
    asUnchecked(this).checkedAccept(x, y);
  }

  /**
   * Safely casts between different {@link UnsafeBiConsumer} parametrization
   *
   * @param <X> first accepted input type
   * @param <Y> second accepted input type
   * @param <E> required exception limit
   * @param biConsumer bi-consumer to adopt
   * @return {@code biConsumer} casted to the compatible parametrization
   *     {@link UnsafeBiConsumer}{@code <X, Y, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  UnsafeBiConsumer<X, Y, E> castDown(UnsafeBiConsumer<? super X, ? super Y, ? extends E> biConsumer) {
    return (UnsafeBiConsumer<X, Y, E>) biConsumer;
  }
}
