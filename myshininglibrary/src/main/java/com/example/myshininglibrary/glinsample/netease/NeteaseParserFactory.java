package com.example.myshininglibrary.glinsample.netease;


import com.example.myshininglibrary.glin.factory.ParserFactory;
import com.example.myshininglibrary.glin.parser.Parser;

/**
 * <p>function: </p>
 * <p>description:  </p>
 * <p>history:  1. 2016/12/19</p>
 * <p>Author: qibin</p>
 * <p>modification:</p>
 */
public class NeteaseParserFactory implements ParserFactory {
    @Override
    public Parser getParser() {
        return new NeteaseObjectParser();
    }

    @Override
    public Parser getListParser() {
        return new NeteaseListParser();
    }
}
