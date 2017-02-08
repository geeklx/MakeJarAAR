package com.example.myshininglibrary.glin.factory;


import com.example.myshininglibrary.glin.parser.Parser;

/**
 * Created by qibin on 2016/7/13.
 */

public interface ParserFactory {
    Parser getParser();
    Parser getListParser();
}
