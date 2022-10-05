package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PRIMITIVE", schema = "main", catalog = "")
public class PrimitiveEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PRIMITIVE_ID", nullable = false)
    private int primitiveId;
    @Basic
    @Column(name = "NEXT_FRAME", nullable = false)
    private Object nextFrame;
    @Basic
    @Column(name = "SVG_PATH", nullable = false, length = 2048)
    private Object svgPath;
    @Basic
    @Column(name = "KEYWORD", nullable = true, length = 20)
    private Object keyword;
    @OneToMany(mappedBy = "primitiveByPrimitiveId")
    private Collection<CardPrimitiveEntity> cardPrimitivesByPrimitiveId;
    @ManyToOne
    @JoinColumn(name = "NEXT_FRAME", referencedColumnName = "CARD_ID", nullable = false)
    private CardEntity cardByNextFrame;

    public int getPrimitiveId() {
        return primitiveId;
    }

    public void setPrimitiveId(int primitiveId) {
        this.primitiveId = primitiveId;
    }

    public Object getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Object nextFrame) {
        this.nextFrame = nextFrame;
    }

    public Object getSvgPath() {
        return svgPath;
    }

    public void setSvgPath(Object svgPath) {
        this.svgPath = svgPath;
    }

    public Object getKeyword() {
        return keyword;
    }

    public void setKeyword(Object keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimitiveEntity that = (PrimitiveEntity) o;
        return primitiveId == that.primitiveId && Objects.equals(nextFrame, that.nextFrame) && Objects.equals(svgPath, that.svgPath) && Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primitiveId, nextFrame, svgPath, keyword);
    }

    public Collection<CardPrimitiveEntity> getCardPrimitivesByPrimitiveId() {
        return cardPrimitivesByPrimitiveId;
    }

    public void setCardPrimitivesByPrimitiveId(Collection<CardPrimitiveEntity> cardPrimitivesByPrimitiveId) {
        this.cardPrimitivesByPrimitiveId = cardPrimitivesByPrimitiveId;
    }

    public CardEntity getCardByNextFrame() {
        return cardByNextFrame;
    }

    public void setCardByNextFrame(CardEntity cardByNextFrame) {
        this.cardByNextFrame = cardByNextFrame;
    }
}
