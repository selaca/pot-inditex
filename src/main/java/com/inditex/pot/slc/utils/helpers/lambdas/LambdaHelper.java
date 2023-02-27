package com.inditex.pot.slc.utils.helpers.lambdas;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Clase de helper de funciones wrappers/decorators a lambdas
 * 
 * @author slc
 * @since 1.0.0
 *
 */
@Slf4j
public class LambdaHelper {

	/*
	 * Definición de funcional interfaces con control de Exceptions ------------------------
	 */
	
	@FunctionalInterface
	public interface ConsumerEx<T> {
		void accept(T t) throws Exception;
	}
	
	@FunctionalInterface
	public interface RunnableEx {
		void run() throws Exception;
	}
	
	@FunctionalInterface
	public interface CallableEx<T> {
		T call() throws Exception;
	}
	
	@FunctionalInterface
	public interface FunctionEx<T, U> {
		U apply(T input) throws Exception;
	}
	
	/*
	 * Funciones wrapper/decorator de helper ----------------------------------------------------------------
	 */
	
	public static Runnable safeRunnable(RunnableEx run) {
		return () -> {
			try {
				run.run();
			} catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}
	
	public static <T> Callable<T> safeCallable(CallableEx<T> callable) {
		return () -> {
			try {
				return callable.call();
			} catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}
	
	public static Runnable safeRunnableWithLoggingEx(RunnableEx runnable, String messageError) {
		return () -> {
			try {
				safeRunnable(runnable).run();
			} catch(Exception ex) {
				log.error(messageError, ex);
				throw new RuntimeException(ex);
			}
		};
	}
	
	public static Runnable safeRunnableWithLoggingExStop(RunnableEx runnable, String messageError) {
		return () -> {
			try {
				safeRunnable(runnable).run();
			} catch(Exception ex) {
				log.error(messageError, ex);
			}
		};
	}
	
	public static <T, U> Function<T, U> safeFunction(FunctionEx<T, U> function) {
		return (i) -> {
			try {
				return
					function.apply(i);
			} catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}
	
	public static Runnable loggingDecorator(RunnableEx runnable, Optional<String> messageBefore, Optional<String> messageAfter) {
		return () -> {
			messageBefore.ifPresent( 
				(msg) -> log.info(msg));

			safeRunnable(runnable).run();
			
			messageAfter.ifPresent( 
				(msg) -> log.info(msg));
		};
	}
	
	

	public static <T> Consumer<T> safeRunConsumer(ConsumerEx<T> consumer) {
		return i -> {
			try {
				consumer.accept(i);
			} catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}
	
	
	
}
