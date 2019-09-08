package at.htl.doghotel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://futalis.de/hunderatgeber/hunderassen
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class DogHotelTest {

    private static DogBreed affenpinscher;
    private static DogBreed havaneser;
    private static DogBreed basenji;
    private static DogBreed dobermann;
    private static DogBreed ridgeback;

    @BeforeAll
    static void init() {
        affenpinscher = new DogBreed("Affenpinscher", 30);
        havaneser = new DogBreed("Havaneser", 27);
        basenji = new DogBreed("Basenji", 43);
        dobermann = new DogBreed("Dobermann", 72);
        ridgeback = new DogBreed("Rhodesian Ridgeback", 69);
    }

    @Test
    void t01AddDog() {

        DogHotel dogHotel = new DogHotel();
        dogHotel.addDog(new Dog("Bello", 27, affenpinscher));
        assertThat(dogHotel.getList().size(), is(1));
        assertThat(dogHotel.getList().get(0).getName(), is("Bello"));
    }

    @Test
    void t02GetListOrderedByName() {
        DogHotel dogHotel = new DogHotel();
        dogHotel.addDog(new Dog("Tino", 63, ridgeback));
        dogHotel.addDog(new Dog("Arko", 41, basenji));
        dogHotel.addDog(new Dog("Bello", 27, affenpinscher));

        List<Dog> actual = dogHotel.getListOrderedByName();

        assertThat(actual.get(0).getName(), is("Arko"));
        assertThat(actual.get(1).getName(), is("Bello"));
        assertThat(actual.get(2).getName(), is("Tino"));
    }

    @Test
    void t03GetListOrderedByHeight() {
        DogHotel dogHotel = new DogHotel();
        dogHotel.addDog(new Dog("Tino", 63, ridgeback));
        dogHotel.addDog(new Dog("Arko", 41, basenji));
        dogHotel.addDog(new Dog("Bello", 27, affenpinscher));

        List<Dog> actual = dogHotel.getListOrderedByHeight();

        assertThat(actual.get(0).getHeight(), is(27));
        assertThat(actual.get(1).getHeight(), is(41));
        assertThat(actual.get(2).getHeight(), is(63));
    }

    @Test
    void t04ToString() {
        DogHotel dogHotel = new DogHotel();
        dogHotel.addDog(new Dog("Tino", 63, ridgeback));

        assertThat(dogHotel.getList().get(0).toString(),is("Tino (Rhodesian Ridgeback)"));
    }

}