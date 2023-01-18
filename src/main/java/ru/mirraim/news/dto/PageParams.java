package ru.mirraim.news.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageParams {
    private int page;
    private int size;
}
