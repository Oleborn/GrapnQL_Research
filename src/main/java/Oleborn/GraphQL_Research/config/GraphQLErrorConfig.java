package Oleborn.GraphQL_Research.config;

import Oleborn.GraphQL_Research.exception.UserNotFoundException;
import graphql.GraphqlErrorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;

import java.util.Map;

@Configuration
public class GraphQLErrorConfig {

    @Bean
    public DataFetcherExceptionResolver exceptionResolver() {
        return new DataFetcherExceptionResolverAdapter() {

            // Словарь соответствий исключений → GraphQL ErrorType
            private final Map<Class<? extends Throwable>, ErrorType> exceptionMappings = Map.of(
                    UserNotFoundException.class, ErrorType.NOT_FOUND
                    //InvalidInputException.class, ErrorType.BAD_REQUEST
            );

            @Override
            protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
                ErrorType errorType = exceptionMappings.get(ex.getClass());

                if (errorType != null) {
                    return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())                          // сообщение ошибки
                            .errorType(errorType)                              // тип ошибки
                            .path(env.getExecutionStepInfo().getPath())        // путь в GraphQL-запросе
                            .extensions(Map.of("exceptionClass", ex.getClass().getSimpleName())) // доп. инфо
                            .build();
                }

                // Для всех остальных ошибок возвращаем null → Spring GraphQL отобразит INTERNAL_ERROR
                return null;
            }
        };
    }
}