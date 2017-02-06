package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaPredicate;

import java.util.function.Predicate;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * A special kind of function mapping its argument to a {@code boolean} result.
 * <p>
 * This interface bridges {@link LavaPredicate} and {@link Predicate} by
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
public interface UnsafePredicate<X, E extends Exception>
    extends Predicate<X>, LavaPredicate<X, E> {

  /**
   * Test if the argument matches the predicate.
   * Any exception raised during invocation will be passed on unchecked.
   *
   * @param x argument to the match
   * @return {@code true} if {@code x} matches, {@code false} otherwise
   */
  @Override
  default boolean test(X x) {
    return asUnchecked(this).checkedTest(x);
  }

  /**
   * Safely casts between different {@link UnsafePredicate} parametrization
   *
   * @param <X> accepted argument type
   * @param <E> required exception limit
   * @param predicate predicate to adopt
   * @return {@code predicate} casted to the compatible parametrization
   *     {@link UnsafePredicate}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  UnsafePredicate<X, E> castDown(UnsafePredicate<? super X, ? extends E> predicate) { return (UnsafePredicate<X, E>) predicate; }
}
