package com.halseyzsmith.hzssbactuator.bootstrap;

import com.halseyzsmith.hzssbactuator.domain.Author;
import com.halseyzsmith.hzssbactuator.domain.Book;
import com.halseyzsmith.hzssbactuator.domain.Category;
import com.halseyzsmith.hzssbactuator.repositories.AuthorRepository;
import com.halseyzsmith.hzssbactuator.repositories.BookRepository;
import com.halseyzsmith.hzssbactuator.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (categoryRepository.count() == 0) {

            // Building Categories
            Category unsavedSciFiCategory = Category.builder().categoryName("Science Fiction").build();
            Category unsavedDystopiaCategory = Category.builder().categoryName("Dystopia").build();
            Category unsavedFictionCategory = Category.builder().categoryName("Fiction").build();
            Category unsavedClassicCategory = Category.builder().categoryName("Classic").build();

            // Saving Categories
            log.debug("Saving Science Fiction Category...");
            Category sciFiCategory = categoryRepository.save(unsavedSciFiCategory);

            log.debug("Saving Dystopia Category...");
            Category dystopiaCategory = categoryRepository.save(unsavedDystopiaCategory);

            log.debug("Saving Fiction Category...");
            Category fictionCategory = categoryRepository.save(unsavedFictionCategory);

            log.debug("Saving Classic Category...");
            Category classicCategory = categoryRepository.save(unsavedClassicCategory);

            // Building Authors
            Author unsavedJohnTwelveHawks = Author.builder()
                    .firstName("John").middleName("Twelve").lastName("Hawks")
                    .biography(Paragraphs.JTH_BIO)
                    .imageUrl("john_twelve_hawks.jpg")
                    .build();

            Author unsavedAynRand = Author.builder()
                    .firstName("Ayn").middleName("").lastName("Rand")
                    .biography(Paragraphs.RAND_BIO)
                    .imageUrl("ayn_rand.jpg")
                    .build();

            // Saving Authors
            log.debug("Saving Author: 'John Twelve Hawks'...");
            Author johnTwelveHawks = authorRepository.save(unsavedJohnTwelveHawks);

            log.debug("Saving Author: 'Ayn Rand'...");
            Author aynRand = authorRepository.save(unsavedAynRand);

            // Building John Twelve Hawk Books
            Book travelerBook = Book.builder()
                    .title("The Traveler")
                    .asin("1400079292")
                    .author(johnTwelveHawks)
                    .series("Fourth Realm Trilogy")
                    .imageUrl("traveler.jpg")
                    .summary(Paragraphs.TRAVELER_SUMMARY)
                    .category(sciFiCategory)
                    .category(dystopiaCategory)
                    .build();

            Book darkRiverBook = Book.builder()
                    .title("The Dark River")
                    .asin("1400079306")
                    .author(johnTwelveHawks)
                    .series("Fourth Realm Trilogy")
                    .imageUrl("dark_river.jpg")
                    .summary(Paragraphs.DARK_RIVER_SUMMARY)
                    .category(sciFiCategory)
                    .category(dystopiaCategory)
                    .build();

            Book goldenCityBook = Book.builder()
                    .title("The Golden City")
                    .asin("1400079314")
                    .author(johnTwelveHawks)
                    .series("Fourth Realm Trilogy")
                    .imageUrl("golden_city.jpg")
                    .summary(Paragraphs.GOLDEN_CITY_SUMMARY)
                    .category(sciFiCategory)
                    .category(dystopiaCategory)
                    .build();

            Book sparkBook = Book.builder()
                    .title("Spark: A Novel")
                    .asin("B00JNQKR3C")
                    .author(johnTwelveHawks)
                    .imageUrl("spark.jpg")
                    .summary(Paragraphs.SPARK_SUMMARY)
                    .category(sciFiCategory)
                    .category(dystopiaCategory)
                    .build();

            // Building Ayn Rand Books
            Book anthemBook = Book.builder()
                    .title("Anthem")
                    .asin("B002OSXD7S")
                    .author(aynRand)
                    .imageUrl("anthem.jpg")
                    .summary(Paragraphs.ANTHEM_SUMMARY)
                    .category(classicCategory)
                    .category(fictionCategory)
                    .build();

            Book fountainheadBook = Book.builder()
                    .title("The Fountainhead")
                    .asin("B08GC58R1Y")
                    .author(aynRand)
                    .imageUrl("fountainhead.jpg")
                    .summary(Paragraphs.FOUNTAINHEAD_SUMMARY)
                    .category(classicCategory)
                    .category(fictionCategory)
                    .build();

            Book atlasShruggedBook = Book.builder()
                    .title("Atlas Shrugged")
                    .asin("B003V8B5XO")
                    .author(aynRand)
                    .imageUrl("atlas_shrugged.jpg")
                    .summary(Paragraphs.ATLAS_SHRUGGED_SUMMARY)
                    .category(classicCategory)
                    .category(fictionCategory)
                    .build();

            Book weTheLivingBook = Book.builder()
                    .title("We The Living")
                    .asin("B002PA0LWA")
                    .author(aynRand)
                    .imageUrl("we_the_living.jpg")
                    .summary(Paragraphs.WE_THE_LIVING_SUMMARY)
                    .category(classicCategory)
                    .category(fictionCategory)
                    .build();

            // Saving John Twelve Hawks Books
            log.debug("Saving Book: 'The Traveler'...");
            bookRepository.save(travelerBook);

            log.debug("Saving Book: 'The Dark River'...");
            bookRepository.save(darkRiverBook);

            log.debug("Saving Book: 'The Golden City'...");
            bookRepository.save(goldenCityBook);

            log.debug("Saving Book: 'Spark: A Novel'...");
            bookRepository.save(sparkBook);

            // Saving Ayn Rand Books
            log.debug("Saving Book: 'Anthem'...");
            bookRepository.save(anthemBook);

            log.debug("Saving Book: 'The Fountainhead'...");
            bookRepository.save(fountainheadBook);

            log.debug("Saving Book: 'Atlas Shrugged'...");
            bookRepository.save(atlasShruggedBook);

            log.debug("Saving Book: 'We The Living'...");
            bookRepository.save(weTheLivingBook);

            log.info("****** Book data loaded!! ******");
        }
    }
}
