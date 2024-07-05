package app.delivery.infrastructure.postgres.converters;

public interface Converter<T, R> {

    T convertToDomain(R object);

    R convertToEntity(T object);
}
