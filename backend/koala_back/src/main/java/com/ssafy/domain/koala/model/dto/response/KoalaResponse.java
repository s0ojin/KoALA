package com.ssafy.domain.koala.model.dto.response;

import com.ssafy.domain.koala.model.entity.Koala;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KoalaResponse {
    private Long koalaId;
    private String koalaName;
    private Integer koalaLevel;
    private Integer koalaExp;
    private Integer koalaType;

    public static KoalaResponse toDto(Koala koala) {
        return KoalaResponse.builder()
                .koalaId(koala.getKoalaId())
                .koalaName(koala.getKoalaName())
                .koalaLevel(koala.getKoalaLevel())
                .koalaExp(koala.getKoalaExp())
                .koalaType(koala.getKoalaType())
                .build();
    }
}
