package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CardPrimitiveEntityPK implements Serializable {
    @Column(name = "CARD_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Object cardId;
    @Column(name = "PRIMITIVE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Object primitiveId;

    public Object getCardId() {
        return cardId;
    }

    public void setCardId(Object cardId) {
        this.cardId = cardId;
    }

    public Object getPrimitiveId() {
        return primitiveId;
    }

    public void setPrimitiveId(Object primitiveId) {
        this.primitiveId = primitiveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardPrimitiveEntityPK that = (CardPrimitiveEntityPK) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(primitiveId, that.primitiveId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, primitiveId);
    }
}
