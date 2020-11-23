package be.ordina.test.suites;

import be.ordina.test.classes.watchlist.AddMovieToWatchlistTest;
import be.ordina.test.classes.watchlist.EmptyWatchlistTest;
import be.ordina.test.classes.watchlist.RemoveMovieFromWatchlistTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(Include.class)
@Categories.ExcludeCategory(Exclude.class)
@Suite.SuiteClasses({ AddMovieToWatchlistTest.class, EmptyWatchlistTest.class, RemoveMovieFromWatchlistTest.class })
public class WatchlistTestSuite {
}
