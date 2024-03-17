package br.com.mmmsieto.order.domain.exceptions;

public record Error(String field, String typeField, String cause, String message) {}
