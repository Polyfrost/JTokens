package cc.polyfrost.javadesigntokens.strategy;

import cc.polyfrost.javadesigntokens.parsers.Parser;

public interface TypeResolutionStrategy {
    /**
     * @param type The strategy string
     * @return The parser for the strategy
     */
    Parser<?> getParser(String type);
}
