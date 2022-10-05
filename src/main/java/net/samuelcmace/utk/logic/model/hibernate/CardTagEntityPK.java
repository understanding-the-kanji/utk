package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CardTagEntityPK implements Serializable {
    @Column(name = "CARD_ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Object cardId;
    @Column(name = "TAG_ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Object tagId;

    public Object getCardId() {
        return cardId;
    }

    public void setCardId(Object cardId) {
        this.cardId = cardId;
    }

    public Object getTagId() {
        return tagId;
    }

    public void setTagId(Object tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardTagEntityPK that = (CardTagEntityPK) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, tagId);
    }
}
