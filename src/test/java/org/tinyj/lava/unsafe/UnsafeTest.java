package org.tinyj.lava.unsafe;

import org.testng.annotations.Test;
import org.tinyj.lava.*;

import java.util.Objects;
import java.util.function.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.tinyj.lava.unsafe.MockProxy.mockProxy;
import static org.tinyj.lava.unsafe.Unsafe.unsafe;
import static org.tinyj.lava.utils.LavaFun.*;

public class UnsafeTest {

  @Test
  public void checked_exception_from_runnable_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();
    Runnable runnable = unsafe(runnable(() -> raise(originalException)));

    try {
      runnable.run();
    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_consumer_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(consumer(x -> raise(originalException))).accept("x");

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_biConsumer_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(biConsumer((x, y) -> raise(originalException))).accept("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_supplier_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(supplier(() -> raise(originalException))).get();

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_function_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(function(x -> raise(originalException))).apply("x");

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_biFunction_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(biFunction((x, y) -> raise(originalException))).apply("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_condition_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(condition(() -> { throw originalException; })).getAsBoolean();

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_predicate_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(predicate(x -> { throw originalException; })).test("x");

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_biPredicate_is_passed_unchanged_but_unchecked() throws Exception {
    final Exception originalException = new Exception();

    try {
      unsafe(biPredicate((x, y) -> { throw originalException; })).test("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isSameAs(originalException);
    }
  }

  @Test
  public void on_invocation_runnable_is_invoked() throws Exception {
    final LavaRunnable<?> runnable = mock(LavaRunnable.class);
    final Runnable unsafeRunnable = unsafe(runnable);
    verifyZeroInteractions(runnable);

    unsafeRunnable.run();

    verify(runnable).checkedRun();
  }

  @Test
  public void on_invocation_consumer_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaConsumer<String, ?> consumer = mock(LavaConsumer.class);
    final Consumer<String> unsafeConsumer = unsafe(consumer);
    verifyZeroInteractions(consumer);

    unsafeConsumer.accept("x");

    verify(consumer).checkedAccept("x");
  }

  @Test
  public void on_invocation_biConsumer_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaBiConsumer<String, String, ?> biConsumer = mock(LavaBiConsumer.class);
    final BiConsumer<String, String> unsafeBiConsumer = unsafe(biConsumer);
    verifyZeroInteractions(biConsumer);

    unsafeBiConsumer.accept("x", "y");

    verify(biConsumer).checkedAccept("x", "y");
  }

  @Test
  public void on_invocation_supplier_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaSupplier<String, ?> supplier = mockProxy(LavaSupplier.class, () -> "x");
    final Supplier<?> unsafeSupplier = unsafe(supplier);
    verifyZeroInteractions(supplier);

    final Object result = unsafeSupplier.get();

    assertThat(result).isEqualTo("x");
  }

  @Test
  public void on_invocation_function_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaFunction<String, String, ?> function = mockProxy(LavaFunction.class, x -> x);
    final Function<String, ?> unsafeFunction = unsafe(function);
    verifyZeroInteractions(function);

    final Object result = unsafeFunction.apply("x");

    assertThat(result).isEqualTo("x");
  }

  @Test
  public void on_invocation_biFunction_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaBiFunction<String, String, String, ?> biFunction = mockProxy(LavaBiFunction.class, (x, y) -> x.toString() + y);
    final BiFunction<String, String, ?> unsafeBiFunction = unsafe(biFunction);
    verifyZeroInteractions(biFunction);

    final Object result = unsafeBiFunction.apply("x", "y");

    assertThat(result).isEqualTo("xy");
  }

  @Test
  public void on_invocation_condition_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaCondition<?> condition = mockProxy(LavaCondition.class, () -> true);
    final BooleanSupplier unsafeCondition = unsafe(condition);
    verifyZeroInteractions(condition);

    final boolean result = unsafeCondition.getAsBoolean();

    assertThat(result).isTrue();
    verify(condition).checkedTest();
  }

  @Test
  public void on_invocation_predicate_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaPredicate<String, ?> predicate = mockProxy(LavaPredicate.class, x -> Objects.equals(x, "x"));
    final Predicate<String> unsafePredicate = unsafe(predicate);
    verifyZeroInteractions(predicate);

    final boolean result = unsafePredicate.test("x");

    assertThat(result).isTrue();
  }

  @Test
  public void on_invocation_biPredicate_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaBiPredicate<String, String, ?> biPredicate = mockProxy(LavaBiPredicate.class, Objects::equals);
    final BiPredicate<String, String> unsafeBiPredicate = unsafe(biPredicate);
    verifyZeroInteractions(biPredicate);

    final boolean result = unsafeBiPredicate.test("x", "x");

    assertThat(result).isTrue();
  }

  private static <T, E extends Exception> T raise(E e) throws E {
    throw e;
  }
}