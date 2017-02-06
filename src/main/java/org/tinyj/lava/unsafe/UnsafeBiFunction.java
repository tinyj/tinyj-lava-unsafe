package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaBiFunction;

import java.util.function.BiFunction;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * A bi-function maps its two argument to a result.
 * <p>
 * This interface bridges {@link LavaBiFunction} and {@link BiFunction} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same arguments yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedApply}.
 *
 * @param <X> the bi-function's first argument type
 * @param <Y> the bi-function's second argument type
 * @param <R> the bi-function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeBiFunction<X, Y, R, E extends Exception>
    extends BiFunction<X, Y, R>, LavaBiFunction<X, Y, R, E> {

  /**
   * Apply the function to arguments.
   * Any exception raised during invocation will be passed on unchecked.
   *
   * @param x first argument to map
   * @param y second argument to map
   * @return the function's result
   */
  @Override
  default R apply(X x, Y y) {
    return asUnchecked(this).checkedApply(x, y);
  }

  /**
   * Safely casts between different {@link UnsafeBiFunction} parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param biFunction bi-function to adopt
   * @return {@code biFunction} casted to the compatible parametrization
   *     {@link UnsafeBiFunction}{@code <X, Y, R, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, R, E extends Exception>
  UnsafeBiFunction<X, Y, R, E> castDown(UnsafeBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction) {
    return (UnsafeBiFunction<X, Y, R, E>) biFunction;
  }
}
