package customer;

import java.util.ArrayList;
import java.util.List;

public class QuoteRepository {
    private static final List<Quote> quotes = new ArrayList<>();

    public static void addQuote(Quote quote) {
        quotes.add(quote);
    }

    public static List<Quote> getAllQuotes() {
        return quotes;
    }
}
