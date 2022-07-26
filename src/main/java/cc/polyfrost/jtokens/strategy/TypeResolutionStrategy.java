package cc.polyfrost.jtokens.strategy;

import cc.polyfrost.jtokens.parsers.Parser;

public interface TypeResolutionStrategy {
    /**
     * @param type The strategy string
     * @return The parser for the strategy
     */
    Parser<?> getParser(String type);
}
