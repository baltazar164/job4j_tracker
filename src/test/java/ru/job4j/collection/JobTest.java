package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByAscNameAndDescPrority() {
        List<Job> actual = new ArrayList<>();
        actual.add(new Job("Ben", 1));
        actual.add(new Job("Alex", 0));
        actual.add(new Job("Alex", 1));
        actual.add(new Job("Ben", 0));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("Alex", 1));
        expected.add(new Job("Alex", 0));
        expected.add(new Job("Ben", 1));
        expected.add(new Job("Ben", 0));
        actual.sort(new JobAscByName().thenComparing(new JobDescByPriority()));
        assertThat(expected, is(actual));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByAscNameAndAscPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 0),
                new Job("Alex", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByAscName() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 0),
                new Job("Ben", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 0),
                new Job("Ben", 1)

        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 0),
                new Job("Ben", 1)

        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 0),
                new Job("Ben", 1)

        );
        assertThat(rsl, greaterThan(0));
    }
}