package co.istad.sb8datajpa.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record CourseDto(Long id,
                        String title,
                        String description,
                        String thumbnail,
                        BigDecimal price,
                        Boolean isFree,
                        LocalDateTime createdAt,
                        CategoryDto category) {
}
