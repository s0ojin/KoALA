package com.ssafy.domain.user.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StudyTimeId implements Serializable {
    @Column(name = "time_cal_type")
    private Integer timeCalType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyTimeId that = (StudyTimeId) o;
        return Objects.equals(timeCalType, that.timeCalType) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeCalType, user);
    }
}
