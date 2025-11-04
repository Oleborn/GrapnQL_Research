package Oleborn.GraphQL_Research.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
//public class GraphQLExceptionHandler {
//
//    @ExceptionHandler(UserNotFoundException.class)
//    public GraphQLError handleUserNotFound(UserNotFoundException ex) {
//        return GraphqlErrorBuilder.newError()
//                .message(ex.getMessage())
//                .errorType(ErrorType.NOT_FOUND)
//                .build();
//    }
//}