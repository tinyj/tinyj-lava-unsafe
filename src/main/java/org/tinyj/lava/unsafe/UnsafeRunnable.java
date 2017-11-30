package org.tinyj.lava.unsafe;

import org.tinyj.lava.LavaRunnable;

import static org.tinyj.lava.unsafe.Unsafe.asUnchecked;

/**
 * A runnable task.
 * <p>
 * This interface bridges {@link LavaRunnable} and {@link Runnable} by
 * tricking the compiler to pass checked exceptions as unchecked.
 * <p>
 * Usually invoking a runnable results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedRun}.
 *
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface UnsafeRunnable<E extends Exception>
    extends Runnable, LavaRunnable<E> {

  /**
   * Execute the task.
   * Any exception raised during invocation will be passed on unchecked.
   */
  @Override
  default void run() {
    asUnchecked(this).checkedRun();
  }

  /**
   * Safely casts between different {@link UnsafeRunnable} parametrization
   *
   * @param <E> required exception limit
   * @param runnable runnable to adopt
   * @return {@code runnable} casted to the compatible parametrization
   *     {@link UnsafeRunnable}{@code <E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  UnsafeRunnable<E> castDown(UnsafeRunnable<? extends E> runnable) {
    return (UnsafeRunnable<E>) runnable;
  }
}
