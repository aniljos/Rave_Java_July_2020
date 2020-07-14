package com;

@FunctionalInterface
public interface GenericCalculator<T,U,V> {

	public V calculate(T x, U y);
}
