package me.exerosis.component.event;

public interface EventExecutor<T> {
    void execute(T event);
}