package ru.netology.hw11exersise1.hw11exersise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    Movie movie1 = new Movie("Bloodshot");
    Movie movie2 = new Movie("Forward");
    Movie movie3 = new Movie("Hotel");
    Movie movie4 = new Movie("Dentlemen");
    Movie movie5 = new Movie("Invisible man");
    Movie movie6 = new Movie("Trolls");
    Movie movie7 = new Movie("Number one");

    @Test
    public void noMoviesAdded() {
        PosterManager manager = new PosterManager();

        Movie[] expected = {};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneMovieAdded() {
        PosterManager manager = new PosterManager();

        manager.save(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addingMovies() {
        PosterManager manager = new PosterManager();

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void defaultLimitOfAddedMovies() {
        PosterManager manager = new PosterManager();

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void limitOfAddedFilms3() {
        PosterManager manager = new PosterManager(3);

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        Movie[] expected = {movie7, movie6, movie5};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void limitOfAddedFilms7() {
        PosterManager manager = new PosterManager(7);

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addedMoviesLessThanTheLimit() {
        PosterManager manager = new PosterManager();

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);

        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}