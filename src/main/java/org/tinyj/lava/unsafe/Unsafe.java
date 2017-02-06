package org.tinyj.lava.unsafe;

import org.tinyj.lava.*;

import java.util.function.*;

/**
 * Utility class
 */
public class Unsafe {

  /**
   * Do not instantiate
   */
  protected Unsafe() { assert false : "Unsafe is a utility class, static use only."; }

  /**
   * This method simplifies the creation of {@link UnsafeRunnable} lambdas in
   * places where a {@link Runnable} is expected or disambiguation between
   * {@link UnsafeSupplier} and {@link UnsafeRunnable} is required.
   * <p>
   * E.g. {@code new Thread(Unsafe.runnable(() -> {...code throwing checked exception...}))}
   *
   * @param <E> upper exception limit
   * @param runnable lambda
   * @return {@code runnable}
   */
  public static <E extends Exception> UnsafeRunnable<E>
  runnable(UnsafeRunnable<? extends E> runnable) { return UnsafeRunnable.castDown(runnable); }

  /**
   * This method simplifies the creation of {@link UnsafeSupplier} lambdas in
   * places where a {@link Supplier} is expected or disambiguation between
   * {@link UnsafeSupplier} and {@link UnsafeRunnable} is required.
   * <p>
   * E.g. {@code Stream.generate(Unsafe.supplier(() -> {...code throwing checked exception...}))}
   *
   * @param <R> return type
   * @param <E> upper exception limit
   * @param supplier lambda
   * @return {@code supplier}
   */
  public static <R, E extends Exception> UnsafeSupplier<R, E>
  supplier(UnsafeSupplier<? extends R, ? extends E> supplier) { return UnsafeSupplier.castDown(supplier); }

  /**
   * This method simplifies the creation of {@link UnsafeFunction} lambdas in
   * places where a {@link Function} is expected or a disambiguation between
   * {@link UnsafeFunction} and {@link UnsafeConsumer} is required.
   * <p>
   * E.g. {@code Stream.map(Unsafe.function(element -> {...code throwing checked exception...}))}
   *
   * @param <X> parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param function lambda
   * @return {@code function}
   */
  public static <X, R, E extends Exception> UnsafeFunction<X, R, E>
  function(UnsafeFunction<? super X, ? extends R, ? extends E> function) { return UnsafeFunction.castDown(function); }

  /**
   * This method simplifies the creation of {@link UnsafeBiFunction} lambdas in
   * places where a {@link BiFunction} is expected or a disambiguation between
   * {@link UnsafeBiFunction} and {@link UnsafeBiConsumer} is required.
   * <p>
   * E.g. {@code map.replaceAll(Unsafe.biFunction((key, value) -> {...code throwing checked exception...}))}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param biFunction lambda
   * @return {@code biFunction}
   */
  public static <X, Y, R, E extends Exception> UnsafeBiFunction<X, Y, R, E>
  biFunction(UnsafeBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction) { return UnsafeBiFunction.castDown(biFunction); }

  /**
   * This method simplifies the creation of {@link UnsafeConsumer} lambdas in
   * places where a {@link Consumer} is expected or a disambiguation between
   * {@link UnsafeFunction} and {@link UnsafeConsumer} is required.
   * <p>
   * E.g. {@code stream.forEach(Unsafe.consumer(element -> {...code throwing checked exception...}))}
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param consumer lambda
   * @return {@code consumer}
   */
  public static <X, E extends Exception> UnsafeConsumer<X, E>
  consumer(UnsafeConsumer<? super X, ? extends E> consumer) { return UnsafeConsumer.castDown(consumer); }

  /**
   * This method simplifies the creation of {@link UnsafeBiConsumer} lambdas in
   * places where a {@link BiConsumer} is expected or a disambiguation between
   * {@link UnsafeBiFunction} and {@link UnsafeBiConsumer} is required.
   * <p>
   * E.g. {@code map.forEach(Unsafe.biConsumer((key, value) -> {...code throwing checked exception...}))}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param biConsumer lambda
   * @return {@code biConsumer}
   */
  public static <X, Y, E extends Exception> UnsafeBiConsumer<X, Y, E>
  biConsumer(UnsafeBiConsumer<? super X, ? super Y, ? extends E> biConsumer) { return UnsafeBiConsumer.castDown(biConsumer); }

