package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CARD", schema = "main", catalog = "")
public class CardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CARD_ID", nullable = false)
    private Object cardId;
    @Basic
    @Column(name = "CARD_KANJI", nullable = false, length = 1)
    private Object cardKanji;
    @Basic
    @Column(name = "HEISIG_INDEX_5_EDITION", nullable = true)
    private Object heisigIndex5Edition;
    @Basic
    @Column(name = "HEISIG_INDEX_6_EDITION", nullable = true)
    private Object heisigIndex6Edition;
    @Basic
    @Column(name = "KEYWORD_5_EDITION", nullable = true, length = 20)
    private Object keyword5Edition;
    @Basic
    @Column(name = "KEYWORD_6_EDITION", nullable = true, length = 20)
    private Object keyword6Edition;
    @Basic
    @Column(name = "ON_READING", nullable = true, length = 20)
    private Object onReading;
    @Basic
    @Column(name = "KUN_READING", nullable = true, length = 20)
    private Object kunReading;
    @OneToMany(mappedBy = "cardByCardId")
    private Collection<CardPrimitiveEntity> cardPrimitivesByCardId;
    @OneToMany(mappedBy = "cardByCardId")
    private Collection<CardTagEntity> cardTagsByCardId;
    @OneToMany(mappedBy = "cardByLastFrame")
    private Collection<LessonEntity> lessonsByCardId;
    @OneToMany(mappedBy = "cardByCardId")
    private Collection<NoteEntity> notesByCardId;
    @OneToMany(mappedBy = "cardByNextFrame")
    private Collection<PrimitiveEntity> primitivesByCardId;

    public Object getCardId() {
        return cardId;
    }

    public void setCardId(Object cardId) {
        this.cardId = cardId;
    }

    public Object getCardKanji() {
        return cardKanji;
    }

    public void setCardKanji(Object cardKanji) {
        this.cardKanji = cardKanji;
    }

    public Object getHeisigIndex5Edition() {
        return heisigIndex5Edition;
    }

    public void setHeisigIndex5Edition(Object heisigIndex5Edition) {
        this.heisigIndex5Edition = heisigIndex5Edition;
    }

    public Object getHeisigIndex6Edition() {
        return heisigIndex6Edition;
    }

    public void setHeisigIndex6Edition(Object heisigIndex6Edition) {
        this.heisigIndex6Edition = heisigIndex6Edition;
    }

    public Object getKeyword5Edition() {
        return keyword5Edition;
    }

    public void setKeyword5Edition(Object keyword5Edition) {
        this.keyword5Edition = keyword5Edition;
    }

    public Object getKeyword6Edition() {
        return keyword6Edition;
    }

    public void setKeyword6Edition(Object keyword6Edition) {
        this.keyword6Edition = keyword6Edition;
    }

    public Object getOnReading() {
        return onReading;
    }

    public void setOnReading(Object onReading) {
        this.onReading = onReading;
    }

    public Object getKunReading() {
        return kunReading;
    }

    public void setKunReading(Object kunReading) {
        this.kunReading = kunReading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity entity = (CardEntity) o;
        return Objects.equals(cardId, entity.cardId) && Objects.equals(cardKanji, entity.cardKanji) && Objects.equals(heisigIndex5Edition, entity.heisigIndex5Edition) && Objects.equals(heisigIndex6Edition, entity.heisigIndex6Edition) && Objects.equals(keyword5Edition, entity.keyword5Edition) && Objects.equals(keyword6Edition, entity.keyword6Edition) && Objects.equals(onReading, entity.onReading) && Objects.equals(kunReading, entity.kunReading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardKanji, heisigIndex5Edition, heisigIndex6Edition, keyword5Edition, keyword6Edition, onReading, kunReading);
    }

    public Collection<CardPrimitiveEntity> getCardPrimitivesByCardId() {
        return cardPrimitivesByCardId;
    }

    public void setCardPrimitivesByCardId(Collection<CardPrimitiveEntity> cardPrimitivesByCardId) {
        this.cardPrimitivesByCardId = cardPrimitivesByCardId;
    }

    public Collection<CardTagEntity> getCardTagsByCardId() {
        return cardTagsByCardId;
    }

    public void setCardTagsByCardId(Collection<CardTagEntity> cardTagsByCardId) {
        this.cardTagsByCardId = cardTagsByCardId;
    }

    public Collection<LessonEntity> getLessonsByCardId() {
        return lessonsByCardId;
    }

    public void setLessonsByCardId(Collection<LessonEntity> lessonsByCardId) {
        this.lessonsByCardId = lessonsByCardId;
    }

    public Collection<NoteEntity> getNotesByCardId() {
        return notesByCardId;
    }

    public void setNotesByCardId(Collection<NoteEntity> notesByCardId) {
        this.notesByCardId = notesByCardId;
    }

    public Collection<PrimitiveEntity> getPrimitivesByCardId() {
        return primitivesByCardId;
    }

    public void setPrimitivesByCardId(Collection<PrimitiveEntity> primitivesByCardId) {
        this.primitivesByCardId = primitivesByCardId;
    }
}
