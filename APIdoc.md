org.tinyj.lava.unsafe
=====================

## org.tinyj.lava.unsafe

### Unsafe
_[(src)](src/main/java/org/tinyj/lava/unsafe/Unsafe.java)_  

Utility class


**`Unsafe()`** _(contructor)_  

Do not instantiate


***`runnable(UnsafeRunnable<? extends E> runnable)`***
⇒ *`UnsafeRunnable<E>`* *(`runnable`)*  
`E`: upper exception limit  
`runnable`: lambda  

This method simplifies the creation of [`UnsafeRunnable`] lambdas in
places where a [`Runnable`] is expected or disambiguation between
[`UnsafeSupplier`] and [`UnsafeRunnable`] is required.

E.g. `new Thread(Unsafe.runnable(() -> {...code throwing checked exception...}))`


***`supplier(UnsafeSupplier<? extends R, ? extends E> supplier)`***
⇒ *`UnsafeSupplier<R, E>`* *(`supplier`)*  
`R`: return type  
`E`: upper exception limit  
`supplier`: lambda  

This method simplifies the creation of [`UnsafeSupplier`] lambdas in
places where a [`Supplier`] is expected or disambiguation between
[`UnsafeSupplier`] and [`UnsafeRunnable`] is required.

E.g. `Stream.generate(Unsafe.supplier(() -> {...code throwing checked exception...}))`


***`function(UnsafeFunction<? super X, ? extends R, ? extends E> function)`***
⇒ *`UnsafeFunction<X, R, E>`* *(`function`)*  
`X`: parameter type  
`R`: return type  
`E`: upper exception limit  
`function`: lambda  

This method simplifies the creation of [`UnsafeFunction`] lambdas in
places where a [`Function`] is expected or a disambiguation between
[`UnsafeFunction`] and [`UnsafeConsumer`] is required.

E.g. `Stream.map(Unsafe.function(element -> {...code throwing checked exception...}))`


***`biFunction(UnsafeBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction)`***
⇒ *`UnsafeBiFunction<X, Y, R, E>`* *(`biFunction`)*  
`X`: first parameter type  
`Y`: second parameter type  
`R`: return type  
`E`: upper exception limit  
`biFunction`: lambda  

This method simplifies the creation of [`UnsafeBiFunction`] lambdas in
places where a [`BiFunction`] is expected or a disambiguation between
[`UnsafeBiFunction`] and [`UnsafeBiConsumer`] is required.

E.g. `map.replaceAll(Unsafe.biFunction((key, value) -> {...code throwing checked exception...}))`


***`consumer(UnsafeConsumer<? super X, ? extends E> consumer)`***
⇒ *`UnsafeConsumer<X, E>`* *(`consumer`)*  
`X`: parameter type  
`E`: upper exception limit  
`consumer`: lambda  

This method simplifies the creation of [`UnsafeConsumer`] lambdas in
places where a [`Consumer`] is expected or a disambiguation between
[`UnsafeFunction`] and [`UnsafeConsumer`] is required.

E.g. `stream.forEach(Unsafe.consumer(element -> {...code throwing checked exception...}))`