  /**
   * This method simplifies the creation of {@link UnsafePredicate} lambdas in
   * places where a {@link Predicate} is expected or a disambiguation between
   * {@link UnsafeFunction} and {@link UnsafePredicate} is required.
   * <p>
   * E.g. {@code stream.filter(Unsafe.predicate(element -> {...code throwing checked exception...}))}
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param predicate lambda
   * @return {@code predicate}
   */
  public static <X, E extends Exception> UnsafePredicate<X, E>
  predicate(UnsafePredicate<? super X, ? extends E> predicate) { return UnsafePredicate.castDown(predicate); }

  /**
   * This method simplifies the creation of {@link UnsafeBiPredicate} lambdas in
   * places where a {@link BiPredicate} is expected or a disambiguation between
   * {@link UnsafeFunction} and {@link UnsafeBiPredicate} is required.
   * <p>
   * E.g. {@code Files.find(start, depth, Unsafe.biPredicate((path, attributes) -> {...code throwing checked exception...}))}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param biPredicate lambda
   * @return {@code biPredicate}
   */
  public static <X, Y, E extends Exception> UnsafeBiPredicate<X, Y, E>
  biPredicate(UnsafeBiPredicate<? super X, ? super Y, ? extends E> biPredicate) { return UnsafeBiPredicate.castDown(biPredicate); }

  /**
   * This method is equivalent to {@code function(operator)}.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param operator lambda
   * @return {@code operator}
   */
  public static <X, E extends Exception> UnsafeFunction<X, X, E>
  unaryOp(UnsafeFunction<? super X, ? extends X, ? extends E> operator) { return UnsafeFunction.castDown(operator); }

  /**
   * This method is equivalent to {@code biFunction(operator)}.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param operator lambda
   * @return {@code operator}
   */
  public static <X, E extends Exception> UnsafeBiFunction<X, X, X, E>
  binaryOp(UnsafeBiFunction<? super X, ? super X, ? extends X, ? extends E> operator) { return UnsafeBiFunction.castDown(operator); }

  /**
   * This method is equivalent to {@code biPredicate(relation)}.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param relation lambda
   * @return {@code operator}
   */
  public static <X, E extends Exception> UnsafeBiPredicate<X, X, E>
  relation(UnsafeBiPredicate<? super X, ? super X, ? extends E> relation) { return UnsafeBiPredicate.castDown(relation); }

  /**
   * Bridge {@link LavaRunnable} to {@link Runnable} by wrapping checked
   * exceptions raised.
   *
   * @param <E> upper exception limit
   * @param checked {@link LavaRunnable} to wrap
   * @return {@link UnsafeRunnable} wrapping {@code checked}
   */
  public static <E extends Exception> UnsafeRunnable<E>
  unsafe(LavaRunnable<? extends E> checked) { return UnsafeRunnable.castDown(checked::checkedRun); }

  /**
   * Bridge {@link LavaConsumer} to {@link Consumer} by wrapping checked
   * exceptions raised.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaConsumer} to wrap
   * @return {@link UnsafeConsumer} wrapping {@code checked}
   */
  public static <X, E extends Exception> UnsafeConsumer<X, E>
  unsafe(LavaConsumer<? super X, ? extends E> checked) { return UnsafeConsumer.castDown(checked::checkedAccept); }

  /**
   * Bridge {@link LavaBiConsumer} to {@link BiConsumer} by wrapping checked
   * exceptions raised.
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaBiConsumer} to wrap
   * @return {@link UnsafeBiConsumer} wrapping {@code checked}
   */
  public static <X, Y, E extends Exception> UnsafeBiConsumer<X, Y, E>
  unsafe(LavaBiConsumer<? super X, ? super Y, ? extends E> checked) { return UnsafeBiConsumer.castDown(checked::checkedAccept); }

