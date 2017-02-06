package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaBiPredicate;

import java.util.function.BiPredicate;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * A special kind of bi-function mapping its arguments to a {@code boolean}.
 * <p>
 * This interface bridges {@link LavaBiPredicate} and {@link BiPredicate} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedTest}.
 *
 * @param <X> the function's argument type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeBiPredicate<X, Y, E extends Exception>
    extends BiPredicate<X, Y>, LavaBiPredicate<X, Y, E> {

  /**
   * Test if the arguments matches the predicate.
   * Any exception raised during invocation will be passed on unchecked.
   *
   * @param x first argument to the match
   * @param y second argument to the match
   * @return {@code true} if {@code x, y} matches, {@code false} otherwise
   */
  @Override
  default boolean test(X x, Y y) {
    return asUnchecked(this).checkedTest(x, y);
  }

  /**
   * Safely casts between different {@link UnsafeBiPredicate}parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <E> required exception limit
   * @param biPredicate bi-predicate to adopt
   * @return {@code biPredicate} casted to the compatible parametrization
   *     {@link UnsafeBiPredicate}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  UnsafeBiPredicate<X, Y, E> castDown(UnsafeBiPredicate<? super X, ? super Y, ? extends E> biPredicate) {
    return (UnsafeBiPredicate<X, Y, E>) biPredicate;
  }
}
