package app.delivery.core.application.commands;

public interface CommandHandler<C> {
    void handle(C command);
}