  /**
   * Bridge {@link LavaSupplier} to {@link Supplier} by wrapping checked
   * exceptions raised.
   *
   * @param <R> return type
   * @param <E> upper exception limit
   * @param checked {@link LavaSupplier} to wrap
   * @return {@link UnsafeSupplier} wrapping {@code checked}
   */
  public static <R, E extends Exception> UnsafeSupplier<R, E>
  unsafe(LavaSupplier<? extends R, ? extends E> checked) { return UnsafeSupplier.castDown(checked::checkedGet); }

  /**
   * Bridge {@link LavaFunction} to {@link Function} by wrapping checked
   * exceptions raised.
   *
   * @param <X> parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param checked {@link LavaFunction} to wrap
   * @return {@link UnsafeFunction} wrapping {@code checked}
   */
  public static <X, R, E extends Exception> UnsafeFunction<X, R, E>
  unsafe(LavaFunction<? super X, ? extends R, ? extends E> checked) { return UnsafeFunction.castDown(checked::checkedApply); }

  /**
   * Bridge {@link LavaBiFunction} to {@link BiFunction} by wrapping checked
   * exceptions raised.
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param checked {@link LavaBiFunction} to wrap
   * @return {@link UnsafeBiFunction} wrapping {@code checked}
   */
  public static <X, Y, R, E extends Exception> UnsafeBiFunction<X, Y, R, E>
  unsafe(LavaBiFunction<? super X, ? super Y, ? extends R, ? extends E> checked) { return UnsafeBiFunction.castDown(checked::checkedApply); }

  /**
   * Bridge {@link LavaCondition} to {@link BooleanSupplier} by wrapping checked
   * exceptions raised.
   *
   * @param <E> upper exception limit
   * @param checked {@link LavaCondition} to wrap
   * @return {@link UnsafeCondition} wrapping {@code checked}
   */
  public static <E extends Exception> UnsafeCondition<E>
  unsafe(LavaCondition<? extends E> checked) { return UnsafeCondition.castDown(checked::checkedTest); }

  /**
   * Bridge {@link LavaPredicate} to {@link Predicate} by wrapping checked
   * exceptions raised.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaPredicate} to wrap
   * @return {@link UnsafePredicate} wrapping {@code checked}
   */
  public static <X, E extends Exception> UnsafePredicate<X, E>
  unsafe(LavaPredicate<? super X, ? extends E> checked) { return UnsafePredicate.castDown(checked::checkedTest); }

  /**
   * Bridge {@link LavaBiPredicate} to {@link BiPredicate} by wrapping checked
   * exceptions raised.
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaConsumer} to wrap
   * @return {@link UnsafeConsumer} wrapping {@code checked}
   */
  public static <X, Y, E extends Exception> UnsafeBiPredicate<X, Y, E>
  unsafe(LavaBiPredicate<? super X, ? super Y, ? extends E> checked) { return UnsafeBiPredicate.castDown(checked::checkedTest); }

  /**
   * Convenience method invoking {@link LavaRunnable} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).run()}
   *
   * @param checked {@link LavaRunnable} to invoke
   */
  public static void
  invoke(LavaRunnable<?> checked) {
    asUnchecked(checked).checkedRun();
  }

  /**
   * Convenience method invoking {@link LavaConsumer} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).accept(x)}
   *
   * @param <X> parameter type
   * @param checked {@link LavaConsumer} to invoke
   * @param x parameter to {@code checked}
   */
  public static <X> void
  invoke(LavaConsumer<X, ?> checked, X x) {
    asUnchecked(checked).checkedAccept(x);
  }

  /**
   * Convenience method invoking {@link LavaBiConsumer} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).accept(x, y)}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param checked {@link LavaBiConsumer} to invoke
   * @param x first parameter to {@code checked}
   * @param y second parameter to {@code checked}
   */
  public static <X, Y> void
  invoke(LavaBiConsumer<X, Y, ?> checked, X x, Y y) {
    asUnchecked(checked).checkedAccept(x, y);
  }

