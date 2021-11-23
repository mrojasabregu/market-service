package com.pinapp.market.marketservice.domain.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Keyword {
    private Long keywordId;
    private List<String> name;
}