***`biConsumer(UnsafeBiConsumer<? super X, ? super Y, ? extends E> biConsumer)`***
⇒ *`UnsafeBiConsumer<X, Y, E>`* *(`biConsumer`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`biConsumer`: lambda  

This method simplifies the creation of [`UnsafeBiConsumer`] lambdas in
places where a [`BiConsumer`] is expected or a disambiguation between
[`UnsafeBiFunction`] and [`UnsafeBiConsumer`] is required.

E.g. `map.forEach(Unsafe.biConsumer((key, value) -> {...code throwing checked exception...}))`


***`predicate(UnsafePredicate<? super X, ? extends E> predicate)`***
⇒ *`UnsafePredicate<X, E>`* *(`predicate`)*  
`X`: parameter type  
`E`: upper exception limit  
`predicate`: lambda  

This method simplifies the creation of [`UnsafePredicate`] lambdas in
places where a [`Predicate`] is expected or a disambiguation between
[`UnsafeFunction`] and [`UnsafePredicate`] is required.

E.g. `stream.filter(Unsafe.predicate(element -> {...code throwing checked exception...}))`


***`biPredicate(UnsafeBiPredicate<? super X, ? super Y, ? extends E> biPredicate)`***
⇒ *`UnsafeBiPredicate<X, Y, E>`* *(`biPredicate`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`biPredicate`: lambda  

This method simplifies the creation of [`UnsafeBiPredicate`] lambdas in
places where a [`BiPredicate`] is expected or a disambiguation between
[`UnsafeFunction`] and [`UnsafeBiPredicate`] is required.

E.g. `Files.find(start, depth, Unsafe.biPredicate((path, attributes) -> {...code throwing checked exception...}))`


***`unaryOp(UnsafeFunction<? super X, ? extends X, ? extends E> operator)`***
⇒ *`UnsafeFunction<X, X, E>`* *(`operator`)*  
`X`: parameter type  
`E`: upper exception limit  
`operator`: lambda  

This method is equivalent to `function(operator)`.


***`binaryOp(UnsafeBiFunction<? super X, ? super X, ? extends X, ? extends E> operator)`***
⇒ *`UnsafeBiFunction<X, X, X, E>`* *(`operator`)*  
`X`: parameter type  
`E`: upper exception limit  
`operator`: lambda  

This method is equivalent to `biFunction(operator)`.


***`relation(UnsafeBiPredicate<? super X, ? super X, ? extends E> relation)`***
⇒ *`UnsafeBiPredicate<X, X, E>`* *(`operator`)*  
`X`: parameter type  
`E`: upper exception limit  
`relation`: lambda  

This method is equivalent to `biPredicate(relation)`.


***`unsafe(LavaRunnable<? extends E> checked)`***
⇒ *`UnsafeRunnable<E>`* *([`UnsafeRunnable`] wrapping `checked`)*  
`E`: upper exception limit  
`checked`: [`LavaRunnable`] to wrap  

Bridge [`LavaRunnable`] to [`Runnable`] by wrapping checked
exceptions raised.


***`unsafe(LavaConsumer<? super X, ? extends E> checked)`***
⇒ *`UnsafeConsumer<X, E>`* *([`UnsafeConsumer`] wrapping `checked`)*  
`X`: parameter type  
`E`: upper exception limit  
`checked`: [`LavaConsumer`] to wrap  

Bridge [`LavaConsumer`] to [`Consumer`] by wrapping checked
exceptions raised.


***`unsafe(LavaBiConsumer<? super X, ? super Y, ? extends E> checked)`***
⇒ *`UnsafeBiConsumer<X, Y, E>`* *([`UnsafeBiConsumer`] wrapping `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`checked`: [`LavaBiConsumer`] to wrap  

Bridge [`LavaBiConsumer`] to [`BiConsumer`] by wrapping checked
exceptions raised.


***`unsafe(LavaSupplier<? extends R, ? extends E> checked)`***
⇒ *`UnsafeSupplier<R, E>`* *([`UnsafeSupplier`] wrapping `checked`)*  
`R`: return type  
`E`: upper exception limit  
`checked`: [`LavaSupplier`] to wrap  

Bridge [`LavaSupplier`] to [`Supplier`] by wrapping checked
exceptions raised.


***`unsafe(LavaFunction<? super X, ? extends R, ? extends E> checked)`***
⇒ *`UnsafeFunction<X, R, E>`* *([`UnsafeFunction`] wrapping `checked`)*  
`X`: parameter type  
`R`: return type  
`E`: upper exception limit  
`checked`: [`LavaFunction`] to wrap  

Bridge [`LavaFunction`] to [`Function`] by wrapping checked
exceptions raised.


***`unsafe(LavaBiFunction<? super X, ? super Y, ? extends R, ? extends E> checked)`***
⇒ *`UnsafeBiFunction<X, Y, R, E>`* *([`UnsafeBiFunction`] wrapping `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`R`: return type  
`E`: upper exception limit  
`checked`: [`LavaBiFunction`] to wrap  

Bridge [`LavaBiFunction`] to [`BiFunction`] by wrapping checked
exceptions raised.


***`unsafe(LavaCondition<? extends E> checked)`***
⇒ *`UnsafeCondition<E>`* *([`UnsafeCondition`] wrapping `checked`)*  
`E`: upper exception limit  
`checked`: [`LavaCondition`] to wrap  

Bridge [`LavaCondition`] to [`BooleanSupplier`] by wrapping checked
exceptions raised.


***`unsafe(LavaPredicate<? super X, ? extends E> checked)`***
⇒ *`UnsafePredicate<X, E>`* *([`UnsafePredicate`] wrapping `checked`)*  
`X`: parameter type  
`E`: upper exception limit  
`checked`: [`LavaPredicate`] to wrap  

Bridge [`LavaPredicate`] to [`Predicate`] by wrapping checked
exceptions raised.


***`unsafe(LavaBiPredicate<? super X, ? super Y, ? extends E> checked)`***
⇒ *`UnsafeBiPredicate<X, Y, E>`* *([`UnsafeConsumer`] wrapping `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`checked`: [`LavaConsumer`] to wrap  

Bridge [`LavaBiPredicate`] to [`BiPredicate`] by wrapping checked
exceptions raised.


***`invoke(LavaRunnable<?> checked)`***  
`checked`: [`LavaRunnable`] to invoke  

Convenience method invoking [`LavaRunnable`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).run()`


***`invoke(LavaConsumer<X, ?> checked, X x)`***  
`X`: parameter type  
`checked`: [`LavaConsumer`] to invoke  
`x`: parameter to `checked`  

Convenience method invoking [`LavaConsumer`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).accept(x)`


***`invoke(LavaBiConsumer<X, Y, ?> checked, X x, Y y)`***  
`X`: first parameter type  
`Y`: second parameter type  
`checked`: [`LavaBiConsumer`] to invoke  
`x`: first parameter to `checked`  
`y`: second parameter to `checked`  

Convenience method invoking [`LavaBiConsumer`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).accept(x, y)`


***`invoke(LavaSupplier<R, ?> checked)`***
⇒ *`R`* *(result of invoking `checked`)*  
`R`: return type  
`checked`: [`LavaSupplier`] to invoke  

Convenience method invoking [`LavaSupplier`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).get()`


***`invoke(LavaFunction<X, R, ?> checked, X x)`***
⇒ *`R`* *(result of invoking `checked`)*  
`X`: parameter type  
`R`: return type  
`checked`: [`LavaFunction`] to invoke  
`x`: parameter to `checked`  

Convenience method invoking [`LavaFunction`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).apply(x)`


***`invoke(LavaBiFunction<X, Y, R, ?> checked, X x, Y y)`***
⇒ *`R`* *(result of invoking `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`R`: return type  
`checked`: [`LavaBiFunction`] to invoke  
`x`: first parameter to `checked`  
`y`: second parameter to `checked`  

Convenience method invoking [`LavaBiFunction`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).apply(x, y)`


***`invoke(LavaCondition<?> checked)`***
⇒ *`boolean`* *(result of invoking `checked`)*  
`checked`: [`LavaCondition`] to invoke  

Convenience method invoking [`LavaCondition`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).apply(x)`


***`invoke(LavaPredicate<X, ?> checked, X x)`***
⇒ *`boolean`* *(result of invoking `checked`)*  
`X`: parameter type  
`checked`: [`LavaPredicate`] to invoke  
`x`: first parameter to `checked`  

Convenience method invoking [`LavaPredicate`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).apply(x)`


***`invoke(LavaBiPredicate<X, Y, ?> checked, X x, Y y)`***
⇒ *`boolean`* *(result of invoking `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`checked`: [`LavaBiPredicate`] to invoke  
`x`: first parameter to `checked`  
`y`: second parameter to `checked`  

Convenience method invoking [`LavaBiPredicate`] wrapping checked
exceptions raised.

Equivalent to `unsafe(checked).apply(x, y)`



### UnsafeBiConsumer<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeBiConsumer.java)_
| _(interface)_  
`X`: first consumed value type  
`Y`: second consumed value type  
`E`: upper limit of thrown exception types  

An operation on two input values.

This interface bridges [`LavaBiConsumer`] and [`BiConsumer`] by
tricking the compiler to pass checked exceptions as unchecked.

Usually invoking a bi-consumer results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedAccept`].


**`accept(X x, Y y)`**  
`x`: first consumed value  
`y`: second consumed value  

Perform operation on inputs.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeBiConsumer<? super X, ? super Y, ? extends E> biConsumer)`***
⇒ *`UnsafeBiConsumer<X, Y, E>`* *(`biConsumer` casted to the compatible parametrization
[`UnsafeBiConsumer`]`<X, Y, E>`)*  
`X`: first accepted input type  
`Y`: second accepted input type  
`E`: required exception limit  
`biConsumer`: bi-consumer to adopt  

Safely casts between different [`UnsafeBiConsumer`] parametrization



### UnsafeBiFunction<X, Y, R, E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeBiFunction.java)_
| _(interface)_  
`X`: the bi-function's first argument type  
`Y`: the bi-function's second argument type  
`R`: the bi-function's result type  
`E`: upper limit of thrown exception types  

A bi-function maps its two argument to a result.

This interface bridges [`LavaBiFunction`] and [`BiFunction`] by
tricking the compiler to pass checked exceptions as unchecked.

While not strictly required it usually is expected that subsequent
invocations with the same arguments yield equal results.

This is a functional interface whose functional method is
[`checkedApply`].


**`apply(X x, Y y)`**
⇒ *`R`* *(the function's result)*  
`x`: first argument to map  
`y`: second argument to map  

Apply the function to arguments.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction)`***
⇒ *`UnsafeBiFunction<X, Y, R, E>`* *(`biFunction` casted to the compatible parametrization
[`UnsafeBiFunction`]`<X, Y, R, E>`)*  
`X`: first accepted argument type  
`Y`: second accepted argument type  
`R`: required result type  
`E`: required exception limit  
`biFunction`: bi-function to adopt  

Safely casts between different [`UnsafeBiFunction`] parametrization



### UnsafeBiPredicate<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeBiPredicate.java)_
| _(interface)_  
`X`: the function's argument type  
`E`: upper limit of thrown exception types  

A special kind of bi-function mapping its arguments to a `boolean`.

This interface bridges [`LavaBiPredicate`] and [`BiPredicate`] by
tricking the compiler to pass checked exceptions as unchecked.

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedTest`].


**`test(X x, Y y)`**
⇒ *`boolean`* *(`true` if `x, y` matches, `false` otherwise)*  
`x`: first argument to the match  
`y`: second argument to the match  

Test if the arguments matches the predicate.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeBiPredicate<? super X, ? super Y, ? extends E> biPredicate)`***
⇒ *`UnsafeBiPredicate<X, Y, E>`* *(`biPredicate` casted to the compatible parametrization
[`UnsafeBiPredicate`]`<X, E>`)*  
`X`: first accepted argument type  
`Y`: second accepted argument type  
`E`: required exception limit  
`biPredicate`: bi-predicate to adopt  

Safely casts between different [`UnsafeBiPredicate`]parametrization



### UnsafeCondition\<E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeCondition.java)_
| _(interface)_  
`E`: upper limit of thrown exception types  

A supplier of values.

This interface bridges [`LavaCondition`] and [`BooleanSupplier`] by
tricking the compiler to pass checked exceptions as unchecked.

There is no requirement that a new or distinct result be returned each time
the supplier is invoked.

This is a functional interface whose functional method is
[`checkedTest`].


**`getAsBoolean()`**
⇒ *`boolean`* *(a value)*  

Produce a value.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeCondition<? extends E> condition)`***
⇒ *`UnsafeCondition<E>`* *(`condition` casted to the compatible parametrization [`UnsafeCondition`]`<R, E>`)*  
`E`: required exception limit  
`condition`: condition to adopt  

Safely casts between different [`UnsafeCondition`] parametrization



### UnsafeConsumer<X, E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeConsumer.java)_
| _(interface)_  
`X`: consumed value type  
`E`: upper limit of thrown exception types  

An operation on an input value.

This interface bridges [`LavaConsumer`] and [`Consumer`] by
tricking the compiler to pass checked exceptions as unchecked.

Usually invoking a consumer results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedAccept`]


**`accept(X x)`**  
`x`: consumed value  

Perform operation on input.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeConsumer<? super X, ? extends E> consumer)`***
⇒ *`UnsafeConsumer<X, E>`* *(`consumer` casted to the compatible parametrization
[`UnsafeConsumer`]`<X, E>`)*  
`X`: accepted input type  
`E`: required exception limit  
`consumer`: consumer to adopt  

Safely casts between different [`UnsafeConsumer`] parametrization



### UnsafeFunction<X, R, E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeFunction.java)_
| _(interface)_  
`X`: the function's argument type  
`R`: the function's result type  
`E`: upper limit of thrown exception types  

A function maps its argument to a result.

This interface bridges [`LavaFunction`] and [`Function`] by
tricking the compiler to pass checked exceptions as unchecked.

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedApply`].


