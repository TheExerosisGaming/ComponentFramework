package me.exerosis.component.systemstate;

public interface SystemState {
    boolean equals(SystemState... states);

    SystemState getLast();

    SystemState getNext();
}