package com.gateway.payment.procedures;

@FunctionalInterface
public interface MessageTransformer<T> {

    abstract  public T transform(Object... arguments);
}
