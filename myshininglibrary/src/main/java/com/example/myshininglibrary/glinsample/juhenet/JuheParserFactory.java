package com.example.myshininglibrary.glinsample.juhenet;

import com.example.myshininglibrary.glin.factory.ParserFactory;
import com.example.myshininglibrary.glin.parser.Parser;

/**
 * Created by shining on 2017/2/10 0010.
 */

public class JuheParserFactory implements ParserFactory {
    @Override
    public Parser getParser() {
        return new JuheObjectParser();
    }

    @Override
    public Parser getListParser() {
        return new JuheListParser();
    }
}
