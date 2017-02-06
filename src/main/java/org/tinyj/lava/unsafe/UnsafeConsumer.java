package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaConsumer;

import java.util.function.Consumer;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * An operation on an input value.
 * <p>
 * This interface bridges {@link LavaConsumer} and {@link Consumer} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * Usually invoking a consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedAccept}
 *
 * @param <X> consumed value type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeConsumer<X, E extends Exception>
    extends Consumer<X>, LavaConsumer<X, E> {

  /**
   * Perform operation on input.
   * Any exception raised during invocation will be passed on unchecked.
   *
   * @param x consumed value
   */
  @Override
  default void accept(X x) {
    asUnchecked(this).checkedAccept(x);
  }

  /**
   * Safely casts between different {@link UnsafeConsumer} parametrization
   *
   * @param <X> accepted input type
   * @param <E> required exception limit
   * @param consumer consumer to adopt
   * @return {@code consumer} casted to the compatible parametrization
   *     {@link UnsafeConsumer}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  UnsafeConsumer<X, E> castDown(UnsafeConsumer<? super X, ? extends E> consumer) { return (UnsafeConsumer<X, E>) consumer; }
}
