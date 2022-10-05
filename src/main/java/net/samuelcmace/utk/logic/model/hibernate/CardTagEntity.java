package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CARD_TAG", schema = "main", catalog = "")
@IdClass(CardTagEntityPK.class)
public class CardTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CARD_ID", nullable = false)
    private Object cardId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID", nullable = false)
    private Object tagId;
    @ManyToOne
    @JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID", nullable = false)
    private CardEntity cardByCardId;
    @ManyToOne
    @JoinColumn(name = "TAG_ID", referencedColumnName = "TAG_ID", nullable = false)
    private TagEntity tagByTagId;

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
        CardTagEntity that = (CardTagEntity) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, tagId);
    }

    public CardEntity getCardByCardId() {
        return cardByCardId;
    }

    public void setCardByCardId(CardEntity cardByCardId) {
        this.cardByCardId = cardByCardId;
    }

    public TagEntity getTagByTagId() {
        return tagByTagId;
    }

    public void setTagByTagId(TagEntity tagByTagId) {
        this.tagByTagId = tagByTagId;
    }
}
