package com.example.musicplayer.domain.model;

public class Playlist {

    private SongNode head;
    private SongNode tail;
    private SongNode current;
    private int size;

    public void addFirst(Song song) {
        validateSong(song);
        SongNode newNode = new SongNode(song);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        size++;
    }

    public void addLast(Song song) {
        validateSong(song);
        SongNode newNode = new SongNode(song);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    public void addAt(Song song, int position) {
        validateSong(song);
        validatePositionForAdd(position);
        // TODO: Implement playlist insertion by position.
        throw new UnsupportedOperationException("addAt is not implemented yet.");
    }

    public void removeById(String songId) {
        validateSongId(songId);
        // TODO: Implement playlist removal by id.
        throw new UnsupportedOperationException("removeById is not implemented yet.");
    }

    public void removeAt(int position) {
        validatePositionForExistingElement(position);
        // TODO: Implement playlist removal by position.
        throw new UnsupportedOperationException("removeAt is not implemented yet.");
    }

    public void move(int fromPosition, int toPosition) {
        validatePositionForExistingElement(fromPosition);
        validatePositionForExistingElement(toPosition);
        // TODO: Implement playlist reordering.
        throw new UnsupportedOperationException("move is not implemented yet.");
    }

    public Song nextSong() {
        // TODO: Implement cursor movement to next song.
        return null;
    }

    public Song previousSong() {
        // TODO: Implement cursor movement to previous song.
        return null;
    }

    public void setCurrent(int position) {
        validatePositionForExistingElement(position);
        // TODO: Implement current pointer assignment.
        throw new UnsupportedOperationException("setCurrent is not implemented yet.");
    }

    public Song getCurrentSong() {
        return current != null ? current.getSong() : null;
    }

    public Song getFirstSong() {
        return head != null ? head.getSong() : null;
    }

    public Song getLastSong() {
        return tail != null ? tail.getSong() : null;
    }

    public boolean contains(String songId) {
        validateSongId(songId);
        // TODO: Implement song existence check.
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Song[] toArray() {
        if (isEmpty()) {
            return new Song[0];
        }
        // TODO: Convert playlist into array.
        return new Song[0];
    }

    private SongNode getNodeAt(int position) {
        validatePositionForExistingElement(position);
        // TODO: Resolve node by position.
        return null;
    }

    private void validateSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }
    }

    private void validateSongId(String songId) {
        if (songId == null || songId.isBlank()) {
            throw new IllegalArgumentException("Song id must not be null or blank.");
        }
    }

    private void validatePositionForAdd(int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position out of range for insertion: " + position);
        }
    }

    private void validatePositionForExistingElement(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position out of range: " + position);
        }
    }
}

