package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CARD", schema = "main", catalog = "")
public class CardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CARD_ID")
    private Object cardId;
    @Basic
    @Column(name = "CARD_KANJI")
    private Object cardKanji;
    @Basic
    @Column(name = "HEISIG_INDEX_5_EDITION")
    private Object heisigIndex5Edition;
    @Basic
    @Column(name = "HEISIG_INDEX_6_EDITION")
    private Object heisigIndex6Edition;
    @Basic
    @Column(name = "KEYWORD_5_EDITION")
    private Object keyword5Edition;
    @Basic
    @Column(name = "KEYWORD_6_EDITION")
    private Object keyword6Edition;
    @Basic
    @Column(name = "ON_READING")
    private Object onReading;
    @Basic
    @Column(name = "KUN_READING")
    private Object kunReading;

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
        CardEntity that = (CardEntity) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(cardKanji, that.cardKanji) && Objects.equals(heisigIndex5Edition, that.heisigIndex5Edition) && Objects.equals(heisigIndex6Edition, that.heisigIndex6Edition) && Objects.equals(keyword5Edition, that.keyword5Edition) && Objects.equals(keyword6Edition, that.keyword6Edition) && Objects.equals(onReading, that.onReading) && Objects.equals(kunReading, that.kunReading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardKanji, heisigIndex5Edition, heisigIndex6Edition, keyword5Edition, keyword6Edition, onReading, kunReading);
    }
}
