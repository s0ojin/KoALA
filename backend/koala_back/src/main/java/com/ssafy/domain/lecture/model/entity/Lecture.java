package com.ssafy.domain.lecture.model.entity;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.domain.sentence.model.entity.LectureSentence;
import com.ssafy.domain.user.model.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@Table(name = "lectures")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lecture_id")
	private Long lectureId;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "teacher_id", referencedColumnName = "user_id", nullable = false)
	private User teacher;

	@Column(name = "lecture_title", nullable = false)
	private String lectureTitle;

	@Column(name = "lecture_detail")
	private String lectureDetail;

	@Column(name = "lecture_url")
	private String lectureUrl;

	@Setter
	@Column(name = "session_id")
	private String sessionId;

	@Builder.Default
	@Column(name = "is_open")
	private int isOpen = 1;

	@OneToMany(mappedBy = "lecture", fetch = LAZY)
	private List<LectureNote> lectureNotes = new ArrayList<>();

	@OneToMany(mappedBy = "lecture", fetch = LAZY)
	private List<LectureSentence> lectureSentences = new ArrayList<>();

	@OneToMany(mappedBy = "lecture", cascade = ALL, fetch = LAZY, orphanRemoval = true)
	private List<RegisteredLecture> registeredLectures = new ArrayList<>();

	public Lecture(User teacher, String lectureTitle, String lectureDetail, String lectureUrl, int isOpen) {
		this.teacher = teacher;
		this.lectureTitle = lectureTitle;
		this.lectureDetail = lectureDetail;
		this.lectureUrl = lectureUrl;
		this.isOpen = isOpen;
	}

}
