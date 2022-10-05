package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "LESSON", schema = "main", catalog = "")
public class LessonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LESSON_ID")
    private Object lessonId;
    @Basic
    @Column(name = "LAST_FRAME")
    private Object lastFrame;

    public Object getLessonId() {
        return lessonId;
    }

    public void setLessonId(Object lessonId) {
        this.lessonId = lessonId;
    }

    public Object getLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(Object lastFrame) {
        this.lastFrame = lastFrame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonEntity that = (LessonEntity) o;
        return Objects.equals(lessonId, that.lessonId) && Objects.equals(lastFrame, that.lastFrame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, lastFrame);
    }
}
