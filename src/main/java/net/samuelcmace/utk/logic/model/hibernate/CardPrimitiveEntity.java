package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CARD_PRIMITIVE", schema = "main", catalog = "")
@IdClass(CardPrimitiveEntityPK.class)
public class CardPrimitiveEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CARD_ID", nullable = false)
    private Object cardId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PRIMITIVE_ID", nullable = false)
    private Object primitiveId;
    @ManyToOne
    @JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID", nullable = false)
    private CardEntity cardByCardId;
    @ManyToOne
    @JoinColumn(name = "PRIMITIVE_ID", referencedColumnName = "PRIMITIVE_ID", nullable = false)
    private PrimitiveEntity primitiveByPrimitiveId;

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

    public CardEntity getCardByCardId() {
        return cardByCardId;
    }

    public void setCardByCardId(CardEntity cardByCardId) {
        this.cardByCardId = cardByCardId;
    }

    public PrimitiveEntity getPrimitiveByPrimitiveId() {
        return primitiveByPrimitiveId;
    }

    public void setPrimitiveByPrimitiveId(PrimitiveEntity primitiveByPrimitiveId) {
        this.primitiveByPrimitiveId = primitiveByPrimitiveId;
    }
}
