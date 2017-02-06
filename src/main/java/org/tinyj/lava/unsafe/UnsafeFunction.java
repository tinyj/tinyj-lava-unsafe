package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaFunction;

import java.util.function.Function;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * A function maps its argument to a result.
 * <p>
 * This interface bridges {@link LavaFunction} and {@link Function} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedApply}.
 *
 * @param <X> the function's argument type
 * @param <R> the function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeFunction<X, R, E extends Exception>
    extends Function<X, R>, LavaFunction<X, R, E> {

  /**
   * Apply the function to an argument
   * Any exception raised during invocation will be passed on unchecked.
   *
   * @param x argument to map
   * @return the function's result
   */
  @Override
  default R apply(X x) {
    return asUnchecked(this).checkedApply(x);
  }

  /**
   * Safely casts between different {@link UnsafeFunction} parametrization
   *
   * @param <X> accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param function function to adopt
   * @return {@code function} casted to the compatible parametrization
   *     {@link UnsafeFunction}{@code <X, R, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, R, E extends Exception>
  UnsafeFunction<X, R, E> castDown(UnsafeFunction<? super X, ? extends R, ? extends E> function) { return (UnsafeFunction<X, R, E>) function; }
}
