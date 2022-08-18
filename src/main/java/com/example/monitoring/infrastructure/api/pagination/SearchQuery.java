package com.example.monitoring.infrastructure.api.pagination;

public record SearchQuery(
        int page,
        int perPage
) {
}
