package com.coderocket.sportscomp.out.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetChuckNorrisOutResponse(
        /*
        {
    "categories": [],
    "created_at": "2020-01-05 13:42:30.730109",
    "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
    "id": "X6QseF16SWGLZMJYs2xeAw",
    "updated_at": "2020-01-05 13:42:30.730109",
    "url": "https://api.chucknorris.io/jokes/X6QseF16SWGLZMJYs2xeAw",
    "value": "Chuck Norris doesn't have chest hairs: he has a series of venemous anemenites that, if sting you, can cause mental retardation"
}
         */
        Object categories,
        String created_at,
        String icon_url,
        @JsonProperty("id")
        String externalId,
        String updated_at,
        String url,
        String value
) {
}
