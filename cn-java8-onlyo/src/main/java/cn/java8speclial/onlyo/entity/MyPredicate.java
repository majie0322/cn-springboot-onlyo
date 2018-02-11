package cn.java8speclial.onlyo.entity;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