  /**
   * Convenience method invoking {@link LavaSupplier} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).get()}
   *
   * @param <R> return type
   * @param checked {@link LavaSupplier} to invoke
   * @return result of invoking {@code checked}
   */
  public static <R> R
  invoke(LavaSupplier<R, ?> checked) {
    return asUnchecked(checked).checkedGet();
  }

  /**
   * Convenience method invoking {@link LavaFunction} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).apply(x)}
   *
   * @param <X> parameter type
   * @param <R> return type
   * @param checked {@link LavaFunction} to invoke
   * @param x parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X, R> R
  invoke(LavaFunction<X, R, ?> checked, X x) {
    return asUnchecked(checked).checkedApply(x);
  }

  /**
   * Convenience method invoking {@link LavaBiFunction} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).apply(x, y)}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <R> return type
   * @param checked {@link LavaBiFunction} to invoke
   * @param x first parameter to {@code checked}
   * @param y second parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X, Y, R> R
  invoke(LavaBiFunction<X, Y, R, ?> checked, X x, Y y) {
    return asUnchecked(checked).checkedApply(x, y);
  }

  /**
   * Convenience method invoking {@link LavaCondition} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).apply(x)}
   *
   * @param checked {@link LavaCondition} to invoke
   * @return result of invoking {@code checked}
   */
  public static boolean
  invoke(LavaCondition<?> checked) {
    return asUnchecked(checked).checkedTest();
  }

  /**
   * Convenience method invoking {@link LavaPredicate} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).apply(x)}
   *
   * @param <X> parameter type
   * @param checked {@link LavaPredicate} to invoke
   * @param x first parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X> boolean
  invoke(LavaPredicate<X, ?> checked, X x) {
    return asUnchecked(checked).checkedTest(x);
  }

  /**
   * Convenience method invoking {@link LavaBiPredicate} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code unsafe(checked).apply(x, y)}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param checked {@link LavaBiPredicate} to invoke
   * @param x first parameter to {@code checked}
   * @param y second parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X, Y> boolean
  invoke(LavaBiPredicate<X, Y, ?> checked, X x, Y y) {
    return asUnchecked(checked).checkedTest(x, y);
  }

  @SuppressWarnings("unchecked")
  static LavaRunnable<RuntimeException> asUnchecked(LavaRunnable<?> checked) {
    return (LavaRunnable<RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static <X> LavaConsumer<X, RuntimeException> asUnchecked(LavaConsumer<X, ?> checked) {
    return (LavaConsumer<X, RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static <X, Y> LavaBiConsumer<X, Y, RuntimeException> asUnchecked(LavaBiConsumer<X, Y, ?> checked) {
    return (LavaBiConsumer<X, Y, RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static <R> LavaSupplier<R, RuntimeException> asUnchecked(LavaSupplier<R, ?> checked) {
    return (LavaSupplier<R, RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static <X, R> LavaFunction<X, R, RuntimeException> asUnchecked(LavaFunction<X, R, ?> checked) {
    return (LavaFunction<X, R, RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static <X, Y, R> LavaBiFunction<X, Y, R, RuntimeException> asUnchecked(LavaBiFunction<X, Y, R, ?> checked) {
    return (LavaBiFunction<X, Y, R, RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static LavaCondition<RuntimeException> asUnchecked(LavaCondition<?> checked) {
    return (LavaCondition<RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static <X> LavaPredicate<X, RuntimeException> asUnchecked(LavaPredicate<X, ?> checked) {
    return (LavaPredicate<X, RuntimeException>) checked;
  }

  @SuppressWarnings("unchecked")
  static <X, Y> LavaBiPredicate<X, Y, RuntimeException> asUnchecked(LavaBiPredicate<X, Y, ?> checked) {
    return (LavaBiPredicate<X, Y, RuntimeException>) checked;
  }
}
