package net.samuelcmace.utk.logic.model.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "NOTE", schema = "main", catalog = "")
public class NoteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NOTE_ID")
    private Object noteId;
    @Basic
    @Column(name = "CARD_ID")
    private Object cardId;

    public Object getNoteId() {
        return noteId;
    }

    public void setNoteId(Object noteId) {
        this.noteId = noteId;
    }

    public Object getCardId() {
        return cardId;
    }

    public void setCardId(Object cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteEntity that = (NoteEntity) o;
        return Objects.equals(noteId, that.noteId) && Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, cardId);
    }
}
