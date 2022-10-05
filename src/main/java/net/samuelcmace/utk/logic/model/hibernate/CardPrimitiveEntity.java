package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CARD_PRIMITIVE", schema = "main", catalog = "")
@IdClass(CardPrimitiveEntityPK.class)
public class CardPrimitiveEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CARD_ID")
    private Object cardId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PRIMITIVE_ID")
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
        CardPrimitiveEntity that = (CardPrimitiveEntity) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(primitiveId, that.primitiveId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, primitiveId);
    }
}
