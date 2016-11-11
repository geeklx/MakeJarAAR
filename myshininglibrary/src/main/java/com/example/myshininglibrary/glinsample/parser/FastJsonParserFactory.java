package com.example.myshininglibrary.glinsample.parser;

//import org.loader.glin.factory.ParserFactory;
//import org.loader.glin.parser.Parser;

import com.example.myshininglibrary.glin.factory.ParserFactory;
import com.example.myshininglibrary.glin.parser.Parser;

/**
 * Created by qibin on 2016/7/13.
 */

public class FastJsonParserFactory implements ParserFactory {

    @Override
    public Parser getParser() {
        return new CommParser("data");
    }

    @Override
    public Parser getListParser() {
        return new ListParser("data");
    }
}