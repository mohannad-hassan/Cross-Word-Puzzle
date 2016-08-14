package com.badr.model.query;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class QueryParserTest extends TestCase {

    private QueryParser parser;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        parser = new QueryParser();
    }

    @org.junit.Test
    public void testSuccessfulCase() {
        try {
            WordInput input = parser.parse("--a--");

            assertEquals(input.getWordLength(), 5);

            List<CharacterInput> characterInputs = input.getCharacterInputs();

            assertEquals(characterInputs.size(), 1);
            assertEquals(characterInputs.get(0).getCharacter(), 'a');
            assertEquals(characterInputs.get(0).getPosition(), 2);

            input = parser.parse("a-a-");

            assertEquals(input.getWordLength(), 4);

            characterInputs = input.getCharacterInputs();

            assertEquals(characterInputs.size(), 2);
            assertEquals(characterInputs.get(0).getCharacter(), 'a');
            assertEquals(characterInputs.get(0).getPosition(), 0);
            assertEquals(characterInputs.get(1).getCharacter(), 'a');
            assertEquals(characterInputs.get(1).getPosition(), 2);
        }
        catch (MalformedQueryException e) {
            fail("Caught a " + MalformedQueryException.class + ": " + e);
        }
    }

    @org.junit.Test
    public void testWhiteSpaceInput() {
        try {
            parser.parse("  --  ");
        }
        catch (MalformedQueryException e) { }
        catch (Exception e) {
            fail("Didn't throw the expected " + MalformedQueryException.class);
        }
    }

    @org.junit.Test
    public void testPlaceHolders() {
        try {
            assertEquals(parser.parse("aa__").getCharacterInputs().size(), 2);
            assertEquals(parser.parse("-a--").getCharacterInputs().size(), 1);
            assertEquals(parser.parse("-aaaa_").getCharacterInputs().size(), 4);
        }
        catch (Exception e) {
            fail("Caught an exception: " + e);
        }
    }
}