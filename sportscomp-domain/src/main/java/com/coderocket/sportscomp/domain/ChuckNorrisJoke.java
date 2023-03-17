package com.coderocket.sportscomp.domain;

import lombok.Builder;

@Builder
public record ChuckNorrisJoke(
        Integer id,
        String url,
        String content
) {
}