**`apply(X x)`**
⇒ *`R`* *(the function's result)*  
`x`: argument to map  

Apply the function to an argument
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeFunction<? super X, ? extends R, ? extends E> function)`***
⇒ *`UnsafeFunction<X, R, E>`* *(`function` casted to the compatible parametrization
[`UnsafeFunction`]`<X, R, E>`)*  
`X`: accepted argument type  
`R`: required result type  
`E`: required exception limit  
`function`: function to adopt  

Safely casts between different [`UnsafeFunction`] parametrization



### UnsafePredicate<X, E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafePredicate.java)_
| _(interface)_  
`X`: the function's argument type  
`E`: upper limit of thrown exception types  

A special kind of function mapping its argument to a `boolean` result.

This interface bridges [`LavaPredicate`] and [`Predicate`] by
tricking the compiler to pass checked exceptions as unchecked.

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedTest`].


**`test(X x)`**
⇒ *`boolean`* *(`true` if `x` matches, `false` otherwise)*  
`x`: argument to the match  

Test if the argument matches the predicate.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafePredicate<? super X, ? extends E> predicate)`***
⇒ *`UnsafePredicate<X, E>`* *(`predicate` casted to the compatible parametrization
[`UnsafePredicate`]`<X, E>`)*  
`X`: accepted argument type  
`E`: required exception limit  
`predicate`: predicate to adopt  

Safely casts between different [`UnsafePredicate`] parametrization



### UnsafeRunnable\<E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeRunnable.java)_
| _(interface)_  
`E`: upper limit of thrown exception types  

A runnable task.

This interface bridges [`LavaRunnable`] and [`Runnable`] by
tricking the compiler to pass checked exceptions as unchecked.

Usually invoking a runnable results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedRun`].


