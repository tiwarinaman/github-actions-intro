package com.naman.github.actions.intro.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiResponse(LocalDateTime timestamp,
                          int result) {
}
