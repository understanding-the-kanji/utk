package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TAG", schema = "main", catalog = "")
public class TagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID", nullable = false)
    private Object tagId;
    @Basic
    @Column(name = "TAG_NAME", nullable = false, length = 50)
    private Object tagName;
    @Basic
    @Column(name = "TAG_DESCRIPTION", nullable = true, length = 500)
    private Object tagDescription;
    @OneToMany(mappedBy = "tagByTagId")
    private Collection<CardTagEntity> cardTagsByTagId;

    public Object getTagId() {
        return tagId;
    }

    public void setTagId(Object tagId) {
        this.tagId = tagId;
    }

    public Object getTagName() {
        return tagName;
    }

    public void setTagName(Object tagName) {
        this.tagName = tagName;
    }

    public Object getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(Object tagDescription) {
        this.tagDescription = tagDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntity tagEntity = (TagEntity) o;
        return Objects.equals(tagId, tagEntity.tagId) && Objects.equals(tagName, tagEntity.tagName) && Objects.equals(tagDescription, tagEntity.tagDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tagName, tagDescription);
    }

    public Collection<CardTagEntity> getCardTagsByTagId() {
        return cardTagsByTagId;
    }

    public void setCardTagsByTagId(Collection<CardTagEntity> cardTagsByTagId) {
        this.cardTagsByTagId = cardTagsByTagId;
    }
}