**`run()`**  

Execute the task.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeRunnable<? extends E> runnable)`***
⇒ *`UnsafeRunnable<E>`* *(`runnable` casted to the compatible parametrization
[`UnsafeRunnable`]`<E>`)*  
`E`: required exception limit  
`runnable`: runnable to adopt  

Safely casts between different [`UnsafeRunnable`] parametrization



### UnsafeSupplier<R, E>
_[(src)](src/main/java/org/tinyj/lava/unsafe/UnsafeSupplier.java)_
| _(interface)_  
`R`: type of supplied values  
`E`: upper limit of thrown exception types  

A supplier of values.

This interface bridges [`LavaSupplier`] and [`Supplier`] by
tricking the compiler to pass checked exceptions as unchecked.

There is no requirement that a new or distinct result be returned each time
the supplier is invoked.

This is a functional interface whose functional method is
[`checkedGet`].


**`get()`**
⇒ *`R`*  

Produce a value.
Any exception raised during invocation will be passed on unchecked.


***`castDown(UnsafeSupplier<? extends R, ? extends E> supplier)`***
⇒ *`UnsafeSupplier<R, E>`* *(`supplier` casted to the compatible parametrization
[`UnsafeSupplier`]`<R, E>`)*  
`R`: required result type  
`E`: required exception limit  
`supplier`: supplier to adopt  

Safely casts between different [`UnsafeSupplier`] parametrization



[`BiConsumer`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiConsumer.html
[`BiFunction`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiFunction.html
[`BiPredicate`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiPredicate.html
[`BooleanSupplier`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BooleanSupplier.html
[`Consumer`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Consumer.html
[`Function`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Function.html
[`LavaBiConsumer`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabiconsumerx-y-e
[`LavaBiFunction`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabifunctionx-y-r-e
[`LavaBiPredicate`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabipredicatex-y-e
[`LavaCondition`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconditione
[`LavaConsumer`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconsumerx-e
[`LavaFunction`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavafunctionx-r-e
[`LavaPredicate`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavapredicatex-e
[`LavaRunnable`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavarunnablee
[`LavaSupplier`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavasupplierr-e
[`Predicate`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Predicate.html
[`Runnable`]: https://docs.oracle.com/javase/9/docs/api/java/lang/Runnable.html
[`Supplier`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Supplier.html
[`UnsafeBiConsumer`]: #unsafebiconsumerx-y-e
[`UnsafeBiFunction`]: #unsafebifunctionx-y-r-e
[`UnsafeBiPredicate`]: #unsafebipredicatex-y-e
[`UnsafeCondition`]: #unsafeconditione
[`UnsafeConsumer`]: #unsafeconsumerx-e
[`UnsafeFunction`]: #unsafefunctionx-r-e
[`UnsafePredicate`]: #unsafepredicatex-e
[`UnsafeRunnable`]: #unsaferunnablee
[`UnsafeSupplier`]: #unsafesupplierr-e
