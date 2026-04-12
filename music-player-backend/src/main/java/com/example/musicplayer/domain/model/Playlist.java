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

        if (position == 0) {
            addFirst(song);
            return;
        }

        if (position == size) {
            addLast(song);
            return;
        }

        SongNode nextNode = getNodeAt(position);
        SongNode previousNode = nextNode.getPrev();
        SongNode newNode = new SongNode(song);

        newNode.setPrev(previousNode);
        newNode.setNext(nextNode);
        previousNode.setNext(newNode);
        nextNode.setPrev(newNode);

        size++;
    }

    public void removeById(String songId) {
        validateSongId(songId);

        SongNode node = head;
        int position = 0;

        while (node != null) {
            if (songId.equals(node.getSong().getId())) {
                removeAt(position);
                return;
            }

            node = node.getNext();
            position++;
        }
    }

    public void removeAt(int position) {
        validatePositionForExistingElement(position);

        SongNode nodeToRemove = getNodeAt(position);
        SongNode previousNode = nodeToRemove.getPrev();
        SongNode nextNode = nodeToRemove.getNext();

        if (previousNode == null) {
            head = nextNode;
        } else {
            previousNode.setNext(nextNode);
        }

        if (nextNode == null) {
            tail = previousNode;
        } else {
            nextNode.setPrev(previousNode);
        }

        nodeToRemove.setPrev(null);
        nodeToRemove.setNext(null);

        if (current == nodeToRemove) {
            if (nextNode != null) {
                current = nextNode;
            } else if (previousNode != null) {
                current = previousNode;
            } else {
                current = null;
            }
        }

        size--;

        if (head != null) {
            head.setPrev(null);
        }

        if (tail != null) {
            tail.setNext(null);
        }
    }

    public void move(int fromPosition, int toPosition) {
        validatePositionForExistingElement(fromPosition);
        validatePositionForExistingElement(toPosition);

        if (fromPosition == toPosition) {
            return;
        }

        SongNode nodeToMove = getNodeAt(fromPosition);
        Song songToMove = nodeToMove.getSong();
        boolean wasCurrent = nodeToMove == current;

        removeAt(fromPosition);
        addAt(songToMove, toPosition);

        if (wasCurrent) {
            current = getNodeAt(toPosition);
        }
    }

    public Song nextSong() {
        if (current == null || current.getNext() == null) {
            return null;
        }

        current = current.getNext();
        return current.getSong();
    }

    public Song previousSong() {
        if (current == null || current.getPrev() == null) {
            return null;
        }

        current = current.getPrev();
        return current.getSong();
    }

    public void setCurrent(int position) {
        current = getNodeAt(position);
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

        SongNode node = head;
        while (node != null) {
            if (songId.equals(node.getSong().getId())) {
                return true;
            }
            node = node.getNext();
        }

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

        Song[] songs = new Song[size];
        SongNode node = head;
        int index = 0;

        while (node != null) {
            songs[index] = node.getSong();
            node = node.getNext();
            index++;
        }

        return songs;
    }

    private SongNode getNodeAt(int position) {
        validatePositionForExistingElement(position);

        SongNode node = head;
        for (int index = 0; index < position; index++) {
            node = node.getNext();
        }

        return node;
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

